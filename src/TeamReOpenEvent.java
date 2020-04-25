import java.time.LocalDateTime;

public class TeamReOpenEvent implements Event {
    LocalDateTime reopenedTime;
    Team reopenedTeam;

    public TeamReOpenEvent(LocalDateTime reopenedTime, Team reopenedTeam) {
        this.reopenedTime = reopenedTime;
        this.reopenedTeam = reopenedTeam;
        addEventToLog();
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
        AlphaSystem.getSystem().getLog().addEvent(this);
    }

    public LocalDateTime getReopenedTime() {
        return reopenedTime;
    }

    public void setReopenedTime(LocalDateTime reopenedTime) {
        this.reopenedTime = reopenedTime;
    }

    public Team getReopenedTeam() {
        return reopenedTeam;
    }

    public void setReopenedTeam(Team reopenedTeam) {
        this.reopenedTeam = reopenedTeam;
    }
}
