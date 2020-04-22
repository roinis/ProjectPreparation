import java.sql.Time;

public class SubstitutionEvent extends GameEvent {
    Player ingoingPlayer;

    public SubstitutionEvent(Time eventGameTime, String description, Team team, Player outGoingPlayer, Player ingoingPlayer) {
        super(eventGameTime,team,outGoingPlayer);
        this.ingoingPlayer = ingoingPlayer;
    }

    @Override
    public String toString() {
        return "Substitution in team " +
                eventTeam.getTeamName() +
                "The Player " +
                ingoingPlayer.getMember().getFull_name() +
                " Subtituted " +
                this.eventPlayer.getMember().getFull_name() +
                " at " + eventGameTime + ".";
    }
}
