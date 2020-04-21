import java.sql.Time;

public class OffsideEvent extends GameEvent {
    public OffsideEvent(Time eventGameTime, Team team, FootballPlayer player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getTeamName()
                + " Committed an Offside on"
                + " at "
                + eventGameTime + ".";
    }


}