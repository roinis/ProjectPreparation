import java.sql.Time;

public class injuryEvent extends gameEvent{


    public injuryEvent(Time eventGameTime, Team team, footballPlayer player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getTeamName()
                + " Was injured at "
                + eventGameTime + ".";
    }
}
