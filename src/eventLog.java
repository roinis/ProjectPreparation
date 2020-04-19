import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class eventLog implements Subject{
    private List<Observer> observers;
    private List<event> events;
    private event newEvent;

    public eventLog() {
        observers = new ArrayList<>();
        events = new ArrayList<>();
    }

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
    public void notifyObserver() {
        for (Observer observer:observers) {
            observer.update(newEvent);
        }
    }

    public void addEvent(event newEvent){
        events.add(newEvent);
        this.newEvent = newEvent;
        notifyObserver();
    }

    public event getNewEvent() {
        return newEvent;
    }

    public void setNewEvent(event newEvent) {
        this.newEvent = newEvent;
    }
}
