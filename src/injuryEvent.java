import java.sql.Time;

public class injuryEvent extends gameEvent  {


    public injuryEvent(Time eventGameTime, team team, player player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getName()
                + " Was injured at "
                + eventGameTime + ".";
    }
}
