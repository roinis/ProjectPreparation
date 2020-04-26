import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class StartGameEventTest {

    @Deprecated
    @Test
    public void testToString() {
        Time gameTime  = new Time(0,0,0);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        StartGameEvent startGameEvent = new StartGameEvent(gameTime,homeTeam,awayTeam);
        String eventString = "The match between " + homeTeam.getTeamName() + " and " + awayTeam.getTeamName() + " has started.";
        assertEquals(startGameEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString1() {
        Time gameTime  = new Time(0,0,0);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        StartGameEvent startGameEvent = new StartGameEvent(gameTime,homeTeam,awayTeam);
        String eventString = "The match between " + homeTeam.getTeamName() + " and " + awayTeam.getTeamName() + " has started.";
        assertEquals(startGameEvent.toString(),eventString);
    }

    @Test
    public void addEventToLog() {
    }


    @Test
    public void getEventGameTime() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        StartGameEvent startGameEvent = new StartGameEvent(gameTime,homeTeam,awayTeam);
        assertEquals(gameTime,startGameEvent.getEventGameTime());
    }

    @Test
    public void setEventGameTime() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        StartGameEvent startGameEvent = new StartGameEvent(gameTime,homeTeam,awayTeam);
        startGameEvent.setEventGameTime(new Time(1,10,10));
        assertEquals(new Time(1,10,10),startGameEvent.getEventGameTime());

    }

    @Test
    public void getHomeTeam() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        StartGameEvent startGameEvent = new StartGameEvent(gameTime,homeTeam,awayTeam);
        assertEquals(homeTeam,startGameEvent.getHomeTeam());
    }

    @Test
    public void setHomeTeam() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        StartGameEvent startGameEvent = new StartGameEvent(gameTime,homeTeam,awayTeam);
        startGameEvent.setHomeTeam(awayTeam);
        assertEquals(awayTeam,startGameEvent.getHomeTeam());
    }

    @Test
    public void getAwayTeam() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        StartGameEvent startGameEvent = new StartGameEvent(gameTime,homeTeam,awayTeam);
        assertEquals(awayTeam,startGameEvent.getAwayTeam());
    }

    @Test
    public void setAwayTeam() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        StartGameEvent startGameEvent = new StartGameEvent(gameTime,homeTeam,awayTeam);
        startGameEvent.setAwayTeam(homeTeam);
        assertEquals(homeTeam,startGameEvent.getAwayTeam());
    }


}