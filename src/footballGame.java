import java.util.Date;

public class footballGame {
    private season season;
    private eventLog events;
    private stadium stadium;
    private Team home;
    private Team away;
    private Date date;
    private mainReferee mainReferee;
    private linesManReferee linesManLeft;
    private linesManReferee linesManRight;
    private int homeGoals;
    private int awayGoals;

    public footballGame(season season, Team home, Team away, Date date) {
        this.season = season;
        this.home = home;
        this.away = away;
        this.stadium=home.getHomeStadium();
        this.date=date;
        this.events=new eventLog();
        this.homeGoals=0;
        this.awayGoals=0;
    }

    public void homeScoreGoal(){
        this.homeGoals++;
    }
    public void awayScoreGoal(){
        this.awayGoals++;
    }

    public void gameHasEnded(){
        if(homeGoals>awayGoals){
            season.addWin(home,homeGoals,awayGoals);
            season.addLoss(away,awayGoals,homeGoals);
        }else  if (awayGoals>homeGoals){
            season.addWin(away,awayGoals,homeGoals);
            season.addLoss(home,homeGoals,awayGoals);
        }else {
            season.addDraw(home,homeGoals,awayGoals);
            season.addDraw(away,awayGoals,homeGoals);
        }
    }


    public stadium getStadium() {
        return stadium;
    }

    public void setStadium(stadium stadium) {
        this.stadium = stadium;
    }

    public mainReferee getMainReferee() {
        return mainReferee;
    }

    public void setMainReferee(mainReferee mainReferee) {
        this.mainReferee = mainReferee;
    }

    public linesManReferee getLinesManLeft() {
        return linesManLeft;
    }

    public void setLinesManLeft(linesManReferee linesManLeft) {
        this.linesManLeft = linesManLeft;
    }

    public linesManReferee getLinesManRight() {
        return linesManRight;
    }

    public void setLinesManRight(linesManReferee linesManRight) {
        this.linesManRight = linesManRight;
    }
}
