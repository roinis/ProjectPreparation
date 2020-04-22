import java.sql.Time;

public class InjuryEvent extends GameEvent {


    public InjuryEvent(Time eventGameTime, Team team,Player player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getMember().getFull_name()
                + "of team " + eventTeam.getTeamName()
                + " Was injured at "
                + eventGameTime + ".";
    }
}
