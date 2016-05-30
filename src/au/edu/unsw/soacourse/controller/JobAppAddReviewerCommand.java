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

import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.ApplyJobRequestDTO;
import au.edu.unsw.soacourse.model.BackgroundRequestDTO;
import au.edu.unsw.soacourse.model.BackgroundResponseDTO;
import au.edu.unsw.soacourse.model.CheckJobApplicationResponse;
import au.edu.unsw.soacourse.model.GetApplicantResponseDTO;
import au.edu.unsw.soacourse.model.GetCandidateResponseDTO;
import au.edu.unsw.soacourse.model.GetReviewerResponseDTO;
import au.edu.unsw.soacourse.model.JobSearchReponseDTO;
import au.edu.unsw.soacourse.model.RegistrationRequestDTO;
import au.edu.unsw.soacourse.model.SavedJobRequestDTO;
import au.edu.unsw.soacourse.model.User;

public class JobAppAddReviewerCommand implements Command {
	UserDao dao = new UserDao();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client client = Client.create(clientConfig);

		WebResource webResource4 = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/applicants/"
						+ request.getParameter("jobID") + "/underreview");

		GetCandidateResponseDTO r4 = webResource4.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-manager").type("application/json")
				.get(GetCandidateResponseDTO.class);
		if (r4.getStatus() != 200) {
			System.out.println(r4.getStatus() + " ERROR");
		} else {
			request.setAttribute("underreview", r4.getCandidateList());
			System.out.println(r4.getCandidateList());
		}
		//
		WebResource webResource3 = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/reviewer/"
						+ request.getSession().getAttribute("managerID").toString());

		GetReviewerResponseDTO r3 = webResource3.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-manager").type("application/json")
				.get(GetReviewerResponseDTO.class);
		if (r3.getStatus() != 200) {
			System.out.println(r3.getStatus() + " ERROR");
		} else {
			request.setAttribute("ReviewerList", r3.getReviewerList());
			System.out.println(r3.getReviewerList());
		}
		request.setAttribute("jobID", request.getParameter("jobID"));
		request.setAttribute("returnMessage", request.getParameter("returnMessage"));
		RequestDispatcher rd = request
				.getRequestDispatcher("/assignreviewer.jsp");
		rd.forward(request, response);
	}
}
