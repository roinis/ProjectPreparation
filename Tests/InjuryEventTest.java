import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class InjuryEventTest {

    @Deprecated
    @Test
    public void testToString() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        InjuryEvent injuryEvent = new InjuryEvent(gameTime,team,player);
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                + " Was injured at " + gameTime + ".";
        assertEquals(injuryEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString1() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        InjuryEvent injuryEvent = new InjuryEvent(gameTime,team,player);
        injuryEvent.setEventTeam(new Team("HBK",new TeamOwner(new Member("","","","roi")),null));
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                + " Was injured at " + gameTime + ".";

        assertNotEquals(eventString,injuryEvent.toString());
    }

    @Deprecated
    @Test
    public void testToString2() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        InjuryEvent injuryEvent = new InjuryEvent(gameTime,team,player);
        injuryEvent.setEventPlayer(new Player(new Member(null,null,null,"john hugo"),null,null));
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                + " Was injured at " + gameTime + ".";

        assertNotEquals(eventString,injuryEvent.toString());
    }
}