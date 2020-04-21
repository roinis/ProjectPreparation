import java.sql.Time;

public class YellowCardEvent extends GameEvent {

    public YellowCardEvent(Time eventGameTime, Team team, FootballPlayer player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getTeamName()
                + " Received Yellow Card at "
                + eventGameTime + ".";
    }

}
