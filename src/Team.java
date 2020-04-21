import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Team implements Subject {

    enum Status{open,close}
    private String teamName;
    private List<TeamOwner> owners;
    private  List<Player> players;
    private List<Coach> coaches;
    private List<TeamManager> managers;
    private Status status;
    private Stadium homeStadium;
    private List<Observer> fanObservers;
    private List<Observer> jobsObservers;
    private List<String> tweets;
    private Budget budget;

    public Team(String teamName, TeamOwner owner, Stadium homeStadium) {
        this.teamName=teamName;
        owners=new ArrayList<>();
        players=new ArrayList<>();
        coaches=new ArrayList<>();
        managers=new ArrayList<>();
        owners.add(owner);
        this.status=Status.open;
        this.homeStadium=homeStadium;
        fanObservers=new ArrayList<>();
        jobsObservers=new ArrayList<>();
        tweets=new ArrayList<>();
        budget=new Budget(this);
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(4,this);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        this.teamName = teamName;
    }

    public List<TeamOwner> getOwners() {
        return owners;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<TeamManager> getManagers() {
        return managers;
    }

    public boolean addOwner(TeamOwner teamOwner){
        if(status==Status.close){
            System.out.println("the team is close");
            return false;
        }
        jobsObservers.add(teamOwner.getMember());
        owners.add(teamOwner);
        notifyObserver(new NewNominationEvent(this,teamOwner.getMember(),"Team owner"));
        return true;
    }

    public boolean removeOwner(TeamOwner teamOwner) {
        if(status==Status.close){
            System.out.println("the team is close");
            return false;
        }
        if (owners.size() == 1) {
            System.out.println("you cant' remove the owner");
            return false;
        }
        Member member=teamOwner.getMember();
        removeAllappointment((TeamOwner) member.getJob("owner"));
        member.removeJob("owner");
        owners.remove(teamOwner);
        jobsObservers.remove(teamOwner);
        RemoveNominationEvent event=new RemoveNominationEvent(this,member,"Team owner");
        member.update(event);
        notifyObserver(event);
        return true;
    }

    public boolean addManager(TeamManager teamManager) {
        if(status==Status.close){
            System.out.println("the team is close");
            return false;
        }
        jobsObservers.add(teamManager.getMember());
        managers.add(teamManager);
        notifyObserver(new NewNominationEvent(this,teamManager.getMember(),"Team manager"));
        return true;
    }

    public boolean removeManager(TeamManager teamManager) {
        if(status==Status.close){
            System.out.println("the team is close");
            return false;
        }
        Member member=teamManager.getMember();
        member.removeJob("manager");
        managers.remove(teamManager);
        jobsObservers.remove(teamManager);
        RemoveNominationEvent event=new RemoveNominationEvent(this,member,"Team manager");
        member.update(event);
        notifyObserver(event);
        return true;
    }

    public Status getStatus() {
        return status;
    }

    public boolean setStatus(Status status) {
        if(status == this.status){
            System.out.println("the team already "+this.status);
            return false;
        }
        this.status = status;
        if(this.status== Status.open) {
            notifyObserver(new TeamReOpenEvent(LocalDateTime.now(),this));
        }
        else if(this.status==Status.close){
            removeAllTeamPermissions();
            notifyObserver(new TeamCloseEvent(LocalDateTime.now(),this));
        }
        System.out.println("the team is "+status+" now");
        return true;
    }

    public Stadium getHomeStadium() {

        return homeStadium;
    }

    public void setHomeStadium(Stadium homeStadium) {
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        this.homeStadium = homeStadium;
    }

    private void removeAllTeamPermissions(){
        removeAllPermissions((List<Job>) (List<?>)owners);
        removeAllPermissions((List<Job>) (List<?>)players);
        removeAllPermissions((List<Job>) (List<?>)coaches);
        removeAllPermissions((List<Job>) (List<?>)managers);
    }

    private void removeAllPermissions(List<Job> jobList){
        for(Job job:jobList)
            job.removeAllPermissions();
    }

    public void addTweet(String tweet){
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        tweets.add(tweet);
        notifyObserver(new TewwtEvent(tweet));
    }

    public void deleteTweet(int index){
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        tweets.remove(index);
    }

    @Override
    public void register(Observer newObserver) {
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
            fanObservers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        int observerIndex = fanObservers.indexOf(deleteObserver);
        fanObservers.remove(observerIndex);
    }

    @Override
    public void notifyObserver(Event newEvent) {
        if(newEvent instanceof TeamReOpenEvent){
            for (Observer observer:jobsObservers) {
                observer.update(newEvent);
            }
        }
        if(newEvent instanceof TeamCloseEvent){
            for (Observer observer:jobsObservers) {
                observer.update(newEvent);
            }
        }
        for (Observer observer:fanObservers) {
            observer.update(newEvent);
        }
    }

    public void registerAssociationMember(AssociationMember associationMember){
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        jobsObservers.add(associationMember);
    }

    private void removeAllappointment(TeamOwner teamOwner){
        for(Job job : teamOwner.getAppointmentList()){
            if(job instanceof TeamOwner)
                teamOwner.removeOwner(job.getMemberUserName());
            else if(job instanceof TeamManager)
                teamOwner.removeManger(job.getMemberUserName());
        }
    }

    public void addWithdraw(Double sum,String description){
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        budget.addWithdraw(sum,description);

    }

    public void addDeposit(Double sum,String description){
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        budget.addDeposit(sum,description);
    }

    private Player getPlayer(String userName){
        for(Player player:players) {
            if (player.getMemberUserName().equals(userName))
                return player;
        }
        return null;
    }

    private Coach getCoah(String userName){
        for(Coach coach:coaches) {
            if (coach.getMemberUserName().equals(userName))
                return coach;
        }
        return null;
    }

    private TeamManager getManager(String userName){
        for(TeamManager manager:managers) {
            if (manager.getMemberUserName().equals(userName))
                return manager;
        }
        return null;
    }

    private void editPlayers(){
        Player player;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Select an action");
        System.out.println("1. add player\n"+"2. remove player\n"+"3. edit player details");
        String action= scanner.nextLine();
        System.out.println("enter a player username");
        String userName=scanner.nextLine();
        switch (action){
            case "1":
                AlphaSystem alphaSystem=AlphaSystem.getSystem();
                player= (Player) alphaSystem.GetSpecificFromDB(7,userName);
                if(player==null){
                    System.out.println("Invalid username");
                    return;
                }
                if(player.addToTeam(this)) {
                    players.add(player);
                    System.out.println("welcome " + player.getMemberFullName() + " join to " + teamName +" team");
                }
                break;
            case "2":
                player=getPlayer(userName);
                if(player==null){
                    System.out.println("Invalid username");
                    return;
                }
                if(player.removeFromTeam(this)){
                    players.remove(player);
                    System.out.println( player.getMemberFullName() + " leave " + teamName +" team");
                }
                break;
            case "3":
                player=getPlayer(userName);
                if(player==null){
                    System.out.println("Invalid username");
                    return;
                }
                player.editDetails();
                break;
            default:
                System.out.println("invalid action");
                break;
        }
        scanner.close();
    }

    private void editCoachs(){
        Coach coach;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Select an action");
        System.out.println("1. add coach\n"+"2. remove coach\n"+"3. edit coach details");
        String action= scanner.nextLine();
        System.out.println("enter a coach username");
        String userName=scanner.nextLine();
        switch (action){
            case "1":
                AlphaSystem alphaSystem=AlphaSystem.getSystem();
                coach= (Coach) alphaSystem.GetSpecificFromDB(3,userName);
                if(coach==null){
                    System.out.println("Invalid username");
                    return;
                }
                if(coach.addToTeam(this)) {
                    coaches.add(coach);
                    System.out.println("welcome " + coach.getMemberFullName() + " join to " + teamName +" team");
                }
                break;
            case "2":
                coach=getCoah(userName);
                if(coach==null){
                    System.out.println("Invalid username");
                    return;
                }
                if(coach.removeFromTeam(this)){
                    coaches.remove(coach);
                    System.out.println( coach.getMemberFullName() + " leave " + teamName +" team");
                }
                break;
            case "3":
                coach=getCoah(userName);
                if(coach==null){
                    System.out.println("Invalid username");
                    return;
                }
                coach.editDetails();
                break;
            default:
                System.out.println("invalid action");
                break;
        }
        scanner.close();

    }

    private void editManagers(){
        TeamManager manager;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Select an action");
        System.out.println("1. edit manager details");
        String action= scanner.nextLine();
        System.out.println("enter a manager username");
        String userName=scanner.nextLine();
        switch (action){
            case "2":
                manager=getManager(userName);
                if(manager==null){
                    System.out.println("Invalid username");
                    return;
                }
                manager.editDetails();
                break;
            default:
                System.out.println("invalid action");
                break;
        }
        scanner.close();
    }

    private void editStadium(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Select an action");
        System.out.println("1. edit Stadium details\n"+"2.set home Stadium");
        String action= scanner.nextLine();
        switch (action){
            case "1":
                homeStadium.editDetails();
                break;
            case "2":
                AlphaSystem alphaSystem=AlphaSystem.getSystem();
                System.out.println("enter the stadium name");
                String stadiumName=scanner.nextLine();
                Stadium stadium= (Stadium) alphaSystem.GetSpecificFromDB(11,stadiumName);
                if(stadium==null){
                    System.out.println("invalid name");
                    return;
                }
                setHomeStadium(stadium);
                break;
            default:
                System.out.println("invalid action");
                break;
        }
        scanner.close();
    }

    public void editProperty(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Select an action");
        System.out.println("1.edit players\n"+"2.edit coaches\n"+"3.edit managers\n"+"4.edit stadium");
        String action=scanner.nextLine();
        scanner.close();
        switch (action){
            case "1":
                editPlayers();
                break;
            case "2":
                editCoachs();
                break;
            case "3":
                editManagers();
                break;
            case "4":
                editStadium();
                break;
            default:
                System.out.println("invalid action");
                break;
        }
    }


}
