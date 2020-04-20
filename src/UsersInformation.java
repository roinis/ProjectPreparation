//roei cohen

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class UsersInformation {

    private HashMap<String,String> id_and_password;
    private HashMap<String,Member> members;


    public UsersInformation(){
        id_and_password = new HashMap<>();
        members = new HashMap<>();
    }

    public HashMap<String,String> getId_and_password(){
        readMembersInformation();
        return id_and_password;
    }


    public HashMap<String,Member> getMembers(){
        readMembersInformation();
        return members;
    }

    public Member getSpecificMember(String user_name){
        readMembersInformation();
        if(members.containsKey(user_name))
            return members.get(user_name);
        return null;
    }

    private void readMembersInformation(){
        id_and_password = new HashMap<>();
        members = new HashMap<>();
        File file = new File("users.txt");
        String line = "";
        String user_name="";
        String user_password="";
        String user_id="";
        String full_name="";
        String[] lineSplitted = new String[4];
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine())!=null){
                lineSplitted = line.split(" ");
                user_name = lineSplitted[0];
                user_password = lineSplitted[1];
                user_id=lineSplitted[2];
                full_name=lineSplitted[3];
                this.id_and_password.put(user_name,user_password);
                this.members.put(user_name,new Member(user_name,user_password,user_id,full_name));
            }
        }catch(IOException e){
            e.fillInStackTrace();
        }
    }



}
