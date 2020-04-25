import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamOwner extends Job{
    private Team team;
    private List<Job> appointmentList;

    public TeamOwner(Member member) {
        super(member);
        this.team = null;
        appointmentList =new ArrayList<>();
        this.jobName="owner";
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(6,this);
    }

    public void addOwner(String userName){
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        Member member= (Member) alphaSystem.GetSpecificFromDB(2,userName);
        if(checker(member))
            return;
        if(member.getJob("owner")!=null){
            System.out.println("this member already a owner");
            return;
        }
        TeamOwner newOwner=new TeamOwner(member);
        if(team.addOwner(newOwner)) {
            member.addJob(newOwner);
            appointmentList.add(newOwner);
            System.out.println("the member " + userName + " add to " + team.getTeamName() + " team owners");
        }
    }

    public void removeOwner(String userName){
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        Member member= (Member) alphaSystem.GetSpecificFromDB(2,userName);
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

    public void addManager(String userName,boolean[] permissionsList){
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        Member member= (Member) alphaSystem.GetSpecificFromDB(2,userName);
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
        ArrayList<TeamManager.Permissions> permissions=choosePermissions(permissionsList);
        TeamManager teamManager=new TeamManager(member,team,permissions);
        if(team.addManager(teamManager)) {
            member.addJob(teamManager);
            appointmentList.add(teamManager);
            System.out.println("the member " + userName + " add to " + team.getTeamName() + " team managers");
        }
    }

    public void removeManger(String userName){
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        Member member= (Member) alphaSystem.GetSpecificFromDB(2,userName);
        if(checker(member))
            return;
        TeamManager teamManager=(TeamManager) member.getJob("manager");
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

    private ArrayList<TeamManager.Permissions> choosePermissions(boolean[] permissionsList){
        ArrayList<TeamManager.Permissions> permissions=new ArrayList<>();
        if(permissionsList[0])
            permissions.add(TeamManager.Permissions.SET_TEAM_STATUS);
        if(permissionsList[1])
            permissions.add(TeamManager.Permissions.EDIT_PROPERTIES);
        if(permissionsList[2])
            permissions.add(TeamManager.Permissions.ADD_FINANCIAL_REPORT);
        if(permissionsList[3])
            permissions.add(TeamManager.Permissions.EDIT_PERSONAL_PAGE);
        return permissions;
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

    public void addTweet(String tweet){
      team.addTweet(tweet);
    }

    public void deleteTweet(int index){
       team.deleteTweet(index);
    }

    public void setPermissionsToManager(TeamManager manager,boolean[] permissionsList){
        manager.setPermissions(choosePermissions(permissionsList));
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public boolean addNewPlayer(String userName){
        return team.addNewPlayer(userName);
    }

    public boolean removeExistingPlayer(String userName){
        return team.removeExistingPlayer(userName);
    }

    public boolean editExistingPlayerName(String userName,String name){
        return team.editExistingPlayerName( userName, name);
    }

    public boolean editExistingPlayerPosition(String userName,String position){
        return team.editExistingPlayerPosition( userName, position);
    }

    public boolean editExistingPlayerBirthday(String userName,int year,int month,int day){
        return team.editExistingPlayerBirthday( userName, year, month, day);
    }

    public boolean addNewCoach(String userName,String job){
        return team.addNewCoach( userName, job);
    }

    public boolean removeExistingCoach(String userName){
        return team.removeExistingCoach( userName);
    }

    public boolean editExistingCoachName(String user,String newName){
        return team.editExistingCoachName( user, newName);
    }

    public boolean editExistingCoachCertification(String user,int certificationId){
        return team.editExistingCoachCertification( user, certificationId);
    }

    public boolean editExistingCoachJobInTeam(String user,String Job){
        return team.editExistingCoachJobInTeam( user, Job);
    }

    public boolean editExistingManagerName(String user,String newName){
        return team.editExistingManagerName( user, newName);
    }

    public boolean editExistingStadiumName(String newName){
        return team.editExistingStadiumName( newName);
    }

    public boolean setNewStadium(String stadiumName){
        return team.setNewStadium( stadiumName);
    }



}
