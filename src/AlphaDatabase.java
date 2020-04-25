import java.util.ArrayList;
import java.util.List;

public class AlphaDatabase {
    List<League> Leagues;  //1
    List<Member> Members; //2
    List<Coach> Coaches; //3
    List<Team> Teams;  //4
    List<TeamManager> TeamManagers; //5
    List<TeamOwner> TeamOwners; //6
    List<Player> Players; //7
    List<AssociationMember> AssociationMembers; //8
    List<Referee> Referees; //9
    List<Ticket> Tickets; //10
    List<Stadium> Stadiums; //11
    private EventLog Log;


    public AlphaDatabase(){
        Leagues = new ArrayList<League>();
        Members = new ArrayList<Member>();
        Coaches = new ArrayList<Coach>();
        Teams = new ArrayList<Team>();
        TeamManagers = new ArrayList<TeamManager>();
        TeamOwners = new ArrayList<TeamOwner>();
        Players = new ArrayList<Player>();
        AssociationMembers = new ArrayList<AssociationMember>();
        Referees = new ArrayList<Referee>();
        Tickets = new ArrayList<Ticket>();
        Stadiums =  new ArrayList<Stadium>();
        Log = EventLog.getEventLog();
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
                    if (Members.get(i).getUser_name().equals(Name))
                        return Members.get(i);
                }
                return null;
            case 3:
                for (int i = 0; i < Coaches.size(); i++) {
                    if (Coaches.get(i).getMemberUserName().equals(Name))
                        return Coaches.get(i);
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
                    if(TeamManagers.get(i).getMemberFullName().equals(Name))
                        return TeamManagers.get(i);
                }
                return null;
            case 6:
                for (int i = 0; i < TeamOwners.size(); i++) {
                    if(TeamOwners.get(i).getMemberFullName().equals(Name))
                        return TeamOwners.get(i);
                }
                return null;
            case 7:
                for (int i = 0; i < Players.size(); i++) {
                    if(Players.get(i).getMemberFullName().equals(Name))
                        return Players.get(i);
                }
                return null;
            case 8:
                for (int i = 0; i < AssociationMembers.size(); i++) {
                    if(AssociationMembers.get(i).getFull_name().equals(Name))
                        return AssociationMembers.get(i);
                }
                return null;
            case 9:
                for (int i = 0; i < Referees.size(); i++) {
                    if(Referees.get(i).getMemberUserName().equals(Name))
                        return Referees.get(i);
                }
                return null;
            case 10:
                for (int i = 0; i < Tickets.size(); i++) {
                    if(Tickets.get(i).getTicketID().equals(Name))
                        return Tickets.get(i);
                }
                return null;
            case 11:
                for (int i = 0; i < Stadiums.size(); i++) {
                    if(Stadiums.get(i).getStadiumName().equals(Name))
                        return Stadiums.get(i);
                }
                return null;
        }
        return null;
    }

    public EventLog GetLog(){
        return Log;
    }

    public Object RemoveMember(Member member) {
        for (int i = 0; i < Members.size(); i++) {
            if (Members.get(i).getUser_name().equals(member.getUser_name()))
                return Members.remove(member);
        }
        return null;
    }

    public Ticket GetNextUnansweredTicket() {
        for (int i = 0; i < Tickets.size(); i++) {
            if(!Tickets.get(i).getIfAnswered())
                return Tickets.get(i);
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
                    if (Members.get(i).getUser_name().equals(Name))
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
                    if (TeamManagers.get(i).getMemberFullName().equals(Name))
                        return true;
                }
                return false;
            case 6:
                for (int i = 0; i < TeamOwners.size(); i++) {
                    if (TeamOwners.get(i).getMemberFullName().equals(Name))
                        return true;
                }
                return false;
            case 7:
                for (int i = 0; i < Players.size(); i++) {
                    if (Players.get(i).getMemberFullName().equals(Name))
                        return true;
                }
                return false;
            case 8:
                for (int i = 0; i < AssociationMembers.size(); i++) {
                    if (AssociationMembers.get(i).getFull_name().equals(Name))
                        return true;
                }
                return false;
            case 9:
                for (int i = 0; i < Referees.size(); i++) {
                    if (Referees.get(i).getMemberUserName().equals(Name))
                        return true;
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
            case 7:
                return Players;
            case 8:
                return AssociationMembers;
            case 9:
                return Referees;
            case 10:
                return Tickets;
            case 11:
                return Stadiums;
        }
        return null;
    }

    public void AddtoDB(int Type, Object ToAdd) {
        switch (Type) {
            case 1:
               if(ToAdd instanceof League)
                   Leagues.add((League)ToAdd);
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
            case 7:
                if(ToAdd instanceof Player)
                    Players.add((Player)ToAdd);
                break;
            case 8:
                if(ToAdd instanceof AssociationMember)
                    AssociationMembers.add((AssociationMember)ToAdd);
                break;
            case 9:
                if(ToAdd instanceof Referee)
                    Referees.add((Referee)ToAdd);
                break;
            case 10:
                if(ToAdd instanceof Ticket)
                    Tickets.add((Ticket)ToAdd);
                break;
            case 11:
                if(ToAdd instanceof Stadium)
                    Stadiums.add((Stadium)ToAdd);
                break;

        }
    }


}
