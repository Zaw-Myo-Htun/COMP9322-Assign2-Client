package au.edu.unsw.soacourse.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import au.edu.unsw.soacourse.model.JobSearchReponseDTO;
import au.edu.unsw.soacourse.model.SignUpRegRequest;
import au.edu.unsw.soacourse.model.UserProfileResponseDTO;
import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.User;

public class SearchJobCommand implements Command {
	UserDao dao = new UserDao();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(
				JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/jobsearch/"
						+ request.getParameter("keyword") + "/"
						+ request.getParameter("status") + "/"
						+ request.getParameter("skill"));
		
		JobSearchReponseDTO r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-candidate")
				.type("application/json").get(JobSearchReponseDTO.class);
		if (r.getStatus() != 200) {
			System.out.println(r.getStatus() + " ERROR");
		}else{
			System.out.println(r.getJobResults().get(0).get(1));
			//request.setAttribute("userProfile", r.getJobSeeker());
			RequestDispatcher rd = request.getRequestDispatcher("/joblist.jsp");
			rd.forward(request, response);
		}
	}
}
