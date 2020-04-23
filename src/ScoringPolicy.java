public class ScoringPolicy {
    private int pointsPerWin;
    private int pointsPerDraw;
    private int pointPerLoss;
    //need to add way to choose what happen if both teams has the same points

    public ScoringPolicy(int pointsPerWin, int pointsPerDraw, int pointPerLoss) {
        this.pointsPerWin = pointsPerWin;
        this.pointsPerDraw = pointsPerDraw;
        this.pointPerLoss = pointPerLoss;
    }

    public ScoringPolicy() {
        this.pointsPerWin = 3;
        this.pointsPerDraw = 1;
        this.pointPerLoss = 0;
    }

    public int getPointsPerWin() {
        return pointsPerWin;
    }

    public int getPointsPerDraw() {
        return pointsPerDraw;
    }

    public int getPointPerLoss() {
        return pointPerLoss;
    }
}
