import java.util.HashMap;
import java.util.Scanner;

public class Login {

    private UsersInformation usersInformation;
    private HashMap<String,String> id_and_password;
    private HashMap<String,Member> members;

    public Login(){
        usersInformation = new UsersInformation();
        id_and_password = new HashMap<>();
        members = new HashMap<>();
    }


    public Member loginToSystem(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Login");
        System.out.println("Please enter User Name:");
        String user_name = sc.nextLine();
        id_and_password = usersInformation.getId_and_password();
        if(!id_and_password.containsKey(user_name)){
            System.out.println("There is no such account with this user name in the system.");
            return null;
        }
        System.out.println("Please enter Password:");
        String password = sc.nextLine();
        String password_from_hash = id_and_password.get(user_name);
        if(!password.equals(password_from_hash)){
            int counter = 2;
            while(counter>0 && !password.equals(password_from_hash)){
                System.out.println("Password does not match to the user name.");
                System.out.println("Please enter Password ("+counter+" attempts left):");
                password = sc.nextLine();
                counter--;
            }
            if(!password.equals(password_from_hash)){
                System.out.println("Password does not match to the user name.");
                return null;
            }
        }
        members = usersInformation.getMembers();
        System.out.println("Login completed successfully!");
        return members.get(user_name);
    }
}
