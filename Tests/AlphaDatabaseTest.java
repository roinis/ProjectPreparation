import java.util.List;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AlphaDatabaseTest {
//    List<League> Leagues;  //1
//    List<Member> Members; //2
//    List<Coach> Coaches; //3
//    List<Team> Teams;  //4
//    List<TeamManager> TeamManagers; //5
//    List<TeamOwner> TeamOwners; //6
//    List<Player> Players; //7
//    List<AssociationMember> AssociationMembers; //8
//    List<Referee> Referees; //9
//    List<Ticket> Tickets; //10
//    List<Stadium> Stadiums; //11
//    private EventLog Log;


    @Test
    public void GetSpecificTest(){
        Member TestMember = new Member("","","","");
        Member TestMember2 = new Member("","","","");
        Member TestMember3 = new Member("","","","");
        Member TestMember4 = new Member("","","","");
        Member TestMember5 = new Member("","","","");
        Member TestMember6 = new Member("","","","");
        TeamOwner Owner = new TeamOwner(TestMember);
        Coach TestCoach = new Coach(TestMember2, Coach.Certification.MainCoach);
        TestMember.addJob(Owner);
        League TestLeague = new League("TestLeague",null,null );
        Stadium TestStadium = new Stadium("TestName", "TestCity");
        Team NewTeam = new Team("TestTeam", Owner, TestStadium);
        TeamManager TestManager = new TeamManager(TestMember3,NewTeam,null);
        Player TestPlayer = new Player(TestMember4, Player.Position.ST,null);
        AssociationMember AssTest = new AssociationMember(TestMember5);
        Referee TestRef = new Referee(TestMember6);
        AlphaSystem system = AlphaSystem.getSystem();
        assertEquals(system.GetSpecificFromDB(4,"TestTeam"),NewTeam);
        assertEquals(system.GetSpecificFromDB(4,"TestTeam"),NewTeam);
        assertEquals(system.GetSpecificFromDB(4,"TestTeam"),NewTeam);
        assertEquals(system.GetSpecificFromDB(4,"TestTeam"),NewTeam);
        assertEquals(system.GetSpecificFromDB(4,"TestTeam"),NewTeam);
        assertEquals(system.GetSpecificFromDB(4,"TestTeam"),NewTeam);
        assertEquals(system.GetSpecificFromDB(4,"TestTeam"),NewTeam);
    }

    @Test
    public void LeagueDBTest(){
        League TestLeague = new League("TestLeague",null,null );
        AlphaDatabase TestDB = new AlphaDatabase();
        TestDB.AddtoDB(1,TestLeague);
        assertEquals(TestLeague,TestDB.Getspecific(1,"TestLeague"));
        assertEquals(((List)TestDB.GetAll(1)).size(),1);
        assertEquals(TestDB.CheckifExists(1,"TestLeague"),true);
    }


    @Test
    public void MemberDBTest(){
        Member TestMember = new Member("TestMember","","","");
        AlphaDatabase TestDB = new AlphaDatabase();
        TestDB.AddtoDB(2,TestMember);
        assertEquals(TestMember,TestDB.Getspecific(2,"TestMember"));
        assertEquals(1,((List)TestDB.GetAll(2)).size());
        assertEquals(true,TestDB.CheckifExists(2,"TestMember"));
    }

    @Test
    public void CoachDBTest(){
        Member TestMember = new Member("TestMember","","","");
        Coach TestCoach = new Coach(TestMember, Coach.Certification.MainCoach);
        AlphaDatabase TestDB = new AlphaDatabase();
        TestDB.AddtoDB(3,TestCoach);
        assertEquals(TestCoach,TestDB.Getspecific(3,"TestMember"));
        assertEquals(1,((List)TestDB.GetAll(3)).size());
        assertEquals(true,TestDB.CheckifExists(3,"TestMember"));
    }

    @Test
    public void TeamDBTest(){
        Member TestMember = new Member("TestMember","","","");
        Stadium testStadium = new Stadium("","");
        TeamOwner Owner = new TeamOwner(TestMember);
        Team testTeam = new Team("Test",Owner,testStadium);
        AlphaDatabase TestDB = new AlphaDatabase();
        TestDB.AddtoDB(4,testTeam);
        assertEquals(testTeam,TestDB.Getspecific(4,"Test"));
        assertEquals(1,((List)TestDB.GetAll(4)).size());
        assertEquals(true,TestDB.CheckifExists(4,"Test"));
    }

    @Test
    public void ManagerDBTest(){
        Member TestMember = new Member("TestMember","","","");
        Member TestMember2 = new Member("Test","","","");
        Stadium testStadium = new Stadium("","");
        TeamOwner Owner = new TeamOwner(TestMember);
        Team testTeam = new Team("TestTeam",Owner,testStadium);
        TeamManager TestManager = new TeamManager(TestMember2,testTeam,null);
        AlphaDatabase TestDB = new AlphaDatabase();
        TestDB.AddtoDB(5,TestManager);
        assertEquals(TestManager,TestDB.Getspecific(5,"Test"));
        assertEquals(1,((List)TestDB.GetAll(5)).size());
        assertEquals(true,TestDB.CheckifExists(5,"Test"));
    }

    @Test
    public void OwnerDBTest(){
        Member TestMember = new Member("TestMember","","","");
        Stadium testStadium = new Stadium("","");
        TeamOwner Owner = new TeamOwner(TestMember);
        Team testTeam = new Team("TestTeam",Owner,testStadium);
        AlphaDatabase TestDB = new AlphaDatabase();
        TestDB.AddtoDB(6,Owner);
        assertEquals(Owner,TestDB.Getspecific(6,"TestMember"));
        assertEquals(1,((List)TestDB.GetAll(6)).size());
        assertEquals(true,TestDB.CheckifExists(6,"TestMember"));
    }

    @Test
    public void PlayerDBTest(){
        Member TestMember = new Member("TestMember","","","");
        Player testPlayer = new Player(TestMember,null,null);
        AlphaDatabase TestDB = new AlphaDatabase();
        TestDB.AddtoDB(7,testPlayer);
        assertEquals(testPlayer,TestDB.Getspecific(7,"TestMember"));
        assertEquals(1,((List)TestDB.GetAll(7)).size());
        assertEquals(true,TestDB.CheckifExists(7,"TestMember"));
    }

    @Test
    public void AssDBTest(){
        Member TestMember = new Member("TestMember","","","");
        AssociationMember AssTest = new AssociationMember(TestMember);
        AlphaDatabase TestDB = new AlphaDatabase();
        TestDB.AddtoDB(8,AssTest);
        assertEquals(AssTest,TestDB.Getspecific(8,"TestMember"));
        assertEquals(1,((List)TestDB.GetAll(8)).size());
        assertEquals(true,TestDB.CheckifExists(8,"TestMember"));
    }

    @Test
    public void RefDBTest(){
        Member TestMember = new Member("TestMember","","","");
        Referee Reftest = new Referee(TestMember);
        AlphaDatabase TestDB = new AlphaDatabase();
        TestDB.AddtoDB(9,Reftest);
        assertEquals(Reftest,TestDB.Getspecific(9,"TestMember"));
        assertEquals(1,((List)TestDB.GetAll(9)).size());
        assertEquals(true,TestDB.CheckifExists(9,"TestMember"));
    }

    @Test
    public void TicketDBTest(){
        Member TestMember = new Member("TestMember","","","");
        Ticket TestTicket = new Ticket(TestMember,"");
        AlphaDatabase TestDB = new AlphaDatabase();
        TestDB.AddtoDB(10,TestTicket);
        assertEquals(TestTicket,TestDB.Getspecific(10,TestTicket.getTicketID()));
        assertEquals(1,((List)TestDB.GetAll(10)).size());
        assertEquals(true,TestDB.CheckifExists(10,TestTicket.getTicketID()));
        assertEquals(TestTicket,TestDB.GetNextUnansweredTicket());
    }

    @Test
    public void StadiumDBTest(){
        Stadium TestStadium = new Stadium("Test","");
        AlphaDatabase TestDB = new AlphaDatabase();
        TestDB.AddtoDB(11,TestStadium);
        assertEquals(TestStadium,TestDB.Getspecific(11,"Test"));
        assertEquals(1,((List)TestDB.GetAll(11)).size());
        assertEquals(true,TestDB.CheckifExists(11,"Test"));
    }

}
