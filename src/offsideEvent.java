import java.sql.Time;

public class offsideEvent extends gameEvent{
    public offsideEvent(Time eventGameTime, team team, player player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getName()
                + " Committed an Offside on"
                + " at "
                + eventGameTime + ".";
    }


}