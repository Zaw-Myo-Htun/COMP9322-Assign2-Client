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

import au.edu.unsw.soacourse.model.CompanyAddRequestDTO;
import au.edu.unsw.soacourse.model.GetCandidateResponseDTO;
import au.edu.unsw.soacourse.model.ReviewedCandidateResponseDTO;

public class ToUpdateStatusToInterviewCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//set  jsp
		//reviewedApplicants
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(
				JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource4 = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/reviewedApplicants/" + request.getParameter("jobID"));

		ReviewedCandidateResponseDTO r4 = webResource4.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-manager").type("application/json")
				.get(ReviewedCandidateResponseDTO.class);
		if (r4.getStatus() != 200) {
			System.out.println(r4.getStatus() + " ERROR");
		} else {
			request.setAttribute("jobID", request.getParameter("jobID"));
			request.setAttribute("reviewedApplicants", r4.getReviewedApplicants());
			RequestDispatcher rd = request.getRequestDispatcher("/.jsp"); 
			rd.forward (request, response); 
		}
	}

}
