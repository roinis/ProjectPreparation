import java.sql.Time;

public class FoulEvent extends GameEvent {
    Player fouledPlayer;

    public FoulEvent(Time eventGameTime, Team team, Player player, Player fouledPlayer) {
        super(eventGameTime, team, player);
        this.fouledPlayer = fouledPlayer;
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getMember().getFull_name()
                + "of team " + eventTeam.getTeamName()
                + " Committed a foul on "
                + fouledPlayer.getMember().getFull_name()
                + " at "
                + eventGameTime + ".";
    }
}

