import java.sql.Time;

public abstract class GameEvent implements Event {
    Time eventGameTime;
    Team eventTeam;
    Player eventPlayer;

    public GameEvent(Time eventGameTime, Team team, Player player) {
        this.eventGameTime = eventGameTime;
        eventTeam = team;
        eventPlayer = player;
        addEventToLog();
    }

    public void addEventToLog(){
        AlphaSystem.getSystem().getLog().addEvent(this);
    }

    public Time getEventGameTime() {
        return eventGameTime;
    }

    public void setEventGameTime(Time eventGameTime) {
        this.eventGameTime = eventGameTime;
    }

    public Team getEventTeam() {
        return eventTeam;
    }

    public void setEventTeam(Team eventTeam) {
        this.eventTeam = eventTeam;
    }

    public Player getEventPlayer() {
        return eventPlayer;
    }

    public void setEventPlayer(Player eventPlayer) {
        this.eventPlayer = eventPlayer;
    }
}
