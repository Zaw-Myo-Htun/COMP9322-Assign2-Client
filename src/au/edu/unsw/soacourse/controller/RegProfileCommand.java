package au.edu.unsw.soacourse.controller;

import java.io.IOException;

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

import au.edu.unsw.soacourse.model.RegistrationRequestDTO;

public class RegProfileCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegistrationRequestDTO userProfile = new RegistrationRequestDTO(); 
		userProfile.setUserID(request.getParameter("userID")); 
		System.out.println(request.getParameter("userID"));
		userProfile.setDob(request.getParameter("dob")); 
		userProfile.setCurrentPosition(request.getParameter("currentPosition"));
		userProfile.setCurrentCompany(request.getParameter("currentCompany")); 
		userProfile.setHighestEducation(request.getParameter("highestEducation")); 
		userProfile.setPastExperience(request.getParameter("pastExperience")); 
		userProfile.setProfessionalSkills (request.getParameter("professionalSkills"));
		userProfile.setResume (request.getParameter("resume"));
		userProfile.setCoverLetter(request.getParameter("cLetter"));

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(
				JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/registration/register");
		ClientResponse r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-candidate")
				.type("application/json").post(ClientResponse.class, userProfile);
		if (r.getStatus() != 201) {
			System.out.println(r.getStatus() + " ERROR");
		}else{
			request.setAttribute("verify", "false");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp"); 
			rd.forward (request, response); 
		}
	}

}
