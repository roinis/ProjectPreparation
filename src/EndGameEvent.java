import java.sql.Time;

public class EndGameEvent implements event {
    Time eventGameTime;
    team homeTeam;
    team awayTeam;

    public EndGameEvent(Time eventGameTime,team homeTeam,team awayTeam) {
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
}
