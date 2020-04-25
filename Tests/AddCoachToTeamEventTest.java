import org.junit.Test;

import static org.junit.Assert.*;

public class AddCoachToTeamEventTest {

    @Test
    public void testToString() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        AddCoachToTeamEvent addCoachToTeamEvent = new AddCoachToTeamEvent(coach,team);
        String eventString = "The Coach: " +
                coach.getMemberFullName() +
                " has joined the Team: " + team.getTeamName() +
                " At: " + addCoachToTeamEvent.getDateTime();

        assertEquals(eventString,addCoachToTeamEvent.toString());
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        AddCoachToTeamEvent addCoachToTeamEvent = new AddCoachToTeamEvent(coach,team);
        String eventString = "The Coach: " +
                coach.getMemberFullName() +
                " has joined the Team: " + team.getTeamName() +
                " At: " + addCoachToTeamEvent.getDateTime();
        addCoachToTeamEvent.setCoach(new Coach(new Member(null,null,null,"yossi"), Coach.Certification.MainCoach));
        assertNotEquals(eventString,addCoachToTeamEvent.toString());
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        AddCoachToTeamEvent addCoachToTeamEvent = new AddCoachToTeamEvent(coach,team);
        String eventString = "The Coach: " +
                coach.getMemberFullName() +
                " has joined the Team: " + team.getTeamName() +
                " At: " + addCoachToTeamEvent.getDateTime();

        addCoachToTeamEvent.setTeam(new Team("TelAviv",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,addCoachToTeamEvent.toString());
    }
}