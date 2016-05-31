package au.edu.unsw.soacourse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.LoginReviewerRequestDTO;
import au.edu.unsw.soacourse.model.LoginReviewerResponseDTO;
import au.edu.unsw.soacourse.model.ManagerJobListResponseDTO;
import au.edu.unsw.soacourse.model.MangaerLoginRequestDTO;
import au.edu.unsw.soacourse.model.User;
import au.edu.unsw.soacourse.model.UserProfileResponseDTO;

public class ReviewerLoginCommand implements Command {
	UserDao dao = new UserDao();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("uname");
		String pwd = request.getParameter("pass");
		
		//loginReviewer
		LoginReviewerRequestDTO rLogin = new LoginReviewerRequestDTO(); 
		rLogin.setEmail(username);
		rLogin.setPassword(pwd);
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(
				JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/loginReviewer");
		LoginReviewerResponseDTO r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-reviewer")
				.type("application/json").post(LoginReviewerResponseDTO.class, rLogin);
		if (r.getStatus() != 201) {
			System.out.println(r.getStatus() + " ERROR");
		}else{
			if(r.getLogin()){
				HttpSession session = request.getSession();
				session.setAttribute("reviewerID",r.getReviewerID()); 
				RequestDispatcher rd = request.getRequestDispatcher("/control?action=ToReviewerHomePage");
				rd.forward(request, response);
			}else{
				request.setAttribute("isValidUser", "false");
				RequestDispatcher rd = request.getRequestDispatcher("/reviewerLogin.jsp");
				rd.forward(request, response);
			}
		}
	}
}
