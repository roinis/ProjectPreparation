public class GameReLocationEvent implements event{

    stadium gameOriginalLocation;
    stadium gameNewLocation;
    Team homeTeam;
    Team awayTeam;

    public GameReLocationEvent(stadium gameOriginalLocation, stadium gameNewLocation, Team homeTeam, Team awayTeam) {
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
