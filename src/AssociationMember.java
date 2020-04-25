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

    public void AddNewTeam(String TeamName, Member teamOwner, Stadium HomeStadium ){
        TeamOwner Owner = new TeamOwner(teamOwner);
        teamOwner.addJob(Owner);
        Team NewTeam = new Team(TeamName, Owner, HomeStadium);
        AlphaSystem system = AlphaSystem.getSystem();
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

    public boolean ChangeScoringPolicyForSeason(String LeagueToChange,int year, int pPerWin,int pPerLoss,int pPerDraw){
        AlphaSystem system = AlphaSystem.getSystem();
        League CurrLeague = (League)system.GetSpecificFromDB(1,LeagueToChange);
        if(CurrLeague.setSeasonScoringPolicy(year,pPerWin,pPerLoss,pPerDraw))
            return true;
        return false;
    }

    public boolean ChangeSchedulingPolicyForSeason(String LeagueToChange,int year, int numOfMatches){
        AlphaSystem system = AlphaSystem.getSystem();
        League CurrLeague = (League)system.GetSpecificFromDB(1,LeagueToChange);
        if(CurrLeague.setSeasonSchedulingPolicy(year,numOfMatches))
            return true;
        return false;
    }

    public boolean AddTeamToSeasonInLeague(String LeagueName, int seasonYear,Team team ){
        AlphaSystem system = AlphaSystem.getSystem();
        League CurrLeague = (League)system.GetSpecificFromDB(1,LeagueName);
        if(CurrLeague.getSpecSeason(seasonYear).addTeamToSeason(team))
            return true;
        return false;
    }





}
