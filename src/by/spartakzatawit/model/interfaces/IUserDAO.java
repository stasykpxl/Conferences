package by.spartakzatawit.model.interfaces;

import java.sql.SQLException;

import by.spartakzatawit.model.beans.User;


//Прослойка между ДБ и приложением для использования разных ДБ
public interface IUserDAO {
	
	//Метод который будет искать пользователя в ДБ и возвращать его
	User getUser(String login, String password) throws SQLException;
	//Метод регистрации юзера
	boolean isAddUser(User user, String password) throws SQLException;
}
