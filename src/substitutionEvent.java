import java.sql.Time;

public class substitutionEvent extends gameEvent {
    footballPlayer ingoingPlayer;

    public substitutionEvent(Time eventGameTime, String description, Team team, footballPlayer outGoingPlayer, footballPlayer ingoingPlayer) {
        super(eventGameTime,team,outGoingPlayer);
        this.ingoingPlayer = ingoingPlayer;
    }

    @Override
    public String toString() {
        return "Substitution in team " +
                eventTeam.getTeamName() +
                "The Player " +
                ingoingPlayer.getName() +
                " Subtituted " +
                this.eventPlayer.getName() +
                " at " + eventGameTime + ".";
    }
}
