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

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import by.spartakzatawit.constants.Constants;
import by.spartakzatawit.model.beans.Conference;
import by.spartakzatawit.model.impl.ConferenceImpl;
import by.spartakzatawit.model.interfaces.IConferenceDAO;

@WebServlet("/viewConf")
public class ViewConferenceController extends AbstractController {
	private static final long serialVersionUID = 1L;
       
    public ViewConferenceController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idConf = request.getParameter(Constants.ID_CONF);
		
		if (idConf == null) {
			jump(request, response, Constants.CONF_CONTR);
		}
		
		IConferenceDAO confDAO = new ConferenceImpl();
		HttpSession session = request.getSession(true);
		//Достаем лист конференций из сессии
		List<Conference> conferences = (List<Conference>) session.getAttribute(Constants.CONF_LIST);
		try {
			int indexConf = confDAO.fillConferenceEvents(conferences, idConf);
			if (indexConf != -1) {
				session.setAttribute(Constants.INDEX_CONF, indexConf);
				jump(request, response, Constants.CONF_JSP);
			} else {
				jumpError(request, response, Constants.INDEX_JSP, Constants.ERROR_MESS);
			}	
		} catch (SQLException | ParseException e) {
			jumpError(request, response, Constants.INDEX_JSP, e.getMessage());
			e.printStackTrace();
		}
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
