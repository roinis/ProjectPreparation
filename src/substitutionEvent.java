import java.sql.Time;

public class substitutionEvent extends gameEvent {
    player ingoingPlayer;

    public substitutionEvent(Time eventGameTime, String description, team team, player outGoingPlayer, player ingoingPlayer) {
        super(eventGameTime,team,outGoingPlayer);
        this.ingoingPlayer = ingoingPlayer;
    }

    @Override
    public String toString() {
        return "Substitution in team " +
                eventTeam.getName() +
                "The Player " +
                ingoingPlayer.getName() +
                " Subtituted " +
                this.eventPlayer.getName() +
                " at " + eventGameTime + ".";
    }
}
