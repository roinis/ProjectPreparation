public class TeamManager extends Job {
    private Team team;

    public TeamManager(Member member, Team team) {
        super(member);
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
