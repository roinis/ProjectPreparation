import java.sql.Time;

public class InjuryEvent extends GameEvent {


    public InjuryEvent(Time eventGameTime, Team team, FootballPlayer player) {
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
