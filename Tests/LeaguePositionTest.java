import org.junit.Test;

import static org.junit.Assert.*;

public class LeaguePositionTest {

    @Test
    public void computePoints() {
        LeaguePosition lP1=new LeaguePosition(null,3,1,2,5,4);
        int totalPoints=lP1.computePoints(3,0,1);
        assertEquals(11,totalPoints);
        totalPoints=lP1.computePoints(3,2,1);
        assertEquals(13,totalPoints);
    }
}