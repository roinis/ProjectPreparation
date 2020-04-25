//roei cohen

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    public boolean editInformation(int type,String user_name,String changed_detail){//1 - change user name|2 - change password|3 - change ID number |4 - change full name
        File users_file = new File("src//users.txt");
        File jobs_file = new File("src//jobs.txt");
        HashMap<String,String[]> users_information = new HashMap<>();
        HashMap<String,String[]> jobs_information = new HashMap<>();
        try{
            BufferedReader br_users = new BufferedReader(new FileReader(users_file));
            BufferedReader br_jobs = new BufferedReader(new FileReader(jobs_file));
            String line = "";
            String[] details;
            String new_line = "";
            while((line=br_users.readLine())!=null){
                String[] tmp_line = line.split(" ");
                users_information.put(tmp_line[0],(Arrays.copyOfRange(tmp_line,1,tmp_line.length)));
            }
            while((line = br_jobs.readLine())!=null){
                String [] tmp_line = line.split(" ");
                jobs_information.put(tmp_line[0],(Arrays.copyOfRange(tmp_line,1,tmp_line.length)));
            }
            if(!users_information.containsKey(user_name))
                return false;
            else{
                switch(type){
                    case 1://change user name
                        //change in users.txt
                        details = users_information.remove(user_name);
                        users_information.put(changed_detail,details);
                        PrintWriter users_pw = new PrintWriter(users_file);
                        users_pw.print("");
                        for(String user_name_hash:users_information.keySet()){
                            new_line = new_line+user_name_hash + " "+String.join(" ",users_information.get(user_name_hash))+"\n";
                        }
                        users_pw.print(new_line);
                        users_pw.close();
                        //change in jobs.txt
                        if(!jobs_information.containsKey(user_name)) {
                            break;
                        }
                        details = jobs_information.remove(user_name);
                        jobs_information.put(changed_detail,details);
                        PrintWriter jobs_pw = new PrintWriter(jobs_file);
                        jobs_pw.print("");
                        new_line = "";
                        for(String user_name_hash:jobs_information.keySet()){
                            new_line = new_line+user_name_hash + " "+String.join(" ",jobs_information.get(user_name_hash))+"\n";
                        }
                        jobs_pw.print(new_line);
                        jobs_pw.close();
                        break;
                    case 2://change password
                        PrintWriter password_pw = new PrintWriter(users_file);
                        password_pw.print("");
                        details = users_information.remove(user_name);
                        details[0] = changed_detail;
                        users_information.put(user_name,details);
                        for(String user_name_hash:users_information.keySet()){
                            new_line = new_line+user_name_hash + " "+String.join(" ",users_information.get(user_name_hash))+"\n";
                        }
                        password_pw.print(new_line);
                        password_pw.close();
                        break;
                    case 3://change ID Number
                        PrintWriter id_pw = new PrintWriter(users_file);
                        id_pw.print("");
                        details = users_information.remove(user_name);
                        details[1] = changed_detail;
                        users_information.put(user_name,details);
                        for(String user_name_hash:users_information.keySet()){
                            new_line = new_line+user_name_hash + " "+String.join(" ",users_information.get(user_name_hash))+"\n";

                        }
                        id_pw.print(new_line);
                        id_pw.close();
                        break;
                    case 4://change full name
                        PrintWriter full_name_pw = new PrintWriter(users_file);
                        full_name_pw.print("");
                        details = users_information.remove(user_name);
                        details[2] = combineFullName(changed_detail);
                        users_information.put(user_name,details);
                        for(String user_name_hash:users_information.keySet()){
                            new_line = new_line+user_name_hash + " "+String.join(" ",users_information.get(user_name_hash))+"\n";
                        }
                        full_name_pw.print(new_line);
                        full_name_pw.close();
                        break;
                }
            }
        }catch(IOException e){
            e.fillInStackTrace();
        }
        return true;
    }

    private void readMembersInformation(){
        id_and_password = new HashMap<>();
        members = new HashMap<>();
        File file = new File("src//users.txt");
        String line = "";
        String user_name="";
        String user_password="";
        String user_id="";
        String full_name="";
        String[] lineSplitted = new String[4];
        List<Member> membersList = (List<Member>) AlphaSystem.getSystem().GetAllFromDB(2);
        for(Member member:membersList){
            members.put(member.getUser_name(),member);
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine())!=null){
                lineSplitted = line.split(" ");
                user_name = lineSplitted[0];
                user_password = lineSplitted[1];
                user_id=lineSplitted[2];
                full_name=String.join(" ",lineSplitted[3].split("_"));
                this.id_and_password.put(user_name,user_password);
                if(!members.containsKey(user_name)) {
                    Member new_member = new Member(user_name, user_password, user_id, full_name);
                    this.members.put(user_name, new_member);
                    AlphaSystem.getSystem().AddtoDB(2,new_member);
                }
            }
        }catch(IOException e){
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



}
