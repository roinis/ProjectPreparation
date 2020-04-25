import org.junit.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.Assert.*;

public class YellowCardEventTest {

    @Deprecated
    @Test
    public void testToString() {
        Time gameTime = new Time(0,55,0);
        Team team = new Team("HBS",null,null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        YellowCardEvent yellowCardEvent = new YellowCardEvent(gameTime,team,player);
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                + " Received Yellow Card at " + gameTime + ".";
        assertEquals(yellowCardEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString1() {
        Time gameTime = new Time(0,20,50);
        Team team = new Team("HBS",null,null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        YellowCardEvent yellowCardEvent = new YellowCardEvent(gameTime,team,player);
        yellowCardEvent.setEventTeam(new Team("HBK",null,null));
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                + " Received Yellow Card at " + gameTime + ".";
        assertNotEquals(yellowCardEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString2() {
        Time gameTime = new Time(0,20,50);
        Team team = new Team("HBS",null,null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        YellowCardEvent yellowCardEvent = new YellowCardEvent(gameTime,team,player);
        yellowCardEvent.setEventPlayer(new Player(new Member(null,null,null,"john hugo"),null,null));
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                + " Received Yellow Card at " + gameTime + ".";
        assertNotEquals(yellowCardEvent.toString(),eventString);
    }


}