import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class FoulEventTest {

    @Deprecated
    @Test
    public void testToString() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",null,null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        Player fouledPlayer = new Player(new Member(null,null,null,"john"),null,null);
        FoulEvent foulEvent = new FoulEvent(gameTime,team,player,fouledPlayer);
        String eventString = "The Player "
                + player.getMember().getFull_name()
                + " of team " + team.getTeamName()
                + " Committed a foul on "
                + fouledPlayer.getMember().getFull_name()
                + " at "
                + gameTime + ".";
        assertEquals(foulEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString1() {
        Time gameTime = new Time(0,50,46);
        Team team = new Team("Maccabi Ha",null,null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        Player fouledPlayer = new Player(new Member(null,null,null,"john"),null,null);
        FoulEvent foulEvent = new FoulEvent(gameTime,team,player,fouledPlayer);
        String eventString = "The Player "
                + player.getMember().getFull_name()
                + " of team " + team.getTeamName()
                + " Committed a foul on "
                + fouledPlayer.getMember().getFull_name()
                + " at "
                + gameTime + ".";
        foulEvent.setFouledPlayer(new Player(new Member(null,null,null,"kalo"),null,null));
        assertNotEquals(foulEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString2() {
        Time gameTime = new Time(0,10,32);
        Team team = new Team("Maccabi Ha",null,null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        Player fouledPlayer = new Player(new Member(null,null,null,"john"),null,null);
        FoulEvent foulEvent = new FoulEvent(gameTime,team,player,fouledPlayer);
        String eventString = "The Player "
                + player.getMember().getFull_name()
                + " of team " + team.getTeamName()
                + " Committed a foul on "
                + fouledPlayer.getMember().getFull_name()
                + " at "
                + gameTime + ".";
        foulEvent.setEventPlayer(new Player(new Member(null,null,null,"kak"),null,null));
        assertNotEquals(foulEvent.toString(),eventString);
    }


}