package by.spartakzatawit.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.spartakzatawit.constants.Constants;
import by.spartakzatawit.model.beans.User;
import by.spartakzatawit.model.impl.UserImpl;
import by.spartakzatawit.model.interfaces.IUserDAO;

//Выполняет создание объекта юзера, открывает сессию
@WebServlet("/login") //адресс сервлета и его регистрация через анатацию
public class LoginController extends AbstractController {
	private static final long serialVersionUID = 1L;
  
    public LoginController() {
        super();
    }

    // TODO
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Отлавливаем данные пользователя
		String login = request.getParameter(Constants.LOGIN);
		String password = request.getParameter(Constants.PASSWORD);
		
		//Проверка на null: login and password
		if (login == null || password == null) {
			//Перенаправляем на логин jsp и выводит сообщение ошибки
			jumpError(request, response, Constants.LOGIN_JSP, Constants.NULL_MESS);
			return;
		}
		
		//Избавление от пробелов при введенных данных
		login = login.trim();
		password = password.trim();
		
		//Проверка на пустоту введенных значений
		if (login.equals(Constants.EMPTY) || password.equals(Constants.EMPTY)) {
			//Перенаправляет на логин jsp и выводит сообщение ошибки
			jumpError(request, response, Constants.LOGIN_JSP, Constants.EMPTY_MESS);
			return;
		}
		
		//Получаем имплементацию(Получение юзера из ДБ через прослойку DAO)
		IUserDAO userDAO = new UserImpl();
		try {
			User user = userDAO.getUser(login, password);
			//Проверка юсера на null
			if (user != null) {
				//Создание сессии, если true то ищет и возвращает старую сессию, если не отдаем true, то создается сессия
				HttpSession session = request.getSession(true);
				//session.setMaxInactiveInterval(60); установка времени сесси в минутах
				//session.invalidate(); удаление сессии
				//Установка атрибутов на хранение в сессию
				session.setAttribute(Constants.USER, user);
				jump(request, response, Constants.CONF_CONTR);
			} else {
				jumpError(request, response, Constants.LOGIN_JSP, Constants.USER_NOT_FOUND);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			jumpError(request, response, Constants.LOGIN_JSP, e.getMessage());
		}
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
