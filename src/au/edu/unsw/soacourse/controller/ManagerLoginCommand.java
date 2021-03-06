package au.edu.unsw.soacourse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.ManagerJobListResponseDTO;
import au.edu.unsw.soacourse.model.MangaerLoginRequestDTO;
import au.edu.unsw.soacourse.model.User;
import au.edu.unsw.soacourse.model.UserProfileResponseDTO;

public class ManagerLoginCommand implements Command {
	UserDao dao = new UserDao();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("uname");
		String pwd = request.getParameter("pass");
		
		
		if(dao.isManagerExist(username, pwd)){
				MangaerLoginRequestDTO m = dao.getManager(username);
				HttpSession session = request.getSession();
				session.setAttribute("mName", m.getName());
				session.setAttribute("mEmail", username);
				session.setAttribute("managerID", m.getManagerID());
				RequestDispatcher rd = request.getRequestDispatcher("/control?action=ToMgrHomePage");
				rd.forward(request, response);
		}else{
			request.setAttribute("isValidUser", "false");
			RequestDispatcher rd = request.getRequestDispatcher("/mgrLogin.jsp");
			rd.forward(request, response);
		}
	}
}
