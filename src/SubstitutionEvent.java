import java.sql.Time;

public class SubstitutionEvent extends GameEvent {
    FootballPlayer ingoingPlayer;

    public SubstitutionEvent(Time eventGameTime, String description, Team team, FootballPlayer outGoingPlayer, FootballPlayer ingoingPlayer) {
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
