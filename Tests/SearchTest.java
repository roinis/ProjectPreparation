import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class SearchTest extends TestCase {

    @Test
    public void testSearchByName1() {
        AlphaDatabase alphaDatabase=new AlphaDatabase();
        League tmp=new League("x",null,null);
        alphaDatabase.AddtoDB(1,tmp);
        Search search=new Search();
        List list=search.searchByName("x",true,false,false,false,false,false,false,false);
        assertEquals(tmp,list.get(0));
    }

    @Test
    public void testSearchByName4() {
        AlphaDatabase alphaDatabase=new AlphaDatabase();
        Team team1 =new Team("t1",new TeamOwner(new Member("alona",null,null,"alona")),new Stadium("zxc","xcv"));
        Search search=new Search();
        List list=search.searchByName("t1",false,false,true,false,false,false,false,false);
        assertEquals(team1,list.get(0));
    }

    @Test
    public void testSearchByName5() {
        AlphaDatabase alphaDatabase=new AlphaDatabase();
        TeamManager tmp=new TeamManager(new Member(null,null,null,"x"),null,null);
        alphaDatabase.AddtoDB(5,tmp);
        Search search=new Search();
        List list=search.searchByName("x",false,false,false,true,false,false,false,false);
        assertTrue(list.get(0) instanceof TeamManager);
    }

    @Test
    public void testSearchByName6() {
        TeamOwner tmp=new TeamOwner(new Member("x",null,null,"x"));
        Search search=new Search();
        List list=search.searchByName("x",false,false,false,false,true,false,false,false);
        assertTrue(list.get(0) instanceof TeamOwner);
    }

    @Test
    public void testSearchByName7() {
        Player tmp=new Player(new Member("x",null,null,"x"),null,null);
        Search search=new Search();
        List list=search.searchByName("x",false,false,false,false,false,true,false,false);
        assertTrue(list.get(0) instanceof Player);
    }

    @Test
    public void testSearchByName9() {
        Referee tmp=new Referee(new Member("x",null,null,"x"));
        Search search=new Search();
        List list=search.searchByName("x",false,false,false,false,false,false,true,false);
        assertTrue(list.get(0) instanceof Referee);
    }

    @Test
    public void testSearchByName11() {
        AlphaDatabase alphaDatabase=new AlphaDatabase();
        Stadium tmp=new Stadium("x",null);
        alphaDatabase.AddtoDB(11,tmp);
        Search search=new Search();
        List list=search.searchByName("x",false,false,false,false,false,false,false,true);
        assertTrue(list.get(0) instanceof Stadium);
    }
}