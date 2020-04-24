import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class GoalEventTest {

    @Deprecated
    @Test
    public void testToString() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",null,null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                        + " scored a goal" + " at " + gameTime + ".";
        assertEquals(goalEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString1() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",null,null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        goalEvent.setEventTeam(new Team("HBK",null,null));
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                + " scored a goal" + " at " + gameTime + ".";

        assertNotEquals(eventString,goalEvent.toString());
    }

    @Deprecated
    @Test
    public void testToString2() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",null,null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        goalEvent.setEventPlayer(new Player(new Member(null,null,null,"john hugo"),null,null));
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                + " scored a goal" + " at " + gameTime + ".";

        assertNotEquals(eventString,goalEvent.toString());
    }
}