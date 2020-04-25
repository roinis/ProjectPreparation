import org.junit.Test;

import static org.junit.Assert.*;

public class AddPlayerToTeamEventTest {


    @Test
    public void testToString() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has joined the Team: " + team.getTeamName() +
                " At: " + addPlayerToTeamEvent.getDateTime();
        assertEquals(eventString,addPlayerToTeamEvent.toString());
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has joined the Team: " + team.getTeamName() +
                " At: " + addPlayerToTeamEvent.getDateTime();

        addPlayerToTeamEvent.setPlayer(new Player(new Member(null,null,null,"yossi"),null,null));
        assertNotEquals(eventString,addPlayerToTeamEvent.toString());
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has joined the Team: " + team.getTeamName() +
                " At: " + addPlayerToTeamEvent.getDateTime();
        addPlayerToTeamEvent.setTeam(new Team("TelAviv",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,addPlayerToTeamEvent.toString());
    }
}