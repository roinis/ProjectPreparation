import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coach extends Job implements Subject {
    private Team team;
    private List<String> tweets;
    private List<Observer> observers;
    enum Certification{GoalkeeperCoach,FitnessCoach,MainCoach,MentalCoach,AssistantCoach}
    private Certification certification;
    private String jobInTheTeam;


    public Coach(Member member,Certification certification) {
        super(member);
        this.team = null;
        this.jobName="coach";
        this.certification=certification;
        this.jobInTheTeam=null;
        tweets=new ArrayList<>();
        observers=new ArrayList<>();
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(3,this);
    }

    public Team getTeam() {
        return team;
    }

    private void setTeam(Team team) {
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

    public boolean addToTeam(Team team,String job){
        if(this.team!=null){
            System.out.println("A coach already has a team");
            return false;
        }
        jobInTheTeam=job;
        setTeam(team);
        return true;
    }

    public boolean removeFromTeam(){
        if(team==null){
            System.out.println("A coach doesn't has a team");
            return false;
        }
        jobInTheTeam=null;
        setTeam(null);
        return true;
    }

    @Override
    public void editDetails() {
        String input;
        Scanner scanner=new Scanner(System.in);
        System.out.println("select a detail to edit");
        System.out.println("1.full name\n"+"2.certification\n"+"3.job in the team");
        input=scanner.nextLine();
        switch (input){
            case "1":
                System.out.println("please choose a new name");
                input=scanner.nextLine();
                getMember().setFull_name(input);
                break;
            case "2":
                setCertification();
                break;
            case "3":
                setJobInTheTeam();
                break;
             default:
                    System.out.println("invalid action");
                    break;
        }
        scanner.close();
    }

    public Certification getCertification() {
        return certification;
    }

    private void setCertification() {
        System.out.println("please choose a certification");
        System.out.println("1.GoalkeeperCoach 2.FitnessCoach 3.MainCoach 4.MentalCoach 5.AssistantCoach");
        Scanner scanner=new Scanner(System.in);
        String certification=scanner.nextLine();
        switch (certification){
            case "1":
                this.certification = Certification.GoalkeeperCoach;
                break;
            case "2":
                this.certification = Certification.FitnessCoach;
                break;
            case "3":
                this.certification = Certification.MainCoach;
                break;
            case "4":
                this.certification = Certification.MentalCoach;
                break;
            case "5":
                this.certification = Certification.AssistantCoach;
                break;
            default:
                System.out.println("invalid action");
                break;
        }
        scanner.close();
    }

    public String getJobInTheTeam() {
        return jobInTheTeam;
    }

    private void setJobInTheTeam() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter the job");
        String job=scanner.nextLine();
        jobInTheTeam=job;
    }

    public List<String> getTweets() {
        return tweets;
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
