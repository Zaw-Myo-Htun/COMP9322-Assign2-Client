package au.edu.unsw.soacourse.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import au.edu.unsw.soacourse.model.SignUpRegRequest;
import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.User;

public class SearchJobCommand implements Command {
	UserDao dao = new UserDao();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userID = UUID.randomUUID().toString(); 
		User user = new User(); 
		user.setEmail (request.getParameter("email")); 
		user.setPassword((request.getParameter ("pwd")));
		user.setName(request.getParameter("name")); 
		user.setUserID(userID);
		user.setVerified ("Yes");
		dao.addUser(user);

		SignUpRegRequest reg = new SignUpRegRequest(); 
		reg.setEmail (request.getParameter("email")); 
		reg.setPassword (request.getParameter("pwd"));
		reg.setUserID(userID); 
		reg.setName(request.getParameter("name"));
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(
				JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/signup");
		ClientResponse r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-candidate")
				.type("application/json").post(ClientResponse.class, reg);
		if (response.getStatus() != 201) {
			System.out.println(r.getStatus() + " ERROR");
		}else{
			request.setAttribute("verify", "false");
			RequestDispatcher rd = request.getRequestDispatcher("/regprofile.jsp"); 
			rd.forward (request, response); 
		}
	}
}
