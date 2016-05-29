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
import au.edu.unsw.soacourse.model.GetReviewerResponseDTO;
import au.edu.unsw.soacourse.model.HiringTeamAddRequestDTO;
import au.edu.unsw.soacourse.model.RegistrationRequestDTO;
import au.edu.unsw.soacourse.model.SavedJobRequestDTO;
import au.edu.unsw.soacourse.model.User;
import au.edu.unsw.soacourse.model.UserProfileResponseDTO;

public class AddReviewerCommand implements Command {
	UserDao dao = new UserDao();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HiringTeamAddRequestDTO reviewer = new HiringTeamAddRequestDTO();
		String reviewerID = UUID.randomUUID().toString();
		reviewer.setReviewerID(reviewerID);
		System.out.println(request.getParameter("managerID"));
		reviewer.setManagerID(request.getParameter("managerID"));
		reviewer.setName(request.getParameter("name"));
		reviewer.setUsername(request.getParameter("username"));
		reviewer.setPassword(request.getParameter("password"));

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/addReviewer");
		ClientResponse r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-manager").type("application/json")
				.post(ClientResponse.class, reviewer);
		if (r.getStatus() != 201) {
			System.out.println(r.getStatus() + " ERROR");
		} else {
			WebResource webResource1 = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/reviewer/" + request.getParameter("managerID"));
			
			GetReviewerResponseDTO r1 = webResource1.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-manager")
					.type("application/json").get(GetReviewerResponseDTO.class);
			if (r1.getStatus() != 200) {
				System.out.println(r1.getStatus() + " ERROR");
			}else{
				request.setAttribute("AddReviewerList", r1.getReviewerList());
				request.setAttribute("managerID", request.getParameter("managerID"));
				RequestDispatcher rd = request.getRequestDispatcher("/addReviewer.jsp");
				rd.forward(request, response);
			}
		}

	}
}
