import java.sql.Time;

public class redCardEvent extends gameEvent{


    public redCardEvent(Time eventGameTime, team team, footballPlayer player) {
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
