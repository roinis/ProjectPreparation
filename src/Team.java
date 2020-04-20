import java.util.ArrayList;
import java.util.List;

public class Team implements Subject {

    enum Status{open,close}
    private String teamName;
    private List<TeamOwner> owners;
    private  List<Player> players;
    private List<Coach> coaches;
    private List<TeamManager> managers;
    private Status status;
    private stadium homeStadium;
    private List<Observer> fanObservers;
    private List<Observer> jobsObservers;

    public Team(String teamName, TeamOwner owner, stadium homeStadium) {
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
        member.update(new RemoveNominationEvent(this,member,"Team owner"));
        return true;
    }

    public boolean addManager(TeamManager teamManager) {
        if(status==Status.close){
            System.out.println("the team is close");
            return false;
        }
        jobsObservers.add(teamManager.getMember());
        managers.add(teamManager);
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
        member.update(new RemoveNominationEvent(this,member,"Team manager"));
        return true;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {

        this.status = status;
    }

    public stadium getHomeStadium() {

        return homeStadium;
    }

    public void setHomeStadium(stadium homeStadium) {

        this.homeStadium = homeStadium;
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
    public void notifyObserver(event newEvent) {
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
