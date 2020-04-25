import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class User2Test {

    @Test
    public void showCoachPrivateInfo() {
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
        League league2 = new League("Pri",new SchedulingPolicy(3),new ScoringPolicy(4,2,1));
        User2 user = new VisitorStub();

        List<String> info = user.showLeagueScoringPolicy("AL");
        assertEquals(String.valueOf(league1.getScoringPolicy().getPointsPerWin()),info.get(0));
        assertEquals(String.valueOf(league1.getScoringPolicy().getPointsPerDraw()),info.get(1));
        assertEquals(String.valueOf(league1.getScoringPolicy().getPointPerLoss()),info.get(2));

        info = user.showLeagueScoringPolicy("Pri");
        assertEquals(String.valueOf(league2.getScoringPolicy().getPointsPerWin()),info.get(0));
        assertEquals(String.valueOf(league2.getScoringPolicy().getPointsPerDraw()),info.get(1));
        assertEquals(String.valueOf(league2.getScoringPolicy().getPointPerLoss()),info.get(2));
    }

    @Test
    public void showLeagueSpecSeasonScoringPolicy() {
        League league1 = new League("AL",new SchedulingPolicy(2),new ScoringPolicy(3,1,0));

        league1.addSeason(2018,new SchedulingPolicy(2),new ScoringPolicy(3,1,0));
        league1.addSeason(2019,new SchedulingPolicy(2),new ScoringPolicy(2,1,0));
        league1.addSeason(2020,new SchedulingPolicy(3),new ScoringPolicy(4,2,1));
        User2 user = new VisitorStub();

        List<String> info = user.showLeagueSpecSeasonScoringPolicy("AL",2019);
        assertEquals("2",info.get(0));
        assertEquals("1",info.get(1));
        assertEquals("0",info.get(2));

        info = user.showLeagueSpecSeasonScoringPolicy("AL",2018);
        assertEquals("3",info.get(0));
        assertEquals("1",info.get(1));
        assertEquals("0",info.get(2));

        info = user.showLeagueSpecSeasonScoringPolicy("AL",2020);
        assertEquals("4",info.get(0));
        assertEquals("2",info.get(1));
        assertEquals("1",info.get(2));
    }

    @Test
    public void showLeagueTable() {

    }

    @Test
    public void showLeagueMainReferees() {
        League league1 = new League("AL",new SchedulingPolicy(2),new ScoringPolicy(3,1,0));
        league1.addMainReferee(new MainReferee(new Member("","","","Hakmon")));
        league1.addMainReferee(new MainReferee(new Member("","","","molina")));
        league1.addMainReferee(new MainReferee(new Member("","","","liani")));
        User2 user = new VisitorStub();

        List<String> info = user.showLeagueMainReferees("AL");
        assertEquals(league1.getLeagueReferees().get(0),info.get(0));
        assertEquals(league1.getLeagueReferees().get(1),info.get(1));
        assertEquals(league1.getLeagueReferees().get(2),info.get(2));


    }

    @Test
    public void showLeagueVarReferees() {

        League league1 = new League("AL",new SchedulingPolicy(2),new ScoringPolicy(3,1,0));
        league1.addVarReferee(new VarReferee(new Member("","","","Hakmon")));
        league1.addVarReferee(new VarReferee(new Member("","","","molina")));
        league1.addVarReferee(new VarReferee(new Member("","","","liani")));
        User2 user = new VisitorStub();

        List<String> info = user.showLeagueMainReferees("AL");
        assertEquals(league1.getLeagueVarReferees().get(0),info.get(0));
        assertEquals(league1.getLeagueVarReferees().get(1),info.get(1));
        assertEquals(league1.getLeagueVarReferees().get(2),info.get(2));
    }

    @Test
    public void showLeagueLinesManReferees() {
        League league1 = new League("AL",new SchedulingPolicy(2),new ScoringPolicy(3,1,0));
        league1.addLinesManReferee(new LinesManReferee(new Member("","","","Hakmon")));
        league1.addLinesManReferee(new LinesManReferee(new Member("","","","molina")));
        league1.addLinesManReferee(new LinesManReferee(new Member("","","","liani")));
        User2 user = new VisitorStub();

        List<String> info = user.showLeagueMainReferees("AL");
        assertEquals(league1.getLeagueLinesmans().get(0),info.get(0));
        assertEquals(league1.getLeagueLinesmans().get(1),info.get(1));
        assertEquals(league1.getLeagueLinesmans().get(2),info.get(2));

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