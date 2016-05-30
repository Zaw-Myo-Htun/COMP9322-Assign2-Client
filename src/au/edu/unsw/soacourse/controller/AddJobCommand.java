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
import au.edu.unsw.soacourse.model.GetCompanyIDResponseDTO;
import au.edu.unsw.soacourse.model.JobAddRequestDTO;

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
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/CompanyID/" +  request.getSession().getAttribute("managerID").toString());
		
		GetCompanyIDResponseDTO r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-manager")
				.type("application/json").get(GetCompanyIDResponseDTO.class);
		
			String companyID = r.getCompanyID();
	
		JobAddRequestDTO JobAdd = new JobAddRequestDTO();
			String JobID = UUID.randomUUID().toString(); 
			JobAdd.setJobID(JobID);
			JobAdd.setJobName(request.getParameter("jobName"));
			JobAdd.setCompanyProfileID(companyID);
			JobAdd.setSalaryRate(Integer.parseInt(request.getParameter("salaryRate")));
			JobAdd.setPositionType(request.getParameter("positionType"));
			JobAdd.setLocation(request.getParameter("location"));
			JobAdd.setJobDescription(request.getParameter("jobDescription"));
			JobAdd.setStatus(request.getParameter("jobStatus"));
			JobAdd.setKeyword(request.getParameter("keyword"));
			JobAdd.setSkills(request.getParameter("skill"));
			
			WebResource webResource1 = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/addjob");
			ClientResponse r1 = webResource1.accept("application/json")
					.header("SecurityKey", "i-am-foundit")
					.header("ShortKey", "app-manager")
					.type("application/json")
					.post(ClientResponse.class, JobAdd);
			if (r1.getStatus() != 201) {
				System.out.println(r1.getStatus() + " ERROR");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/control?action=ToMgrHomePage");
				rd.forward(request, response);
			}
	}

}
