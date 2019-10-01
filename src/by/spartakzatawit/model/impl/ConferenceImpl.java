package by.spartakzatawit.model.impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import by.spartakzatawit.constants.SQLConstants;
import by.spartakzatawit.model.beans.Conference;
import by.spartakzatawit.model.beans.Event;
import by.spartakzatawit.model.beans.User;
import by.spartakzatawit.model.db.ConnectionManager;
import by.spartakzatawit.model.enums.SectionKind;
import by.spartakzatawit.model.interfaces.IConferenceDAO;
import by.spartakzatawit.model.managers.ConferenceManager;

//Класс для получения конференций из БД
public class ConferenceImpl implements IConferenceDAO {

	//Метод получения коференций
	@Override
	public List<Conference> getConferences(Enum<?> section, User user) throws SQLException {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
				
		//Получаем перечисление того что нам выводить из БД
		SectionKind sect = (SectionKind) section;
		String sql = sect.getSQL();
		
		List<Conference> conferences = new ArrayList<Conference>();
		
		try {
			cn = ConnectionManager.createConnection();
			st = cn.prepareStatement(sql);
			if (sect == SectionKind.CONF_BY_USER) {
				st.setInt(1, user.getId());				
			}
			rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(SQLConstants.ID_LABEL);
				String title = rs.getString(SQLConstants.TITLE_LABEL);
				String descr = rs.getString(SQLConstants.DESCR_LABEL);
				String place = rs.getString(SQLConstants.PLACE_LABEL);
				Date date = rs.getDate(SQLConstants.DATE_LABEL);
				conferences.add(new Conference(id, title, descr, place, date));
			}
		} finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(st);
			ConnectionManager.closeConnection();
		}
		return conferences;
	}

	//Метод добавления ивентов
	@Override
	public int fillConferenceEvents(List<Conference> conferences, String idConf) throws SQLException, ParseException {
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		int indexConf = ConferenceManager.getIndex(conferences, idConf);
		if (indexConf == -1) {
			return indexConf;
		}
		
		try {
			cn = ConnectionManager.createConnection();
			pst = cn.prepareStatement(SQLConstants.SELECT_EVENTS);
			pst.setString(1, idConf);
			rs = pst.executeQuery();
			
			List<Event> events = new ArrayList<Event>();
			
			while (rs.next()) {
				int id = rs.getInt(SQLConstants.ID_LABEL);
				String title = rs.getString(SQLConstants.TITLE_LABEL);
				String time = rs.getString(SQLConstants.TIME_LABEL);
				events.add(new Event(id, title, time));
				
			}
			conferences.get(indexConf).setEvents(events);;
		} finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(pst);
			ConnectionManager.closeConnection();
		}
		return indexConf;
	}

	//Метод для добавления юзера
	@Override
	public int addConference(Conference conference, User user) throws SQLException {
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int idConf = -1;
		try {
			cn = ConnectionManager.createConnection();
			//Statement.RETURN_GENERATED_KEYS - возвращает то значание что устанавливается овтаматически в БД
			pst = cn.prepareStatement(SQLConstants.INSERT_CONF, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, user.getId());
			pst.setString(2, conference.getTitle());
			pst.setString(3, conference.getDescr());
			pst.setString(4, conference.getPlace());
			pst.setDate(5, conference.getDate());
			
			if (pst.executeUpdate() != 0) {
				// pst.getGeneratedKeys() - возвращает количество созданных ключей
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					idConf = rs.getInt(1);	
				}
			}
		} finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(pst);
			ConnectionManager.closeConnection();
		}	
		return idConf;
	}

	//Метод добавления ивентов
	@Override
	public void addConferenceEvents(List<Event> events, int idConf) throws SQLException {
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			cn = ConnectionManager.createConnection();
			pst = cn.prepareStatement(SQLConstants.INSERT_EVENTS);
			pst.setInt(1, idConf);
			for (Event event : events) {
				pst.setString(2, event.getTitle());
				pst.setTime(3, event.getTime());
				pst.executeUpdate();
			}
		} finally {
			ConnectionManager.closeStatement(pst);
			ConnectionManager.closeConnection();
		}	
	}

	//Метод удаления конференций
	@Override
	public void removeConferences(String[] idConferences, User user) throws SQLException {	
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			cn = ConnectionManager.createConnection();
			pst = cn.prepareStatement(SQLConstants.DELETE_CONF);
			pst.setInt(2, user.getId());
			for (String idConf : idConferences) {
				pst.setString(1, idConf);
				pst.executeUpdate();
			}			
		} finally {
			ConnectionManager.closeStatement(pst);
			ConnectionManager.closeConnection();
		}	
	}
	
}
