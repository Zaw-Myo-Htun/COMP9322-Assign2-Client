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
import au.edu.unsw.soacourse.model.RegistrationRequestDTO;
import au.edu.unsw.soacourse.model.SavedJobRequestDTO;
import au.edu.unsw.soacourse.model.User;

public class DeleteSavedJobCommand implements Command {
	UserDao dao = new UserDao();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			//String jobID = request.getParameter("jobID");
			String jobID = "1";
			String userID = request.getSession().getAttribute("userID").toString();
			
			SavedJobRequestDTO savejob = new SavedJobRequestDTO();
			savejob.setJobID(jobID);
			savejob.setUserID(userID);
			dao.deleteSavedJob(savejob);

			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/deleteSavedJob/"
							+ userID + "/" + jobID);
			ClientResponse r = webResource.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-candidate")
					.type("application/json")
					.delete(ClientResponse.class);
			if (r.getStatus() != 200) {
				System.out.println(r.getStatus() + " ERROR");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/control?action=ToSavedJob");
				rd.forward(request, response);
			}
		
	}

}
