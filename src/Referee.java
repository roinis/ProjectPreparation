import java.util.ArrayList;
import java.util.List;

public class Referee extends Job{
    List<FootballGame> GamesToRef;
    List<Season> ActiveSeasons;
    boolean ActiveStatus;


    public Referee(Member member) {
        super(member);
        GamesToRef = new ArrayList<FootballGame>();
        ActiveSeasons = new ArrayList<Season>();
        ActiveStatus = true;
        AlphaSystem system = AlphaSystem.getSystem();
        system.AddtoDB(9, this);
    }

    @Override
    public void editDetails() {

    }

    //כרגע לא ממומש
    private void ChangeInfo(){}


    public List<FootballGame> GetGames(){
        return GamesToRef;
    }

    public void DelistAsRef(){
        ActiveStatus = false;
        //Seasons.removeRef(this);
    }


    public void AddGameToRef(FootballGame ToRef){
        GamesToRef.add(ToRef);
    }

    public void AddSeasonToRef(Season SeasonToRef){
        ActiveSeasons.add(SeasonToRef);
    }

    //כרגע לא עובד
    private void AddEvent(FootballGame Game, GameEvent ChosenEvent){
        //Game.AddEvent();
    }

    private void EditEvents(FootballGame Game, GameEvent ChosenEvent){
        //if game ended in less than 5 hours
        //Game.RemoveEvent();
        //Game.AddEvent();
    }

}
