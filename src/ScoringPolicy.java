public class ScoringPolicy {
    int pointsPerWin;
    int pointsPerDraw;
    int pointPerLoss;
    //need to add way to choose what happen if both teams has the same points

    public ScoringPolicy(int pointsPerWin, int pointsPerDraw, int pointPerLoss) {
        this.pointsPerWin = pointsPerWin;
        this.pointsPerDraw = pointsPerDraw;
        this.pointPerLoss = pointPerLoss;
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
