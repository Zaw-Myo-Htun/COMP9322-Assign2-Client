package au.edu.unsw.soacourse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.edu.unsw.soacourse.dao.UserDao;
import au.edu.unsw.soacourse.model.User;

public class LoginCommand implements Command {
	UserDao dao = new UserDao();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("uname");
		String pwd = request.getParameter("pass");
		
		
		if(dao.isUserExist(username, pwd)){
			if(!dao.isUserExistAndVerified(username)){
				request.setAttribute("isValidUser", "verify");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}else{
				User s = dao.getUser(username);
				HttpSession session = request.getSession();
				session.setAttribute("cName", s.getName());
				session.setAttribute("email", username);
				session.setAttribute("userID", s.getUserID());
				RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
				rd.forward(request, response);
			}
		}else{
			request.setAttribute("isValidUser", "false");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}
}
