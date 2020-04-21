import java.util.ArrayList;
import java.util.List;

public class EventLog implements Observer{
    private List<Observer> observers;
    private List<Event> events;
    private Event newEvent;

    public EventLog() {
        observers = new ArrayList<>();
        events = new ArrayList<>();
    }
/**
    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver(event newEvent) {
        events.add(newEvent)
        for (Observer observer:observers) {
            observer.update(newEvent);
        }
    }
**/


    public Event getNewEvent() {
        return newEvent;
    }

    public void setNewEvent(Event newEvent) {
        this.newEvent = newEvent;
    }


    @Override
    public void update(Event newEvent) {
        events.add(newEvent);
        this.newEvent = newEvent;
    }
}
