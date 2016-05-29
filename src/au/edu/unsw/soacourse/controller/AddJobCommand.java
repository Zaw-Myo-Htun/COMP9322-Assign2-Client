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
import au.edu.unsw.soacourse.model.ApplyJobRequestDTO;
import au.edu.unsw.soacourse.model.CheckJobApplicationResponse;
import au.edu.unsw.soacourse.model.JobSearchReponseDTO;
import au.edu.unsw.soacourse.model.RegistrationRequestDTO;
import au.edu.unsw.soacourse.model.SavedJobRequestDTO;
import au.edu.unsw.soacourse.model.User;

public class AddJobCommand implements Command {
	UserDao dao = new UserDao();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(
				JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/checkJobApplication/"
						+ request.getSession().getAttribute("userID").toString() + "/" + request.getParameter("jobID"));
		
		CheckJobApplicationResponse r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-candidate")
				.type("application/json").get(CheckJobApplicationResponse.class);
		if(r.isExists()){
			// can't apply
		}else{
			ApplyJobRequestDTO applyJob = new ApplyJobRequestDTO();
			String jobApplicationID = UUID.randomUUID().toString(); 
			applyJob.setJobApplicationID(jobApplicationID);
			applyJob.setJobID("1");
			applyJob.setUserID(request.getSession().getAttribute("userID").toString());
			applyJob.setAdr("ADR001");
			applyJob.setDl("DL001");
			applyJob.setCv("CV1");
			applyJob.setResume("Resume1");
//			applyJob.setJobID( request.getParameter("jobID"));
//			applyJob.setUserID(request.getSession().getAttribute("userID").toString());
//			applyJob.setAdr(request.getParameter("ADR"));
//			applyJob.setDl(request.getParameter("DL"));
//			applyJob.setCv(request.getParameter("CV"));
//			applyJob.setResume(request.getParameter("Resume"));
			applyJob.setStatus("default");
			WebResource webResource1 = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/applyJob");
			ClientResponse r1 = webResource1.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-candidate")
					.type("application/json")
					.post(ClientResponse.class, applyJob);
			if (r1.getStatus() != 201) {
				System.out.println(r1.getStatus() + " ERROR");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
				rd.forward(request, response);
			}
		}
	}

}
