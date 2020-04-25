import java.time.LocalDateTime;

public class TeamCloseEvent implements Event {
    LocalDateTime closedTime;
    Team closedTeam;

    public TeamCloseEvent(LocalDateTime closedTime, Team closedTeam) {
        this.closedTeam = closedTeam;
        this.closedTime = closedTime;
        addEventToLog();
    }

    @Override
    public String toString() {
        return "The Team: " +
                closedTeam.getTeamName() +
                " has closed" +
                " at " + closedTime;
    }

    @Override
    public void addEventToLog() {
        AlphaSystem.getSystem().getLog().addEvent(this);
    }

    public LocalDateTime getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(LocalDateTime closedTime) {
        this.closedTime = closedTime;
    }

    public Team getClosedTeam() {
        return closedTeam;
    }

    public void setClosedTeam(Team closedTeam) {
        this.closedTeam = closedTeam;
    }
}
