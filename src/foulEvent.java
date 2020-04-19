import java.sql.Time;

public class foulEvent extends gameEvent{
    player fouledPlayer;

    public foulEvent(Time eventGameTime, team team, player player, player fouledPlayer) {
        super(eventGameTime, team, player);
        this.fouledPlayer = fouledPlayer;
    }

    @Override
    public String toString() {
        return "The Player "
                + eventPlayer.getName()
                + "of team " + eventTeam.getName()
                + " Committed a foul on "
                + fouledPlayer.getName()
                + " at "
                + eventGameTime + ".";
    }
}

