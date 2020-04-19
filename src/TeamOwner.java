import java.util.ArrayList;
import java.util.List;

public class TeamOwner extends Job {
    private Team team;
    private List<TeamOwner> ownerList;

    public TeamOwner(Team team,Member member) {
        super(member);
        this.team = team;
        ownerList=new ArrayList<>();
    }

    public void addOwner(Member member){//לשנות לפי מזהה
        if(team.getStatus()== Team.Status.close){
            System.out.println("the team is close");
            return;
        }
        if(member.isAOwnaer()){
            System.out.println("this member already a owner");
            return;
        }
        TeamOwner newOwner=new TeamOwner(team,member);
        member.addJob(newOwner);
        team.addOwner(newOwner);
        ownerList.add(newOwner);
    }

    public void removeOwner(Member member){//לשנות לפי מזהה
        if(team.getStatus()== Team.Status.close){
            System.out.println("the team is close");
            return;
        }
        if(!member.isAOwnaer()){
            System.out.println("this member is not a owner");
            return;
        }
        TeamOwner teamOwner=member.getOwner();
        if(!ownerList.contains(teamOwner)){
            System.out.println("you cant' remove this owner");
            return;
        }
        team.removeOwner(teamOwner);
        member.removeJob(teamOwner);
        ownerList.remove(teamOwner);
    }

    public void openTeam(){
        if(team.getStatus()== Team.Status.open){
            System.out.println("the team is open");
            return;
        }
        team.setStatus(Team.Status.open);
        team.addOwner(this);
    }

    public void closeTeam(){
        if(team.getStatus()== Team.Status.close){
            System.out.println("the team is close");
            return;
        }
        List<TeamOwner> owners=team.getOwners();//להעביר לקבוצה!!
        List<Player> players=team.getPlayers();
        List<Coach> coaches=team.getCoaches();
        List<TeamManager> managers=team.getManagers();
       // removeAllJobs(owners);
        owners.clear();
        players.clear();
        coaches.clear();
        managers.clear();
    }

    private void removeAllJobs(List<Job> jobList){
        for(Job job:jobList){
            Member member=job.getMember();
            member.removeJob(job);
        }
    }


}
