import java.sql.Time;

public class RedCardEvent extends GameEvent {


    public RedCardEvent(Time eventGameTime, Team team, Player player) {
        super(eventGameTime, team, player);

    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getMember().getFull_name()
                + " of team " + eventTeam.getTeamName()
                + " Received Red Card at "
                + eventGameTime + ".";
    }
}
