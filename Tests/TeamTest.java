import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void setTeamNameTest(){
        AlphaSystem system=AlphaSystem.getSystem();
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,null)),null);
        team.setTeamName("hbs");
        Team teamFromDB=(Team)system.GetSpecificFromDB(4,"hbs");
        assertNull(system.GetSpecificFromDB(4,"xxx"));
        assertEquals("hbs",teamFromDB.getTeamName());
        team.setStatus(Team.Status.close);
        team.setTeamName("yyy");
        assertEquals("hbs",teamFromDB.getTeamName());
    }

    @Test
    public void addOwnerTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),null);
        TeamOwner newOwner=new TeamOwner(new Member("eli",null,null,"eli barkat"));
        assertTrue(team.addOwner(newOwner));
        assertEquals(newOwner,team.getOwners().get(1));
        team.setStatus(Team.Status.close);
        assertFalse(team.addOwner(newOwner));
    }

    @Test
    public void removeOwnerTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),null);
        TeamOwner newOwner=new TeamOwner(new Member("eli",null,null,"eli barkat"));
        team.addOwner(newOwner);
        assertTrue(team.removeOwner(newOwner));
        assertEquals(1,team.getOwners().size());
        assertFalse(team.removeOwner(team.getOwners().get(0)));
        assertTrue(team.addOwner(newOwner));
        team.setStatus(Team.Status.close);
        assertFalse(team.removeOwner(newOwner));
    }

    @Test
    public void addManagerTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),null);
        TeamManager manager=new TeamManager(new Member("bachar",null,null,"barak bachar"),null,new ArrayList<>());
        assertTrue(team.addManager(manager));
        assertEquals(manager,team.getManagers().get(0));
        team.setStatus(Team.Status.close);
        assertFalse(team.addManager(manager));
    }

    @Test
    public void removeManagerTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),null);
        TeamManager manager=new TeamManager(new Member("bachar",null,null,"barak bachar"),null,new ArrayList<>());
        team.addManager(manager);
        assertTrue(team.removeManager(manager));
        assertEquals(0,team.getManagers().size());
        team.addManager(manager);
        team.setStatus(Team.Status.close);
        assertFalse(team.removeManager(manager));
    }

    @Test
    public void setStatusTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),null);
        assertFalse(team.setStatus(Team.Status.open));
        assertTrue(team.setStatus(Team.Status.close));
    }

    @Test
    public void setHomeStadiumTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        team.setHomeStadium(new Stadium("vasermil","lod"));
        assertEquals("vasermil",team.getHomeStadium().getStadiumName());
        team.setStatus(Team.Status.close);
        assertFalse(team.setHomeStadium(new Stadium("dalet","null")));
    }

    @Test
    public void addTweetTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        team.addTweet("abc");
        assertEquals("abc",team.getTweets().get(0));
        team.setStatus(Team.Status.close);
        assertFalse(team.addTweet("xyz"));
    }

    @Test
    public void deleteTweetTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        team.addTweet("abc");
        team.addTweet("xyz");
        assertFalse(team.deleteTweet(5));
        assertTrue(team.deleteTweet(1));
        assertEquals(1,team.getTweets().size());
        assertEquals("abc",team.getTweets().get(0));
        team.setStatus(Team.Status.close);
        assertFalse(team.deleteTweet(0));
    }

    @Test
    public void registerTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Member user=new Member("mem",null,null,null);
        assertEquals(0,team.getFanObservers().size());
        team.register(user);
        assertEquals(1,team.getFanObservers().size());
        assertEquals(user,team.getFanObservers().get(0));
        team.setStatus(Team.Status.close);
        assertEquals(1,team.getFanObservers().size());
    }

    @Test
    public void unregisterTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Member user=new Member("mem",null,null,null);
        team.register(user);
        team.unregister(user);
        assertEquals(0,team.getFanObservers().size());
        team.register(user);
        team.setStatus(Team.Status.close);
        team.unregister(user);
        assertEquals(1,team.getFanObservers().size());
    }

    @Test
    public void notifyObserverTest(){

    }

    @Test
    public void registerSystemAdminTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        SystemAdmin admin=new SystemAdmin("x",null,null,"x x");
        assertTrue(team.registerSystemAdmin(admin));
        team.setStatus(Team.Status.close);
        assertFalse(team.registerSystemAdmin(admin));
    }

    @Test
    public void equalsTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Player p=new Player(new Member("p",null,null,"p p"),null,null);
        assertTrue(team.equals(team));
        assertFalse(team.equals(p));
        Team team1=new Team("xyz",new TeamOwner(new Member("alona2",null,null,"alona barka2t")),new Stadium("terner","lod"));
        assertFalse(team.equals(team1));
    }

    @Test
    public void addWithdrawTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        team.addWithdraw(5d,"5 shelkel");
        Budget budget=team.getBudget();
        double ret=budget.getBudget();
        assertEquals(-5.0,ret,0);
        team.addWithdraw(10d,"10 shelkel");
        ret=budget.getBudget();
        assertEquals(-15.0,ret,0);
        team.setStatus(Team.Status.close);
        assertFalse(team.addWithdraw(5d," nothing"));
    }

    @Test
    public void addDepositTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        team.addDeposit(5d,"5 shelkel");
        Budget budget=team.getBudget();
        double ret=budget.getBudget();
        assertEquals(5.0,ret,0);
        team.addDeposit(10d,"10 shelkel");
        ret=budget.getBudget();
        assertEquals(15.0,ret,0);
        team.setStatus(Team.Status.close);
        assertFalse(team.addDeposit(5d," nothing"));
    }

    @Test
    public void addNewPlayerTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Player p1=new Player(new Member("ogu",null,null,"john ogu"),null,null);
        Player p2=new Player(new Member("tony",null,null,"tony nwakeme"),null,null);
        Player p3=new Player(new Member("illuz",null,null,"evyatar illuz"),null,null);

        assertTrue(team.addNewPlayer("john ogu"));
        assertTrue(team.addNewPlayer("tony nwakeme"));
        assertFalse(team.addNewPlayer("sahar"));
        assertEquals(2,team.getPlayers().size());
        assertTrue(p1.getTeam().equals(team));
        team.setStatus(Team.Status.close);
        assertFalse(team.addNewPlayer("evyatar illuz"));
    }

    @Test
    public void removeExistingPlayerTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Player p1=new Player(new Member("ogu",null,null,"john ogu"),null,null);
        Player p2=new Player(new Member("tony",null,null,"tony nwakeme"),null,null);
        team.addNewPlayer("john ogu");
        team.addNewPlayer("tony nwakeme");
        assertTrue(team.removeExistingPlayer("ogu"));
        assertEquals(1,team.getPlayers().size());
        assertEquals("tony",team.getPlayers().get(0).getMemberUserName());
        team.setStatus(Team.Status.close);
        assertFalse(team.removeExistingPlayer("tony"));
    }

    @Test
    public void editExistingPlayerName(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Player p1=new Player(new Member("ogu",null,null,"john ogu"),null,null);
        team.addNewPlayer("john ogu");
        team.editExistingPlayerName("ogu","john ugo");
        assertEquals("john ugo",p1.getMemberFullName());
        assertFalse(team.editExistingPlayerName("zzz","bbb"));
        team.setStatus(Team.Status.close);
        assertFalse(team.editExistingPlayerName("ogu","john ugo banana"));
    }

    @Test
    public void editExistingPlayerPosition(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Player p1=new Player(new Member("ogu",null,null,"john ogu"),null,null);
        team.addNewPlayer("john ogu");
        team.editExistingPlayerPosition("ogu","CDM");
        assertEquals("CDM",p1.getPositionName());
        assertFalse(team.editExistingPlayerPosition("zzz","bbb"));
        team.setStatus(Team.Status.close);
        assertFalse(team.editExistingPlayerName("ogu","john ugo banana"));
    }

    @Test
    public void editExistingPlayerBirthday(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Player p1=new Player(new Member("ogu",null,null,"john ogu"),null,null);
        team.addNewPlayer("john ogu");
        team.editExistingPlayerBirthday("ogu",2000,12,12);
        assertEquals("2000-12-12",p1.getStringBirthDate());
        assertFalse(team.editExistingPlayerPosition("zzz","bbb"));
        team.setStatus(Team.Status.close);
        assertFalse(team.editExistingPlayerName("ogu","john ugo banana"));
    }

    @Test
    public void addNewCoach(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Coach p1=new Coach(new Member("ogu",null,null,"john ogu"),null);
        assertTrue(team.addNewCoach("ogu","banana"));
        assertEquals(1,team.getCoaches().size());
        assertFalse(team.addNewCoach("ogi","banana"));
        team.setStatus(Team.Status.close);
        assertFalse(team.addNewCoach("ogu","banana"));
    }

    @Test
    public void removeExistingCoach(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Coach p1=new Coach(new Member("ogu",null,null,"john ogu"),null);
        team.addNewCoach("ogu","banana");
        assertTrue(team.removeExistingCoach("ogu"));
        assertEquals(0,team.getCoaches().size());
        assertFalse(team.removeExistingCoach("ogi"));
        team.addNewCoach("ogu","banana");
        team.setStatus(Team.Status.close);
        assertFalse(team.removeExistingCoach("ogu"));
    }

    @Test
    public void editExistingCoachNameTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Coach p1=new Coach(new Member("ogu",null,null,"john ogu"),null);
        team.addNewCoach("ogu","banana");
        assertTrue(team.editExistingCoachName("ogu","ogi"));
        assertEquals("ogi",p1.getMemberFullName());
        assertFalse(team.editExistingCoachName("oga","ogi"));
        team.setStatus(Team.Status.close);
        assertFalse(team.editExistingCoachName("ogu","ogi"));
    }

    @Test
    public void editExistingCoachCertificationTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Coach p1=new Coach(new Member("ogu",null,null,"john ogu"),null);
        team.addNewCoach("ogu","banana");
        team.editExistingCoachCertification("ogu",3);
        assertEquals(Coach.Certification.MainCoach,p1.getCertification());
        assertFalse(team.editExistingCoachCertification("ogi",3));
        team.setStatus(Team.Status.close);
        assertFalse(team.editExistingCoachCertification("ogu",2));
    }

    @Test
    public void editExistingCoachJobInTeam(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Coach p1=new Coach(new Member("ogu",null,null,"john ogu"),null);
        team.addNewCoach("ogu","banana");
        team.editExistingCoachJobInTeam("ogu","orange");
        assertEquals("orange",p1.getJobInTheTeam());
        assertFalse(team.editExistingCoachJobInTeam("ogi","orange"));
        team.setStatus(Team.Status.close);
        assertFalse(team.editExistingCoachJobInTeam("ogu","orange"));
    }

    @Test
    public void editExistingManagerName(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        TeamManager manager=new TeamManager(new Member("ogu",null,null,"john ogu"),null,new ArrayList<>());
        team.addManager(manager);
        team.editExistingManagerName("ogu","john ogi");
        assertEquals("john ogi",manager.getMemberFullName());
        assertFalse(team.editExistingManagerName("ogi","john ogi"));
        team.setStatus(Team.Status.close);
        assertFalse(team.editExistingManagerName("ogu","john ogu"));
    }

    @Test
    public void editExistingStadiumNameTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        team.editExistingStadiumName("vasermil");
        assertEquals("vasermil",team.getHomeStadium().getStadiumName());
        team.setStatus(Team.Status.close);
        assertFalse(team.editExistingStadiumName("terner"));
    }

    @Test
    public void setNewStadiumTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        Stadium stadium=new Stadium("vasermil","lod");
        team.setNewStadium("vasermil");
        assertEquals("vasermil",team.getHomeStadium().getStadiumName());
        assertFalse(team.setNewStadium("xxx"));
        team.setStatus(Team.Status.close);
        assertFalse(team.setNewStadium("terner"));
    }

    @Test
    public void setPermissionsToManagerTest(){
        Team team=new Team("xxx",new TeamOwner(new Member("alona",null,null,"alona barkat")),new Stadium("terner","lod"));
        TeamManager manager=new TeamManager(new Member("ogu",null,null,"john ogu"),null,new ArrayList<>());
        team.addManager(manager);
        ArrayList<TeamManager.Permissions> perm=new ArrayList<>();
        perm.add(TeamManager.Permissions.EDIT_PERSONAL_PAGE);
        perm.add(TeamManager.Permissions.EDIT_PROPERTIES);
        assertTrue(team.setPermissionsToManager("ogu",perm));
        assertEquals(2,manager.getPermissions().size());
        team.setStatus(Team.Status.close);
        assertFalse(team.setPermissionsToManager("ogu",perm));

    }


}
