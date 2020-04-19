import java.sql.Time;

public class goalEvent extends gameEvent {

    public goalEvent(Time eventGameTime, team team, player player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getName()
                + " scored a goal"
                + " at "
                + eventGameTime + ".";
    }



}
