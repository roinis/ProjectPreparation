import java.util.ArrayList;
import java.util.List;

public class Team {

    enum Status{open,close}
    private String teamName;
    private List<TeamOwner> owners;
    private  List<Player> players;
    private List<Coach> coaches;
    private List<TeamManager> managers;
    private List<Member> members;
    private Status status;
    private stadium homeStadium;

    public Team(String teamName, TeamOwner owner, stadium homeStadium) {
        this.teamName=teamName;
        owners=new ArrayList<>();
        players=new ArrayList<>();
        coaches=new ArrayList<>();
        managers=new ArrayList<>();
        owners.add(owner);
        this.status=Status.open;
        this.homeStadium=homeStadium;
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

    public void addOwner(TeamOwner teamOwner){
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        owners.add(teamOwner);
    }

    public void removeOwner(TeamOwner teamOwner) {
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        if (owners.size() == 1) {
            System.out.println("you cant' remove the owner");
            return;
        }
        owners.remove(teamOwner);
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

    public void addManager(TeamManager teamManager) {
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        managers.add(teamManager);
    }

    public void removeManager(TeamManager teamManager) {
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        owners.remove(teamManager);
    }
}