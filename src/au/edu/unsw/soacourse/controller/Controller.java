package au.edu.unsw.soacourse.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@WebServlet({ "/Controller", "/control" })
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private HashMap<Actions, Command> commands;

	private enum Actions {
		Register, AdminLogin,Activation,Login,ToEditProfile,EditProfile
	};

	public Controller() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		commands = new HashMap<Actions, Command>();
		commands.put(Actions.Register, new RegisterCommand());
		commands.put(Actions.Activation, new ActivationCommand());
		commands.put(Actions.Login, new LoginCommand());
		commands.put(Actions.ToEditProfile, new ToEditProfileCommand());
		commands.put(Actions.EditProfile, new EditProfileCommand());

	}

	//
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String actionParameter = request.getParameter("action");

		Actions action;

		if (actionParameter == null || actionParameter.isEmpty()) {
			action = Actions.AdminLogin;
		} else
			action = Enum.valueOf(Actions.class, actionParameter);

		if (action == null) {
			response.sendError(404);
		} else {
			Command command = commands.get(action);
			command.execute(request, response);
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		 handleRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

}