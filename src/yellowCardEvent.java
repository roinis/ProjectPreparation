import java.sql.Time;

public class yellowCardEvent extends gameEvent{

    public yellowCardEvent(Time eventGameTime, Team team, footballPlayer player) {
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
