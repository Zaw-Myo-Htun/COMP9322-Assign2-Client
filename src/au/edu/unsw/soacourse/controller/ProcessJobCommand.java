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

import au.edu.unsw.soacourse.model.GetFinalResultResponseDTO;
import au.edu.unsw.soacourse.model.GetInterviewApplicantsResponseDTO;
import au.edu.unsw.soacourse.model.GetCompanyIDResponseDTO;
import au.edu.unsw.soacourse.model.JobAddRequestDTO;
import au.edu.unsw.soacourse.model.JobSearchReponseDTO;
import au.edu.unsw.soacourse.model.ReviewedCandidateResponseDTO;
import au.edu.unsw.soacourse.model.UserProfileResponseDTO;

public class ProcessJobCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client client = Client.create(clientConfig);
		System.out.println(request.getParameter("jobID") + "   ---   ");
		if (request.getParameter("jobStatus").equals("start")) {
			
			
			WebResource webResource = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/job/"
							+ request.getParameter("jobID"));

			JobSearchReponseDTO r = webResource.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-candidate")
					.type("application/json").get(JobSearchReponseDTO.class);
			if (r.getStatus() != 200) {
				System.out.println(r.getStatus() + " ERROR");
			} else {
				WebResource webResource1 = client
						.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/closeJob/"
								+ request.getParameter("jobID"));

				ClientResponse r1 = webResource1
						.header("SecurityKey", "i-am-foundit")
						.header("ShortKey", "app-manager")
						.put(ClientResponse.class);
				if (r1.getStatus() != 204) {
					System.out.println(r1.getStatus() + " sd ERROR");
				} else {
					request.setAttribute("jobDetail", r.getJob());
					RequestDispatcher rd = request
							.getRequestDispatcher("/mgrJobdetail.jsp");
					rd.forward(request, response);
				}
			}
		} else if (request.getParameter("jobStatus").equals("reviewer")) {
			WebResource webResource4 = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/reviewedApplicants/" + request.getParameter("jobID"));

			ReviewedCandidateResponseDTO r4 = webResource4.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-manager").type("application/json")
					.get(ReviewedCandidateResponseDTO.class);
			if (r4.getStatus() != 200) {
				System.out.println(r4.getStatus() + " ERROR");
			} else {
				System.out.println(r4.getReviewedApplicants());
				request.setAttribute("jobID", request.getParameter("jobID"));
				request.setAttribute("reviewedApplicants", r4.getReviewedApplicants());
				RequestDispatcher rd = request.getRequestDispatcher("/updatetointerview.jsp"); 
				rd.forward (request, response); 
			}
		} else if (request.getParameter("jobStatus").equals("interviewer")) {
			WebResource webResource3 = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/interview/" + request.getParameter("jobID"));

			GetInterviewApplicantsResponseDTO r3 = webResource3.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-manager").type("application/json")
					.get(GetInterviewApplicantsResponseDTO.class);
			if (r3.getStatus() != 200) {
				System.out.println(r3.getStatus() + " ERROR");
			} else {
				System.out.println(r3.getApplicants());
				request.setAttribute("jobID", request.getParameter("jobID"));
				request.setAttribute("applicants", r3.getApplicants());
				RequestDispatcher rd = request.getRequestDispatcher("/interview.jsp"); 
				rd.forward (request, response); 
			}
		} else if (request.getParameter("jobStatus").equals("end")) {
			WebResource webResource3 = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/finalApplicant/" + request.getParameter("jobID"));

			GetFinalResultResponseDTO r3 = webResource3.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-manager").type("application/json")
					.get(GetFinalResultResponseDTO.class);
			if (r3.getStatus() != 200) {
				System.out.println(r3.getStatus() + " ERROR");
			} else {
				System.out.println(r3.getFinalApplicants());
				request.setAttribute("jobID", request.getParameter("jobID"));
				request.setAttribute("applicants", r3.getFinalApplicants());
				RequestDispatcher rd = request.getRequestDispatcher("/result.jsp"); 
				rd.forward (request, response); 
			}
		}
	}

}
