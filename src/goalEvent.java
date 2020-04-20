import java.sql.Time;

public class goalEvent extends gameEvent {

    public goalEvent(Time eventGameTime, Team team, footballPlayer player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        AlphaSystem system = AlphaSystem.getSystem();

        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getTeamName()
                + " scored a goal"
                + " at "
                + eventGameTime + ".";
    }





}
