import org.junit.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class FootballGameTest {

    @Test
    public void addEventTest() {
        MainReferee ref=new MainReferee("x",null,null,null);
        FootballGame game=new FootballGame(null,new Team(null,null,null),null, LocalDateTime.of(1990,2,2,1,0));
        game.setMainReferee(ref);
        assertTrue(game.addEvent(null,ref,LocalDateTime.of(1990,2,2,4,0)));
        assertFalse(game.addEvent(null,ref,LocalDateTime.of(1991,2,2,2,0)));
        assertFalse(game.addEvent(null,ref,LocalDateTime.of(1990,2,2,7,0)));
        assertFalse(game.addEvent(null,new MainReferee("z",null,null,null),LocalDateTime.of(1990,2,2,3,0)));
    }

    @Test
    public void gameHasEndedTest1() {
        Season s=new Season(1990,new SchedulingPolicy(1),new ScoringPolicy(3,1,0));
        s.addTeamToSeason(new Team("x",null,null));
        s.addTeamToSeason(new Team("y",null,null));
        s.scheduleGames();
        s.getGames().getFirst().homeScoreGoal();
        s.getGames().getFirst().gameHasEnded();
        assertEquals(1,s.getRankings().getFirst().getKey().getGamesWon());
        assertEquals("x",s.getRankings().getFirst().getKey().getTeam().getTeamName());

    }

    @Test
    public void gameHasEndedTest2() {
        Season s=new Season(1990,new SchedulingPolicy(1),new ScoringPolicy(3,1,0));
        s.addTeamToSeason(new Team("x",null,null));
        s.addTeamToSeason(new Team("y",null,null));
        s.scheduleGames();
        s.getGames().getFirst().awayScoreGoal();
        s.getGames().getFirst().gameHasEnded();
        assertEquals(1,s.getRankings().getLast().getKey().getGamesLoss());
        assertEquals("x",s.getRankings().getLast().getKey().getTeam().getTeamName());
    }

    @Test
    public void gameHasEndedTest3() {
        Season s=new Season(1990,new SchedulingPolicy(1),new ScoringPolicy(3,1,0));
        s.addTeamToSeason(new Team("x",null,null));
        s.addTeamToSeason(new Team("y",null,null));
        s.scheduleGames();
        s.getGames().getFirst().gameHasEnded();
        assertEquals(1,s.getRankings().getLast().getKey().getGamesDraw());
        assertEquals(1,s.getRankings().getFirst().getKey().getGamesDraw());
        int x=0;
    }

}