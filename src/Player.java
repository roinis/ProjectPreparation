import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Player extends Job implements Subject{
    public enum Position{ST,CF,CAM,LM,CM,RM,CDM,RW,LW,RB,LB,CB,GK}
    private Position position;
    private Team team;
    private List<Observer> observers;
    private LocalDate dateOfBirth;
    private List<String> tweets;


    public Player(Member member, Position position, LocalDate dateOfBirth) {
        super(member);
        this.team = null;
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
        return dateOfBirth.toString();
    }

    private void setTeam(Team team) {
        this.team = team;
    }

    public String getPositionName(){
        return position.name();
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
        if(this.team!=null){
            System.out.println("A player already has a team");
            return false;
        }
        setTeam(team);
        return true;
    }

    public boolean removeFromTeam(){
        if(team==null){
            System.out.println("A player doesn't has a team");
            return false;
        }
        setTeam(null);
        return true;
    }

    public void editFullName(String newName){
        getMember().setFull_name(newName);
    }

    public boolean editPosition(String newPosition){
        if(setPosition(newPosition))
            return true;
        return false;
    }
    public void editBirthDay(int year,int month,int day){
        setDateOfBirth(year,month,day);
    }

    @Override
    public void editDetails() {
        String input;
        Scanner scanner=new Scanner(System.in);
        System.out.println("select a detail to edit");
        System.out.println("1.full name\n"+"2.position\n"+"3.date of birth");
        input=scanner.nextLine();
        switch (input){
            case "1":
                System.out.println("please choose a new name");
                input=scanner.nextLine();
                getMember().setFull_name(input);
                break;
            case "2":
                setPosition(scanner.nextLine());
                break;
            case "3":
                String year,day,moanth;
                System.out.println("please choose a year");
                year=scanner.nextLine();
                System.out.println("please choose a month");
                moanth=scanner.nextLine();
                System.out.println("please choose a day");
                day=scanner.nextLine();
                setDateOfBirth(Integer.parseInt(year),Integer.parseInt(moanth),Integer.parseInt(day));//לשנות כאשר יהיה UI
                break;
            default:
                System.out.println("invalid action");
                break;
        }
        scanner.close();
    }

    private void setDateOfBirth(int year, int month,int day) {
        this.dateOfBirth =LocalDate.of(year,month,day);
    }

    private boolean setPosition(String test) {
        switch (test){
            case "ST":
                this.position = Position.ST;
                return true;
            case "CF":
                this.position = Position.CF;
                return true;
            case "CAM":
                this.position = Position.CAM;
                return true;
            case "LM":
                this.position = Position.LM;
                return true;
            case "CM":
                this.position = Position.CM;
                return true;
            case "RM":
                this.position = Position.RM;
                return true;
            case "CDM":
                this.position = Position.CDM;
                return true;
            case "RW":
                this.position = Position.RW;
                return true;
            case "LW":
                this.position = Position.LW;
                return true;
            case "RB":
                this.position = Position.RB;
                return true;
            case "LB":
                this.position = Position.LB;
                return true;
            case "CB":
                this.position = Position.CB;
                return true;
            case "GK":
                this.position = Position.GK;
                return true;
            default:
                return false;

        }
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public List<String> getTweets() {
        return tweets;
    }
}
