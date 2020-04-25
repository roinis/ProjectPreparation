import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveNominationEventTest {

    @Test
    public void testToString() {
        Team team = new Team("HBS",null,null);
        Member member = new Member(null,null,null,"toni wak");
        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        String eventString = member.getFull_name() + " of team " + team.getTeamName()
                +" has fired from " + "coach"
                + " position.";
        assertEquals(eventString,removeNominationEvent.toString());
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS",null,null);
        Member member = new Member(null,null,null,"toni wak");
        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        String eventString = member.getFull_name() + " of team " + team.getTeamName()
                +" has fired from " + "coach"
                + " position.";
        removeNominationEvent.setNomination("player");
        assertNotEquals(eventString,removeNominationEvent.toString());
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS",null,null);
        Member member = new Member(null,null,null,"toni wak");
        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        String eventString = member.getFull_name() + " of team " + team.getTeamName()
                +" has fired from " + "coach"
                + " position.";
        removeNominationEvent.setTeam(new Team("MTA",null,null));
        assertNotEquals(eventString,removeNominationEvent.toString());
    }

}