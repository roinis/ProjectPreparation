import java.util.ArrayList;

public class TeamManager extends Job {
    private Team team;

    public TeamManager(Member member, Team team, ArrayList<Job.Permissions> permissions) {
        super(member);
        this.team = team;
        this.jobName="manager";
        this.setPermissions(permissions);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
