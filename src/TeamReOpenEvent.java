import java.time.LocalDateTime;

public class TeamReOpenEvent implements Event {
    LocalDateTime reopenedTime;
    Team reopenedTeam;

    public TeamReOpenEvent(LocalDateTime reopenedTime, Team reopenedTeam) {
        this.reopenedTime = reopenedTime;
        this.reopenedTeam = reopenedTeam;
    }

    @Override
    public String toString() {
        return "The Team: " +
                reopenedTeam.getTeamName() +
                " has reopened" +
                " at " + reopenedTime;
    }

    @Override
    public void addEventToLog() {
        //AlphaSystem.getSystem().getLog().addEvent(this);
    }
}
