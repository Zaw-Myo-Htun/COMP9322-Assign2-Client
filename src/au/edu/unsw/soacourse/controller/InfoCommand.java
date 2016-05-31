package au.edu.unsw.soacourse.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import au.edu.unsw.soacourse.model.GetCompanyIDResponseDTO;
import au.edu.unsw.soacourse.model.JobAddRequestDTO;
import au.edu.unsw.soacourse.model.JobSearchReponseDTO;
import au.edu.unsw.soacourse.model.ReviewedCandidateResponseDTO;
import au.edu.unsw.soacourse.model.ReviewerJobApplicationDetailsResponseDTO;
import au.edu.unsw.soacourse.model.UserProfileResponseDTO;

public class InfoCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client client = Client.create(clientConfig);

		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/reviewApplicant/"
						+ request.getParameter("jobAppID"));

		ReviewerJobApplicationDetailsResponseDTO r = webResource
				.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-reviewer").type("application/json")
				.get(ReviewerJobApplicationDetailsResponseDTO.class);
		if (r.getStatus() != 200) {
			System.out.println(r.getStatus() + " ERROR");
		} else {
			request.setAttribute("jobAppDetail", r.getJobApplicationDetails().get(0));
			RequestDispatcher rd = request.getRequestDispatcher("/info.jsp");
			rd.forward(request, response);

		}

	}

}
