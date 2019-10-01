package by.spartakzatawit.model.enums;

import by.spartakzatawit.constants.SQLConstants;

//Перечисление для определения вывода каких конференций
public enum SectionKind {
	ALL(SQLConstants.WHERE_ALL),
	TODAY(SQLConstants.WHERE_TODAY), 
	TOMORROW(SQLConstants.WHERE_TOMORROW),
	SOON(SQLConstants.WHERE_SOON),
	PAST(SQLConstants.WHERE_PAST),
	CONF_BY_USER(SQLConstants.WHERE_CONF_BY_USER);
	
	private String sql;
	
	private SectionKind(String sql) {
		this.sql = sql;
	}
	
	public String getSQL() {
		return SQLConstants.SELECT_CONF + this.sql;
	}
}
