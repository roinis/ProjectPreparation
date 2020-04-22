import java.sql.Time;

public class YellowCardEvent extends GameEvent {

    public YellowCardEvent(Time eventGameTime, Team team, Player player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getMember().getFull_name()
                + "of team " + eventTeam.getTeamName()
                + " Received Yellow Card at "
                + eventGameTime + ".";
    }

}
