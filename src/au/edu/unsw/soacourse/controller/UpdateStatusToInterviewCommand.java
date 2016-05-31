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

import au.edu.unsw.soacourse.model.ShortListApplicantsResponseDTO;
import au.edu.unsw.soacourse.model.CompanyAddRequestDTO;
import au.edu.unsw.soacourse.model.GetCandidateResponseDTO;
import au.edu.unsw.soacourse.model.ReviewedCandidateResponseDTO;
import au.edu.unsw.soacourse.model.ShortListApplicantsRequestDTO;

public class UpdateStatusToInterviewCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//shortListApplicants
		
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
		
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/shortListApplicants");
		ShortListApplicantsResponseDTO r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-manager")
				.type("application/json").post(ShortListApplicantsResponseDTO.class, r4);
		if (r.getStatus() != 201) {
			System.out.println(r.getStatus() + " ERROR");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/control?action=ToMgrHomePage");
			rd.forward(request, response);
		}
	}

}
