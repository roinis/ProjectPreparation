import java.security.Policy;

public class AssociationMember extends Member {

    public AssociationMember(String user_name, String user_password, String user_id, String full_name) {
        super(user_name, user_password, user_id, full_name);
    }

    public void NewLeague(String LeagueName){
        //should be in League
        AlphaSystem system = AlphaSystem.getSystem();
        system.AddtoDB(1,new League(LeagueName,((League)system.GetSpecificFromDB(1,LeagueName)).getSchedulingPolicy(),((League)system.GetSpecificFromDB(1,LeagueName)).getScoringPolicy()));
    }

    // League needs Patching
    public void AddSeasonToLeague(String LeagueName, int year ){
        AlphaSystem system = AlphaSystem.getSystem();
        League CurrLeague = (League)system.GetSpecificFromDB(1,LeagueName);
        CurrLeague.addSeason(year, CurrLeague.getSchedulingPolicy(), CurrLeague.getScoringPolicy());
    }

    // to be continued
    public void AddNewRef(Member member){
        new Referee(member);
        //שליחת הזמנה?
    }

    // League needs Patching
    public void AddRefToSeason(Referee RefToAdd, League League){
        //League.AddRef(RefToAdd)
    }

    // League needs Patching
    public void ChangeScoringPolicyForLeague(League LeagueToChange, ScoringPolicy NewPolicy){
       //Leaguetochange.changeScoringpolicy(newpolicy)
    }

    // League needs Patching
    public void ChangeSchedulingPolicyForLeague(League LeagueToChange, SchedulingPolicy NewPolicy){
        //Leaguetochange.changeSchedulingpolicy(newpolicy)
    }





}
