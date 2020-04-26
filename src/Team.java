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
        this.status=Status.open;
        this.homeStadium=homeStadium;
        fanObservers=new ArrayList<>();
        jobsObservers=new ArrayList<>();
        tweets=new ArrayList<>();
        budget=new Budget(this);
        owner.setTeam(this);
        owners.add(owner);
        jobsObservers.add(owner.getMember());
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(4,this);
    }

    public String getTeamName() {
        return teamName;
    }

    public boolean setTeamName(String teamName) {
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        this.teamName = teamName;
        return true;
    }

    public List<TeamOwner> getOwners() {
        return owners;
    }

    public Budget getBudget() {
        return budget;
    }

    public List<String> getTweets() {
        return tweets;
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
            return false;
        }
        teamOwner.setTeam(this);
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
        removeAllAppointment(teamOwner);
        member.removeJob("owner");
        owners.remove(teamOwner);
        jobsObservers.remove(member);
        RemoveNominationEvent event=new RemoveNominationEvent(this,member,"Team owner");
        member.update(event);
        notifyObserver(event);
        return true;
    }

    public boolean addManager(TeamManager teamManager) {
        if(status==Status.close){
            //System.out.println("the team is close");
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
            //System.out.println("the team already "+this.status);
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
        //System.out.println("the team is "+status+" now");
        return true;
    }

    public Stadium getHomeStadium() {

        return homeStadium;
    }

    public boolean setHomeStadium(Stadium homeStadium) {
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        this.homeStadium = homeStadium;
        return true;
    }

    public List<Observer> getFanObservers(){
        return fanObservers;
    }

    private void removeAllTeamPermissions(){
        for(TeamManager teamManager:managers)
            teamManager.removeAllPermissions();
    }

    public boolean addTweet(String tweet){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        tweets.add(tweet);
        notifyObserver(new TewwtEvent(tweet));
        return true;
    }

    public boolean deleteTweet(int index){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        if(index>=tweets.size())
            return false;
        tweets.remove(index);
        return true;
    }

    @Override
    public void register(Observer newObserver) {
        if(status==Status.close){
            //System.out.println("the team is close");
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

    public boolean registerSystemAdmin(SystemAdmin systemAdmin){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        jobsObservers.add(systemAdmin);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Team))
            return false;
        Team secTeam=(Team)obj;
        if(this.getTeamName().equals(secTeam.getTeamName()))
            return true;
        return false;
    }

    private void removeAllAppointment(TeamOwner teamOwner){
        ArrayList<String> owners=new ArrayList<>();
        ArrayList<String> managers=new ArrayList<>();
        for(Job job : teamOwner.getAppointmentList()){
            if(job instanceof TeamOwner)
                owners.add(job.getMemberUserName());
            else if(job instanceof TeamManager)
                managers.add(job.getMemberUserName());
        }
        for(String userName:owners)
            teamOwner.removeOwner(userName);
        for(String userName:managers)
            teamOwner.removeOwner(userName);
    }

    public boolean addWithdraw(Double sum,String description){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        budget.addWithdraw(sum,description);
        return true;
    }

    public boolean addDeposit(Double sum,String description){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        budget.addDeposit(sum,description);
        return true;
    }

    private Player getPlayer(String userName){
        for(Player player:players) {
            if (player.getMemberUserName().equals(userName))
                return player;
        }
        return null;
    }

    private Coach getCoach(String userName){
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

    public boolean addNewPlayer(String userName){ //searching by name and not by username!
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        Player player = (Player) alphaSystem.GetSpecificFromDB(7, userName);
        if(player==null){
            return false;
        }
        if(player.addToTeam(this)) {
            players.add(player);
            notifyObserver(new AddPlayerToTeamEvent(player,this));
            return true;
        }else return false;
    }

    public boolean removeExistingPlayer(String userName){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        Player player = getPlayer(userName);
        if(player==null){
            return false;
        }
        if(player.removeFromTeam()){
            players.remove(player);
            notifyObserver(new RemovePlayerFromTeamEvent(player,this));
            return true;
        }
        return false;
    }

    public boolean editExistingPlayerName(String userName,String name){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        Player player = getPlayer(userName);
        if(player==null)
            return false;
        player.editFullName(name);
        return true;
    }

    public boolean editExistingPlayerPosition(String userName,String position){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        Player player = getPlayer(userName);
        if(player==null)
            return false;
        if(player.editPosition(position))
            return true;
        return false;
    }

    public boolean editExistingPlayerBirthday(String userName,int year,int month,int day){
        if(status==Status.close){
            System.out.println("the team is close");
            return false;
        }
        Player player = getPlayer(userName);
        if(player==null)
            return false;
        player.editBirthDay(year,month,day);
        return true;
    }

    public boolean addNewCoach(String userName,String job){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        Coach coach = (Coach) alphaSystem.GetSpecificFromDB(3, userName);
        if(coach==null){
            return false;
        }
        if(coach.addToTeam(this,job)) {
            coaches.add(coach);
            notifyObserver(new AddCoachToTeamEvent(coach,this));
            return true;
        }else return false;
    }

    public boolean removeExistingCoach(String userName){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        Coach coach= getCoach(userName);
        if(coach==null){
            return false;
        }
        if(coach.removeFromTeam()){
            coaches.remove(coach);
            notifyObserver(new RemoveCoachFromTeamEvent(coach,this));
            return true;
        }
        return false;
    }

    public boolean editExistingCoachName(String user,String newName){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        Coach coach=getCoach(user);
        if(coach==null)
            return false;
        coach.editFullName(newName);
        return true;
    }

    public boolean editExistingCoachCertification(String user,int certificationId){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        Coach coach=getCoach(user);
        if(coach==null)
            return false;
        if(coach.setCertification(certificationId))
            return true;
        return false;
    }

    public boolean editExistingCoachJobInTeam(String user,String Job){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        Coach coach=getCoach(user);
        if(coach==null)
            return false;
        coach.setJobInTheTeam(Job);
        return true;
    }

    public boolean editExistingManagerName(String user,String newName){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        TeamManager manager = getManager(user);
        if(manager==null){
            return false;
        }
        manager.editFullName(newName);
        return true;
    }

    public boolean editExistingStadiumName(String newName){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        homeStadium.setStadiumName(newName);
        return true;
    }

    public boolean setNewStadium(String stadiumName){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        Stadium stadium= (Stadium) alphaSystem.GetSpecificFromDB(11,stadiumName);
        if(stadium==null)
            return false;
        setHomeStadium(stadium);
        return true;
    }

    public boolean setPermissionsToManager(String manager, ArrayList<TeamManager.Permissions> permissionsList){
        if(status==Status.close){
            //System.out.println("the team is close");
            return false;
        }
        TeamManager teamManager=getManager(manager);
        teamManager.setPermissions(permissionsList);
        return true;
    }


}



  /*  private void editCoaches(){
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
                System.out.println("please enter his job in the team");
                String job=scanner.nextLine();
                if(coach.addToTeam(this,job)) {
                    System.out.println("please enter his job in the team");
                    coaches.add(coach);
                    System.out.println("welcome " + coach.getMemberFullName() + " join to " + teamName +" team");
                }
                break;
            case "2":
                coach= getCoach(userName);
                if(coach==null){
                    System.out.println("Invalid username");
                    return;
                }
                if(coach.removeFromTeam()){
                    coaches.remove(coach);
                    System.out.println( coach.getMemberFullName() + " leave " + teamName +" team");
                }
                break;
            case "3":
                coach= getCoach(userName);
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
    }*/


  /*
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
*/
/*
    public void editProperty(){
        if(status==Status.close){
            System.out.println("the team is close");
            return;
        }
        Scanner scanner=new Scanner(System.in);
        System.out.println("Select an action");
        System.out.println("1.edit players\n"+"2.edit coaches\n"+"3.edit managers\n"+"4.edit stadium");
        String action=scanner.nextLine();
        scanner.close();
        switch (action){
            case "1":
                //editPlayers();
                break;
            case "2":
                editCoaches();
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
    }*/


/*
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
    }*/
