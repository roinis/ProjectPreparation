import javafx.util.Pair;
import org.junit.Test;

import java.security.acl.Owner;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class SeasonTest {

    @Test
    public void addTeamToSeason() {
        Season s=new Season(1990,null,null);
        Team team1 =new Team("t1",new TeamOwner(new Member("alona",null,null,"alona")),new Stadium("zxc","xcv"));
        assertTrue(s.addTeamToSeason(team1));
        assertFalse(s.addTeamToSeason(team1));
    }

    @Test
    public void getRankings() {
        Season s=new Season(1990,null,null);
        LinkedList<Pair<LeaguePosition, Integer>> list = s.getRankings();
        assertTrue(list.size()==0);
        Team team1 =new Team("t1",new TeamOwner(new Member("alona",null,null,"alona")),new Stadium("zxc","xcv"));
        Team team2 =new Team("t2",new TeamOwner(new Member("eli",null,null,"eli")),new Stadium("zxvb","xzzcv"));
        s.addTeamToSeason(team1);
        s.addTeamToSeason(team2);
        s.addWin(team1,1,0);
        LinkedList<Pair<LeaguePosition, Integer>> list2 = s.getRankings();
        assertEquals(list2.getFirst().getKey().getTeam().getTeamName(),team1.getTeamName());
        assertEquals(list2.getLast().getKey().getTeam(),team2);
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
        Team team1 =new Team("t1",new TeamOwner(new Member("alona",null,null,"alona")),new Stadium("zxc","xcv"));
        Team team2 =new Team("t2",new TeamOwner(new Member("eli",null,null,"eli")),new Stadium("zxvb","xzzcv"));
        Team team3 =new Team("t3",new TeamOwner(new Member("asi",null,null,"asi")),new Stadium("hbf","qwe"));
        s.addTeamToSeason(team1);
        s.addTeamToSeason(team2);
        s.addTeamToSeason(team3);
        s.scheduleGames();
        list = s.getGames();
        assertEquals(6,list.size());
    }

    @Test
    public void sceduleMainRefereeTest() {
        League l=new League(null,null,null);
        MainReferee ref=new MainReferee(new Member("x",null,"y","z"));
        l.addMainReferee(ref);
        Season season=new Season(1990,new SchedulingPolicy(1),null);
        Team team1 =new Team("t1",new TeamOwner(new Member("alona",null,null,"alona")),new Stadium("zxc","xcv"));
        Team team2 =new Team("t2",new TeamOwner(new Member("eli",null,null,"eli")),new Stadium("zxvb","xzzcv"));
        season.addTeamToSeason(team1);
        season.addTeamToSeason(team2);
        season.scheduleGames();
        season.scheduleMainReferees(l.getLeagueReferees());
        assertEquals(ref,season.getGames().getFirst().getMainReferee());
    }

    @Test
    public void sceduleLinesManRefereeTest() {
        League l=new League(null,null,null);
        LinesManReferee ref1=new LinesManReferee(new Member("x",null,"y","z"));
        LinesManReferee ref2=new LinesManReferee(new Member("a",null,"b","c"));
        l.addLinesManReferee(ref1);
        l.addLinesManReferee(ref2);
        Season season=new Season(1990,new SchedulingPolicy(1),null);
        Team team1 =new Team("t1",new TeamOwner(new Member("alona",null,null,"alona")),new Stadium("zxc","xcv"));
        Team team2 =new Team("t2",new TeamOwner(new Member("eli",null,null,"eli")),new Stadium("zxvb","xzzcv"));
        season.addTeamToSeason(team1);
        season.addTeamToSeason(team2);
        season.scheduleGames();
        season.scheduleLinesMansReferees(l.getLeagueLinesmans());
        assertEquals(ref1,season.getGames().getFirst().getLinesManLeft());
        assertEquals(ref2,season.getGames().getFirst().getLinesManRight());
    }

    @Test
    public void sceduleVarRefereeTest() {
        League l=new League(null,null,null);
        VarReferee ref=new VarReferee(new Member("x",null,"y","z"));
        l.addVarReferee(ref);
        Season season=new Season(1990,new SchedulingPolicy(1),null);
        Team team1 =new Team("t1",new TeamOwner(new Member("alona",null,null,"alona")),new Stadium("zxc","xcv"));
        Team team2 =new Team("t2",new TeamOwner(new Member("eli",null,null,"eli")),new Stadium("zxvb","xzzcv"));
        season.addTeamToSeason(team1);
        season.addTeamToSeason(team2);
        season.scheduleGames();
        season.scheduleVarReferees(l.getLeagueVarReferees());
        assertEquals(ref,season.getGames().getFirst().getVarReferee());
    }
}