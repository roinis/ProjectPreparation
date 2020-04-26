import org.junit.Test;

import java.sql.Time;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class EndGameEventTest {

    @Deprecated
    @Test
    public void testToString() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);
        String eventString = "The match between " + homeTeam.getTeamName() + " and " + awayTeam.getTeamName() + " has ended.";
        assertEquals(endGameEvent.toString(),eventString);

    }

    @Deprecated
    @Test
    public void testToString1() {
        Time gameTime  = new Time(1,10,50);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);
        endGameEvent.setAwayTeam(new Team("HSS",new TeamOwner(new Member("","","","roi")),null));
        String eventString = "The match between " + homeTeam.getTeamName() + " and " + awayTeam.getTeamName() + " has ended.";
        assertNotEquals(endGameEvent.toString(),eventString);
    }



    @Test
    public void getEventGameTime() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);
        assertEquals(gameTime,endGameEvent.getEventGameTime());
    }

    @Test
    public void setEventGameTime() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);
        endGameEvent.setEventGameTime(new Time(1,10,10));
        assertEquals(new Time(1,10,10),endGameEvent.getEventGameTime());

    }

    @Test
    public void getHomeTeam() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);
        assertEquals(homeTeam,endGameEvent.getHomeTeam());
    }

    @Test
    public void setHomeTeam() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);
        endGameEvent.setHomeTeam(awayTeam);
        assertEquals(awayTeam,endGameEvent.getHomeTeam());
    }

    @Test
    public void getAwayTeam() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);
        assertEquals(awayTeam,endGameEvent.getAwayTeam());
    }

    @Test
    public void setAwayTeam() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);
        endGameEvent.setAwayTeam(homeTeam);
        assertEquals(homeTeam,endGameEvent.getAwayTeam());
    }
}