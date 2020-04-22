import java.sql.Time;

public class EndGameEvent implements Event {
    Time eventGameTime;
    Team homeTeam;
    Team awayTeam;

    public EndGameEvent(Time eventGameTime, Team homeTeam, Team awayTeam) {
        this.eventGameTime = eventGameTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return "The match between " +
                homeTeam +
                "and " + awayTeam +
                "had ended.";
    }

    @Override
    public void addEventToLog() {
        //AlphaSystem.getSystem().getLog().addEvent(this);
    }
}
