package au.edu.unsw.soacourse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
//	static Logger logger = Logger.getLogger(Command.class.getName());
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}