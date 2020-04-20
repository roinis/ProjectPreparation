//roei cohen
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Register {

    private HashMap<String,String> id_and_password;
    private UsersInformation usersInformation;
    private static List<Member> members = new ArrayList<>();

    public Register(){
        usersInformation = new UsersInformation();
        id_and_password = new HashMap<>();
    }

    private void writeNewMember(String user_name,String user_password,String user_id,String full_name){
        File file = new File("users.txt");
        try {
            FileWriter writer = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(user_name +" "+ user_password +" "+ user_id +" "+ full_name);
            bw.newLine();
            bw.close();
        }catch (IOException e){
            e.fillInStackTrace();
        }
    }

    private String combineFullName(String full_name){
        String[] nameSplitted = full_name.split(" ");
        String full_name_fixed ="";
        for(int i = 0;i<nameSplitted.length;i++){
            if(i==0){
                full_name_fixed = nameSplitted[i];
            }
            else
                full_name_fixed = full_name_fixed+"_"+nameSplitted[i];
        }
        return  full_name_fixed;
    }

    public void registerToSystem(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Create Account");
        System.out.println("Please enter User Name:");
        String user_name = sc.nextLine();
        this.id_and_password = usersInformation.getId_and_password();
        while(this.id_and_password.containsKey(user_name)){
            System.out.println("Account with this user name already exists, Please choose another Account name.");
            System.out.println("Please enter User ID:");
            user_name = sc.nextLine();
        }
        System.out.println("Please enter Password:");
        String password = sc.nextLine();
        System.out.println("Please enter ID number:");
        String user_id = sc.nextLine();
        System.out.println("Please enter Full Name:");
        String full_name = sc.nextLine();
        writeNewMember(user_name,password,user_id,combineFullName(full_name));
        members.add(new Member(user_name,password,user_id,full_name));
        System.out.println("Registration completed successfully!");
    }
}
