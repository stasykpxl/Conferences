package by.spartakzatawit.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.spartakzatawit.constants.Constants;
import by.spartakzatawit.model.beans.User;
import by.spartakzatawit.model.impl.ConferenceImpl;
import by.spartakzatawit.model.interfaces.IConferenceDAO;


@WebServlet("/removeConf")
public class RemoveConferenceController extends AbstractController {
	private static final long serialVersionUID = 1L;
       
    public RemoveConferenceController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] idConferences = request.getParameterValues(Constants.ID_CONF);
		
		if (idConferences == null) {
			jump(request, response, "/WebProject/" + Constants.HOME_JSP);			
		}
		
		IConferenceDAO confDAO = new ConferenceImpl();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.USER);
		try {
			confDAO.removeConferences(idConferences, user);
			request.setAttribute(Constants.SECTION, Constants.CONF_BY_USER);
			jump(request, response, Constants.CONF_CONTR);
		} catch (SQLException e) {
			e.printStackTrace();
			jumpError(request, response, Constants.HOME_JSP, e.getMessage());
		}
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
