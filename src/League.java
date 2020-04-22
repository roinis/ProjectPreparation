import javafx.util.Pair;

import java.util.LinkedList;

public class League {
    private String name;
    private LinkedList<Season> seasons;
    private SchedulingPolicy schedulingPolicy;
    private ScoringPolicy scoringPolicy;

    public League(String name,SchedulingPolicy schedulingPolicy,ScoringPolicy scoringPolicy) {
        this.name = name;
        this.seasons=new LinkedList<>();
        this.schedulingPolicy=schedulingPolicy;
        this.scoringPolicy=scoringPolicy;
    }

    public String getName(){ return name;}

    public boolean addSeason(int year, SchedulingPolicy schedulingPolicy, ScoringPolicy scoringPolicy){
        if(schedulingPolicy==null)
            schedulingPolicy=this.schedulingPolicy;
        if(scoringPolicy==null)
            scoringPolicy=this.scoringPolicy;
        Season newSeason =new Season(year, schedulingPolicy,scoringPolicy);
        for (Season season:seasons) {
            if(season.getYear()==year)
                return false;
        }
        seasons.add(newSeason);
        return true;
    }

    private Season getSpecSeason(int year){
        for (Season season:seasons) {
            if(season.getYear()==year)
                return season;
        }
        return null;
    }

    public LinkedList<Pair<LeaguePosition, Integer>> getSeasonRankings(int year){
        Season season=getSpecSeason(year);
        if(season==null)
            return null;
        LinkedList<Pair<LeaguePosition, Integer>> sortdRankings = season.getRankings();
        return sortdRankings;
    }

    public SchedulingPolicy getSchedulingPolicy() {
        return schedulingPolicy;
    }

    public void setSchedulingPolicy(SchedulingPolicy schedulingPolicy) {
        this.schedulingPolicy = schedulingPolicy;
    }

    public ScoringPolicy getScoringPolicy() {
        return scoringPolicy;
    }

    public void setScoringPolicy(ScoringPolicy scoringPolicy) {
        this.scoringPolicy = scoringPolicy;
    }


}
