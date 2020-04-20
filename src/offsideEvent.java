import java.sql.Time;

public class offsideEvent extends gameEvent{
    public offsideEvent(Time eventGameTime, Team team, footballPlayer player) {
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