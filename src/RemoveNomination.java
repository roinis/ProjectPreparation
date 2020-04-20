import java.time.LocalDateTime;

public class RemoveNomination {
    Team team;
    Coach coach;
    TeamOwner teamOwner;
    LocalDateTime gameDelayedTime;

    public RemoveNomination(Team team, Coach coach) {
        this.team = team;
        this.coach = coach;
    }
    public RemoveNomination(Team team, TeamOwner teamOwner) {
        this.team = team;
        this.teamOwner = teamOwner;
    }

    @Override
    public String toString() {
        if(coach != null)
            return "The coach "
                    + coach.getMemberFullName()
                    + " of team" + team.getTeamName()
                    + "has fired.";
        else
            return "The team owner "
                    + teamOwner.getMemberFullName()
                    + " of team" + team.getTeamName()
                    + "has fired.";
    }
}
