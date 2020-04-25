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

    public class MemberStub extends Member{
        public MemberStub(String user_name,String user_password,String user_id,String full_name){
            super(user_name,user_password, user_id, full_name);
            AlphaSystem alphaSystem=AlphaSystem.getSystem();
            alphaSystem.AddtoDB(2,this);
        }

    }



}


