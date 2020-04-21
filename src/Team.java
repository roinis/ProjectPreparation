import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
public class Team implements Subject {

    enum Status{open,close}
    private String teamName;
    private List<TeamOwner> owners;
    private  List<Player> players;
    private List<Coach> coaches;
    private List<TeamManager> managers;
    private Status status;
    private Stadium homeStadium;
    private List<Observer> fanObservers;
    private List<Observer> jobsObservers;
    private List<String> tweets;

    public Team(String teamName, TeamOwner owner, Stadium homeStadium) {
        this.teamName=teamName;
        owners=new ArrayList<>();
        players=new ArrayList<>();
        coaches=new ArrayList<>();
        managers=new ArrayList<>();
        owners.add(owner);
        this.status=Status.open;
        this.homeStadium=homeStadium;
        fanObservers=new ArrayList<>();
        jobsObservers=new ArrayList<>();
        tweets=new ArrayList<>();
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(4,this);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        this.teamName = teamName;
    }

    public List<TeamOwner> getOwners() {
        return owners;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<TeamManager> getManagers() {
        return managers;
    }

    public boolean addOwner(TeamOwner teamOwner){
        if(status==Status.close){
            System.out.println("the team is close");
            return false;
        }
        jobsObservers.add(teamOwner.getMember());
        owners.add(teamOwner);
        notifyObserver(new NewNominationEvent(this,teamOwner.getMember(),"Team owner"));
        return true;
    }

    public boolean removeOwner(TeamOwner teamOwner) {
        if(status==Status.close){
            System.out.println("the team is close");
            return false;
        }
        if (owners.size() == 1) {
            System.out.println("you cant' remove the owner");
            return false;
        }
        Member member=teamOwner.getMember();
        member.removeJob("owner");
        owners.remove(teamOwner);
        jobsObservers.remove(teamOwner);
        RemoveNominationEvent event=new RemoveNominationEvent(this,member,"Team owner");
        member.update(event);
        notifyObserver(event);
        return true;
    }

    public boolean addManager(TeamManager teamManager) {
        if(status==Status.close){
            System.out.println("the team is close");
            return false;
        }
        jobsObservers.add(teamManager.getMember());
        managers.add(teamManager);
        notifyObserver(new NewNominationEvent(this,teamManager.getMember(),"Team manager"));
        return true;
    }

    public boolean removeManager(TeamManager teamManager) {
        if(status==Status.close){
            System.out.println("the team is close");
            return false;
        }
        Member member=teamManager.getMember();
        member.removeJob("manager");
        managers.remove(teamManager);
        jobsObservers.remove(teamManager);
        RemoveNominationEvent event=new RemoveNominationEvent(this,member,"Team manager");
        member.update(event);
        notifyObserver(event);
        return true;
    }

    public Status getStatus() {
        return status;
    }

    public boolean setStatus(Status status) {
        if(status == this.status){
            System.out.println("the team already "+this.status);
            return false;
        }
        this.status = status;
        if(this.status== Status.open) {
            notifyObserver(new TeamReOpenEvent(LocalDateTime.now(),this));
        }
        else if(this.status==Status.close){
            removeAllTeamPermissions();
            notifyObserver(new TeamCloseEvent(LocalDateTime.now(),this));
        }
        System.out.println("the team is "+status+" now");
        return true;
    }

    public Stadium getHomeStadium() {

        return homeStadium;
    }

    public void setHomeStadium(Stadium homeStadium) {

        this.homeStadium = homeStadium;
    }

    private void removeAllTeamPermissions(){
        removeAllPermissions((List<Job>) (List<?>)owners);
        removeAllPermissions((List<Job>) (List<?>)players);
        removeAllPermissions((List<Job>) (List<?>)coaches);
        removeAllPermissions((List<Job>) (List<?>)managers);
    }

    private void removeAllPermissions(List<Job> jobList){
        for(Job job:jobList)
            job.removeAllPermissions();
    }

    public void addTweet(String tweet){
        tweets.add(tweet);
    }

    public void deleteTweet(int index){
        tweets.remove(index);
    }

    @Override
    public void register(Observer newObserver) {
        /*else if(newObserver instanceof )//נציג התאחדות
            jobsObservers.add(newObserver);*/
            fanObservers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = fanObservers.indexOf(deleteObserver);
        fanObservers.remove(observerIndex);
    }

    @Override
    public void notifyObserver(Event newEvent) {
        if(newEvent instanceof TeamReOpenEvent){
            for (Observer observer:jobsObservers) {
                observer.update(newEvent);
            }
        }
        if(newEvent instanceof TeamCloseEvent){
            for (Observer observer:jobsObservers) {
                observer.update(newEvent);
            }
        }
        for (Observer observer:fanObservers) {
            observer.update(newEvent);
        }
    }

}
