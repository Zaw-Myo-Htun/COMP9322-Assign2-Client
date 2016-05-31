package au.edu.unsw.soacourse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.GetApplicantResponseDTO;
import au.edu.unsw.soacourse.model.ManagerJobListResponseDTO;
import au.edu.unsw.soacourse.model.UserProfileResponseDTO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class ViewApplicantsCommand implements Command {
	UserDao dao = new UserDao();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(
				JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/applicants/" +  request.getParameter("jobID"));
		
		GetApplicantResponseDTO r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-manager")
				.type("application/json").get(GetApplicantResponseDTO.class);
		if (r.getStatus() != 200) {
			System.out.println(r.getStatus() + " ERROR");
		}else{
//			for(int i=0;i<r.getApplicantList().size();i++){
//				for(int j=0;j<r.getApplicantList().get(i).size();j++){
//					
//				}
//			}
			System.out.println(r.getApplicantList());
			request.setAttribute("applicantList",r.getApplicantList());
			request.setAttribute("jobID",request.getParameter("jobID"));
			RequestDispatcher rd = request.getRequestDispatcher("/applicantlist.jsp");
			rd.forward(request, response);
		}
	}

}
