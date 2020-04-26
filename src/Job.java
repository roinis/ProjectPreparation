import java.util.ArrayList;
import java.util.List;

public abstract class Job {
    private Member member;
    protected String jobName;

    public Job(Member member) {
        this.member=member;
    }

    public Member getMember() {
        return member;
    }

    public String getJobName() {
        return jobName;
    }

    public String getMemberUserName(){
        return member.getUser_name();
    }

    public String getMemberFullName(){
        return member.getFull_name();
    }


}
