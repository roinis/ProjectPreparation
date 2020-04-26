import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamManagerTest {

    @Test
    public void teamManagerTest(){
        MemberStub member = new MemberStub("test", "12345", "12345", "test");
        boolean[] permissions1={true,true,true,true};
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        TeamManager teamManager=new TeamManager(member,null,null);
        teamManager.setTeam(team);
        assertEquals(team,teamManager.getTeam());
        teamManager.setPermissions(choosePermissions(permissions1));
        for(TeamManager.Permissions permissions: TeamManager.Permissions.values())
            assertTrue(teamManager.getPermissions().contains(permissions));
        teamManager.removeAllPermissions();
        assertTrue(teamManager.getPermissions().isEmpty());
    }

    @Test
    public void openAndCloseTeamTest(){
        boolean[] permissions2={false,false,false,false};
        boolean[] permissions1={true,true,true,true};
        MemberStub member = new MemberStub("test", "12345", "12345", "test");
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        TeamManager teamManager=new TeamManager(member,team,choosePermissions(permissions2));
        teamManager.closeTeam();
        assertEquals(Team.Status.open,team.getStatus());
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.closeTeam();
        assertEquals(Team.Status.close,team.getStatus());
        teamManager.removeAllPermissions();
        teamManager.openTeam();
        assertEquals(Team.Status.close,team.getStatus());
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.openTeam();
        assertEquals(Team.Status.open,team.getStatus());
    }

    @Test
    public void budgetTest(){
        boolean[] permissions2={false,false,false,false};
        boolean[] permissions1={true,true,true,true};
        MemberStub member = new MemberStub("test", "12345", "12345", "test");
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        TeamManager teamManager=new TeamManager(member,team,choosePermissions(permissions2));
        Budget budget=team.getBudget();
        teamManager.addWithdraw((double) 100,"Withdraw");
        assertTrue(budget.getReports().size()==0);
        assertTrue(0==budget.getBudget());
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.addWithdraw((double) 100,"Withdraw");
        assertTrue(budget.getReports().size()==1);
        assertTrue(-100==budget.getBudget());
        teamManager.addDeposit((double) 500,"Deposit");
        assertTrue(400==budget.getBudget());
        assertTrue(budget.getReports().size()==2);
        teamManager.removeAllPermissions();
        teamManager.addDeposit((double) 500,"Deposit");
        assertTrue(400==budget.getBudget());
        assertTrue(budget.getReports().size()==2);
    }

    @Test
    public void tweetsTest(){
        boolean[] permissions2={false,false,false,false};
        boolean[] permissions1={true,true,true,true};
        MemberStub member = new MemberStub("test", "12345", "12345", "test");
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        TeamManager teamManager=new TeamManager(member,team,choosePermissions(permissions2));
        teamManager.addTweet("test");
        assertFalse(team.getTweets().contains("test"));
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.addTweet("test");
        assertTrue(team.getTweets().contains("test"));
        teamManager.removeAllPermissions();
        teamManager.deleteTweet(0);
        assertTrue(team.getTweets().contains("test"));
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.deleteTweet(0);
        assertFalse(team.getTweets().contains("test"));
    }

    @Test
    public void playerTest(){
        LocalDate date=LocalDate.of(1992,07,23);
        boolean[] permissions2={false,false,false,false};
        boolean[] permissions1={true,true,true,true};
        MemberStub member = new MemberStub("test", "12345", "12345", "test");
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        TeamManager teamManager=new TeamManager(member,team,choosePermissions(permissions2));
        MemberStub p_member = new MemberStub("test", "12345", "12345", "test");
        Player player=new Player(p_member,Player.Position.GK,date);

        teamManager.addNewPlayer("test");
        assertFalse(team.getPlayers().contains(player));
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.addNewPlayer("test");
        assertTrue(team.getPlayers().contains(player));

        teamManager.removeAllPermissions();
        teamManager.editExistingPlayerName("test","barda");
        assertEquals("test",player.getMemberFullName());
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.editExistingPlayerName("test","barda");
        assertEquals("barda",player.getMemberFullName());

        teamManager.removeAllPermissions();
        teamManager.editExistingPlayerPosition("test","ST");
        assertEquals("GK",player.getPositionName());
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.editExistingPlayerPosition("test","ST");
        assertEquals("ST",player.getPositionName());

        teamManager.removeAllPermissions();
        teamManager.editExistingPlayerBirthday("test",2000,1,1);
        assertEquals("1992-07-23",player.getStringBirthDate());
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.editExistingPlayerBirthday("test",2000,1,1);
        assertEquals("2000-01-01",player.getStringBirthDate());

        teamManager.removeAllPermissions();
        teamManager.removeExistingPlayer("test");
        assertTrue(team.getPlayers().contains(player));
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.removeExistingPlayer("test");
        assertFalse(team.getPlayers().contains(player));
    }

    @Test
    public void coachTest(){
        boolean[] permissions2={false,false,false,false};
        boolean[] permissions1={true,true,true,true};
        MemberStub member = new MemberStub("test", "12345", "12345", "test");
        TeamOwner teamOwner = new TeamOwner(member);
        Team team = new Team("hapoel", teamOwner, null);
        TeamManager teamManager=new TeamManager(member,team,choosePermissions(permissions2));
        MemberStub c_member = new MemberStub("test", "12345", "12345", "test");
        Coach coach=new Coach(c_member,Coach.Certification.MainCoach);

        teamManager.addNewCoach("test","job");
        assertFalse(team.getCoaches().contains(coach));
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.addNewCoach("test","job");
        assertTrue(team.getCoaches().contains(coach));

        teamManager.removeAllPermissions();
        teamManager.editExistingCoachName("test","barda");
        assertEquals("test",coach.getMemberFullName());
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.editExistingCoachName("test","barda");
        assertEquals("barda",coach.getMemberFullName());

        teamManager.removeAllPermissions();
        teamManager.editExistingCoachCertification("test",1);
        assertEquals(Coach.Certification.MainCoach,coach.getCertification());
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.editExistingCoachCertification("test",1);
        assertEquals(Coach.Certification.GoalkeeperCoach,coach.getCertification());

        teamManager.removeAllPermissions();
        teamManager.editExistingCoachJobInTeam("test","new job");
        assertEquals("job",coach.getJobInTheTeam());
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.editExistingCoachJobInTeam("test","new job");
        assertEquals("new job",coach.getJobInTheTeam());

        teamManager.removeAllPermissions();
        teamManager.removeExistingCoach("test");
        assertTrue(team.getCoaches().contains(coach));
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.removeExistingCoach("test");
        assertFalse(team.getCoaches().contains(coach));
    }

    @Test
    public void stadiumTest(){
        boolean[] permissions2={false,false,false,false};
        boolean[] permissions1={true,true,true,true};
        MemberStub member = new MemberStub("test", "12345", "12345", "test");
        TeamOwner teamOwner = new TeamOwner(member);
        Stadium stadium1=new Stadium("test1","test1");
        Team team = new Team("hapoel", teamOwner, stadium1);
        TeamManager teamManager=new TeamManager(member,team,choosePermissions(permissions2));
        Stadium stadium2=new Stadium("test2","test2");

        teamManager.editExistingStadiumName("goodtest");
        assertEquals("test1",stadium1.getStadiumName());
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.editExistingStadiumName("goodtest");
        assertEquals("goodtest",stadium1.getStadiumName());

        teamManager.removeAllPermissions();
        teamManager.setNewStadium("test2");
        assertEquals(stadium1,team.getHomeStadium());
        teamManager.setPermissions(choosePermissions(permissions1));
        teamManager.setNewStadium("test2");
        assertEquals(stadium2,team.getHomeStadium());
    }

    public class MemberStub extends Member{
        public MemberStub(String user_name,String user_password,String user_id,String full_name){
            super(user_name,user_password, user_id, full_name);
            AlphaSystem alphaSystem=AlphaSystem.getSystem();
            alphaSystem.AddtoDB(2,this);
        }

    }

    private ArrayList<TeamManager.Permissions> choosePermissions(boolean[] permissionsList){
        ArrayList<TeamManager.Permissions> permissions=new ArrayList<>();
        if(permissionsList[0])
            permissions.add(TeamManager.Permissions.SET_TEAM_STATUS);
        if(permissionsList[1])
            permissions.add(TeamManager.Permissions.EDIT_PROPERTIES);
        if(permissionsList[2])
            permissions.add(TeamManager.Permissions.ADD_FINANCIAL_REPORT);
        if(permissionsList[3])
            permissions.add(TeamManager.Permissions.EDIT_PERSONAL_PAGE);
        return permissions;
    }

}
