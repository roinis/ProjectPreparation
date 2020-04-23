import java.security.Policy;

public class AssociationMember extends Member {

    public AssociationMember(Member member) {
        super(member);
    }

    public void NewLeague(String LeagueName){
        //should be in League
        AlphaSystem system = AlphaSystem.getSystem();
        system.AddtoDB(1,new League(LeagueName,new SchedulingPolicy(),new ScoringPolicy()));
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

    public void AddRefToLeague(Referee RefToAdd, League league){
         league.AddRef(RefToAdd);
    }

    public void ChangeScoringPolicyForLeague(String LeagueToChange, int pPerWin,int pPerLoss,int pPerDraw){
        AlphaSystem system = AlphaSystem.getSystem();
        League CurrLeague = (League)system.GetSpecificFromDB(1,LeagueToChange);
        CurrLeague.setScoringPolicy(pPerWin,pPerLoss,pPerDraw);
    }

    public void ChangeSchedulingPolicyForLeague(String LeagueToChange, int numOfMatches){
        AlphaSystem system = AlphaSystem.getSystem();
        League CurrLeague = (League)system.GetSpecificFromDB(1,LeagueToChange);
        CurrLeague.setSchedulingPolicy(numOfMatches);
    }

    public void ChangeScoringPolicyForSeason(String LeagueToChange,int year, int pPerWin,int pPerLoss,int pPerDraw){
        AlphaSystem system = AlphaSystem.getSystem();
        League CurrLeague = (League)system.GetSpecificFromDB(1,LeagueToChange);
        CurrLeague.setSeasonScoringPolicy(year,pPerWin,pPerLoss,pPerDraw);
    }

    public void ChangeSchedulingPolicyForSeason(String LeagueToChange,int year, int numOfMatches){
        AlphaSystem system = AlphaSystem.getSystem();
        League CurrLeague = (League)system.GetSpecificFromDB(1,LeagueToChange);
        CurrLeague.setSeasonSchedulingPolicy(year,numOfMatches);
    }





}
