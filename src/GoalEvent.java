import java.sql.Time;

public class GoalEvent extends GameEvent {

    public GoalEvent(Time eventGameTime, Team team, Player player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getMember().getFull_name()
                + " of team " + eventTeam.getTeamName()
                + " scored a goal"
                + " at "
                + eventGameTime + ".";
    }





}
