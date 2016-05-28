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

public class SaveJobCommand implements Command {
	UserDao dao = new UserDao();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// try {
		// success = dao.addSavedJobs(request.getParameter("jobID"), request
		// .getSession().getAttribute("userID").toString(),
		// request.getParameter("jobName"));
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// SavedJobRequestDTO savejob = new SavedJobRequestDTO();
		// savejob.setJobID(request.getParameter("jobID"));
		// savejob.setUserID(request.getSession().getAttribute("userID")
		// .toString());
		// savejob.setJobName(request.getParameter("jobName"));
		//
		// ClientConfig clientConfig = new DefaultClientConfig();
		// clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
		// Boolean.TRUE);
		// Client client = Client.create(clientConfig);
		// WebResource webResource = client
		// .resource("http://localhost:8080/HelloWorldCxfRest/foundIT/saveJob");
		// ClientResponse r = webResource.accept("application/json")
		// .header("SecurityKey", "i-am-foundit")
		// .header("ShortKey", "app-candidate").type("application/json")
		// // .post(ClientResponse.class, savejob);
		if (!dao.isSavedJobExist(request.getParameter("jobID"), request
				.getSession().getAttribute("userID").toString())) {
			SavedJobRequestDTO savejob = new SavedJobRequestDTO();
			savejob.setJobID(request.getParameter("jobID"));
			savejob.setUserID(request.getSession().getAttribute("userID").toString());
			savejob.setJobName(request.getParameter("jobName"));
			dao.addSavedJobs(savejob);

			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/saveJob");
			ClientResponse r = webResource.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-candidate")
					.type("application/json")
					.post(ClientResponse.class, savejob);
			if (r.getStatus() != 201) {
				System.out.println(r.getStatus() + " ERROR");
			} else {
				System.out.println("aaaaa");
				request.setAttribute("returnMessage", "The job has been saved!");
			}
		} else {
			System.out.println("bbbbb");
			request.setAttribute("returnMessage",
					"The job has already been saved before!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/joblist.jsp");
		rd.forward(request, response);
	}

}
