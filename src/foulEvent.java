import java.sql.Time;

public class foulEvent extends gameEvent{
    footballPlayer fouledPlayer;

    public foulEvent(Time eventGameTime, Team team, footballPlayer player, footballPlayer fouledPlayer) {
        super(eventGameTime, team, player);
        this.fouledPlayer = fouledPlayer;
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getTeamName()
                + " Committed a foul on "
                + fouledPlayer.getName()
                + " at "
                + eventGameTime + ".";
    }
}

