import java.sql.Time;

public abstract class gameEvent implements event{
    Time eventGameTime;
    team eventTeam;
    footballPlayer eventPlayer;

    public gameEvent(Time eventGameTime,team team,footballPlayer player) {
        this.eventGameTime = eventGameTime;
        eventTeam = team;
        eventPlayer = player;
    }


}
