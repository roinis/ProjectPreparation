import javafx.util.Pair;
import org.junit.Test;

import java.security.acl.Owner;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class User2Test {

    @Test
    public void showCoachPrivateInfo() {
        Team team  = new Team("HBS",new TeamOwner(new Member("","","","alona")),null);
        Coach coach1 = new Coach(new Member("barak bahar","","","barak bahar"),Coach.Certification.MainCoach);
        Coach coach2 = new Coach(new Member("yossi abuksis","","","yossi abuksis"),Coach.Certification.MainCoach);
        Coach coach3 = new Coach(new Member("roni levi","","","roni levi"),Coach.Certification.MainCoach);
        coach1.addToTeam(team,"Coach");
        coach2.addToTeam(team,"Coach");
        coach3.addToTeam(team,"Coach");

        User2 user = new VisitorStub();
        List<String> info = user.showCoachPrivateInfo("barak bahar");
        assertEquals(coach1.getMember().getFull_name(),info.get(0));
        assertEquals(coach1.getTeam().getTeamName(),info.get(1));

        info = user.showCoachPrivateInfo("yossi abuksis");
        assertEquals(coach2.getMember().getFull_name(),info.get(0));
        assertEquals(coach2.getTeam().getTeamName(),info.get(1));

        info = user.showCoachPrivateInfo("roni levi");
        assertEquals(coach3.getMember().getFull_name(),info.get(0));
        assertEquals(coach3.getTeam().getTeamName(),info.get(1));
        /**
         System.out.println(coach1.getMember().getFull_name());
         System.out.println(coach1.getTeam().getTeamName());
         **/


    }

    @Test
    public void showTeamManagerPrivateInfo() {
        Team team  = new Team("HBS",new TeamOwner(new Member("alona","","","alona")),null);
        TeamManager teamManager1 = new TeamManager(new Member("bol","","","bol"),team,null);
        TeamManager teamManager2 = new TeamManager(new Member("john","","","john"),team,null);

        User2 user = new VisitorStub();
        List<String> info = user.showTeamManagerPrivateInfo("bol");
        assertEquals(teamManager1.getMember().getFull_name(),info.get(0));
        assertEquals(teamManager1.getTeam().getTeamName(),info.get(1));

        info = user.showTeamManagerPrivateInfo("john");
        assertEquals(teamManager2.getMember().getFull_name(),info.get(0));
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
        Team team1=new Team("x",new TeamOwner(new Member("owner1",null,null,"owner1")),new Stadium("terner","city"));
        Team team2=new Team("y",new TeamOwner(new Member("owner2",null,null,"owner2")),new Stadium("vasermil","city"));
        League l=new League("t1",null,null);
        l.addSeason(1990,new SchedulingPolicy(1),new ScoringPolicy());
        l.getSpecSeason(1990).addTeamToSeason(team1);
        l.getSpecSeason(1990).addTeamToSeason(team2);
        l.getSpecSeason(1990).addWin(team1,1,0);
        User2 user=new VisitorStub();
        LinkedList<Pair<String, Integer>> ret = user.showLeagueTable("t1", 1990);
        assertEquals("x",ret.getFirst().getKey());
        assertEquals(new Integer(3),ret.getFirst().getValue());
        assertNull(user.showLeagueTable("t1", 1991));
        assertNull(user.showLeagueTable("t2", 1991));
    }

    @Test
    public void showLeagueMainReferees() {
        League league1 = new League("AL",new SchedulingPolicy(2),new ScoringPolicy(3,1,0));
        league1.addMainReferee(new MainReferee(new Member("Hakmon","","","Hakmon")));
        league1.addMainReferee(new MainReferee(new Member("molina","","","molina")));
        league1.addMainReferee(new MainReferee(new Member("liani","","","liani")));
        User2 user = new VisitorStub();

        List<String> info = user.showLeagueMainReferees("AL");
        assertEquals(league1.getLeagueReferees().get(0).getMemberFullName(),info.get(0));
        assertEquals(league1.getLeagueReferees().get(1).getMemberFullName(),info.get(1));
        assertEquals(league1.getLeagueReferees().get(2).getMemberFullName(),info.get(2));


    }

    @Test
    public void showLeagueVarReferees() {

        League league1 = new League("AL",new SchedulingPolicy(2),new ScoringPolicy(3,1,0));
        league1.addVarReferee(new VarReferee(new Member("Hakmon","","","Hakmon")));
        league1.addVarReferee(new VarReferee(new Member("molina","","","molina")));
        league1.addVarReferee(new VarReferee(new Member("liani","","","liani")));
        User2 user = new VisitorStub();

        List<String> info = user.showLeagueVarReferees("AL");
        assertEquals(league1.getLeagueVarReferees().get(0).getMemberFullName(),info.get(0));
        assertEquals(league1.getLeagueVarReferees().get(1).getMemberFullName(),info.get(1));
        assertEquals(league1.getLeagueVarReferees().get(2).getMemberFullName(),info.get(2));
    }

    @Test
    public void showLeagueLinesManReferees() {
        League league1 = new League("AL",new SchedulingPolicy(2),new ScoringPolicy(3,1,0));
        league1.addLinesManReferee(new LinesManReferee(new Member("Hakmon","","","Hakmon")));
        league1.addLinesManReferee(new LinesManReferee(new Member("molina","","","molina")));
        league1.addLinesManReferee(new LinesManReferee(new Member("liani","","","liani")));
        User2 user = new VisitorStub();

        List<String> info = user.showLeagueLinesManReferees("AL");
        assertEquals(league1.getLeagueLinesmans().get(0).getMemberFullName(),info.get(0));
        assertEquals(league1.getLeagueLinesmans().get(1).getMemberFullName(),info.get(1));
        assertEquals(league1.getLeagueLinesmans().get(2).getMemberFullName(),info.get(2));

    }

    @Test
    public void showTeamPlayers() {
        User2 user = new VisitorStub();
        Player player1=new Player(new Member("ogu",null,null,"john ogu"), Player.Position.CDM, LocalDate.of(1990,11,11));
        Player player2=new Player(new Member("sahar",null,null,"ben sahar"), Player.Position.CDM, LocalDate.of(1990,11,11));
        Team team=new Team("Hbs",new TeamOwner(new Member("x",null,null,null)),null);
        team.addNewPlayer("john ogu");
        team.addNewPlayer("ben sahar");
        assertNull(user.showTeamPlayers("macabi"));
        List<String> players = user.showTeamPlayers("Hbs");
        assertEquals("john ogu",players.get(0));
        assertEquals("ben sahar",players.get(1));
        assertEquals(2,players.size());
    }

    @Test
    public void showTeamCoaches() {
        User2 user = new VisitorStub();
        Coach coach1=new Coach(new Member("bachar",null,null,"barak bachar"), Coach.Certification.MainCoach);
        Coach coach2=new Coach(new Member("shimshon",null,null,"dror shimshon"), Coach.Certification.MainCoach);
        Team team=new Team("Hbs",new TeamOwner(new Member("x",null,null,null)),null);
        team.addNewCoach("bachar","main manager");
        team.addNewCoach("shimshon","fitness coach");
        assertNull(user.showTeamPlayers("macabi"));
        List<String> coaches = user.showTeamCoaches("Hbs");
        assertEquals("barak bachar",coaches.get(0));
        assertEquals("dror shimshon",coaches.get(1));
        assertEquals(2,coaches.size());
    }

    @Test
    public void showTeamManagers() {

    }

    @Test
    public void showTeamOwners() {
        User2 user=new VisitorStub();
        TeamOwner owner1=new TeamOwner(new Member("alona",null,null,"alona barkat"));
        MemberStub owner2=new MemberStub("eli",null,null,"eli barkat");
        Team team=new Team("hbs",owner1,null);
        owner1.addOwner("eli");
        List<String> ret = user.showTeamOwners("hbs");
        assertEquals(2,ret.size());
        assertEquals("alona barkat",ret.get(0));
        assertEquals("eli barkat",ret.get(1));
        assertNull(user.showTeamOwners("macabi"));

    }

    @Test
    public void showTeamStadium() {
        User2 user=new VisitorStub();
        TeamOwner owner1=new TeamOwner(new Member("alona",null,null,"alona barkat"));
        Stadium stadium=new Stadium("terner","x");
        Team team=new Team("hbs",owner1,stadium);
        assertEquals("terner",user.showTeamStadium("hbs"));
        assertNull(user.showTeamStadium("x"));
    }

    @Test
    public void showPlayerTeam() {
        User2 user = new VisitorStub();
        Player player=new Player(new Member("ogu",null,null,"john ogu"), Player.Position.CDM, LocalDate.of(1990,11,11));
        Team team=new Team("Hbs",new TeamOwner(new Member("x",null,null,null)),null);
        player.addToTeam(team);
        assertNull(user.showPlayerTeam("tony"));
        assertEquals("Hbs",user.showPlayerTeam("john ogu"));
    }

    @Test
    public void showPlayerPosition() {
        User2 user = new VisitorStub();
        Player player=new Player(new Member("ogu",null,null,"john ogu"), Player.Position.CDM, LocalDate.of(1990,11,11));
        Team team=new Team("Hbs",new TeamOwner(new Member("x",null,null,null)),null);
        player.addToTeam(team);
        assertNull(user.showPlayerPosition("tony"));
        assertEquals("CDM",user.showPlayerPosition("john ogu"));
    }

    @Test
    public void showPlayerBirthDate() {
        User2 user = new VisitorStub();
        Player player=new Player(new Member("ogu",null,null,"john ogu"), Player.Position.CDM, LocalDate.of(1990,11,11));
        Team team=new Team("Hbs",new TeamOwner(new Member("x",null,null,null)),null);
        player.addToTeam(team);
        assertNull(user.showPlayerBirthDate("tony"));
        assertEquals("1990-11-11",user.showPlayerBirthDate("john ogu"));
    }

    public class MemberStub extends Member{
        public MemberStub(String user_name,String user_password,String user_id,String full_name){
            super(user_name,user_password, user_id, full_name);
            AlphaSystem alphaSystem=AlphaSystem.getSystem();
            alphaSystem.AddtoDB(2,this);
        }
    }
}