import org.junit.Test;

import java.security.acl.Owner;
import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class FootballGameTest {

    @Test
    public void addEventTest() {
        MainReferee ref=new MainReferee(new Member("x",null,null,null));
        Team team1 =new Team("t1",new TeamOwner(new Member("alona",null,null,"alona")),new Stadium("zxc","xcv"));
        Team team2 =new Team("t2",new TeamOwner(new Member("eli",null,null,"eli")),new Stadium("zxv","vbn"));
        FootballGame game=new FootballGame(new Season(1990,new SchedulingPolicy(1),new ScoringPolicy(3,1,0)),team1,team2, LocalDateTime.of(1990,2,2,1,0));
        game.setMainReferee(ref);
        assertTrue(game.addEvent(null,ref,LocalDateTime.of(1990,2,2,4,0)));
        assertFalse(game.addEvent(null,ref,LocalDateTime.of(1991,2,2,2,0)));
        assertFalse(game.addEvent(null,ref,LocalDateTime.of(1990,2,2,7,0)));
        assertFalse(game.addEvent(null,new MainReferee(new Member("z",null,null,null)),LocalDateTime.of(1990,2,2,3,0)));
    }

    @Test
    public void gameHasEndedTest1() {
        Season s=new Season(1990,new SchedulingPolicy(1),new ScoringPolicy(3,1,0));
        Team team1 =new Team("t1",new TeamOwner(new Member("alona",null,null,"alona")),new Stadium("zxc","xcv"));
        Team team2 =new Team("t2",new TeamOwner(new Member("eli",null,null,"eli")),new Stadium("zxv","vbn"));
        s.addTeamToSeason(team1);
        s.addTeamToSeason(team2);
        s.scheduleGames();
        s.getGames().getFirst().homeScoreGoal();
        s.getGames().getFirst().gameHasEnded();
        assertEquals(1,s.getRankings().getFirst().getKey().getGamesWon());
        assertEquals("t1",s.getRankings().getFirst().getKey().getTeam().getTeamName());

    }

    @Test
    public void gameHasEndedTest2() {
        Season s=new Season(1990,new SchedulingPolicy(1),new ScoringPolicy(3,1,0));
        Team team1 =new Team("t1",new TeamOwner(new Member("alona",null,null,"alona")),new Stadium("zxc","xcv"));
        Team team2 =new Team("t2",new TeamOwner(new Member("eli",null,null,"eli")),new Stadium("zxv","vbn"));
        s.addTeamToSeason(team1);
        s.addTeamToSeason(team2);
        s.scheduleGames();
        s.getGames().getFirst().awayScoreGoal();
        s.getGames().getFirst().gameHasEnded();
        assertEquals(1,s.getRankings().getLast().getKey().getGamesLoss());
        assertEquals("t1",s.getRankings().getLast().getKey().getTeam().getTeamName());
    }

    @Test
    public void gameHasEndedTest3() {
        Season s=new Season(1990,new SchedulingPolicy(1),new ScoringPolicy(3,1,0));
        Team team1 =new Team("t1",new TeamOwner(new Member("alona",null,null,"alona")),new Stadium("zxc","xcv"));
        Team team2 =new Team("t2",new TeamOwner(new Member("eli",null,null,"eli")),new Stadium("zxv","vbn"));
        s.addTeamToSeason(team1);
        s.addTeamToSeason(team2);
        s.scheduleGames();
        s.getGames().getFirst().gameHasEnded();
        assertEquals(1,s.getRankings().getLast().getKey().getGamesDraw());
        assertEquals(1,s.getRankings().getFirst().getKey().getGamesDraw());
    }

}