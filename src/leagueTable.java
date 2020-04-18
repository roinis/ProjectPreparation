import javafx.util.Pair;

import java.util.LinkedList;

public class leagueTable {
    LinkedList<leaguePosition> leagueTable;

    public boolean addTeam(team team) {
        for (leaguePosition position:leagueTable) {
            if(position.getTeam().equals(team))
                return false;
        }
        leaguePosition newPosition=new leaguePosition(team,0,0,0,0,0);
        return true;
    }
    public void addWin(team team,int goalsScored,int goalsReceived){
        for (leaguePosition position:leagueTable) {
            if(team.equals(position.getTeam())){
                position.addWin();
                position.setGoalsScored(position.getGoalsScored()+goalsScored);
                position.setGoalsReceive(position.getGoalsReceive()+goalsReceived);
                break;
            }
        }
    }

    public void addLoss(team team,int goalsScored,int goalsReceived){
        for (leaguePosition position:leagueTable) {
            if(team.equals(position.getTeam())){
                position.addLoss();
                position.setGoalsScored(position.getGoalsScored()+goalsScored);
                position.setGoalsReceive(position.getGoalsReceive()+goalsReceived);
                break;
            }
        }
    }

    public void addDraw(team team,int goalsScored,int goalsReceived){
        for (leaguePosition position:leagueTable) {
            if(team.equals(position.getTeam())){
                position.addDraw();
                position.setGoalsScored(position.getGoalsScored()+goalsScored);
                position.setGoalsReceive(position.getGoalsReceive()+goalsReceived);
                break;
            }
        }
    }

    public LinkedList<Pair<leaguePosition,Integer>> getTeamsPoints(int pointsPerWin, int pointPerLoss, int pointsPerDraw) {
        LinkedList<Pair<leaguePosition,Integer>> rankings=new LinkedList<>();
        for (leaguePosition position:leagueTable) {
            int points=position.computePoints(pointsPerWin,pointPerLoss,pointsPerDraw);
            Pair<leaguePosition,Integer> newPair=new Pair<>(position,points);
            rankings.add(newPair);
        }
        return rankings;
    }

    public LinkedList<team> getAllTeams(){
        LinkedList<team> teams=new LinkedList<>();
        for (leaguePosition team:leagueTable) {
            teams.add(team.getTeam());
        }
        return teams;
    }
}
