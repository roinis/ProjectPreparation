public class GameReLocationEvent implements Event {

    Stadium gameOriginalLocation;
    Stadium gameNewLocation;
    Team homeTeam;
    Team awayTeam;

    public GameReLocationEvent(Stadium gameOriginalLocation, Stadium gameNewLocation, Team homeTeam, Team awayTeam) {
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
