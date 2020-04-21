import java.util.ArrayList;
import java.util.List;

public class Coach extends Job implements Subject {
    private Team team;
    private List<String> tweets;
    private List<Observer> observers;


    public Coach(Member member, Team team) {
        super(member);
        this.team = team;
        this.jobName="coach";
        tweets=new ArrayList<>();
        observers=new ArrayList<>();
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(3,this);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void addTweet(String tweet){
        tweets.add(tweet);
    }

    public void deleteTweet(int index){
        tweets.remove(index);
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
    public void notifyObserver(Event newEvent) {
        for (Observer observer:observers) {
            observer.update(newEvent);
        }
    }
}
