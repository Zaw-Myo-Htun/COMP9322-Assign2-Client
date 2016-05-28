package au.edu.unsw.soacourse.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.edu.unsw.soacourse.model.MangaerLoginRequestDTO;
import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.EmailRequestDTO;
import au.edu.unsw.soacourse.model.RegistrationRequestDTO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class ManagerRegisterCommand implements Command {
	UserDao dao = new UserDao();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter ("email"); 
		String pwd = request.getParameter ("pass"); 
		String name = request.getParameter("name"); 
		String mgrID = UUID.randomUUID().toString(); 
		
		
		if(!dao.isManagerEmailExist(email)) { 
//			EmailRequestDTO emailDTO = new EmailRequestDTO(); 
//			String emailLink = "Press the link to activate: http://localhost:8080/COMP9322-Assign2-Client/control?action=Activation&email="
//					+ email + "&name=" + name+ "&pwd=" + pwd; 
//			emailDTO.setEmail(email); 
//			emailDTO.setMessage("Please verify!\n" + emailLink); 
//			emailDTO.setSubject ("Verification");
//			ClientConfig clientConfig = new DefaultClientConfig();
//			clientConfig.getFeatures().put(
//					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
//			Client client = Client.create(clientConfig);
//			WebResource webResource = client
//					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/email");
//			ClientResponse r = webResource.accept("application/json")
//					.header("SecurityKey", "i-am-foundit")
//					.header("ShortKey", "app-candidate")
//					.type("application/json").post(ClientResponse.class, emailDTO);
//			if (r.getStatus() != 201) {
//				request.setAttribute("isMannagerExist", "error");
//				RequestDispatcher rd = request.getRequestDispatcher("/reg.jsp"); 
//				rd.forward (request, response); 
//			}else{
//				request.setAttribute("isValidUser", "verify");
//				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp"); 
//				rd.forward (request, response);
//			}
			MangaerLoginRequestDTO mgrProfile = new MangaerLoginRequestDTO(); 
			mgrProfile.setManagerID(mgrID); 
			mgrProfile.setEmail(email);
			mgrProfile.setPassword (pwd);
			mgrProfile.setName(name);

			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/addManager");
			ClientResponse r = webResource.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-candidate")
					.type("application/json").post(ClientResponse.class, mgrProfile);
			if (r.getStatus() != 201) {
				System.out.println(r.getStatus() + " ERROR");
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/mgrLogin.jsp"); 
				rd.forward (request, response); 
			}
		}else{
			request.setAttribute("isManagerExist", "true");
			RequestDispatcher rd = request.getRequestDispatcher("/mgrReg.jsp");
			rd.forward (request, response);
		}
	}

}
