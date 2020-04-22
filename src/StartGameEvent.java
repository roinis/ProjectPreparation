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

    public Time getEventGameTime() {
        return eventGameTime;
    }

    public void setEventGameTime(Time eventGameTime) {
        this.eventGameTime = eventGameTime;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }
}
