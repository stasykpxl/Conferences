package by.spartakzatawit.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.spartakzatawit.constants.Constants;
import by.spartakzatawit.model.beans.Conference;
import by.spartakzatawit.model.beans.Event;
import by.spartakzatawit.model.beans.User;
import by.spartakzatawit.model.factories.EventFactory;
import by.spartakzatawit.model.impl.ConferenceImpl;
import by.spartakzatawit.model.interfaces.IConferenceDAO;

@WebServlet("/addConf")
public class AddConferenceController extends AbstractController {
	private static final long serialVersionUID = 1L;

    public AddConferenceController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter(Constants.TITLE);
		String descr = request.getParameter(Constants.DESCR);
		String place =  request.getParameter(Constants.PLACE);
		String date =  request.getParameter(Constants.DATE);
		if (title == null || descr == null || place == null || date == null) {
			jumpError(request, response, Constants.ADD_CONF_JSP, Constants.NULL_MESS);
			return;
		}
		if (title.equals(Constants.EMPTY)) {
			jumpError(request, response, Constants.ADD_CONF_JSP, Constants.EMPTY_MESS);
			return;
		}
		
		try {
			Conference conference = new Conference(title, descr, place, date);
			HttpSession session = request.getSession();
			//Вытягиваем юзера из сессии
			User user = (User) session.getAttribute(Constants.USER);
			IConferenceDAO confDAO = new ConferenceImpl();
			int idConf = confDAO.addConference(conference, user);	
			if (idConf != -1) {
				String[] titlesEvents = request.getParameterValues(Constants.TITLE_EVENT);
				String[] timesEvents = request.getParameterValues(Constants.TIME);
				List<Event> events = EventFactory.getEvents(titlesEvents, timesEvents);
				confDAO.addConferenceEvents(events, idConf);
				jump(request, response, Constants.CONF_CONTR);
			} else {
				jumpError(request, response, Constants.ADD_CONF_JSP, Constants.WRONG_ADD_CONFE);
			}
			return;
		} catch (ParseException e) {
			e.printStackTrace();
			jumpError(request, response, Constants.ADD_CONF_JSP, Constants.INCORRECT_DATE);
		} catch (SQLException e) {
			e.printStackTrace();
			jumpError(request, response, Constants.ADD_CONF_JSP, e.getMessage());
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
