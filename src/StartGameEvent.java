import java.sql.Time;

public class StartGameEvent {

    public StartGameEvent(Time eventGameTime,team homeTeam,team awayTeam) {
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
}
