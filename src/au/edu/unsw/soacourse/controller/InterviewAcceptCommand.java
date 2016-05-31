package au.edu.unsw.soacourse.controller;

import java.io.IOException;
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

import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.ApplyJobRequestDTO;
import au.edu.unsw.soacourse.model.CheckJobApplicationResponse;
import au.edu.unsw.soacourse.model.JobSearchReponseDTO;
import au.edu.unsw.soacourse.model.RegistrationRequestDTO;
import au.edu.unsw.soacourse.model.SavedJobRequestDTO;
import au.edu.unsw.soacourse.model.User;

public class InterviewAcceptCommand implements Command {
	UserDao dao = new UserDao();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client client = Client.create(clientConfig);
		System.out.println(request.getParameter("jobAppID") + " ---sabdg");
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/acceptance/"
						+ request.getParameter("jobAppID")
						+ "/" + request.getParameter("YesNo"));

		ClientResponse r1 = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-candidate").type("application/json")
				.put(ClientResponse.class);

		if (r1.getStatus() != 204) {
			System.out.println(r1.getStatus() + " ERROR");
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/control?action=ToClientLogin");
			rd.forward(request, response);
		}

	}

}
