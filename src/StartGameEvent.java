import java.sql.Time;

public class StartGameEvent implements Event{

    private Time eventGameTime;
    private Team homeTeam;
    private Team awayTeam;

    public StartGameEvent(Time eventGameTime, Team homeTeam, Team awayTeam) {
        this.eventGameTime = eventGameTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return "The match between " +
                homeTeam +
                "and " + awayTeam +
                "had started.";
    }

    @Override
    public void addEventToLog() {
        //AlphaSystem.getSystem().getLog().addEvent(this);
    }
}
