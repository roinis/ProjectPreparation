import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class GameReLocationEventTest {

    @Test
    public void testToString() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",null,null);
        Team awayTeam = new Team("MH",null,null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        String eventString = "The match between " +
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had relocated from " +
                originalStadium.getStadiumName() + " to " +
                relocatedStadium.getStadiumName() + ".";
        assertEquals(eventString,gameReLocationEvent.toString());
    }

    @Test
    public void testToString1() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",null,null);
        Team awayTeam = new Team("MH",null,null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        String eventString = "The match between " +
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had relocated from " +
                originalStadium.getStadiumName() + " to " +
                relocatedStadium.getStadiumName() + ".";
        gameReLocationEvent.setGameNewLocation(new Stadium("kamp noe","barcelona"));
        assertNotEquals(eventString,gameReLocationEvent.toString());
    }
    @Test
    public void testToString2() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",null,null);
        Team awayTeam = new Team("MH",null,null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        String eventString = "The match between " +
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had relocated from " +
                originalStadium.getStadiumName() + " to " +
                relocatedStadium.getStadiumName() + ".";
            gameReLocationEvent.setAwayTeam(new Team("Barcelona",null,null));
        assertNotEquals(eventString,gameReLocationEvent.toString());
    }


}