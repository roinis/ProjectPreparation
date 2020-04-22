import java.util.LinkedList;
import java.util.List;

public class Search {
    private AlphaDatabase database;
    public Search(AlphaDatabase database) {
        this.database = database;
    }

    public List<Object> searchByName(String name,boolean leagueBool,boolean coachBool,boolean teamBool,boolean manBool,boolean ownerBool,boolean playerBool,boolean refBool,boolean stadBool){
        LinkedList<Object> found=new LinkedList<>();
        League league=(League) database.Getspecific(1,name);
        if(league!=null&&leagueBool)
            found.add(league);
        Coach coach=(Coach) database.Getspecific(3,name);
        if(coach!=null&&coachBool)
            found.add(coach);
        Team team=(Team) database.Getspecific(4,name);
        if(team!=null&&teamBool)
            found.add(team);
        TeamManager manager=(TeamManager)database.Getspecific(5,name);
        if(manager!=null&&manBool)
            found.add(manager);
        TeamOwner owner=(TeamOwner)database.Getspecific(6,name);
        if(owner!=null&&ownerBool)
            found.add(owner);
        Player player=(Player) database.Getspecific(7,name);
        if(player!=null&&playerBool)
            found.add(player);
        Referee referee=(Referee)database.Getspecific(9,name);
        if(referee!=null&&refBool)
            found.add(referee);
        Stadium stadium=(Stadium)database.Getspecific(11,name);
        if(stadium!=null&&stadBool)
            found.add(stadium);
        return found;
    }
    public List<Object> searchByCategory(int choice){
        database.GetAll(choice);
        return (List<Object>) database.GetAll(choice);
    }
}

