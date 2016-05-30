package au.edu.unsw.soacourse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.EmailRequestDTO;
import au.edu.unsw.soacourse.model.GetCandidateResponseDTO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class SendEmailToUnsuccessfulCommand implements Command {
	UserDao dao = new UserDao();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pass");
		String name = request.getParameter("name");

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client client = Client.create(clientConfig);

		WebResource webResource3 = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/applicants/"
						+ request.getParameter("jobID") + "/unsuccessful");

		GetCandidateResponseDTO r3 = webResource3.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-manager").type("application/json")
				.get(GetCandidateResponseDTO.class);
		if (r3.getStatus() != 200) {
			System.out.println(r3.getStatus() + " ERROR");
		} else {
			for (int i = 0; i < r3.getCandidateList().size(); i++) {
				EmailRequestDTO emailDTO = new EmailRequestDTO();
				emailDTO.setEmail(r3.getCandidateList().get(i).get(3));
				emailDTO.setMessage("We are sorry to tell you that your application has been rejected!");
				emailDTO.setSubject("Job Application Result");
				WebResource webResource = client
						.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/email");
				ClientResponse r = webResource.accept("application/json")
						.header("SecurityKey", "i-am-foundit")
						.header("ShortKey", "app-candidate")
						.type("application/json")
						.post(ClientResponse.class, emailDTO);
				if (r.getStatus() != 201) {
					System.out.println(r.getStatus() + " Error ");
				} else {
					request.setAttribute("isValidUser", "verify");

				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/control?action=ToApplicantOutcome&jobID="
					+ request.getParameter("jobID") + "&sent=yes"); 
		rd.forward (request, response);
	}

}
