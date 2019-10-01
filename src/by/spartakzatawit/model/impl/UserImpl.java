package by.spartakzatawit.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.spartakzatawit.constants.SQLConstants;
import by.spartakzatawit.model.beans.User;
import by.spartakzatawit.model.db.ConnectionManager;
import by.spartakzatawit.model.interfaces.IUserDAO;

//Реализация юсера через прослойку DAO
public class UserImpl implements IUserDAO{

	@Override
	public User getUser(String login, String password)  throws SQLException{
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			//Создаем соединение
			cn = ConnectionManager.createConnection();
			
			//Для получения юсера создаем prepareStatement, который принимает SQL запрос
			pst = cn.prepareStatement(SQLConstants.SELECT_USER);
			pst.setString(1, login);
			pst.setString(2, password);
			
			//Получение результата запроса в БД
			rs = pst.executeQuery();
			while (rs.next()) {
				//Достаем логин, id, name, email: "login(DB)" 
				int id = rs.getInt(SQLConstants.ID_LABEL);
				String log = rs.getString(SQLConstants.LOGIN_LABEL);
				String firstName = rs.getString(SQLConstants.FNAME_LABEL);
				String secondName = rs.getString(SQLConstants.SNAME_LABEL);
				String email = rs.getString(SQLConstants.EMAIL_LABEL);
				user = new User(id, login, firstName, secondName, email);
			}
		} finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(pst);
			ConnectionManager.closeConnection();
		}
			return user;
	}

	//Метод регистрации юзера
	@Override
	public boolean isAddUser(User user, String password) throws SQLException {
		Connection cn = null;
		PreparedStatement pst = null;
		boolean result = false;
		
		try {
			cn = ConnectionManager.createConnection();
			pst = cn.prepareStatement(SQLConstants.INSERT_USER);
			
			//"insert into users(login,password,firstname,secondname,email) values(?,?,?,?,?)" - вставляем значения
			pst.setString(1, user.getLogin());
			pst.setString(2, password);
			pst.setString(3,  user.getFirstName());
			pst.setString(4, user.getSecondName());
			pst.setString(5, user.getEmail());
			
			//Чтобы только один регистрирующийся мог вызывать метод
			synchronized (UserImpl.class) {
				if (!isFoundLogin(user.getLogin())) {
					pst.executeUpdate();
					result = true;
				}
			}
		} finally {
			ConnectionManager.closeStatement(pst);
			ConnectionManager.closeConnection();
		}
		return result;
	}
	
	//Проверка на одинаковый логин в БД
	private boolean isFoundLogin(String login) throws SQLException {
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean result = false;
		
		try {
			cn = ConnectionManager.createConnection();
			pst = cn.prepareStatement(SQLConstants.FOUND_LOGIN);
			pst.setString(1, login);
			//pst.executeQuery(); - выполнение запроса  setString(1, login); - для подстановки логина вместо ? в запросе
			rs = pst.executeQuery();
			result = rs.next();	
		}finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(pst);
			//ConnectionManager.createConnection() - не закрываем т.к. метод будет работать в другом методе
		}
		return result;		
	}

	
}
