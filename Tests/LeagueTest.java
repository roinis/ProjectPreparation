import javafx.util.Pair;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class LeagueTest {

    @org.junit.Test
    public void addSeasonTest1(){
        League l=new League("t1",null,null);
        assertTrue(l.addSeason(1990,null,null));
    }

    @org.junit.Test
    public void addSeasonTest2(){
        League l=new League("t2",null,null);
        assertTrue(l.addSeason(1990,null,null));
        assertTrue(l.addSeason(1991,null,null));
        assertFalse(l.addSeason(1990,null,null));
    }

    @org.junit.Test
    public void getSeasonRankings(){
        Team team1=new Team("x",new TeamOwner(new Member("owner1",null,null,"owner1")),new Stadium("terner","city"));
        Team team2=new Team("y",new TeamOwner(new Member("owner2",null,null,"owner2")),new Stadium("vasermil","city"));
        League l=new League("t1",null,null);
        assertNull(l.getSeasonRankings(12));
        l.addSeason(1990,new SchedulingPolicy(1),new ScoringPolicy());
        l.getSpecSeason(1990).addTeamToSeason(team1);
        l.getSpecSeason(1990).addTeamToSeason(team2);
        l.getSpecSeason(1990).addWin(team1,1,0);
        LinkedList<Pair<LeaguePosition, Integer>> rankings = l.getSpecSeason(1990).getRankings();
        assertEquals("x",rankings.getFirst().getKey().getTeam().getTeamName());
        assertEquals(new Integer(3),rankings.getFirst().getValue());
    }




}