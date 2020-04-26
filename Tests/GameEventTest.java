import org.junit.Test;

import java.sql.Time;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class GameEventTest {


    @Test
    public void getEventGameTime() {
        Time gameTime  = new Time(1,20,10);
        Team team = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member("","","","roi"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        assertEquals(gameTime,goalEvent.getEventGameTime());

    }

    @Test
    public void setEventGameTime() {
        Time gameTime  = new Time(1,20,10);
        Time gameTime1  = new Time(1,0,10);
        Team team = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member("","","","roi"),null,null);

        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        goalEvent.setEventGameTime(gameTime1);
        assertEquals(gameTime1,goalEvent.getEventGameTime());
    }

    @Test
    public void getEventTeam() {
        Time gameTime  = new Time(1,20,10);
        Team team = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member("","","","roi"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        assertEquals(team,goalEvent.getEventTeam());
    }

    @Test
    public void setEventTeam() {
        Time gameTime  = new Time(1,20,10);
        Team team = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team team1 = new Team ("Hapoel BS1",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member("","","","roi"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        goalEvent.setEventTeam(team1);
        assertEquals(team1,goalEvent.getEventTeam());
    }

    @Test
    public void getEventPlayer() {
        Time gameTime  = new Time(1,20,10);
        Team team = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member("","","","roi"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        assertEquals(player.getMemberUserName(),goalEvent.getEventPlayer().getMemberUserName());
    }

    @Test
    public void setEventPlayer() {
        Time gameTime  = new Time(1,20,10);
        Team team = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member("","","","roi"),null,null);
        Player player1 = new Player(new Member("","","","roi1"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        assertEquals(player1.getMemberUserName(),goalEvent.getEventPlayer().getMemberUserName());
    }

}