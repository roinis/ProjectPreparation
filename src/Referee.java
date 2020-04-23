import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Referee extends Job{
    List<FootballGame> GamesToRef;
    List<Season> ActiveSeasons;
    boolean ActiveStatus;
    Member member;
    boolean Var;
    boolean Line;
    boolean Main;



    public Referee(Member member) {
        super(member);
        this.member = member;
        GamesToRef = new ArrayList<FootballGame>();
        ActiveSeasons = new ArrayList<Season>();
        ActiveStatus = true;
        AlphaSystem system = AlphaSystem.getSystem();
        system.AddtoDB(9, this);
        Var = false;
        Line = false;
        Main = false;
    }

    @Override
    public void editDetails() {
        String input;
        Scanner scanner=new Scanner(System.in);
        System.out.println("select a detail to edit");
        System.out.println("1.full name\n"+"2.training\n"+"3.date of birth");
        input=scanner.nextLine();
        switch (input){
            case "1":
                System.out.println("please choose a new name");
                input=scanner.nextLine();
                getMember().setFull_name(input);
                break;
            case "2":
                SetTraining();
                break;
            default:
                System.out.println("invalid action");
                break;
        }
        scanner.close();
    }

    private void SetTraining(){
        String input;
        Scanner scanner=new Scanner(System.in);
        boolean StillEditing = true;
        while(StillEditing) {
            System.out.println("You are currently listed as:");
            if (Main)
                System.out.print("Main ");
            if (Var)
                System.out.print("Var ");
            if (Line)
                System.out.println("Line");
            System.out.println("To add or remove one of the them, type the appropriate button, press 4 to quit:");
            System.out.println("1.Main\n" + "2.Var\n" + "3.Line\n" +"4.Done");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    if(Main)
                        Main = false;
                    else
                        Main = true;
                    break;
                case "2":
                    if(Var)
                        Var = false;
                    else
                        Var = true;
                    break;
                case "3":
                    if(Line)
                        Line = false;
                    else
                        Line = true;
                    break;
                case "4":
                    StillEditing = false;
                    break;
                default:
                    System.out.println("invalid action");
                    break;
            }
            scanner.close();
        }

    }

    public boolean CanMainRef(){
        return Main;
    }

    public boolean CanVarRef(){
        return Var;
    }

    public boolean CanLineRef(){
        return Line;
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
