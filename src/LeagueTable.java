import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class LeagueTable {
    LinkedList<LeaguePosition> leagueTable;

    public LeagueTable() {
        this.leagueTable=new LinkedList<>();
    }

    public boolean addTeam(Team team) {
        for (LeaguePosition position:leagueTable) {
            if(position.getTeam().equals(team))
                return false;
        }
        LeaguePosition newPosition=new LeaguePosition(team,0,0,0,0,0);
        leagueTable.add(newPosition);
        return true;
    }
    public void addWin(Team team, int goalsScored, int goalsReceived){
        for (LeaguePosition position:leagueTable) {
            if(team.equals(position.getTeam())){
                position.addWin();
                position.setGoalsScored(position.getGoalsScored()+goalsScored);
                position.setGoalsReceive(position.getGoalsReceive()+goalsReceived);
                break;
            }
        }
    }

    public void addLoss(Team team, int goalsScored, int goalsReceived){
        for (LeaguePosition position:leagueTable) {
            if(team.equals(position.getTeam())){
                position.addLoss();
                position.setGoalsScored(position.getGoalsScored()+goalsScored);
                position.setGoalsReceive(position.getGoalsReceive()+goalsReceived);
                break;
            }
        }
    }

    public void addDraw(Team team, int goalsScored, int goalsReceived){
        for (LeaguePosition position:leagueTable) {
            if(team.equals(position.getTeam())){
                position.addDraw();
                position.setGoalsScored(position.getGoalsScored()+goalsScored);
                position.setGoalsReceive(position.getGoalsReceive()+goalsReceived);
                break;
            }
        }
    }

    public List<LeaguePosition> getPositions(){
        return this.leagueTable;
    }

    public LinkedList<Pair<LeaguePosition,Integer>> getTeamsPoints(int pointsPerWin, int pointPerLoss, int pointsPerDraw) {
        LinkedList<Pair<LeaguePosition,Integer>> rankings=new LinkedList<>();
        for (LeaguePosition position:leagueTable) {
            int points=position.computePoints(pointsPerWin,pointPerLoss,pointsPerDraw);
            Pair<LeaguePosition,Integer> newPair=new Pair<>(position,points);
            rankings.add(newPair);
        }
        return rankings;
    }

    public LinkedList<Team> getAllTeams(){
        LinkedList<Team> teams=new LinkedList<>();
        for (LeaguePosition team:leagueTable) {
            teams.add(team.getTeam());
        }
        return teams;
    }
}
