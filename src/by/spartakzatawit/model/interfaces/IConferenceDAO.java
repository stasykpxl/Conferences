package by.spartakzatawit.model.interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import by.spartakzatawit.model.beans.Conference;
import by.spartakzatawit.model.beans.Event;
import by.spartakzatawit.model.beans.User;

public interface IConferenceDAO {
	//Метод для получения конференций
	List<Conference> getConferences(Enum<?> section, User user) throws SQLException;
	
	//Метод для заполнения конференций ивентами
	int fillConferenceEvents(List<Conference> conferences, String idConf) throws SQLException, ParseException;	
	
	//Метод для добавления конференции
	int addConference(Conference conference, User user) throws SQLException;
	
	//Метод добавления событий
	void addConferenceEvents(List<Event> events, int idConf) throws SQLException;
	
	//Метод удаления конференций
	void removeConferences(String[] idConferences, User user) throws SQLException;
}
