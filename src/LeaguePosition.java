public class LeaguePosition {
    private Team team;
    private int gamesWon;
    private int gamesLoss;
    private int gamesDraw;
    private int goalsScored;
    private int goalsReceive;

    public LeaguePosition(Team team, int gamesWon, int gamesLoss, int gamesDraw, int goalsScored, int goalsReceive) {
        this.team = team;
        this.gamesWon = gamesWon;
        this.gamesLoss = gamesLoss;
        this.gamesDraw = gamesDraw;
        this.goalsScored = goalsScored;
        this.goalsReceive = goalsReceive;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesLoss() {
        return gamesLoss;
    }

    public int getGamesDraw() {
        return gamesDraw;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsReceive() {
        return goalsReceive;
    }

    public void addWin() {
        gamesWon++;
    }

    public Team getTeam() {
        return team;
    }

    public void addLoss() {
        gamesLoss++;
    }

    public void addDraw() {
        gamesDraw++;
    }

    public int computePoints(int pointsPerWin, int pointPerLoss, int pointsPerDraw) {
        int points=gamesWon*pointsPerWin+gamesLoss*pointPerLoss+pointsPerDraw*gamesDraw;
        return points;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void setGoalsReceive(int goalsReceive) {
        this.goalsReceive = goalsReceive;
    }
}
