package by.spartakzatawit.model.enums;

//Класс для работы с перечислением
public class SectionManager {
	
	public static Enum<?> getSectionKind(String param) {
		try {
			//valueOf - возвращает перечисление которое соответсвует строке
			return SectionKind.valueOf(param.toUpperCase());
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return SectionKind.TODAY;
		}
	}
}
