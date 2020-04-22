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
        League l=new League("t1",null,null);
        assertNull(l.getSeasonRankings(12));
    }


}