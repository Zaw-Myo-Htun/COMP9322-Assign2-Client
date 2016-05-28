package au.edu.unsw.soacourse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.GetJobApplicationResponseDTO;
import au.edu.unsw.soacourse.model.UserProfileResponseDTO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class ToAppliedJobCommand implements Command {
	UserDao dao = new UserDao();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(
				JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/jobApplication/" + request.getSession().getAttribute("userID").toString());
		
		GetJobApplicationResponseDTO r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-candidate")
				.type("application/json").get(GetJobApplicationResponseDTO.class);
		if (r.getStatus() != 200) {
			System.out.println(r.getStatus() + " ERROR");
		}else{
			request.setAttribute("appliedJobs", r.getJobApplicationList());
			RequestDispatcher rd = request.getRequestDispatcher("/jobapplied.jsp");
			rd.forward(request, response);
		}
	}

}
