import java.sql.Time;

public class yellowCardEvent extends gameEvent{

    public yellowCardEvent(Time eventGameTime, team team, player player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getName()
                + " Received Yellow Card at "
                + eventGameTime + ".";
    }

}
