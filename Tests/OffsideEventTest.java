import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class OffsideEventTest {

    @Deprecated
    @Test
    public void testToString() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        OffsideEvent offsideEvent = new OffsideEvent(gameTime,team,player);
        String eventString = "The Player " + player.getMember().getFull_name()  + "of team " + team.getTeamName()
                            + " Committed an Offside on" + " at " + gameTime + ".";
        assertEquals(offsideEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString1() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        OffsideEvent offsideEvent = new OffsideEvent(gameTime,team,player);
        offsideEvent.setEventTeam(new Team("HBK",new TeamOwner(new Member("","","","roi")),null));
        String eventString = "The Player " + player.getMember().getFull_name()  + "of team " + team.getTeamName()
                + " Committed an Offside on" + " at " + gameTime + ".";

        assertNotEquals(eventString,offsideEvent.toString());
    }

    @Deprecated
    @Test
    public void testToString2() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        OffsideEvent offsideEvent = new OffsideEvent(gameTime,team,player);
        offsideEvent.setEventPlayer(new Player(new Member(null,null,null,"john hugo"),null,null));
        String eventString = "The Player " + player.getMember().getFull_name()  + "of team " + team.getTeamName()
                + " Committed an Offside on" + " at " + gameTime + ".";

        assertNotEquals(eventString,offsideEvent.toString());
    }
}