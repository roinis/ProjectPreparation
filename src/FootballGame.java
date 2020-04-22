import java.time.LocalDate;
import java.util.Date;

public class FootballGame {
    private Season season;
    private EventLog events;
    private Stadium stadium;
    private Team home;
    private Team away;
    private LocalDate date;
    private MainReferee mainReferee;
    private LinesManReferee linesManLeft;
    private LinesManReferee linesManRight;
    private int homeGoals;
    private int awayGoals;

    public FootballGame(Season season, Team home, Team away, LocalDate date) {
        this.season = season;
        this.home = home;
        this.away = away;
        this.stadium=home.getHomeStadium();
        this.date=date;
        this.events=new EventLog();
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

    public void addEvent(Event event){
        //need to ask roi nis
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public MainReferee getMainReferee() {
        return mainReferee;
    }

    public void setMainReferee(MainReferee mainReferee) {
        this.mainReferee = mainReferee;
    }

    public LinesManReferee getLinesManLeft() {
        return linesManLeft;
    }

    public void setLinesManLeft(LinesManReferee linesManLeft) {
        this.linesManLeft = linesManLeft;
    }

    public LinesManReferee getLinesManRight() {
        return linesManRight;
    }

    public void setLinesManRight(LinesManReferee linesManRight) {
        this.linesManRight = linesManRight;
    }
}
