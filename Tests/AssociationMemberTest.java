import org.junit.Test;
import static org.junit.Assert.*;

public class AssociationMemberTest {

    @Test
    public void addLeagueTest(){
        AssociationMember associationMember=new AssociationMember(new Member("x",null,null,null));
        associationMember.NewLeague("y");
        associationMember.NewLeague("z");
        AlphaSystem system = AlphaSystem.getSystem();
        League l1=(League) system.GetSpecificFromDB(1,"y");
        League l2=(League) system.GetSpecificFromDB(1,"z");
        assertEquals("y",l1.getName());
        assertEquals("z",l2.getName());
    }

    @Test
    public void addSeasonToLeagueTest(){
        AssociationMember associationMember=new AssociationMember(new Member("x",null,null,null));
        associationMember.NewLeague("y");
        AlphaSystem system = AlphaSystem.getSystem();
        associationMember.AddSeasonToLeague("y",1990);
        associationMember.AddSeasonToLeague("y",1991);
        League l1=(League) system.GetSpecificFromDB(1,"y");
        Season s = l1.getSpecSeason(1990);
        assertEquals(1990,s.getYear());
        s = l1.getSpecSeason(1991);
        assertEquals(1991,s.getYear());
    }

    @Test
    public void AddRefToSeasonTest(){
        AlphaSystem system = AlphaSystem.getSystem();
        AssociationMember associationMember=new AssociationMember(new Member("x",null,null,null));
        associationMember.NewLeague("y");
        MainReferee mainRef=new MainReferee(new Member("mainRef",null,null,null));
        LinesManReferee lineRef=new LinesManReferee(new Member("lineRef",null,null,null));
        VarReferee varRef=new VarReferee(new Member("varRef",null,null,null));
        associationMember.AddRefToLeague(mainRef,(League) system.GetSpecificFromDB(1,"y"));
        associationMember.AddRefToLeague(lineRef,(League) system.GetSpecificFromDB(1,"y"));
        associationMember.AddRefToLeague(varRef,(League) system.GetSpecificFromDB(1,"y"));
        assertEquals("mainRef", ((League) system.GetSpecificFromDB(1,"y")).getLeagueReferees().get(0).getMember().getUser_name());
        assertEquals("lineRef", ((League) system.GetSpecificFromDB(1,"y")).getLeagueLinesmans().get(0).getMember().getUser_name());
        assertEquals("varRef", ((League) system.GetSpecificFromDB(1,"y")).getLeagueVarReferees().get(0).getMember().getUser_name());
    }

    @Test
    public void ChangeScoringPolicyForSeasonTest(){
        AlphaSystem system = AlphaSystem.getSystem();
        AssociationMember associationMember=new AssociationMember(new Member("x",null,null,null));
        associationMember.NewLeague("y");
        associationMember.AddSeasonToLeague("y",1990);
        associationMember.ChangeScoringPolicyForSeason("y",1990,5,6,7);
        League y=(League) system.GetSpecificFromDB(1,"y");
        ScoringPolicy sp = y.getSpecSeason(1990).getScoringPolicy();
        assertEquals(5,sp.getPointsPerWin());
        assertEquals(6,sp.getPointPerLoss());
        assertEquals(7,sp.getPointsPerDraw());
    }

    @Test
    public void ChangeSchedulePolicyForSeasonTest(){
        AlphaSystem system = AlphaSystem.getSystem();
        AssociationMember associationMember=new AssociationMember(new Member("x",null,null,null));
        associationMember.NewLeague("y");
        associationMember.AddSeasonToLeague("y",1990);
        associationMember.ChangeSchedulingPolicyForSeason("y",1990,5);
        League y=(League) system.GetSpecificFromDB(1,"y");
        SchedulingPolicy sp = y.getSpecSeason(1990).getSchedulingPolicy();
        assertEquals(5,sp.getNumOf2TeamsGames());
    }

    @Test
    public void ChangeScoringPolicyForLeagueTest(){
        AlphaSystem system = AlphaSystem.getSystem();
        AssociationMember associationMember=new AssociationMember(new Member("x",null,null,null));
        associationMember.NewLeague("y");
        associationMember.ChangeScoringPolicyForLeague("y",5,6,7);
        League y=(League) system.GetSpecificFromDB(1,"y");
        ScoringPolicy sp = y.getScoringPolicy();
        assertEquals(5,sp.getPointsPerWin());
        assertEquals(6,sp.getPointPerLoss());
        assertEquals(7,sp.getPointsPerDraw());
    }

    @Test
    public void ChangeSchedulePolicyForLeagueTest(){
        AlphaSystem system = AlphaSystem.getSystem();
        AssociationMember associationMember=new AssociationMember(new Member("x",null,null,null));
        associationMember.NewLeague("y");
        associationMember.AddSeasonToLeague("y",1990);
        associationMember.ChangeSchedulingPolicyForLeague("y",5);
        League y=(League) system.GetSpecificFromDB(1,"y");
        SchedulingPolicy sp = y.getSchedulingPolicy();
        assertEquals(5,sp.getNumOf2TeamsGames());
    }


}