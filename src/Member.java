//roei cohen
import java.util.HashMap;

public class Member extends User implements Observer{

    private String user_name;
    private String user_password;
    private String user_id;
    private String full_name;
    private HashMap<String,Job> jobs;

    public Member(String user_name,String user_password,String user_id,String full_name){
        this.user_name=user_name;
        this.user_password=user_password;
        this.user_id=user_id;
        this.full_name=full_name;
        jobs = new HashMap<>();
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
        jobs.put(job.getJobName(),job);
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
        System.out.println(newEvent.toString());
    }
}
