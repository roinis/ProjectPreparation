import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveCoachFromTeamEventTest {

    @Test
    public void testToString() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        String eventString = "The Coach: " +
                coach.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removeCoachFromTeamEvent.getDateTime();

        assertEquals(eventString,removeCoachFromTeamEvent.toString());
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        String eventString = "The Coach: " +
                coach.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removeCoachFromTeamEvent.getDateTime();

        removeCoachFromTeamEvent.setCoach(new Coach(new Member(null,null,null,"yossi"), Coach.Certification.MainCoach));
        assertNotEquals(eventString,removeCoachFromTeamEvent.toString());
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        String eventString = "The Coach: " +
                coach.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removeCoachFromTeamEvent.getDateTime();

        removeCoachFromTeamEvent.setTeam(new Team("TelAviv",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,removeCoachFromTeamEvent.toString());
    }
}