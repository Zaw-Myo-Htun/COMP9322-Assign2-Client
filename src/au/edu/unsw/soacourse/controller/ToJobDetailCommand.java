package au.edu.unsw.soacourse.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.edu.unsw.soacourse.model.JobSearchReponseDTO;
import au.edu.unsw.soacourse.model.UserProfileResponseDTO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class ToJobDetailCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(
				JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/job/" + request.getParameter("jobID"));
		
		JobSearchReponseDTO r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-candidate")
				.type("application/json").get(JobSearchReponseDTO.class);
		
		WebResource webResource1 = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/candidate/" + request.getSession().getAttribute("userID").toString());
		
		UserProfileResponseDTO r1 = webResource1.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-candidate")
				.type("application/json").get(UserProfileResponseDTO.class);
		
		if (r.getStatus() != 200) {
			System.out.println(r.getStatus() + " ERROR");
		}else{
			ArrayList detail = new ArrayList();
			if (r1.getStatus() != 200) {
				System.out.println(r1.getStatus() + " ERROR");
			}else{
				detail.addAll(r.getJob());
				detail.add(r1.getJobSeeker().get(9));
				detail.add(r1.getJobSeeker().get(10));
			}
			request.setAttribute("jobDetail", detail);
			RequestDispatcher rd = request.getRequestDispatcher("/jobdetail.jsp");
			rd.forward(request, response);
		}
	}
}
