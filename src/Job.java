import java.util.ArrayList;
import java.util.List;

public abstract class Job {
    enum Permissions{}
    private ArrayList<Permissions> permissions;
    private Member member;
    protected String jobName;

    public Job(Member member) {
        this.permissions = new ArrayList<>();
        this.member=member;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<Permissions> permissions) {
        if(!(this instanceof TeamOwner)){
            System.out.println("you cant' change the permissions");
            return;
        }
        this.permissions = permissions;
    }

    public Member getMember() {
        return member;
    }

    public String getJobName() {
        return jobName;
    }

    public void removeAllPermissions(){
        permissions.clear();
    }

    public void addAllPermissions(){
        for(Job.Permissions permission: Job.Permissions.values()){
            permissions.add(permission);
        }
    }

}
