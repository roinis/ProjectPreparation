//roei cohen
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Member extends User implements Observer{

    private String user_name;
    private String user_password;
    private String user_id;
    private String full_name;
    private HashMap<String,Job> jobs;
    private List<Event> eventList;

    public Member(String user_name,String user_password,String user_id,String full_name){
        this.user_name=user_name;
        this.user_password=user_password;
        this.user_id=user_id;
        this.full_name=full_name;
        jobs = new HashMap<>();
        eventList = new ArrayList<>();
    }

    public String getFull_name(){
        return full_name;
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
        if(!jobs.containsKey(job.getJobName())) {
            jobs.put(job.getJobName(), job);
            addJobToFile(job);
        }
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
}
