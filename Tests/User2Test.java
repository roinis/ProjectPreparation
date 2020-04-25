import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class User2Test {

    @Test
    public void showCoachPrivateInfo() {
        AlphaSystem system = AlphaSystem.getSystem();
        Team team  = new Team("HBS",new TeamOwner(new Member("","","","alona")),null);
        Coach coach1 = new Coach(new Member("","","","barak bahar"),Coach.Certification.MainCoach);
        Coach coach2 = new Coach(new Member("","","","yossi abuksis"),Coach.Certification.MainCoach);
        Coach coach3 = new Coach(new Member("","","","roni levi"),Coach.Certification.MainCoach);
        coach1.addToTeam(team,"Coach");
        coach2.addToTeam(team,"Coach");
        coach3.addToTeam(team,"Coach");

        User2 user = new VisitorStub();
        List<String> info = user.showCoachPrivateInfo("barak bahar");
        assertEquals(coach1.getMember().getFull_name(),info.get(0));
        assertEquals(coach1.getTeam().getTeamName(),info.get(1));

        info = user.showCoachPrivateInfo("yossi abuksis");
        assertEquals(coach1.getMember().getFull_name(),info.get(0));
        assertEquals(coach1.getTeam().getTeamName(),info.get(1));

        info = user.showCoachPrivateInfo("roni levi");
        assertEquals(coach1.getMember().getFull_name(),info.get(0));
        assertEquals(coach1.getTeam().getTeamName(),info.get(1));
        /**
        System.out.println(coach1.getMember().getFull_name());
        System.out.println(coach1.getTeam().getTeamName());
         **/


    }

    @Test
    public void showTeamManagerPrivateInfo() {
        Team team  = new Team("HBS",new TeamOwner(new Member("","","","alona")),null);
        TeamManager teamManager1 = new TeamManager(new Member("","","","bol"),team,null);
        TeamManager teamManager2 = new TeamManager(new Member("","","","john"),team,null);

        User2 user = new VisitorStub();
        List<String> info = user.showTeamManagerPrivateInfo("bol");
        assertEquals(teamManager1.getMember().getFull_name(),info.get(0));
        assertEquals(teamManager1.getTeam().getTeamName(),info.get(1));

        info = user.showTeamManagerPrivateInfo("john");
        assertEquals(teamManager1.getMember().getFull_name(),info.get(0));
        assertEquals(teamManager2.getTeam().getTeamName(),info.get(1));

    }

    @Test
    public void showPlayerTeamTest(){
        Team team  = new Team("HBS",new TeamOwner(new Member("x","","","alona")),null);
        Player player=new Player(new Member("y","","","ogu"), Player.Position.ST,null);
        player.addToTeam(team);
        User2 user = new VisitorStub();
        assertNull(user.showPlayerTeam("oo"));
        String info = user.showPlayerTeam("ogu");
        assertEquals("HBS",info);
    }

    @Test
    public void showPlayerPositionTest(){
        Player player=new Player(new Member("y","","","ogu"), Player.Position.ST,null);
        User2 user = new VisitorStub();
        assertNull(user.showPlayerPosition("oo"));
        String info = user.showPlayerPosition("ogu");
        assertEquals("ST",info);
    }

    @Test
    public void showPlayerBirthDateTest(){
        Player player=new Player(new Member("y","","","ogu"), Player.Position.ST,LocalDate.of(1,1,1));
        User2 user = new VisitorStub();
        assertNull(user.showPlayerPosition("oo"));
        String info = user.showPlayerBirthDate("ogu");
        assertEquals("0001-01-01",info);
    }

    @Test
    public void showTeamStadiumTest(){
        Team team  = new Team("HBS",new TeamOwner(new Member("x","","","alona")),null);
        team.setHomeStadium(new Stadium("terner","lod"));
        User2 user = new VisitorStub();
        String info = user.showTeamStadium("HBS");
        assertNull(user.showTeamStadium("oo"));
        assertEquals("terner",info);
    }

    @Test
    public void showTeamPlayersTest(){
        Player player1=new Player(new Member("y","","","ogu"), Player.Position.ST,LocalDate.of(1,1,1));
        Player player2=new Player(new Member("y","","","tony"), Player.Position.ST,LocalDate.of(1,1,1));
        Team team  = new Team("HBS",new TeamOwner(new Member("x","","","alona")),null);
        player1.addToTeam(team);
        player2.addToTeam(team);
    }

}