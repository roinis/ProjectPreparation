import java.util.ArrayList;
import java.util.List;

public class Coach extends Job implements Subject {
    private Team team;
    private List<String> tweets;
    private List<Observer> observers;


    public Coach(Member member) {
        super(member);
        this.team = null;
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
        notifyObserver(new TewwtEvent(tweet));
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

    public boolean addToTeam(Team team){
        if(team!=null){
            System.out.println("A coach already has a team");
            return false;
        }
        setTeam(team);
        return true;
    }

    public boolean removeFromTeam(){
        if(team==null){
            System.out.println("A coach doesn't has a team");
            return false;
        }
        setTeam(null);
        return true;
    }

    @Override
    public void editDetails() {

    }
}
