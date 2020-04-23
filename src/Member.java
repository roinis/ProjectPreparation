//roei cohen
import java.io.*;
import java.util.*;

public class Member extends User implements Observer{

    private String user_name;
    private String user_password;
    private String user_id;
    private String full_name;
    private HashMap<String,Job> jobs;
    private List<Event> eventList;
    private boolean online;
    private boolean blocked;
    private List<Ticket> ticketList;
    private List<String> searchHistory;

    public Member(String user_name,String user_password,String user_id,String full_name){
        this.user_name=user_name;
        this.user_password=user_password;
        this.user_id=user_id;
        this.full_name=full_name;
        jobs = new HashMap<>();
        eventList = new ArrayList<>();
        ticketList = new ArrayList<>();
        searchHistory = new ArrayList<>();
        online=false;
        blocked = false;
    }

    public void memberSearch(){
        searchHistory.add(userGeneralSearch());
    }

    public void watchSearchHistory(){
        if(searchHistory.size()==0)
            System.out.println("No searches have been performed yet.");
        for(String search:searchHistory){
            System.out.println(search);
        }
    }

    public Member(Member member){
        this.user_name=member.user_name;
        this.user_id = member.user_id;
        this.user_password = member.user_password;
        this.full_name = member.full_name;
        this.jobs=member.jobs;
        this.eventList = member.eventList;
        this.online = member.online;
        this.blocked = member.blocked;
        this.ticketList = member.ticketList;
    }

    public void setFull_name(String full_name){
        this.full_name=full_name;
    }

    public void setBlocked(boolean blocked){
        this.blocked=blocked;
    }

    public void editPersonalInformation(){//1-username|2-password|3-id number|4-fullname
        System.out.println("Edit Personal Information:");
        System.out.println("What would you like to edit?(Please enter the number of the field)");
        System.out.println("1.User Name");
        System.out.println("2.Password");
        System.out.println("3.ID Number");
        System.out.println("4.Full Name");
        Scanner sc = new Scanner(System.in);
        int choise = Integer.parseInt(sc.nextLine());
        String input ="";
        boolean result = false;
        UsersInformation usersInformation = new UsersInformation();
        switch (choise){
            case 1:
                System.out.println("Please enter the new user name:");
                input = sc.nextLine();
                result = usersInformation.editInformation(1,user_name,input);
            case 2:
                System.out.println("Please enter the new password:");
                input = sc.nextLine();
                result  = usersInformation.editInformation(2,user_name,input);
            case 3:
                System.out.println("Please enter the new id number:");
                input = sc.nextLine();
                result = usersInformation.editInformation(3,user_name,input);
            case 4:
                System.out.println("Please enter the new full name:");
                input = sc.nextLine();
                result = usersInformation.editInformation(3,user_name,input);
        }
        if(result==false)
            System.out.println("There was a problem changing the information of this Member");
        else
            System.out.println("Information have been changed successfully!");
    }

    public String getFull_name(){
        return full_name;
    }

    public void setOnline(boolean online){
        this.online=online;
    }

    public HashMap<String,Job> getJobsList(){
        return jobs;
    }

    public Job getJob(String job_name){
        if(jobs.containsKey(job_name))
            return jobs.get(job_name);
        return null;
    }

    public void addJob(Job job){
        if(job instanceof Referee){
            if(jobs.size()>0)
                return;
        }
        if(!jobs.containsKey(job.getJobName())) {
            jobs.put(job.getJobName(), job);
            addJobToFile(job);
        }
    }

    public void logout(){
        online=false;
    }

    public boolean removeJob(String job_name){
        if(jobs.containsKey(job_name)) {
            jobs.remove(job_name);
            return true;
        }
        return false;
    }

    public String getUser_name() {
        return user_name;
    }

    @Override
    public void update(Event newEvent) {
        this.eventList.add(newEvent);
        System.out.println(newEvent.toString());
    }

    private void printInfo(String password){
        System.out.println("The user name is: "+user_name);
        System.out.println("The password is: "+password);
        System.out.println("The full name is: "+full_name);
        System.out.println("The user ID is: "+user_id);
    }

    public void showMemberInformation(){
        System.out.println("Watch my information:");
        System.out.println("Would you like to see your password? (Y/N)");
        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();
        if(ans.equals("Y"))
            printInfo(this.user_password);
        else
            printInfo("*********");
    }

    public void newComplaint(){
        System.out.println("New Complaint Form");
        System.out.println("Please enter the complaint you would like to send:");
        Scanner sc = new Scanner(System.in);
        String complaint = sc.nextLine();
        Ticket ticket = new Ticket(this,complaint);
        AlphaSystem.getSystem().AddtoDB(10,ticket);
        this.ticketList.add(ticket);
        System.out.println("Your opinion is important for us and your complaint has been sent to the System Manager, Thank you.");
    }

    public boolean addReferee(Job referee){
        if(this.jobs.size()>0)
            return false;
        addJob(referee);
        return true;
    }

    private void addJobToFile(Job job){
        File file = new File("src//jobs.txt");
        HashMap<String,String[]> user_jobs = new HashMap<>();
        String line = "";

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine())!=null){
                String[] splittedLine = line.split(" ");
                user_jobs.put(splittedLine[0],(Arrays.copyOfRange(splittedLine,1,splittedLine.length)));
            }
            if(!user_jobs.containsKey(user_name)){
                bw.write(user_name+" "+job.getJobName());
                bw.close();
            }
            else{
                PrintWriter pw = new PrintWriter(file);
                pw.print("");
                pw.close();
                String[] jobs_without_new_job = user_jobs.remove(user_name);
                String[] jobs = new String[jobs_without_new_job.length+1];
                jobs[0] = job.getJobName();
                for(int i = 0;i<jobs_without_new_job.length;i++){
                    jobs[i+1] = jobs_without_new_job[i];
                }
                user_jobs.put(user_name,jobs);
                String new_line = "";
                for(String user_name_hash:user_jobs.keySet()){
                    new_line = user_name_hash + " "+String.join(" ",user_jobs.get(user_name_hash));
                    bw.write(new_line);
                }
                bw.close();
            }

        }catch (IOException e){
            e.fillInStackTrace();
        }
    }

    public void followFootballGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert the League name:");
        String input = sc.nextLine();
        League chosenLeague = (League)AlphaSystem.getSystem().GetSpecificFromDB(1,input);
        if(chosenLeague!=null){
            System.out.println("Please insert the Home team name:");
            String home_team = sc.nextLine();
            System.out.println("Please insert the Away team name:");
            String away_team = sc.nextLine();
            Season currSeason = chosenLeague.getCurrentSeason();
            List<FootballGame> footballGames = currSeason.getGames();
            boolean found_game=false;
            for(FootballGame footballGame:footballGames){
                if(footballGame.getHomeTeamName().equals(home_team)&&footballGame.getAwayTeamName().equals(away_team)) {
                    footballGame.register(this);
                    System.out.println("You are now following the match between " + home_team + " and " + away_team);
                    return;
                }
            }
            System.out.println("No match has found in this league in the current season with such team names.");
        }
    }

    public void followPersonalPage(){//need to finish
        System.out.println("Please chose the number of one of the following you would like to follow:");
        System.out.println("1.Teams");
        System.out.println("2.Players");
        System.out.println("3.Coaches");
        Scanner sc = new Scanner(System.in);
        int choise = Integer.parseInt(sc.nextLine());
        switch (choise){
            case 1:
                System.out.println("Please chose one the number of one the following Teams you would like to follow after:");
                List<Team> teamsList = (List<Team>)AlphaSystem.getSystem().GetAllFromDB(4);
                for(int i = 0; i<teamsList.size();i++){
                    System.out.println((i+1)+". "+teamsList.get(i).getTeamName());
                }
                try {
                    choise = Integer.parseInt(sc.nextLine());
                }catch (Exception e){
                    System.out.println("Please insert a number.");
                }
                if(choise<1||choise>teamsList.size())
                    return;
                Team chosenTeam = teamsList.get(choise-1);
                chosenTeam.register(this);
                System.out.println("You are now following "+chosenTeam.getTeamName()+" successfully!");
                break;
            case 2:
                System.out.println("Please chose one the number of one the following Players you would like to follow after:");
                List<Player> playersList = (List<Player>)AlphaSystem.getSystem().GetAllFromDB(7);
                for(int i = 0; i<playersList.size();i++){
                    System.out.println((i+1)+". "+playersList.get(i).getMemberFullName());
                }try {
                choise = Integer.parseInt(sc.nextLine());
                }catch (Exception e){
                    System.out.println("Please insert a number.");
                }
                if(choise<1||choise>playersList.size())
                    return;
                Player chosenPlayer = playersList.get(choise-1);
                chosenPlayer.register(this);
                System.out.println("You are now following "+chosenPlayer.getMemberFullName()+" successfully!");
                break;
            case 3:
                System.out.println("Please chose one the number of one the following Coaches you would like to follow after:");
                List<Coach> coachesList = (List<Coach>)AlphaSystem.getSystem().GetAllFromDB(3);
                for(int i = 0; i<coachesList.size();i++){
                    System.out.println((i+1)+". "+coachesList.get(i).getMemberFullName());
                }try {
                    choise = Integer.parseInt(sc.nextLine());
                }catch (Exception e){
                    System.out.println("Please insert a number.");
                }
                if(choise<1||choise>coachesList.size())
                    return;
                Coach chosenCoach = coachesList.get(choise-1);
                chosenCoach.register(this);
                System.out.println("You are now following "+chosenCoach.getMemberFullName()+" successfully!");
                break;
        }
    }
}
