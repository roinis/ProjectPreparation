//roei cohen

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

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
    }

    private void showTeamInformation(List<Team> teams){
        Scanner sc = new Scanner(System.in);
        int choise =0;
        System.out.println("Please chose one the number of one the following Teams you would like to watch it's information:");
        for(int i = 0; i<teams.size();i++){
            System.out.println((i+1)+". "+teams.get(i).getTeamName());
        }
        choise = Integer.parseInt(sc.nextLine());
        if(choise<1||choise>teams.size())
            return;
        Team chosenTeam = teams.get(choise-1);
        System.out.println("Which information would you like to watch?");
        System.out.println("1.Players Names");
        System.out.println("2.Coaches Names");
        System.out.println("3.Manager's Name");
        System.out.println("4.Home Stadium");
        System.out.println("5.Team Owner's Name");
        choise = Integer.parseInt(sc.nextLine());
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
        choise = Integer.parseInt(sc.nextLine());
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
        choise = Integer.parseInt(sc.nextLine());
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
        choise = Integer.parseInt(sc.nextLine());
        if(choise<1||choise>teamManagers.size())
            return;
        TeamManager chosenTeamManager = teamManagers.get(choise-1);
        System.out.println("The Team Manager name is "+ chosenTeamManager.getMember().getFull_name());
        System.out.println("The Team Manager Team is "+ chosenTeamManager.getMember().getFull_name());
    }

    public void showInformation(){
        AlphaSystem system = AlphaSystem.getSystem();
        int choise = 0;
        Scanner sc = new Scanner(System.in);
        printInfoMenu();
        choise = Integer.parseInt(sc.nextLine());
        if(choise<1||choise>5) {
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
        }
    }

    public void searchInformation(){

    }


}
