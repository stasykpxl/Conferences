package by.spartakzatawit.constants;

public class SQLConstants {
	//Запрос на нахождения юсера
	public static final String SELECT_USER = "select * from users where login=? and password=?";
	
	//Вставка нового пользователя в БД
	public static final String INSERT_USER = "insert into users(login,password,firstname,secondname,email) "
																	  + "values(?,?,?,?,?)";
	
	//Запрос на проверку логина 
	public static final String FOUND_LOGIN = "select id from users where login=?"; 
	
	//Запрос на вывод конференций
	public static final String SELECT_CONF = "select * from conferences "; 
	
	//Запрос на вывод всех конференций
	public static final String WHERE_ALL = ""; 
	
	//Запрос на вывод конференций на сегодня CURRENT_DATE() - функция SQL
	public static final String WHERE_TODAY = "where date=CURRENT_DATE()"; 
	
	//Запрос на вывод конференций на завтра
	public static final String WHERE_TOMORROW = "where date=DATE_ADD(CURRENT_DATE(),INTERVAL 1 DAY)"; 
	
	//Запрос на вывод конференций которые скоро
	public  static final String WHERE_SOON = "where date>DATE_ADD(CURRENT_DATE(),INTERVAL 1 DAY)";
			
	//Запрос на вывод прошедших конференций 
	public static final String WHERE_PAST = "where date<CURRENT_DATE()"; 
	
	//Запрос на вывод конференций юзера
	public static final String WHERE_CONF_BY_USER = "where idUser=?";
	
	//Запрос на вывод ивентов
	public static final String SELECT_EVENTS = "select events.id, events.title, events.time from events "
											+ "join conferences on idConf = conferences.id where idConf=? order by time";
	
	//Запрос на добавление конференции
	public static final String INSERT_CONF = "insert into conferences(idUser,title,descr,place,date) "
																		+ "values(?,?,?,?,?)";
	
	//Запрос на удаление конференций
	public static final String DELETE_CONF = "delete from conferences,events using conferences,events "
											+ "where conferences.id=? and conferences.idUser=? "
											+ "and conferences.id=events.idConf";
	
	//Запрос на добавление ивентов
	public static final String INSERT_EVENTS = "insert into events(idConf,title,time) values(?,?,?)";

	//Имена в БД 
	public static final String LOGIN_LABEL = "login";
	public static final String ID_LABEL = "id";
	public static final String TITLE_LABEL = "title";
	public static final String DESCR_LABEL = "descr";
	public static final String PLACE_LABEL = "place";
	public static final String DATE_LABEL = "date";
	public static final String TIME_LABEL = "time";
	public static final String FNAME_LABEL = "firstname";
	public static final String SNAME_LABEL = "secondname";
	public static final String EMAIL_LABEL = "email";

}
