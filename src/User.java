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
        Team chosenTeam = teams.get(choise);
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

    public void showInformation(){
        String choise = "";
        Scanner sc = new Scanner(System.in);
        printInfoMenu();
        choise = sc.nextLine();
        switch (choise){
            case "1":
                List<Team> teams = (List<Team>) AlphaSystem.GetAllFromDB(4);
                showTeamInformation(teams);



        }

    }


}
