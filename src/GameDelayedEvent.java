import java.time.LocalDateTime;

public class GameDelayedEvent implements Event {
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
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had delayed from " +
                gameOriginalTime + " to " +
                gameDelayedTime + ".";
    }

    @Override
    public void addEventToLog() {
        //AlphaSystem.getSystem().getLog().addEvent(this);
    }

    public LocalDateTime getGameOriginalTime() {
        return gameOriginalTime;
    }

    public void setGameOriginalTime(LocalDateTime gameOriginalTime) {
        this.gameOriginalTime = gameOriginalTime;
    }

    public LocalDateTime getGameDelayedTime() {
        return gameDelayedTime;
    }

    public void setGameDelayedTime(LocalDateTime gameDelayedTime) {
        this.gameDelayedTime = gameDelayedTime;
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
