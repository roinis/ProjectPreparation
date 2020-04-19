import java.util.HashSet;

public class Member extends User{

    private String user_name;
    private String user_password;
    private String user_id;
    private String full_name;
    private HashSet<User> memberTypes;

    public Member(String user_name,String user_password,String user_id,String full_name){
        this.user_name=user_name;
        this.user_password=user_password;
        this.user_id=user_id;
        this.full_name=full_name;
        memberTypes = new HashSet<>();
    }




}
