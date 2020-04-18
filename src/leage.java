import javafx.util.Pair;

import java.util.LinkedList;

public class leage {
    private String name;
    private LinkedList<season> seasons;

    public leage(String name) {
        this.name = name;
        this.seasons=new LinkedList<>();
    }

    public boolean addSeason(int year, schedulingPolicy schedulingPolicy, scoringPolicy scoringPolicy){
        season newSeason =new season(year, schedulingPolicy,scoringPolicy);
        for (season season:seasons) {
            if(season.getYear()==year)
                return false;
        }
        seasons.add(newSeason);
        return true;
    }

    private season getSpecSeason(int year){
        for (season season:seasons) {
            if(season.getYear()==year)
                return season;
        }
        return null;
    }

    public void getSeasonRankings(int year){
        LinkedList<Pair<leaguePosition, Integer>> sortdRankings = getSpecSeason(year).getRankings();

    }


}
