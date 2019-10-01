package by.spartakzatawit.constants;


//Класс для хранения константых значений
public final  class Constants {
	//Константы для конекшена к ДБ
	public final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public final static String URL_DB = "jdbc:mysql://localhost/webappconferences?serverTimezone=Europe/Minsk";
	public final static String USER_DB = "root";
	public final static String PASSWORD_DB = "";
	
	//Константы - сохранения и получения данных(со страниц jsp их имена на страницах) 
	public static final String LOGIN = "login";
	public static final String PASSWORD = "password";
	public static final String FIRST_NAME = "firstName";
	public static final String SECOND_NAME = "secondName";
	public static final String EMAIL = "email";
	public static final String SECTION = "section";
	public static final String USER = "user";
	public static final String MESSAGE = "message";
	public static final String TODAY = "today";
	public static final String CONF_LIST = "conferences";
	public static final String ID_CONF = "idConf";
	public static final String INDEX_CONF = "indexConf";
	public static final String TITLE = "title";
	public static final String TITLE_EVENT = "evTitle";
	public static final String DESCR = "descr";
	public static final String PLACE = "place";
	public static final String DATE = "date";
	public static final String TIME = "time";
	
	//Константа - пусто
	public static final String EMPTY = "";
	public static final String CONF_BY_USER = "conf_by_user";
	//Формат даты
	public static final String TIME_PATTERN = "HH:mm";
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	
	//Константы - сообщения	
	public static final String NULL_MESS = "Fields are null";
	public static final String EMPTY_MESS = "Fields are empty";
	public static final String USER_NOT_FOUND = "User not found";
	public static final String USER_FOUND_MESS = "User is exists";
	public static final String ERROR_MESS = "Error data";
	public static final String INCORRECT_DATE = "Incorrect date";
	public static final String WRONG_ADD_CONFE = "Not add new conference";
	public static final String NOT_SELECT_CONF = "";
	
	//Константы - адресса сервлетов и страниц
	public static final String LOGIN_JSP = "/login.jsp";
	public static final String INDEX_JSP = "/index.jsp";
	public static final String REGIST_JSP = "/regist.jsp";
	public static final String CONF_JSP = "/conf.jsp";
	public static final String OUT_JSP = "/WebProject/start.jsp";
	public static final String ADD_CONF_JSP = "/addConf.jsp";
	public static final String CONF_CONTR = "/conf";
	public static final String HOME_JSP = "/home.jsp";

	
	
}
