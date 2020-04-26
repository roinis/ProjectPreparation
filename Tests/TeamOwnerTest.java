import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
            boolean[] permissions1={true,true,true,true};
            boolean[] permissions2={false,false,false,false};
            MemberStub member1 = new MemberStub("test", "12345", "12345", "test");
            MemberStub member2 = new MemberStub("notManager", "12345", "12345", "notManager");
            MemberStub member3 = new MemberStub("owner", "12345", "12345", "owner");
            TeamOwner teamOwner = new TeamOwner(member3);
            member3.addJob(teamOwner);
            Team team = new Team("hapoel", teamOwner, null);
            assertTrue(teamOwner.getAppointmentList().isEmpty());
            teamOwner.addManager("test1",permissions1);
            assertTrue(teamOwner.getAppointmentList().isEmpty());
            teamOwner.addManager("test",permissions1);
            TeamManager manager = (TeamManager) member1.getJob("manager");
            assertTrue(manager != null);
            assertTrue(teamOwner.getAppointmentList().contains(manager));
            teamOwner.addManager("test",permissions1);
            assertEquals(1, teamOwner.getAppointmentList().size());
            teamOwner.addManager("owner",permissions1);
            assertEquals(1, teamOwner.getAppointmentList().size());
            assertFalse(teamOwner.getAppointmentList().contains(teamOwner));
            teamOwner.setPermissionsToManager("test",permissions2);
            assertTrue(manager.getPermissions().isEmpty());
            teamOwner.editExistingManagerName("test","barda");
            assertEquals("barda",manager.getMemberFullName());
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

    @Test
    public void budgetTest(){
        MemberStub member = new MemberStub("test", "12345", "12345", "test");
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        Budget budget=team.getBudget();
        teamOwner.addWithdraw((double) 100,"Withdraw");
        assertTrue(budget.getReports().size()==1);
        assertTrue(-100==budget.getBudget());
        teamOwner.addDeposit((double) 500,"Deposit");
        assertTrue(400==budget.getBudget());
        assertTrue(budget.getReports().size()==2);
    }

    @Test
    public void tweetsTest(){
        MemberStub member = new MemberStub("test", "12345", "12345", "test");
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        teamOwner.addTweet("test");
        assertTrue(team.getTweets().contains("test"));
        teamOwner.deleteTweet(0);
        assertFalse(team.getTweets().contains("test"));
    }

    @Test
    public void playerTest(){
        MemberStub member = new MemberStub("owner", "12345", "12345", "owner");
        MemberStub p_member = new MemberStub("test", "12345", "12345", "test");
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        Player player=new Player(p_member,null,null);
        teamOwner.addNewPlayer("test");
        assertTrue(team.getPlayers().contains(player));
        teamOwner.editExistingPlayerName("test","barda");
        assertEquals("barda",player.getMemberFullName());
        teamOwner.editExistingPlayerPosition("test","ST");
        assertEquals("ST",player.getPositionName());
        teamOwner.editExistingPlayerBirthday("test",2000,1,1);
        assertEquals("2000-01-01",player.getStringBirthDate());
        teamOwner.removeExistingPlayer("test");
        assertFalse(team.getPlayers().contains(player));
    }

    @Test
    public void coachTest(){
        MemberStub member = new MemberStub("owner", "12345", "12345", "owner");
        MemberStub c_member = new MemberStub("test", "12345", "12345", "test");
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        Coach coach=new Coach(c_member,null);
        teamOwner.addNewCoach("test","job");
        assertTrue(team.getCoaches().contains(coach));
        teamOwner.editExistingCoachName("test","barda");
        assertEquals("barda",coach.getMemberFullName());
        teamOwner.editExistingCoachCertification("test",1);
        assertEquals(Coach.Certification.GoalkeeperCoach,coach.getCertification());
        teamOwner.editExistingCoachJobInTeam("test","new job");
        assertEquals("new job",coach.getJobInTheTeam());
        teamOwner.removeExistingCoach("test");
        assertFalse(team.getCoaches().contains(coach));
    }

   @Test
   public void stadiumTest(){
       MemberStub member = new MemberStub("owner", "12345", "12345", "owner");
       TeamOwner teamOwner = new TeamOwner(member);
       Stadium stadium1=new Stadium("test1","test1");
       Stadium stadium2=new Stadium("test2","test2");
       Team team = new Team("hapoel", teamOwner, stadium1);
       teamOwner.editExistingStadiumName("goodtest");
       assertEquals("goodtest",stadium1.getStadiumName());
       teamOwner.setNewStadium("test2");
       assertEquals(stadium2,team.getHomeStadium());
   }





    public class MemberStub extends Member{
        public MemberStub(String user_name,String user_password,String user_id,String full_name){
            super(user_name,user_password, user_id, full_name);
            AlphaSystem alphaSystem=AlphaSystem.getSystem();
            alphaSystem.AddtoDB(2,this);
        }

    }



}


