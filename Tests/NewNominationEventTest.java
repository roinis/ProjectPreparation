import org.junit.Test;

import static org.junit.Assert.*;

public class NewNominationEventTest {

    @Test
    public void testToString() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
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
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
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
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        NewNominationEvent newNominationEvent = new NewNominationEvent(team,member,"coach");
        String eventString = member.getFull_name()
                +" appointed to the new "
                + "coach"
                + " of team " + team.getTeamName();
        newNominationEvent.setTeam(new Team("MTA",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,newNominationEvent.toString());
    }


    @Test
    public void getMember() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        NewNominationEvent newNominationEvent = new NewNominationEvent(team,member,"coach");
        assertEquals(member,newNominationEvent.getMember());
    }

    @Test
    public void getTeam() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        NewNominationEvent newNominationEvent = new NewNominationEvent(team,member,"coach");
        assertEquals(team,newNominationEvent.getTeam());
    }

    @Test
    public void setTeam() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team team1 = new Team("HBS1",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        NewNominationEvent newNominationEvent = new NewNominationEvent(team,member,"coach");
        newNominationEvent.setTeam(team1);
        assertEquals(team1,newNominationEvent.getTeam());
    }

    @Test
    public void setMember() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        Member member1 = new Member(null,null,null,"toni wak1");
        NewNominationEvent newNominationEvent = new NewNominationEvent(team,member,"coach");
        newNominationEvent.setMember(member1);
        assertEquals(member1,newNominationEvent.getMember());

    }

    @Test
    public void getNomination() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        NewNominationEvent newNominationEvent = new NewNominationEvent(team,member,"coach");
        assertEquals("coach",newNominationEvent.getNomination());
    }

    @Test
    public void setNomination() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        NewNominationEvent newNominationEvent = new NewNominationEvent(team,member,"coach");
        newNominationEvent.setNomination("ch1");
        assertEquals("ch1",newNominationEvent.getNomination());
    }
}