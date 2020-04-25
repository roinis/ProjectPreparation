import org.junit.Test;

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
    public void showLeagueScoringPolicy() {
        League league1 = new League("AL",new SchedulingPolicy(2),new ScoringPolicy(3,1,0));
        League league2 = new League("AL",new SchedulingPolicy(3),new ScoringPolicy(4,2,1));



    }

    @Test
    public void showLeagueSpecSeasonScoringPolicy() {
    }

    @Test
    public void showLeagueTable() {
    }

    @Test
    public void showLeagueMainReferees() {
    }

    @Test
    public void showLeagueVarReferees() {
    }

    @Test
    public void showLeagueLinesManReferees() {
    }

    @Test
    public void showTeamPlayers() {
    }

    @Test
    public void showTeamCoaches() {
    }

    @Test
    public void showTeamManagers() {
    }

    @Test
    public void showTeamOwners() {
    }

    @Test
    public void showTeamStadium() {
    }

    @Test
    public void showPlayerTeam() {
    }

    @Test
    public void showPlayerPosition() {
    }

    @Test
    public void showPlayerBirthDate() {
    }
}