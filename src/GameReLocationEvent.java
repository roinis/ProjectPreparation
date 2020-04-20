import java.time.LocalDateTime;

public class GameReLocationEvent implements event{

    stadium gameOriginalLocation;
    stadium gameNewLocation;
    team homeTeam;
    team awayTeam;

    public GameReLocationEvent(stadium gameOriginalLocation, stadium gameNewLocation, team homeTeam, team awayTeam) {
        this.gameOriginalLocation = gameOriginalLocation;
        this.gameNewLocation = gameNewLocation;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return "The match between " +
                homeTeam +
                "and " + awayTeam +
                "had relocated from " +
                gameOriginalLocation + " to " +
                gameNewLocation + ".";
    }

}
