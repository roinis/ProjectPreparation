import java.time.LocalDateTime;

public class GameDelayedEvent implements event{
    LocalDateTime gameOriginalTime;
    LocalDateTime gameDelayedTime;
    Team homeTeam;
    Team awayTeam;

    public GameDelayedEvent(LocalDateTime gameOriginalTime, LocalDateTime gameDelayedTime, Team homeTeam, Team awayTeam) {
        this.gameOriginalTime = gameOriginalTime;
        this.gameDelayedTime = gameDelayedTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return "The match between " +
                homeTeam +
                "and " + awayTeam +
                "had delayed from " +
                gameOriginalTime + " to " +
                gameDelayedTime + ".";
    }
}
