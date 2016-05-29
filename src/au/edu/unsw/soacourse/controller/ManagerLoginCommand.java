package au.edu.unsw.soacourse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.MangaerLoginRequestDTO;
import au.edu.unsw.soacourse.model.User;

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
				RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
				rd.forward(request, response);
		}else{
			request.setAttribute("isValidUser", "false");
			RequestDispatcher rd = request.getRequestDispatcher("/mgrLogin.jsp");
			rd.forward(request, response);
		}
	}
}
