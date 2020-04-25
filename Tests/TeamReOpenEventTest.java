import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class TeamReOpenEventTest {

    @Test
    public void testToString() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        LocalDateTime closeTeamDate  = LocalDateTime.of(2020,3,1,15,13,0);
        TeamReOpenEvent teamReOpenEvent  = new TeamReOpenEvent(closeTeamDate,team);
        String eventString = "The Team: " +
                team.getTeamName() +
                " has reopened" +
                " at " + closeTeamDate;
        assertEquals(eventString,teamReOpenEvent.toString());
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        LocalDateTime closeTeamDate  = LocalDateTime.of(2020,3,1,15,13,0);
        TeamReOpenEvent teamReOpenEvent = new TeamReOpenEvent(closeTeamDate,team);
        String eventString = "The Team: " +
                team.getTeamName() +
                " has reopened" +
                " at " + closeTeamDate;;
        teamReOpenEvent.setReopenedTeam(new Team("MTA",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,teamReOpenEvent.toString());
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        LocalDateTime closeTeamDate  = LocalDateTime.of(2020,3,1,15,13,0);
        TeamReOpenEvent teamReOpenEvent = new TeamReOpenEvent(closeTeamDate,team);
        String eventString = "The Team: " +
                team.getTeamName() +
                " has reopened" +
                " at " + closeTeamDate;
        teamReOpenEvent.setReopenedTime(LocalDateTime.of(2020,2,10,18,3,0));
        assertNotEquals(eventString,teamReOpenEvent.toString());
    }


}