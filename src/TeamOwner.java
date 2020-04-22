import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamOwner extends Job{
    private Team team;
    private List<Job> appointmentList;

    public TeamOwner(Team team, Member member) {
        super(member);
        this.team = team;
        appointmentList =new ArrayList<>();
        this.jobName="owner";
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
        team.setStatus(Team.Status.open);
    }

    public void closeTeam(){
        team.setStatus(Team.Status.close);
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
        ArrayList<TeamManager.Permissions> permissions=choosePermissions();
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

    private boolean checker(Member member){
        if(member==null){
            System.out.println("the user name not exist");
             return true;
        }
        return false;
    }

    private ArrayList<TeamManager.Permissions> choosePermissions(){
        return new ArrayList<>();
    }

    public List<Job> getAppointmentList() {
        return appointmentList;
    }

    public void addWithdraw(Double sum,String description){
        team.addWithdraw(sum,description);

    }

    public void addDeposit(Double sum,String description){
        team.addDeposit(sum,description);
    }

    @Override
    public void editDetails() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("please choose a new name");
        String input=scanner.nextLine();
        getMember().setFull_name(input);
    }

    public void editProperty(){
        team.editProperty();
    }
}
