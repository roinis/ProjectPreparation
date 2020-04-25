import java.time.LocalDateTime;

public class AddCoachToTeamEvent implements Event{

    Coach coach;
    Team team;
    LocalDateTime dateTime;

    public AddCoachToTeamEvent(Coach coach, Team team) {
        this.coach = coach;
        this.team = team;
        this.dateTime = LocalDateTime.now();
        addEventToLog();
    }

    @Override
    public String toString() {
        return "The Coach: " +
                coach.getMemberFullName() +
                " has joined the Team: " + team.getTeamName() +
                " At: " + dateTime;
    }

    @Override
    public void addEventToLog() {
        AlphaSystem.getSystem().getLog().addEvent(this);
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Team getTeam() {
        return team;
    }



    public void setTeam(Team team) {
        this.team = team;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
