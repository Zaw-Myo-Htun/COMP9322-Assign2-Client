package au.edu.unsw.soacourse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.EmailRequestDTO;
import au.edu.unsw.soacourse.model.RegistrationRequestDTO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RegisterCommand implements Command {
	UserDao dao = new UserDao();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter ("email"); 
		String pwd = request.getParameter ("pass"); 
		String name = request.getParameter("name"); 
		
		
		
		if(!dao.isEmailExist(email)) { 
			System.out.println("asdasdasda");
			EmailRequestDTO emailDTO = new EmailRequestDTO(); 
			String emailLink = "Press the link to activate: http://localhost:8080/COMP9322—assn2–client/control?action=Activation&email="
					+ email + "&name=" + name+ "&pwd=" + pwd; 
			emailDTO.setEmail(email); 
			emailDTO.setMessage("Please verify!\n" + emailLink); 
			emailDTO.setSubject ("Verification");
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/email");
			ClientResponse r = webResource.accept("application/json")
					.header("Authorization", "i-am-foundit")
					.header("Authorization", "app-candidate")
					.type("application/json").post(ClientResponse.class, emailDTO);
			if (response.getStatus() != 201) {
				request.setAttribute("isUserExist", "error");
				RequestDispatcher rd = request.getRequestDispatcher("/reg.jsp"); 
				rd.forward (request, response); 
			}else{
				request.setAttribute("isUserExist", "verify");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp"); 
				rd.forward (request, response); 
			}
		}else{
			request.setAttribute("isUserExist", "true");
			RequestDispatcher rd = request.getRequestDispatcher("/reg.jsp"); 
			rd.forward (request, response); 
		}
	}

}
