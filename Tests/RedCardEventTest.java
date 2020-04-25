import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class RedCardEventTest {

    @Deprecated
    @Test
    public void testToString() {
        Time gameTime = new Time(0,55,0);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        RedCardEvent redCardEvent = new RedCardEvent(gameTime,team,player);
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                            + " Received Red Card at " + gameTime + ".";
        assertEquals(redCardEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString1() {
        Time gameTime = new Time(0,20,50);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        RedCardEvent redCardEvent = new RedCardEvent(gameTime,team,player);
        redCardEvent.setEventTeam(new Team("HBK",new TeamOwner(new Member("","","","roi")),null));
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                + " Received Red Card at " + gameTime + ".";
        assertNotEquals(redCardEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString2() {
        Time gameTime = new Time(0,52,30);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        RedCardEvent redCardEvent = new RedCardEvent(gameTime,team,player);
        redCardEvent.setEventPlayer(new Player(new Member(null,null,null,"john hugo"),null,null));
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                                + " Received Red Card at " + gameTime + ".";
        assertNotEquals(redCardEvent.toString(),eventString);
    }

}