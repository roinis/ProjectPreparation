import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Player extends Job implements Subject{
    private Team team;
    private List<Observer> observers;


    enum Position{ST,CF,CAM,LM,CM,RM,CDM,RW,LW,RB,LB,CB,GK}
    private Position position;
    private Date dateOfBirth;
    private List<String> tweets;


    public Player(Member member, Team team, Position position, Date dateOfBirth) {
        super(member);
        this.team = team;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.jobName="player";
        tweets=new ArrayList<>();
        observers=new ArrayList<>();
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(7,this);
    }

    public Team getTeam() {
        return team;
    }

    public String getStringBirthDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(dateOfBirth);
        return strDate;
    }

    private void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public String getPositionName(){
        return position.name();
    }

    public void setPosition(Position position) {
        this.position = position;
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
            System.out.println("A player already has a team");
            return false;
        }
        setTeam(team);
        return true;
    }

    public boolean removeFromTeam(){
        if(team==null){
            System.out.println("A player dont have a team");
            return false;
        }
        setTeam(null);
        return true;
    }

    @Override
    public void editDetails() {

    }

}
