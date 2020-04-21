import java.sql.Time;

public class FoulEvent extends GameEvent {
    FootballPlayer fouledPlayer;

    public FoulEvent(Time eventGameTime, Team team, FootballPlayer player, FootballPlayer fouledPlayer) {
        super(eventGameTime, team, player);
        this.fouledPlayer = fouledPlayer;
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getTeamName()
                + " Committed a foul on "
                + fouledPlayer.getName()
                + " at "
                + eventGameTime + ".";
    }
}

