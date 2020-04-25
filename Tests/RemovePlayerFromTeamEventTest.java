import org.junit.Test;

import static org.junit.Assert.*;

public class RemovePlayerFromTeamEventTest {

    @Test
    public void testToString() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player,team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removePlayerFromTeamEvent.getDateTime();
        assertEquals(eventString,removePlayerFromTeamEvent.toString());
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player,team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removePlayerFromTeamEvent.getDateTime();
        removePlayerFromTeamEvent.setPlayer(new Player(new Member(null,null,null,"yossi"),null,null));
        assertNotEquals(eventString,removePlayerFromTeamEvent.toString());
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player,team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removePlayerFromTeamEvent.getDateTime();
        removePlayerFromTeamEvent.setTeam(new Team("TelAviv",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,removePlayerFromTeamEvent.toString());
    }
}