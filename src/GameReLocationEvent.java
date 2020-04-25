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
        addEventToLog();
    }

    @Override
    public String toString() {
        return "The match between " +
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had relocated from " +
                gameOriginalLocation.getStadiumName() + " to " +
                gameNewLocation.getStadiumName() + ".";
    }

    @Override
    public void addEventToLog() {
        AlphaSystem.getSystem().getLog().addEvent(this);
    }

    public Stadium getGameOriginalLocation() {
        return gameOriginalLocation;
    }

    public void setGameOriginalLocation(Stadium gameOriginalLocation) {
        this.gameOriginalLocation = gameOriginalLocation;
    }

    public Stadium getGameNewLocation() {
        return gameNewLocation;
    }

    public void setGameNewLocation(Stadium gameNewLocation) {
        this.gameNewLocation = gameNewLocation;
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
