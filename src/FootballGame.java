import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class FootballGame implements Subject {
    private Season season;
    private EventLog events;
    private Stadium stadium;
    private Team home;
    private Team away;
    private LocalDateTime date;
    private MainReferee mainReferee;
    private LinesManReferee linesManLeft;
    private LinesManReferee linesManRight;
    private int homeGoals;
    private int awayGoals;
    private List<Observer> fanObservers;
    public FootballGame(Season season, Team home, Team away, LocalDateTime date) {
        this.season = season;
        this.home = home;
        this.away = away;
        this.stadium=home.getHomeStadium();
        this.date=date;
        this.events=new EventLog();
        this.homeGoals=0;
        this.awayGoals=0;
        this.fanObservers=new LinkedList<>();
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

    public void addFoulEvent(Time time,Team team,Player player,Player fouledPlayer){
        FoulEvent foul=new FoulEvent(time,team,player,fouledPlayer);
        notifyObserver(foul);
    }

    public void addGoalEvent(Time time,Team team,Player player){
        GoalEvent goal=new GoalEvent(time,team,player);
        notifyObserver(goal);
    }

    public void addInjuryEvent(Time time,Team team,Player player){
        InjuryEvent injury=new InjuryEvent(time,team,player);
        notifyObserver(injury);
    }

    public void addOffsideEvent(Time time,Team team,Player player){
        OffsideEvent offside=new OffsideEvent(time,team,player);
        notifyObserver(offside);
    }

    public void addRedCardEvent(Time time,Team team,Player player){
        RedCardEvent redCard=new RedCardEvent(time,team,player);
        notifyObserver(redCard);
    }

    public void addYellowCardEvent(Time time,Team team,Player player){
        YellowCardEvent yellowCard=new YellowCardEvent(time,team,player);
        notifyObserver(yellowCard);
    }

    //need to fix adter pulling from roinis
    public void addStartEvent(Time time){
        StartGameEvent start=new StartGameEvent(time,home,away);
        notifyObserver(null);
    }

    public void addSubtitutionEvent(Time time,String description,Team team,Player in,Player out){
        SubstitutionEvent substitute=new SubstitutionEvent(time,description,team,in,out);
        notifyObserver(substitute);
    }

    public void addGameDelayedEvent(LocalDateTime newDate){
        GameDelayedEvent delayed=new GameDelayedEvent(date,newDate,home,away);
        notifyObserver(delayed);
    }

    public void addRelocationGameEvent(Stadium newLocation){
        GameReLocationEvent relocation=new GameReLocationEvent(stadium,newLocation,home,away);
        notifyObserver(relocation);
    }






    @Override
    public void register(Observer observer) {
        fanObservers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        fanObservers.remove(observer);
    }

    @Override
    public void notifyObserver(Event newEvent) {
        for (Observer observer:fanObservers) {
            observer.update(newEvent);
        }
    }
}
