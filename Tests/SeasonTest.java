import javafx.util.Pair;
import org.junit.Test;

import java.security.acl.Owner;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class SeasonTest {

    @Test
    public void addTeamToSeason() {
        Season s=new Season(1990,null,null);
        Team t=new Team("x",null,null);
        assertTrue(s.addTeamToSeason(t));
        assertFalse(s.addTeamToSeason(t));
    }

    @Test
    public void getRankings() {
        Season s=new Season(1990,null,null);
        LinkedList<Pair<LeaguePosition, Integer>> list = s.getRankings();
        assertTrue(list.size()==0);
        Team t1=new Team("first",null,null);
        Team t2=new Team("second",null,null);
        s.addTeamToSeason(t1);
        s.addTeamToSeason(t2);
        s.addWin(t1,0,0);
        LinkedList<Pair<LeaguePosition, Integer>> list2 = s.getRankings();
        assertEquals(list2.getFirst().getKey().getTeam(),t1);
        assertEquals(list2.getLast().getKey().getTeam(),t2);
    }

    @Test
    public void addWin() {
        Season season=new Season(12,null,null);
        assertTrue(season.addWin(null,3,1));
        assertFalse(season.addWin(null,1,1));
        assertFalse(season.addWin(null,1,2));
    }

    @Test
    public void addLoss() {
        Season season=new Season(12,null,null);
        assertFalse(season.addLoss(null,3,1));
        assertFalse(season.addLoss(null,1,1));
        assertTrue(season.addLoss(null,1,2));
    }

    @Test
    public void addDraw() {
        Season season=new Season(12,null,null);
        assertFalse(season.addDraw(null,3,1));
        assertFalse(season.addDraw(null,1,2));
        assertTrue(season.addDraw(null,1,1));
    }

    @Test
    public void scheduleGames() {

        Season s=new Season(1990,new SchedulingPolicy(2),null);
        LinkedList<FootballGame> list = s.getGames();
        assertEquals(0,list.size());
        s.addTeamToSeason(new Team("a",null,null));
        s.addTeamToSeason(new Team("b",null,null));
        s.addTeamToSeason(new Team("c",null,null));
        s.scheduleGames();
        list = s.getGames();
        assertEquals(6,list.size());
    }

    @Test
    public void sceduleMainRefereeTest() {
        League l=new League(null,null,null);
        MainReferee ref=new MainReferee("x",null,"y","z");
        l.addMainReferee(ref);
        Season season=new Season(1990,new SchedulingPolicy(1),null);
        season.addTeamToSeason(new Team(null,null,null));
        season.addTeamToSeason(new Team(null,null,null));
        season.scheduleGames();
        season.scheduleMainReferees(l.getLeagueReferees());
        assertEquals(ref.getUser_name(),season.getGames().getFirst().getMainReferee().getUser_name());
    }

    @Test
    public void sceduleLinesManRefereeTest() {
        League l=new League(null,null,null);
        LinesManReferee ref1=new LinesManReferee("x",null,"y","z");
        LinesManReferee ref2=new LinesManReferee("a",null,"b","c");
        l.addLinesManReferee(ref1);
        l.addLinesManReferee(ref2);
        Season season=new Season(1990,new SchedulingPolicy(1),null);
        season.addTeamToSeason(new Team(null,null,null));
        season.addTeamToSeason(new Team(null,null,null));
        season.scheduleGames();
        season.scheduleLinesMansReferees(l.getLeagueLinesmans());
        assertEquals(ref1.getUser_name(),season.getGames().getFirst().getLinesManLeft().getUser_name());
        assertEquals(ref2.getUser_name(),season.getGames().getFirst().getLinesManRight().getUser_name());
    }

    @Test
    public void sceduleVarRefereeTest() {
        League l=new League(null,null,null);
        VarReferee ref=new VarReferee("x",null,"y","z");
        l.addVarReferee(ref);
        Season season=new Season(1990,new SchedulingPolicy(1),null);
        season.addTeamToSeason(new Team(null,null,null));
        season.addTeamToSeason(new Team(null,null,null));
        season.scheduleGames();
        season.scheduleVarReferees(l.getLeagueVarReferees());
        assertEquals(ref.getUser_name(),season.getGames().getFirst().getVarReferee().getUser_name());
    }
}