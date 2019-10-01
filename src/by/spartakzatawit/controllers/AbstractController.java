package by.spartakzatawit.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.spartakzatawit.constants.Constants;


//Абстрактный класс
@WebServlet("/AbstractController")
public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AbstractController() {
        super();
    }
    
    //Метод перенаправления
    protected void jump(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
    	//
    	RequestDispatcher rd = request.getRequestDispatcher(url);
    	rd.forward(request, response);
    }
    
    //Метод перенаправления при ошибке
    //message - сообщение об ошибке(помещаем в request)
    protected void jumpError(HttpServletRequest request, HttpServletResponse response, String url, String message) throws ServletException, IOException {
		request.setAttribute(Constants.MESSAGE, message);
		jump(request, response, url);
	}
}
