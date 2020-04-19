import java.util.ArrayList;
import java.util.List;

public abstract class Job {
    enum Permissions{}
    private List<Permissions> permissions;
    private Member member;

    public Job(Member member) {
        this.permissions = new ArrayList<>();
        this.member=member;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        if(!(this instanceof TeamOwner)){
            System.out.println("you cant' change the permissions");
            return;
        }
        this.permissions = permissions;
    }

    public Member getMember() {
        return member;
    }
}
