import java.sql.Time;

public abstract class gameEvent implements event{
    Time eventGameTime;
    team eventTeam;
    player eventPlayer;

    public gameEvent(Time eventGameTime,team team,player player) {
        this.eventGameTime = eventGameTime;
        eventTeam = team;
        eventPlayer = player;
    }


}
