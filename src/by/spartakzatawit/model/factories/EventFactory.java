package by.spartakzatawit.model.factories;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import by.spartakzatawit.model.beans.Event;

public class EventFactory {
	public static List<Event> getEvents(String[] titlesEvents, String[] timesEvents) throws ParseException {
		List<Event> events = new ArrayList<Event>();
		for (int i = 0; i < timesEvents.length; i++) {
			String title = titlesEvents[i];
			String time = timesEvents[i];
			try {
				events.add(new Event(title, time));
			} catch (ParseException e) {
				throw e;
			}
		}
		return events;
	}
}
