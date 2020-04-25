import java.util.LinkedList;
import java.util.List;

public class Search {

    public List<Object> searchByName(String name,boolean leagueBool,boolean coachBool,boolean teamBool,boolean manBool,boolean ownerBool,boolean playerBool,boolean refBool,boolean stadBool){
        AlphaSystem system=AlphaSystem.getSystem();
        LinkedList<Object> found=new LinkedList<>();
        League league=(League) system.GetSpecificFromDB(1,name);
        if(league!=null&&leagueBool)
            found.add(league);
        Coach coach=(Coach) system.GetSpecificFromDB(3,name);
        if(coach!=null&&coachBool)
            found.add(coach);
        Team team=(Team) system.GetSpecificFromDB(4,name);
        if(team!=null&&teamBool)
            found.add(team);
        TeamManager manager=(TeamManager)system.GetSpecificFromDB(5,name);
        if(manager!=null&&manBool)
            found.add(manager);
        TeamOwner owner=(TeamOwner)system.GetSpecificFromDB(6,name);
        if(owner!=null&&ownerBool)
            found.add(owner);
        Player player=(Player) system.GetSpecificFromDB(7,name);
        if(player!=null&&playerBool)
            found.add(player);
        Referee referee=(Referee)system.GetSpecificFromDB(9,name);
        if(referee!=null&&refBool)
            found.add(referee);
        Stadium stadium=(Stadium)system.GetSpecificFromDB(11,name);
        if(stadium!=null&&stadBool)
            found.add(stadium);
        return found;
    }
    public List<Object> searchByCategory(int choice){
        AlphaSystem system=AlphaSystem.getSystem();
        List<Object> ret= (List<Object>) system.GetAllFromDB(choice);
        return ret;
    }
}

