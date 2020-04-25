import org.junit.Test;

import java.sql.Time;

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
    public void addEventToLog() {
    }



}