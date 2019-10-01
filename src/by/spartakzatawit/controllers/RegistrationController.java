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
import by.spartakzatawit.model.impl.UserImpl;
import by.spartakzatawit.model.interfaces.IUserDAO;

@WebServlet("/regist")
public class RegistrationController extends AbstractController {
	private static final long serialVersionUID = 1L;
       
    public RegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(Constants.LOGIN);
		String password = request.getParameter(Constants.PASSWORD);
		String firstName = request.getParameter(Constants.FIRST_NAME);
		String secondName = request.getParameter(Constants.SECOND_NAME);
		String email = request.getParameter(Constants.EMAIL);
		
		if(login == null || password == null || email == null || firstName == null || secondName == null) {
			jumpError(request, response, Constants.REGIST_JSP, Constants.NULL_MESS);
			return;
		} 
		
		login = login.trim();
		password = password.trim();
		firstName = firstName.trim();
		secondName = secondName.trim();
		email = email.trim();
		
		if (login.equals(Constants.EMPTY ) || password.equals(Constants.EMPTY ) ||
				firstName.equals(Constants.EMPTY ) || secondName.equals(Constants.EMPTY) ||
																								  email.equals(Constants.EMPTY)){
			jumpError(request, response, Constants.REGIST_JSP, Constants.EMPTY_MESS);
			return;
		}
		
		//Создадим имплементацию DAO и юзера
		IUserDAO userDAO = new UserImpl();
		User user = new User(login, firstName, secondName, email);
		
		try {
			if (userDAO.isAddUser(user, password)) {
				HttpSession session = request.getSession();
				//Добавляем пользователя в сессию
				session.setAttribute(Constants.USER, user);
				
				jump(request, response, Constants.CONF_CONTR);
			} else {
				jumpError(request, response, Constants.INDEX_JSP, Constants.USER_FOUND_MESS);
			}
			
		} catch (SQLException e) {
			jumpError(request, response, Constants.REGIST_JSP, e.getMessage());
			e.printStackTrace();
		}
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
