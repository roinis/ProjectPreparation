import javafx.util.Pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

public class Season {
    private LeagueTable table;
    private LinkedList<FootballGame> games;
    private int year;
    private SchedulingPolicy schedulingPolicy;
    private ScoringPolicy scoringPolicy;

    public Season(int year, SchedulingPolicy schedulingPolicy, ScoringPolicy scoringPolicy) {
        this.year = year;
        this.schedulingPolicy = schedulingPolicy;
        this.scoringPolicy = scoringPolicy;
        this.table=new LeagueTable();
        this.games=new LinkedList<>();
    }

    public boolean addTeamToSeason(Team team){
        if(table.addTeam(team))
            return true;
        return false;
    }

    public int getYear() {
        return year;
    }

    //need to fix
    public LinkedList<Pair<LeaguePosition, Integer>> getRankings() { //need to break the tie!!!!!!!!!!!!!!!!!!
        LinkedList<Pair<LeaguePosition, Integer>> rankings = table.getTeamsPoints(scoringPolicy.getPointsPerWin(), scoringPolicy.getPointPerLoss(), scoringPolicy.getPointsPerDraw());
        Collections.sort(rankings, new Comparator<Pair<LeaguePosition, Integer>>() { @Override public int compare(Pair<LeaguePosition, Integer> s1, Pair<LeaguePosition, Integer> s2)
        { return s1.getValue() - s2.getValue(); } } );
        Collections.reverse(rankings);
        return rankings;
    }

    public void addWin(Team team, int goalsScored, int goalsReceived){
        table.addWin(team,goalsScored,goalsReceived);
    }
    public void addLoss(Team team, int goalsScored, int goalsReceived){
        table.addLoss(team,goalsScored,goalsReceived);
    }
    public void addDraw(Team team, int goalsScored, int goalsReceived){
        table.addDraw(team,goalsScored,goalsReceived);
    }

    public void scheduleGames(){
        LinkedList<Team> teams = table.getAllTeams();
        for (int i=0;i<schedulingPolicy.getNumOf2TeamsGames();i++){
            LinkedList<Team> usedTeames=new LinkedList<>();
            while (teams.size()>0){
                Team home=teams.removeFirst();
                for (Team away:teams) {
                    FootballGame newGame=new FootballGame(this,home,away,new Date(/*need to fix :add correct date*/));
                    games.add(newGame);
                }
                usedTeames.addFirst(home);
            }
            teams=usedTeames;
        }
    }
}