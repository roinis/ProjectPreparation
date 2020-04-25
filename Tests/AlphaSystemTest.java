import org.junit.Test;
import static org.junit.Assert.*;

public class AlphaSystemTest {

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


}