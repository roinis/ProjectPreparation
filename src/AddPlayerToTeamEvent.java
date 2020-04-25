import java.time.LocalDateTime;

public class AddPlayerToTeamEvent implements Event{
    Player player;
    Team team;
    LocalDateTime dateTime;

    public AddPlayerToTeamEvent(Player player, Team team) {
        this.player = player;
        this.team = team;
        this.dateTime = LocalDateTime.now();
        addEventToLog();
    }

    @Override
    public String toString() {
        return "The Player: " +
                player.getMemberFullName() +
                " has joined the Team: " + team.getTeamName() +
                " At: " + dateTime;
    }

    @Override
    public void addEventToLog() {
        AlphaSystem.getSystem().getLog().addEvent(this);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }



    public void setTeam(Team team) {
        this.team = team;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
