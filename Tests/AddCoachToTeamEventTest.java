import org.junit.Test;

import java.time.LocalDateTime;

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

    @Test
    public void getCoach() {
        Coach coach = new Coach(new Member("","","","coach"),null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        AddCoachToTeamEvent addCoachToTeamEvent = new AddCoachToTeamEvent(coach,team);
        assertEquals(addCoachToTeamEvent.getCoach(),coach);

    }

    @Test
    public void setCoach() {
        Coach coach = new Coach(new Member("","","","coach"),null);
        Coach coach1 = new Coach(new Member("","","","coach1"),null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        AddCoachToTeamEvent addCoachToTeamEvent = new AddCoachToTeamEvent(coach,team);
        addCoachToTeamEvent.setCoach(coach1);
        assertEquals(addCoachToTeamEvent.getCoach(),coach1);
    }

    @Test
    public void getTeam() {
        Coach coach = new Coach(new Member("","","","coach"),null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        AddCoachToTeamEvent addCoachToTeamEvent = new AddCoachToTeamEvent(coach,team);
        assertEquals(addCoachToTeamEvent.getTeam(),team);
    }

    @Test
    public void setTeam() {
        Coach coach = new Coach(new Member("","","","coach"),null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team team1 = new Team("HBS1",new TeamOwner(new Member("","","","roi")),null);
        AddCoachToTeamEvent addCoachToTeamEvent = new AddCoachToTeamEvent(coach,team);
        addCoachToTeamEvent.setTeam(team1);
        assertEquals(addCoachToTeamEvent.getTeam(),team1);
    }

    @Test
    public void getDateTime() {
        Coach coach = new Coach(new Member("","","","coach"),null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        AddCoachToTeamEvent addCoachToTeamEvent = new AddCoachToTeamEvent(coach,team);
        addCoachToTeamEvent.getDateTime();
    }

    @Test
    public void setDateTime() {
        Coach coach = new Coach(new Member("","","","coach"),null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        LocalDateTime localDateTime = LocalDateTime.now();
        AddCoachToTeamEvent addCoachToTeamEvent = new AddCoachToTeamEvent(coach,team);
        addCoachToTeamEvent.setDateTime(localDateTime);
        assertEquals(localDateTime,addCoachToTeamEvent.getDateTime());
    }
}