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

  /*  @Test
    public void addAndRemoveOwnerTest(){
        try {
            Member member= (Member) alphaSystem.GetSpecificFromDB(2,"test");

            TeamOwner teamOwner = new TeamOwner(null);
            Team team = new Team("hapoel", teamOwner, null);
            assertTrue(teamOwner.getAppointmentList().isEmpty());
            teamOwner.addOwner("test2");
            assertTrue(teamOwner.getAppointmentList().isEmpty());
            teamOwner.addOwner("test1");
            TeamOwner newOwner = (TeamOwner) member.getJob("owner");
            assertTrue(newOwner != null);
            assertTrue(teamOwner.getAppointmentList().contains(newOwner));
        }catch (Exception e){};

    }*/



}


