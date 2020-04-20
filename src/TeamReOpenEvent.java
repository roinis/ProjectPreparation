import java.time.LocalDateTime;

public class TeamReOpenEvent implements event{
    LocalDateTime reopenedTime;
    team reopenedTeam;

    public TeamReOpenEvent(LocalDateTime reopenedTime, team reopenedTeam) {
        this.reopenedTime = reopenedTime;
        this.reopenedTeam = reopenedTeam;
    }

    @Override
    public String toString() {
        return "The Team: " +
                reopenedTeam +
                " has reopened" +
                " at " + reopenedTime;
    }
}
