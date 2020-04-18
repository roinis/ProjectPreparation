import javafx.util.Pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

public class season {
    private leagueTable table;
    private LinkedList<footballGame> games;
    private int year;
    private schedulingPolicy schedulingPolicy;
    private scoringPolicy scoringPolicy;

    public season(int year, schedulingPolicy schedulingPolicy, scoringPolicy scoringPolicy) {
        this.year = year;
        this.schedulingPolicy = schedulingPolicy;
        this.scoringPolicy = scoringPolicy;
        this.table=new leagueTable();
        this.games=new LinkedList<>();
    }

    public boolean addTeamToSeason(team team){
        if(table.addTeam(team))
            return true;
        return false;
    }

    public int getYear() {
        return year;
    }

    //need to fix
    public LinkedList<Pair<leaguePosition, Integer>> getRankings() { //need to break the tie!!!!!!!!!!!!!!!!!!
        LinkedList<Pair<leaguePosition, Integer>> rankings = table.getTeamsPoints(scoringPolicy.getPointsPerWin(), scoringPolicy.getPointPerLoss(), scoringPolicy.getPointsPerDraw());
        Collections.sort(rankings, new Comparator<Pair<leaguePosition, Integer>>() { @Override public int compare(Pair<leaguePosition, Integer> s1, Pair<leaguePosition, Integer> s2)
        { return s1.getValue() - s2.getValue(); } } );
        Collections.reverse(rankings);
        return rankings;
    }

    public void addWin(team team,int goalsScored,int goalsReceived){
        table.addWin(team,goalsScored,goalsReceived);
    }
    public void addLoss(team team,int goalsScored,int goalsReceived){
        table.addLoss(team,goalsScored,goalsReceived);
    }
    public void addDraw(team team,int goalsScored,int goalsReceived){
        table.addDraw(team,goalsScored,goalsReceived);
    }

    public void scheduleGames(){
        LinkedList<team> teams = table.getAllTeams();
        for (int i=0;i<schedulingPolicy.getNumOf2TeamsGames();i++){
            LinkedList<team> usedTeames=new LinkedList<>();
            while (teams.size()>0){
                team home=teams.removeFirst();
                for (team away:teams) {
                    footballGame newGame=new footballGame(this,home,away,new Date(/*need to fix :add correct date*/));
                    games.add(newGame);
                }
                usedTeames.addFirst(home);
            }
            teams=usedTeames;
        }
    }
}