import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class GameReLocationEventTest {

    @Test
    public void testToString() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
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
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
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
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        String eventString = "The match between " +
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had relocated from " +
                originalStadium.getStadiumName() + " to " +
                relocatedStadium.getStadiumName() + ".";
            gameReLocationEvent.setAwayTeam(new Team("Barcelona",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,gameReLocationEvent.toString());
    }


    @Test
    public void getGameOriginalLocation() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        assertEquals(originalStadium,gameReLocationEvent.getGameOriginalLocation());
    }

    @Test
    public void setGameOriginalLocation() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        gameReLocationEvent.setGameOriginalLocation(relocatedStadium);
        assertEquals(relocatedStadium,gameReLocationEvent.getGameOriginalLocation());
    }

    @Test
    public void getGameNewLocation() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        assertEquals(relocatedStadium,gameReLocationEvent.getGameNewLocation());
    }

    @Test
    public void setGameNewLocation() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        gameReLocationEvent.setGameNewLocation(originalStadium);
        assertEquals(originalStadium,gameReLocationEvent.getGameNewLocation());
    }

    @Test
    public void getHomeTeam() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        assertEquals(homeTeam,gameReLocationEvent.getHomeTeam());
    }

    @Test
    public void setHomeTeam() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        gameReLocationEvent.setHomeTeam(awayTeam);
        assertEquals(awayTeam,gameReLocationEvent.getHomeTeam());
    }

    @Test
    public void getAwayTeam() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        assertEquals(awayTeam,gameReLocationEvent.getAwayTeam());
    }

    @Test
    public void setAwayTeam() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        gameReLocationEvent.setAwayTeam(homeTeam);
        assertEquals(homeTeam,gameReLocationEvent.getAwayTeam());
    }
}