import org.junit.Test;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class PlayerTest{

    @Test
    public void playerGettersTest(){
        Player player=new Player(null,Player.Position.ST, LocalDate.of(1992,7,23));
        assertEquals("ST",player.getPositionName());
        assertEquals("1992-07-23",player.getStringBirthDate());
        assertEquals(null, player.getTeam());
    }

   /*@Test
    public void settersTest(){
        Player player=new Player(null,Player.Position.ST, LocalDate.of(1992,7,23));
        player.setDateOfBirth(2000,01,01);
        assertEquals("2000-01-01",player.getStringBirthDate());
    }*/

    @Test
    public void  tweetsTest(){
        Player player=new Player(null,Player.Position.ST, LocalDate.of(1992,7,23));
        player.addTweet("test");
        assertTrue(player.getTweets().contains("test"));
        player.deleteTweet(0);
        assertFalse(player.getTweets().contains("test"));
    }

    @Test
    public void observerTest(){
        Observer observer=new Observer() {
            @Override
            public void update(Event newEvent) {
                assertTrue(true);
            }
        };
        Player player=new Player(null,Player.Position.ST, LocalDate.of(1992,7,23));
        player.register(observer);
        assertTrue(player.getObservers().contains(observer));
        player.notifyObserver(new TewwtEvent("test"));
        player.unregister(observer);
        assertFalse(player.getObservers().contains(observer));
    }

    @Test
    public void TeamTest(){
        TeamOwner teamOwner=new TeamOwner(null);
        Team team=new Team("hapoel",teamOwner,null);
        Player player=new Player(null,Player.Position.ST, LocalDate.of(1992,7,23));
        assertTrue(player.addToTeam(team));
        assertEquals(team,player.getTeam());
        assertFalse(player.addToTeam(team));
        assertTrue(player.removeFromTeam());
        assertEquals(null,player.getTeam());
        assertFalse(player.removeFromTeam());
    }

    @Test
    public void editTest1(){
        try {
            Member member=new Member("test","12345","12345","editTest");
            String input="1\n"+"test";
            Player player = new Player(member, Player.Position.ST, LocalDate.of(1992, 7, 23));
            InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream);
            player.editDetails();
            assertEquals("test",player.getMemberFullName());
        }catch (Exception e){e.printStackTrace();}
    }

  /*  @Test
    public void editTest2(){
        try {
            Member member=new Member("test","12345","12345","editTest");
            String input="2\n"+"GK\n";
            Player player = new Player(member, Player.Position.ST, LocalDate.of(1992, 7, 23));
            InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream);
            player.editDetails();
            assertEquals("GK",player.getPositionName());
        }catch (Exception e){e.printStackTrace();}
    }*/

    @Test
    public void editTest3(){
        try {
            String input="3\n"+"2000\n01\n01";
            Player player = new Player(null, Player.Position.ST, LocalDate.of(1992, 7, 23));
            InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream);
            player.editDetails();
            assertEquals("2000-01-01",player.getStringBirthDate());
        }catch (Exception e){e.printStackTrace();}
    }


}
