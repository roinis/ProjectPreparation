public class Coach extends Job {
    private Team team;

    public Coach(Member member, Team team) {
        super(member);
        this.team = team;
        this.jobName="coach";
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
