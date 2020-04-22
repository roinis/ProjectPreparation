import java.util.ArrayList;
import java.util.Scanner;

public class TeamManager extends Job {
    private Team team;
    enum Permissions{openTeam,closeTeam,addManager,removeManager, editProperties,editTeamPage}
    private ArrayList<Permissions> permissions;

    public TeamManager(Member member, Team team, ArrayList<Permissions> permissions) {
        super(member);
        this.team = team;
        this.jobName="manager";
        this.permissions=permissions;
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(5,this);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    //omer add this to fix the build
    @Override
    public void editDetails() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("please choose a new name");
        String input=scanner.nextLine();
        getMember().setFull_name(input);
    }



    public void removeAllPermissions(){
        permissions.clear();
    }
}
