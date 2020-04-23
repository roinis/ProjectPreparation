import java.security.Policy;

public class AssociationMember extends Member {

    public AssociationMember(Member member) {
        super(member);
    }

    public void NewLeague(String LeagueName){
        //should be in League
        AlphaSystem system = AlphaSystem.getSystem();
        system.AddtoDB(1,new League(LeagueName,((League)system.GetSpecificFromDB(1,LeagueName)).getSchedulingPolicy(),((League)system.GetSpecificFromDB(1,LeagueName)).getScoringPolicy()));
    }

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

    public void AddRefToSeason(Referee RefToAdd, League League){
        if (RefToAdd instanceof LinesManReferee)
            League.addLinesManReferee((LinesManReferee)RefToAdd);
        if (RefToAdd instanceof VarReferee)
            League.addVarReferee((VarReferee)RefToAdd);
        if (RefToAdd instanceof MainReferee)
            League.addMainReferee((MainReferee)RefToAdd);
    }

    public void RemoveRefFromLeague(Referee RefToAdd, League League){
        if (RefToAdd instanceof LinesManReferee)
            League.removeLinesManReferee((LinesManReferee)RefToAdd);
        if (RefToAdd instanceof VarReferee)
            League.removeVarReferee((VarReferee)RefToAdd);
        if (RefToAdd instanceof MainReferee)
            League.removeMainReferee((MainReferee)RefToAdd);
    }

    public void ChangeScoringPolicyForLeague(League LeagueToChange, ScoringPolicy NewPolicy){
        LeagueToChange.setScoringPolicy(NewPolicy);
    }

    public void ChangeSchedulingPolicyForLeague(League LeagueToChange, SchedulingPolicy NewPolicy){
        LeagueToChange.setSchedulingPolicy(NewPolicy);
    }





}
