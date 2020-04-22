//roei cohen

import javafx.util.Pair;

import java.util.*;

public abstract class User {

    private UsersInformation usersInformation;


    public User(){
        usersInformation=new UsersInformation();
    }

    private void printInfoMenu(){
        System.out.println("Watch General Information");
        System.out.println("Please chose the number of one of the following information topics you would like to see:");
        System.out.println("1.Teams");
        System.out.println("2.Players");
        System.out.println("3.Coaches");
        System.out.println("4.Team Managers");
        System.out.println("5.Leagues");
        System.out.println("6.Seasons");
    }


    private void showLeagueInformation(List<League> leagues){
        Scanner sc = new Scanner(System.in);
        int choise = 0;
        System.out.println("Please chose one the number of one the following Leagues you would like to watch it's information:");
        for(int i = 0;i<leagues.size();i++){
            System.out.println((i+1)+". "+leagues.get(i).getName());
        }try {
            choise = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.out.println("You have to insert a number.");
        }
        if(choise<1||choise>leagues.size())
            return;
        League chosenLeague = leagues.get(choise-1);
        System.out.println("What information would you like to watch?");
        System.out.println("1.League scoring policy");
        System.out.println("2.Selected season League table");
        System.out.println("3.Main referees in the league");
        System.out.println("4.VAR referees in the league");
        System.out.println("5.Lines-Man referees in the league");
        try {
            choise = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.out.println("You have to insert a number.");
        }
        switch (choise){
            case 1:
                System.out.println("For a win in this league a team gets :"+chosenLeague.getScoringPolicy().getPointsPerWin());
                System.out.println("For a draw in this league a team gets :"+chosenLeague.getScoringPolicy().getPointsPerDraw());
                System.out.println("For a lose in this league a team gets :"+chosenLeague.getScoringPolicy().getPointPerLoss());
            case 2:
                System.out.println("Please insert the year of the season you would like to see it's table:");
                int year = 0;
                try{
                    year = Integer.parseInt(sc.nextLine());
                }
                catch (Exception e){
                    System.out.println("You have to insert a number.");
                }
                Season chosenSeason = chosenLeague.getSpecSeason(year);
                if(chosenSeason==null){
                    System.out.println("There is no such league in the inserted year.");
                    return;
                }
                LinkedList<Pair<LeaguePosition, Integer>> seasonList = chosenSeason.getRankings();
                int position = 1;
                for(Pair<LeaguePosition,Integer> positionPair:seasonList){
                    System.out.println(position+"."+positionPair.getKey().getTeam().getTeamName()+", Points:"+positionPair.getValue()+", Wins:"+positionPair.getKey().getGamesWon()
                            +", Loses:"+positionPair.getKey().getGamesLoss()+ ", Draws:"+positionPair.getKey().getGamesDraw());
                    position++;
                }
            case 3:
                List<MainReferee> mainReferees = chosenLeague.getLeagueReferees();
                for(MainReferee mainReferee:mainReferees){
                    System.out.println(mainReferee.getFull_name());
                }
            case 4:
                List<VarReferee> varReferees = chosenLeague.getLeagueVarReferees();
                for(VarReferee varReferee:varReferees){
                    System.out.println(varReferee.getFull_name());
                }
            case 5:
                List<LinesManReferee> linesManReferees = chosenLeague.getLeagueLinesmans();
                for(LinesManReferee linesManReferee:linesManReferees){
                    System.out.println(linesManReferee.getFull_name());
                }
        }

    }

    private void showTeamInformation(List<Team> teams){
        Scanner sc = new Scanner(System.in);
        int choise =0;
        System.out.println("Please chose one the number of one the following Teams you would like to watch it's information:");
        for(int i = 0; i<teams.size();i++){
            System.out.println((i+1)+". "+teams.get(i).getTeamName());
        }
        try {
            choise = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.out.println("You have to insert a number.");
        }
        if(choise<1||choise>teams.size())
            return;
        Team chosenTeam = teams.get(choise-1);
        System.out.println("What information would you like to watch?");
        System.out.println("1.Players Names");
        System.out.println("2.Coaches Names");
        System.out.println("3.Manager's Name");
        System.out.println("4.Home Stadium");
        System.out.println("5.Team Owner's Name");
        try {
            choise = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.out.println("You have to insert a number.");
        }
        switch (choise){
            case 1:
                List<Player> playersNames = chosenTeam.getPlayers();
                for(Player player:playersNames){
                    System.out.println(player.getMember().getFull_name());
                }
                break;
            case 2:
               List<Coach> coachesNames = chosenTeam.getCoaches();
               for(Coach coach:coachesNames){
                   System.out.println(coach.getMember().getFull_name());
               }
               break;
            case 3:
                List<TeamManager> managersNames = chosenTeam.getManagers();
                for(TeamManager teamManager:managersNames){
                    System.out.println(teamManager.getMember().getFull_name());
                }
                break;
            case 4:
                System.out.println(chosenTeam.getHomeStadium().getStadiumName());
                break;
            case 5:
                List<TeamOwner> teamOwnersNames = chosenTeam.getOwners();
                for(TeamOwner teamOwner:teamOwnersNames){
                    System.out.println(teamOwner.getMember().getFull_name());
                }
                break;
        }
    }

    private void showPlayersInformation(List<Player> playerList){
        Scanner sc = new Scanner(System.in);
        int choise =0;
        System.out.println("Please chose one the number of one the following Players you would like to watch information about him:");
        for(int i = 0; i<playerList.size();i++){
            System.out.println((i+1)+". "+playerList.get(i).getMember().getFull_name());
        }
        try {
            choise = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.out.println("You have to insert a number.");
        }
        if(choise<1||choise>playerList.size())
            return;
        Player chosenPlayer = playerList.get(choise-1);
        System.out.println("The Player name is "+ chosenPlayer.getMemberFullName());
        System.out.println("The Player plays in the team "+chosenPlayer.getTeam().getTeamName());
        System.out.println("The Player position in the field is "+ chosenPlayer.getPositionName());
        System.out.println("The Player birth date is "+ chosenPlayer.getStringBirthDate());
    }

    private void showCoachInformation(List<Coach> coachList){
        Scanner sc = new Scanner(System.in);
        int choise =0;
        System.out.println("Please chose one the number of one the following Coaches you would like to watch information about him:");
        for(int i = 0; i<coachList.size();i++){
            System.out.println((i+1)+". "+coachList.get(i).getMember().getFull_name());
        }
        try {
            choise = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.out.println("You have to insert a number.");
        }
        if(choise<1||choise>coachList.size())
            return;
        Coach chosenCoach = coachList.get(choise-1);
        System.out.println("The Coach name is "+ chosenCoach.getMember().getFull_name());
        System.out.println("The Coach team is "+ chosenCoach.getTeam().getTeamName());
    }

    private void showTeamManagerInformation(List<TeamManager> teamManagers){
        Scanner sc = new Scanner(System.in);
        int choise =0;
        System.out.println("Please chose one the number of one the following Team Managers you would like to watch information about him:");
        for(int i = 0; i<teamManagers.size();i++){
            System.out.println((i+1)+". "+teamManagers.get(i).getMember().getFull_name());
        }
        try {
            choise = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.out.println("You have to insert a number.");
        }
        if(choise<1||choise>teamManagers.size())
            return;
        TeamManager chosenTeamManager = teamManagers.get(choise-1);
        System.out.println("The Team Manager name is "+ chosenTeamManager.getMember().getFull_name());
        System.out.println("The Team Manager Team is "+ chosenTeamManager.getMember().getFull_name());
    }

    public void showSystemInformation(){
        AlphaSystem system = AlphaSystem.getSystem();
        int choise = 0;
        Scanner sc = new Scanner(System.in);
        printInfoMenu();
        try {
            choise = Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            System.out.println("You have to insert a number.");
        }
        if(choise<1||choise>6) {
            System.out.println("The option that have been chosen is not available.");
            return;
        }
        switch (choise){
            case 1:
                List<Team> teams = (List<Team>) system.GetAllFromDB(4);
                showTeamInformation(teams);
                break;
            case 2:
                List<Player> players = (List<Player>) system.GetAllFromDB(7);
                showPlayersInformation(players);
                break;
            case 3:
                List<Coach> coaches = (List<Coach>) system.GetAllFromDB(3);
                showCoachInformation(coaches);
                break;
            case 4:
                List<TeamManager> teamManagers = (List<TeamManager>) system.GetAllFromDB(5);
                showTeamManagerInformation(teamManagers);
                break;
            case 5:
                List<League> leagueList = (List<League>) system.GetAllFromDB(1);
                showLeagueInformation(leagueList);
                break;
            case 6:
                //List<Season> seasonList = (List<Season>) system.GetAllFromDB()
        }
    }

    public void searchInformation(){

    }


}
