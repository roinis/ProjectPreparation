import java.sql.Time;

public class GoalEvent extends GameEvent {

    public GoalEvent(Time eventGameTime, Team team, FootballPlayer player) {
        super(eventGameTime, team, player);
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getTeamName()
                + " scored a goal"
                + " at "
                + eventGameTime + ".";
    }





}
