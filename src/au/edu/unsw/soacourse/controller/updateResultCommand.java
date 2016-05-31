package au.edu.unsw.soacourse.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import au.edu.unsw.soacourse.model.AssignReviewerRequestDTO;
import au.edu.unsw.soacourse.model.AssignReviewerResponseDTO;
import au.edu.unsw.soacourse.model.GetCompanyIDResponseDTO;
import au.edu.unsw.soacourse.model.JobAddRequestDTO;
import au.edu.unsw.soacourse.model.SavedJobRequestDTO;
import au.edu.unsw.soacourse.model.SelectedApplicantsReponseDTO;
import au.edu.unsw.soacourse.model.SelectedApplicantsRequestDTO;

public class updateResultCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String[] levelDropdowns = request.getParameterValues("reviewer1");
		//
		// System.out.println(levelDropdowns.length);
		// System.out.println(levelDropdowns[0]);
		// System.out.println(levelDropdowns[1]);

		String[] results = request.getParameterValues("result");
		String[] jobAppIDlist = request.getParameterValues("jobAppID");
		String[] userID = request.getParameterValues("userID");
		String[] email = request.getParameterValues("email");

//		for (int i = 0; i < reviewer1list.length; i++) {
//			System.out.println(jobAppIDlist[i] + "  - -- - ");
//		}
//		System.out.println(jobAppIDlist);
//		System.out.println(request.getParameter("reviewer1"));
//		System.out.println(request.getParameter("reviewer2"));

		ArrayList<ArrayList<String>> assignResult = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < results.length; i++) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(jobAppIDlist[i]);
			temp.add(userID[i]);
			temp.add(email[i]);
			temp.add(results[i]);
			assignResult.add(temp);
		}
		System.out.println(assignResult + " - abc ---" );

		SelectedApplicantsRequestDTO select = new SelectedApplicantsRequestDTO();
		select.setApplicants(assignResult);
		select.setJobID(request.getParameter("jobID"));

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/selectApplicants");
		SelectedApplicantsReponseDTO r = webResource.accept("application/json")
				.header("SecurityKey", "i-am-foundit")
				.header("ShortKey", "app-manager").type("application/json")
				.post(SelectedApplicantsReponseDTO.class, select);
		if (r.getStatus() != 201) {
			System.out.println(r.getStatus() + " ERROR");
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/control?action=ToMgrHomePage");
			rd.forward(request, response);
		}
	}
}
