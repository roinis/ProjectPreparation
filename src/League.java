import javafx.util.Pair;

import java.util.LinkedList;

public class League {
    private String name;
    private LinkedList<Season> seasons;

    public League(String name) {
        this.name = name;
        this.seasons=new LinkedList<>();
    }

    public String getName(){ return name;}

    public boolean addSeason(int year, SchedulingPolicy schedulingPolicy, ScoringPolicy scoringPolicy){
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


}
