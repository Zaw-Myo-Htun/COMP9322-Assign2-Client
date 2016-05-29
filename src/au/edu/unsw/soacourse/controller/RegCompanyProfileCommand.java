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

import au.edu.unsw.soacourse.model.CompanyAddRequestDTO;
import au.edu.unsw.soacourse.model.RegistrationRequestDTO;

public class RegCompanyProfileCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CompanyAddRequestDTO companyProfile = new CompanyAddRequestDTO(); 
		String companyProfileID = UUID.randomUUID().toString(); 
		companyProfile.setCompanyProfileID(companyProfileID);
		companyProfile.setManagerID(request.getParameter("managerID"));
		companyProfile.setCompanyName(request.getParameter("companyName"));
		companyProfile.setDescription(request.getParameter("description"));
		companyProfile.setWebsite(request.getParameter("website"));
		companyProfile.setIndustryType(request.getParameter("industryType"));
		companyProfile.setCompanyLocation(request.getParameter("companyLocation"));
		companyProfile.setHeadquaters(request.getParameter("headquaters"));
		

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(
				JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/addCompany");
		ClientResponse r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-manager")
				.type("application/json").post(ClientResponse.class, companyProfile);
		if (r.getStatus() != 201) {
			System.out.println(r.getStatus() + " ERROR");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp"); 
			rd.forward (request, response); 
		}
	}

}
