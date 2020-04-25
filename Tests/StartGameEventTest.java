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


}