import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class SubstitutionEventTest {

    @Deprecated
    @Test
    public void testToString() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",null,null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        Player ingoingPlayer = new Player(new Member(null,null,null,"john"),null,null);
        SubstitutionEvent substitutionEvent = new SubstitutionEvent(gameTime,"",team,player,ingoingPlayer);
        String eventString = "Substitution in team " +
                team.getTeamName() +
                "The Player " +
                ingoingPlayer.getMember().getFull_name() +
                " Subtituted " +
                player.getMember().getFull_name() +
                " at " + gameTime + ".";
        assertEquals(substitutionEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString1() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",null,null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        Player ingoingPlayer = new Player(new Member(null,null,null,"john"),null,null);
        SubstitutionEvent substitutionEvent = new SubstitutionEvent(gameTime,"",team,player,ingoingPlayer);
        String eventString = "Substitution in team " +
                team.getTeamName() +
                "The Player " +
                ingoingPlayer.getMember().getFull_name() +
                " Subtituted " +
                player.getMember().getFull_name() +
                " at " + gameTime + ".";
        substitutionEvent.setIngoingPlayer(new Player(new Member(null,null,null,"pola"),null,null));
        assertNotEquals(substitutionEvent.toString(),eventString);
    }

    @Deprecated
    @Test
    public void testToString2() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",null,null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        Player ingoingPlayer = new Player(new Member(null,null,null,"john"),null,null);
        SubstitutionEvent substitutionEvent = new SubstitutionEvent(gameTime,"",team,player,ingoingPlayer);
        String eventString = "Substitution in team " +
                team.getTeamName() +
                "The Player " +
                ingoingPlayer.getMember().getFull_name() +
                " Subtituted " +
                player.getMember().getFull_name() +
                " at " + gameTime + ".";
        substitutionEvent.setEventPlayer(new Player(new Member(null,null,null,"reuven"),null,null));
        assertNotEquals(substitutionEvent.toString(),eventString);
    }

}