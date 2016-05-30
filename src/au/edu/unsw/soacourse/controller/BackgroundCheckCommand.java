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
import au.edu.unsw.soacourse.model.JobSearchReponseDTO;
import au.edu.unsw.soacourse.model.RegistrationRequestDTO;
import au.edu.unsw.soacourse.model.SavedJobRequestDTO;
import au.edu.unsw.soacourse.model.User;

public class BackgroundCheckCommand implements Command {
	UserDao dao = new UserDao();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/applicants/"
						+ request.getParameter("jobID"));

		GetApplicantResponseDTO r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-manager").type("application/json")
				.get(GetApplicantResponseDTO.class);
		if (r.getStatus() != 200) {
			System.out.println(r.getStatus() + " ERROR");
		} else {
			ArrayList<ArrayList<String>> arr = r.getApplicantList();
			for (int i = 0; i < arr.size(); i++) {
				ArrayList<String> sss = arr.get(i);
				for (int j = 0; j < sss.size(); j++) {
					BackgroundRequestDTO bg = new BackgroundRequestDTO();
					bg.setName(arr.get(i).get(2));
					bg.setAdr(arr.get(i).get(4));
					bg.setDl(arr.get(i).get(3));
					WebResource webResource1 = client
							.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/background");
					BackgroundResponseDTO r1 = webResource1
							.accept("application/json")
							.header("SecurityKey", "i-am-foundit")
							.header("ShortKey", "app-manager")
							.type("application/json")
							.post(BackgroundResponseDTO.class, bg);
					if (r1.getStatus() != 201) {
						System.out.println(r1.getStatus() + " ERROR");
					} else {
						WebResource webResource2;
						if (r1.getFlag()) {
							webResource2 = client
									.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/updateJobApplication/"
											+ arr.get(i).get(0)
											+ "/underreview");
						} else {
							webResource2 = client
									.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/updateJobApplication/"
											+ arr.get(i).get(0)
											+ "/unsuccessful");
						}
						ClientResponse r2 = webResource2
								.accept("application/json")
								.header("SecurityKey", "i-am-foundit")
								.header("ShortKey", "app-manager")
								.type("application/json")
								.put(ClientResponse.class);
						if (r2.getStatus() != 204) {
							System.out.println(r2.getStatus() + " ERROR");
						} else {
						}
					}
				}
			}
			// call applicants services - get two arraylist underreview and
			// unsuccessful

			WebResource webResource3 = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/applicants/"
							+ request.getParameter("jobID") + "/unsuccessful");

			GetCandidateResponseDTO r3 = webResource3
					.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-manager").type("application/json")
					.get(GetCandidateResponseDTO.class);
			if (r3.getStatus() != 200) {
				System.out.println(r3.getStatus() + " ERROR");
			} else {
				request.setAttribute("unsuccessful", r3.getCandidateList());
			}
			WebResource webResource4 = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/applicants/"
							+ request.getParameter("jobID") + "/underreview");

			GetCandidateResponseDTO r4 = webResource4
					.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-manager").type("application/json")
					.get(GetCandidateResponseDTO.class);
			if (r4.getStatus() != 200) {
				System.out.println(r4.getStatus() + " ERROR");
			} else {
				request.setAttribute("underreview", r4.getCandidateList());
			}
		}
		request.setAttribute("jobID",request.getParameter("jobID"));
		RequestDispatcher rd = request
				.getRequestDispatcher("/applicantoutcome.jsp");
		rd.forward(request, response);
	}
}
