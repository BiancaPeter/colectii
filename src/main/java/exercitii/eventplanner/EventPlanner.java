package exercitii.eventplanner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventPlanner {
    public static void main(String[] args) {
        LocalDate after = LocalDate.of(2022, 12, 29);
        LocalDate before = LocalDate.of(2023, 1, 1);
        Event event1 = new Event(LocalDate.of(2022, 12, 30), "petrecere");
        Event event2 = new Event(LocalDate.of(2022, 12, 31), "revelion");
        Event event3 = new Event(LocalDate.of(2022, 12, 29), "zi de nastere");
        Event event4 = new Event(LocalDate.of(2023, 2, 1), "after-party");
        List<Event> eventList = new ArrayList<>();
        eventList.add(event1);
        eventList.add(event2);
        eventList.add(event3);
        eventList.add(event4);
        //printeaza o lista cu toate evenimentele care au loc intr-un interval (dupa o anumita data si inainte de lata data)
        System.out.println(findEventsByDateInterval(after, before, eventList));
        System.out.println(getEventsByDateInterval(after, before, eventList));
    }

    public static List<String> findEventsByDateInterval(LocalDate after, LocalDate before, List<Event> eventList) {
        return eventList.stream()
                .filter(event -> event.getDate().isAfter(after))
                .filter(event -> event.getDate().isBefore(before))
                .map(event -> event.getName())
                .collect(Collectors.toList());
    }

    public static List<String> getEventsByDateInterval(LocalDate after, LocalDate before, List<Event> eventList) {
        List<String> eventsInInterval = new ArrayList<>();
        for (Event event : eventList) {
            if (event.getDate().isAfter(after) && event.getDate().isBefore(before)) {
                eventsInInterval.add(event.getName());
            }
        }
        return eventsInInterval;
    }
}
