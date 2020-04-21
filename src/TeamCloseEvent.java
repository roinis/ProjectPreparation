import java.time.LocalDateTime;

public class TeamCloseEvent implements Event {
    LocalDateTime closedTime;
    Team closedTeam;

    public TeamCloseEvent(LocalDateTime closedTime, Team closedTeam) {
        this.closedTeam = closedTeam;
        this.closedTime = closedTime;
    }

    @Override
    public String toString() {
        return "The Team: " +
                closedTeam +
                " has closed" +
                " at " + closedTime;
    }

    @Override
    public void addEventToLog() {
        //AlphaSystem.getSystem().getLog().addEvent(this);
    }
}
