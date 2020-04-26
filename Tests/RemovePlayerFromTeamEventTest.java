import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class RemovePlayerFromTeamEventTest {

    @Test
    public void testToString() {
        Team team = new Team("HBS", new TeamOwner(new Member("", "", "", "roi")), null);
        Player player = new Player(new Member(null, null, null, "toni wak"), null, null);
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player, team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removePlayerFromTeamEvent.getDateTime();
        assertEquals(eventString, removePlayerFromTeamEvent.toString());
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS", new TeamOwner(new Member("", "", "", "roi")), null);
        Player player = new Player(new Member(null, null, null, "toni wak"), null, null);
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player, team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removePlayerFromTeamEvent.getDateTime();
        removePlayerFromTeamEvent.setPlayer(new Player(new Member(null, null, null, "yossi"), null, null));
        assertNotEquals(eventString, removePlayerFromTeamEvent.toString());
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS", new TeamOwner(new Member("", "", "", "roi")), null);
        Player player = new Player(new Member(null, null, null, "toni wak"), null, null);
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player, team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removePlayerFromTeamEvent.getDateTime();
        removePlayerFromTeamEvent.setTeam(new Team("TelAviv", new TeamOwner(new Member("", "", "", "roi")), null));
        assertNotEquals(eventString, removePlayerFromTeamEvent.toString());
    }

    @Test
    public void getPlayer() {
        Player player = new Player(new Member(null, null, null, "toni wak"), null, null);
        Team team = new Team("HBS", new TeamOwner(new Member("", "", "", "roi")), null);
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player, team);
        assertEquals(player, removePlayerFromTeamEvent.getPlayer());
    }

    @Test
    public void setPlayer() {
        Player player = new Player(new Member(null, null, null, "toni wak"), null, null);
        Player player1 = new Player(new Member(null, null, null, "toni wak1"), null, null);
        Team team = new Team("HBS", new TeamOwner(new Member("", "", "", "roi")), null);
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player, team);
        removePlayerFromTeamEvent.setPlayer(player1);
        assertEquals(player1, removePlayerFromTeamEvent.getPlayer());
    }

    @Test
    public void getTeam() {
        Player player = new Player(new Member(null, null, null, "toni wak"), null, null);
        Team team = new Team("HBS", new TeamOwner(new Member("", "", "", "roi")), null);
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player, team);
        assertEquals(team, removePlayerFromTeamEvent.getTeam());
    }

    @Test
    public void setTeam() {
        Player player = new Player(new Member(null, null, null, "toni wak"), null, null);
        Team team = new Team("HBS", new TeamOwner(new Member("", "", "", "roi")), null);
        Team team1 = new Team("HBS1", new TeamOwner(new Member("", "", "", "roi")), null);
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player, team);
        removePlayerFromTeamEvent.setTeam(team1);
        assertEquals(team1, removePlayerFromTeamEvent.getTeam());
    }

    @Test
    public void getDateTime() {
        Player player = new Player(new Member(null, null, null, "toni wak"), null, null);
        Team team = new Team("HBS", new TeamOwner(new Member("", "", "", "roi")), null);
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player, team);
        removePlayerFromTeamEvent.getDateTime();
    }

    @Test
    public void setDateTime() {
        Player player = new Player(new Member(null, null, null, "toni wak"), null, null);
        Team team = new Team("HBS", new TeamOwner(new Member("", "", "", "roi")), null);
        LocalDateTime localDateTime = LocalDateTime.now();
        RemovePlayerFromTeamEvent removePlayerFromTeamEvent = new RemovePlayerFromTeamEvent(player, team);
        removePlayerFromTeamEvent.setDateTime(localDateTime);
        assertEquals(localDateTime, removePlayerFromTeamEvent.getDateTime());
    }
}