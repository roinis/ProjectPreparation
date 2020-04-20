import java.time.LocalDateTime;

public class TeamReOpenEvent implements event{
    LocalDateTime reopenedTime;
    Team reopenedTeam;

    public TeamReOpenEvent(LocalDateTime reopenedTime, Team reopenedTeam) {
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
