import java.sql.Time;

public abstract class gameEvent implements event{
    Time eventGameTime;
    Team eventTeam;
    footballPlayer eventPlayer;

    public gameEvent(Time eventGameTime, Team team, footballPlayer player) {
        this.eventGameTime = eventGameTime;
        eventTeam = team;
        eventPlayer = player;
    }


}
