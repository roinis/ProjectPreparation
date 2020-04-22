import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Player extends Job implements Subject{
    private Team team;
    private List<Observer> observers;


    enum Position{ST,CF,CAM,LM,CM,RM,CDM,RW,LW,RB,LB,CB,GK}
    private Position position;
    private Date dateOfBirth;
    private List<String> tweets;


    public Player(Member member, Position position, Date dateOfBirth) {
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(dateOfBirth);
        return strDate;
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
        if(team!=null){
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
                setPosition();
                break;
            case "3":
                setDateOfBirth(new Date());//לשנות כאשר יהיה UI
                break;
            default:
                System.out.println("invalid action");
                break;
        }
        scanner.close();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Position getPosition() {
        return position;
    }

    private void setPosition() {
        System.out.println("please choose a position");
        System.out.println("ST,CF,CAM,LM,CM,RM,CDM,RW,LW,RB,LB,CB,GK");
        Scanner scanner=new Scanner(System.in);
        String certification=scanner.nextLine();
        switch (certification){
            case "ST":
                this.position = Position.ST;
                break;
            case "CF":
                this.position = Position.CF;
                break;
            case "CAM":
                this.position = Position.CAM;
                break;
            case "LM":
                this.position = Position.LM;
                break;
            case "CM":
                this.position = Position.CM;
                break;
            case "RM":
                this.position = Position.RM;
                break;
            case "CDM":
                this.position = Position.CDM;
                break;
            case "RW":
                this.position = Position.RW;
                break;
            case "LW":
                this.position = Position.LW;
                break;
            case "RB":
                this.position = Position.RB;
                break;
            case "LB":
                this.position = Position.LB;
                break;
            case "CB":
                this.position = Position.CB;
                break;
            case "GK":
                this.position = Position.GK;
                break;
            default:
                System.out.println("invalid action");
                break;
        }
        scanner.close();
    }
}
