import org.junit.Test;

import static org.junit.Assert.*;

public class NewNominationEventTest {

    @Test
    public void testToString() {
        Team team = new Team("HBS",null,null);
        Member member = new Member(null,null,null,"toni wak");
        NewNominationEvent newNominationEvent = new NewNominationEvent(team,member,"coach");
        String eventString = member.getFull_name()
                            +" appointed to the new "
                            + "coach"
                            + " of team " + team.getTeamName();
        System.out.println(eventString);
        assertEquals(eventString,newNominationEvent.toString());
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS",null,null);
        Member member = new Member(null,null,null,"toni wak");
        NewNominationEvent newNominationEvent = new NewNominationEvent(team,member,"coach");
        String eventString = member.getFull_name()
                +" appointed to the new "
                + "coach"
                + " of team " + team.getTeamName();
        newNominationEvent.setNomination("player");
        assertNotEquals(eventString,newNominationEvent.toString());
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS",null,null);
        Member member = new Member(null,null,null,"toni wak");
        NewNominationEvent newNominationEvent = new NewNominationEvent(team,member,"coach");
        String eventString = member.getFull_name()
                +" appointed to the new "
                + "coach"
                + " of team " + team.getTeamName();
        newNominationEvent.setTeam(new Team("MTA",null,null));
        assertNotEquals(eventString,newNominationEvent.toString());
    }


}