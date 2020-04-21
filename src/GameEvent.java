import java.sql.Time;

public abstract class GameEvent implements Event {
    Time eventGameTime;
    Team eventTeam;
    Player eventPlayer;

    public GameEvent(Time eventGameTime, Team team, Player player) {
        this.eventGameTime = eventGameTime;
        eventTeam = team;
        eventPlayer = player;
    }

    public void addEventToLog(){
        //AlphaSystem.getSystem().getLog().addEvent(this);
    }


}
