import java.time.LocalDateTime;

public class TeamCloseEvent implements event{
    LocalDateTime closedTime;
    team closedTeam;

    public TeamCloseEvent(LocalDateTime closedTime, team closedTeam) {
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

}
