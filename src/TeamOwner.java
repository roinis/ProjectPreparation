import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TeamOwner extends Job{
    private Team team;
    private List<Job> appointmentList;

    public TeamOwner(Team team, Member member) {
        super(member);
        this.team = team;
        appointmentList =new ArrayList<>();
        this.jobName="owner";
        this.addAllPermissions();
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(6,this);
    }

    public void addOwner(String userName){
        UsersInformation usersInformation=new UsersInformation();
        Member member=usersInformation.getSpecificMember(userName);
        if(checker(member))
            return;
        if(member.getJob("owner")!=null){
            System.out.println("this member already a owner");
            return;
        }
        TeamOwner newOwner=new TeamOwner(team,member);
        if(team.addOwner(newOwner)) {
            member.addJob(newOwner);
            appointmentList.add(newOwner);
            System.out.println("the member " + userName + " add to " + team.getTeamName() + " team owners");
        }
    }

    public void removeOwner(String userName){
        UsersInformation usersInformation=new UsersInformation();
        Member member=usersInformation.getSpecificMember(userName);
        if(checker(member))
            return;
        TeamOwner teamOwner=(TeamOwner)member.getJob("owner");
        if(teamOwner==null){
            System.out.println("this member is not a owner");
            return;
        }
        if(!appointmentList.contains(teamOwner)){
            System.out.println("you cant' remove this owner");
            return;
        }
        if(team.removeOwner(teamOwner)) {
            appointmentList.remove(teamOwner);
            System.out.println("the member " + userName + " remove from " + team.getTeamName() + " team owners");
        }
    }

    public void openTeam(){
        if(team.getStatus()== Team.Status.open){
            System.out.println("the team already open");
            return;
        }
        team.setStatus(Team.Status.open);
        this.addAllPermissions();
        System.out.println("the team is open now");
    }

    public void closeTeam(){
        if(team.getStatus()== Team.Status.close){
            System.out.println("the team already close");
            return;
        }
        List<Job> owners=(List<Job>)(List<?>) team.getOwners();
        List<Job> players=(List<Job>)(List<?>)team.getPlayers();
        List<Job> coaches=(List<Job>)(List<?>)team.getCoaches();
        List<Job> managers=(List<Job>)(List<?>)team.getManagers();
        removeAllPermissions(owners);
        removeAllPermissions(players);
        removeAllPermissions(coaches);
        removeAllPermissions(managers);
        System.out.println("the team is close now");
    }

    public void addManager(String userName){
        UsersInformation usersInformation=new UsersInformation();
        Member member=usersInformation.getSpecificMember(userName);
        if(checker(member))
            return;
        if(member.getJob("manager")!=null){
            System.out.println("this member already a manager");
            return;
        }
        if(member.getJob("owner")!=null){
            System.out.println("this member already a owner");
            return;
        }
        ArrayList<Job.Permissions> permissions=choosePermissions();
        TeamManager teamManager=new TeamManager(member,team,permissions);
        if(team.addManager(teamManager)) {
            member.addJob(teamManager);
            appointmentList.add(teamManager);
            System.out.println("the member " + userName + " add to " + team.getTeamName() + " team managers");
        }
    }

    public void removeManger(String userName){
        UsersInformation usersInformation=new UsersInformation();
        Member member=usersInformation.getSpecificMember(userName);
        if(checker(member))
            return;
        TeamManager teamManager=(TeamManager) member.getJob("owner");
        if(teamManager==null){
            System.out.println("this member is not a manager");
            return;
        }
        if(!appointmentList.contains(teamManager)){
            System.out.println("you cant' remove this manager");
            return;
        }
        if(team.removeManager(teamManager)) {
            appointmentList.remove(teamManager);
            System.out.println("the member " + userName + " remove from " + team.getTeamName() + " team managers");
        }
    }

    private void removeAllPermissions(List<Job> jobList){
        for(Job job:jobList)
            job.removeAllPermissions();
    }

    private boolean checker(Member member){
        if(team.getStatus()== Team.Status.close){
            System.out.println("the team is close");
            return true;
        }
        if(member==null){
            System.out.println("the user name not exist");
             return true;
        }
        return false;
    }

    private ArrayList<Job.Permissions> choosePermissions(){
        return new ArrayList<>();
    }

}
