import java.sql.Time;

public abstract class GameEvent implements Event {
    Time eventGameTime;
    Team eventTeam;
    FootballPlayer eventPlayer;

    public GameEvent(Time eventGameTime, Team team, FootballPlayer player) {
        this.eventGameTime = eventGameTime;
        eventTeam = team;
        eventPlayer = player;
    }


}
