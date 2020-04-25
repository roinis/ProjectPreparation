import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class TeamOwnerTest {

    @Test
    public void setTeamTest(){
        TeamOwner teamOwner=new TeamOwner(null);
        assertEquals(null,teamOwner.getTeam());
        Team team=new Team("hapoel",teamOwner,null);
        assertEquals(team,teamOwner.getTeam());
    }

    @Test
    public void addAndRemoveOwnerTest() {
        MemberStub member1 = new MemberStub("test", "12345", "12345", "test");
        MemberStub member2 = new MemberStub("memberTest", "12345", "12345", "memberTest");
        new MemberStub("notOwner", "12345", "12345", "notOwner");
        TeamOwner teamOwner = new TeamOwner(null);
        Team team = new Team("hapoel", teamOwner, null);
        assertTrue(teamOwner.getAppointmentList().isEmpty());
        teamOwner.addOwner("test1");
        assertTrue(teamOwner.getAppointmentList().isEmpty());
        teamOwner.addOwner("test");
        TeamOwner newOwner = (TeamOwner) member1.getJob("owner");
        assertTrue(newOwner != null);
        assertTrue(teamOwner.getAppointmentList().contains(newOwner));
        teamOwner.addOwner("test");
        assertEquals(1, teamOwner.getAppointmentList().size());
        newOwner.addOwner("memberTest");
        teamOwner.addOwner("memberTest");
        teamOwner.removeOwner("test1");
        assertEquals(1, teamOwner.getAppointmentList().size());
        teamOwner.removeOwner("notOwner");
        assertEquals(1, teamOwner.getAppointmentList().size());
        teamOwner.removeOwner("memberTest");
        assertEquals(1, teamOwner.getAppointmentList().size());
        teamOwner.removeOwner("test");
        assertFalse(teamOwner.getAppointmentList().contains(newOwner));
        assertEquals(0,teamOwner.getAppointmentList().size());
        assertNull(member1.getJob("owner"));
        assertNull(member2.getJob("owner"));
    }

    @Test
    public void openAndCloseTeamTest(){
        MemberStub member = new MemberStub("test", "12345", "12345", "test");
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        teamOwner.closeTeam();
        assertEquals(Team.Status.close,team.getStatus());
        teamOwner.openTeam();
        assertEquals(Team.Status.open,team.getStatus());
    }

    @Test
    public void addAndRemoveManagersTest() {
        try {
            String input = "no\nno\nno\nno\nno\nno\nno";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream);
            MemberStub member1 = new MemberStub("test", "12345", "12345", "test");
            MemberStub member2 = new MemberStub("notManager", "12345", "12345", "notManager");
            MemberStub member3 = new MemberStub("owner", "12345", "12345", "owner");
            TeamOwner teamOwner = new TeamOwner(member3);
            member3.addJob(teamOwner);
            Team team = new Team("hapoel", teamOwner, null);
            assertTrue(teamOwner.getAppointmentList().isEmpty());
            teamOwner.addManager("test1");
            assertTrue(teamOwner.getAppointmentList().isEmpty());
            teamOwner.addManager("test");
            TeamManager manager = (TeamManager) member1.getJob("manager");
            assertTrue(manager != null);
            assertTrue(teamOwner.getAppointmentList().contains(manager));
            teamOwner.addManager("test");
            assertEquals(1, teamOwner.getAppointmentList().size());
            teamOwner.addManager("owner");
            assertEquals(1, teamOwner.getAppointmentList().size());
            assertFalse(teamOwner.getAppointmentList().contains(teamOwner));

            teamOwner.removeManger("test1");
            assertEquals(1, teamOwner.getAppointmentList().size());
            teamOwner.removeManger("notManager");
            assertEquals(1, teamOwner.getAppointmentList().size());
            TeamManager teamManager=new TeamManager(member2,team,null);
            member2.addJob(teamManager);
            teamOwner.removeManger("notManager");
            assertEquals(1, teamOwner.getAppointmentList().size());
            teamOwner.removeManger("test");
            assertFalse(teamOwner.getAppointmentList().contains(manager));
            assertEquals(0, teamOwner.getAppointmentList().size());
            assertNull(member1.getJob("manager"));

        }catch (Exception e){};
    }

    public void test(){
        int x=0;
    }

    public class MemberStub extends Member{
        public MemberStub(String user_name,String user_password,String user_id,String full_name){
            super(user_name,user_password, user_id, full_name);
            AlphaSystem alphaSystem=AlphaSystem.getSystem();
            alphaSystem.AddtoDB(2,this);
        }

    }



}


