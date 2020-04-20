import java.util.ArrayList;
import java.util.List;

public class AlphaDatabase {
    List<leage> Leagues;  //1
    List<Member> Members; //2
    List<Coach> Coaches; //3
    List<Team> Teams;  //4
    List<TeamManager> TeamManagers; //5
    List<TeamOwner> TeamOwners; //6

    public AlphaDatabase(){
        Leagues = new ArrayList<leage>();
        Members = new ArrayList<Member>();
        Coaches = new ArrayList<Coach>();
        Teams = new ArrayList<Team>();
        TeamManagers = new ArrayList<TeamManager>();
        TeamOwners = new ArrayList<TeamOwner>();
    }

    public Object Getspecific(int Type, String Name) {
        switch (Type) {
            case 1:
                for (int i = 0; i < Leagues.size(); i++) {
                    if (Leagues.get(i).getName().equals(Name))
                        return Leagues.get(i);
                }
                return null;
            case 2:
                for (int i = 0; i < Members.size(); i++) {
                    if (Members.get(i).getFull_name().equals(Name))
                        return Members.get(i);
                }
                return null;
            case 3:
                for (int i = 0; i < Coaches.size(); i++) {

                }
                return null;
            case 4:
                for (int i = 0; i < Teams.size(); i++) {
                    if (Teams.get(i).getTeamName().equals(Name))
                        return Teams.get(i);
                }
                return null;
            case 5:
                for (int i = 0; i < TeamManagers.size(); i++) {
//                    if(TeamManagers.get(i).getName().equals(Name))
//                        return TeamManagers.get(i);
                }
                return null;
            case 6:
                for (int i = 0; i < TeamOwners.size(); i++) {
//                    if(TeamOwners.get(i).getName().equals(Name))
//                        return TeamOwners.get(i);
                }
                return null;
        }
        return null;
    }

    public boolean CheckifExists(int Type, String Name) {
        switch (Type) {
            case 1:
                for (int i = 0; i < Leagues.size(); i++) {
                    if (Leagues.get(i).getName().equals(Name))
                        return true;
                }
                return false;
            case 2:
                for (int i = 0; i < Members.size(); i++) {
                    if (Members.get(i).getFull_name().equals(Name))
                        return true;
                }
                return false;
            case 3:
                for (int i = 0; i < Coaches.size(); i++) {
                    return true;
                }
                return false;

            case 4:
                for (int i = 0; i < Teams.size(); i++) {
                    if (Teams.get(i).getTeamName().equals(Name))
                        return true;
                }
                return false;
            case 5:
                for (int i = 0; i < TeamManagers.size(); i++) {
//                    if(TeamManagers.get(i).getName().equals(Name))
//                        return TeamManagers.get(i);
                }
                return false;
            case 6:
                for (int i = 0; i < TeamOwners.size(); i++) {
//                    if(TeamOwners.get(i).getName().equals(Name))
//                        return TeamOwners.get(i);
                }
                return false;
        }
        return false;
    }

    public Object GetAll(int Type) {
        switch (Type) {
            case 1:
                return Leagues;
            case 2:
                return Members;
            case 3:
               return Coaches;
            case 4:
               return Teams;
            case 5:
                return TeamManagers;
            case 6:
              return TeamOwners;
        }
        return null;
    }

    public void AddtoDB(int Type, Object ToAdd) {
        switch (Type) {
            case 1:
               if(ToAdd instanceof leage)
                   Leagues.add((leage)ToAdd);
               break;
            case 2:
                if(ToAdd instanceof Member)
                    Members.add((Member)ToAdd);
                break;
            case 3:
                if(ToAdd instanceof Coach)
                    Coaches.add((Coach)ToAdd);
                break;
            case 4:
                if(ToAdd instanceof Team)
                    Teams.add((Team)ToAdd);
                break;
            case 5:
                if(ToAdd instanceof TeamManager)
                    TeamManagers.add((TeamManager)ToAdd);
                break;
            case 6:
                if(ToAdd instanceof TeamOwner)
                    TeamOwners.add((TeamOwner)ToAdd);
                break;
        }
    }


}
