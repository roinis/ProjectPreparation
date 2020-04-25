import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class EventLogTest {

    @Deprecated
    @Test
    public void addEvent() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);

        gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);

        EventLog eventLog = AlphaSystem.getSystem().getLog();
        assertEquals(endGameEvent,eventLog.getEvents().get(0));
        assertEquals(goalEvent,eventLog.getEvents().get(1));
    }

    @Deprecated
    @Test
    public void removeEvent() {
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);

        gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);

        EventLog eventLog = AlphaSystem.getSystem().getLog();
        eventLog.removeEvent(goalEvent);
        assertEquals(endGameEvent,eventLog.getEvents().get(0));
        assertEquals(eventLog.getEvents().size(),1);

    }

    @Test
    public void saveEventsToDB() {
    }
}