//roei cohen

import java.io.*;
import java.util.Arrays;
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
                        users_pw.close();
                        BufferedWriter users_bw = new BufferedWriter(new FileWriter(users_file,true));
                        for(String user_name_hash:users_information.keySet()){
                            new_line = user_name_hash + " "+String.join(" ",users_information.get(user_name_hash));
                            users_bw.write(new_line);
                        }
                        users_bw.close();
                        //change in jobs.txt
                        if(!jobs_information.containsKey(user_name))
                            return false;
                        details = jobs_information.remove(user_name);
                        jobs_information.put(changed_detail,details);
                        PrintWriter jobs_pw = new PrintWriter(users_file);
                        jobs_pw.print("");
                        jobs_pw.close();
                        BufferedWriter jobs_bw = new BufferedWriter(new FileWriter(jobs_file,true));
                        for(String user_name_hash:jobs_information.keySet()){
                            new_line = user_name_hash + " "+String.join(" ",jobs_information.get(user_name_hash));
                            jobs_bw.write(new_line);
                        }
                        jobs_bw.close();
                    case 2://change password
                        PrintWriter password_pw = new PrintWriter(users_file);
                        password_pw.print("");
                        password_pw.close();
                        details = users_information.remove(user_name);
                        details[1] = changed_detail;
                        users_information.put(user_name,details);
                        BufferedWriter password_bw = new BufferedWriter(new FileWriter(users_file,true));
                        for(String user_name_hash:users_information.keySet()){
                            new_line = user_name_hash + " "+String.join(" ",users_information.get(user_name_hash));
                            password_bw.write(new_line);
                        }
                    case 3://change ID Number
                        PrintWriter id_pw = new PrintWriter(users_file);
                        id_pw.print("");
                        id_pw.close();
                        details = users_information.remove(user_name);
                        details[2] = changed_detail;
                        users_information.put(user_name,details);
                        BufferedWriter id_bw = new BufferedWriter(new FileWriter(users_file,true));
                        for(String user_name_hash:users_information.keySet()){
                            new_line = user_name_hash + " "+String.join(" ",users_information.get(user_name_hash));
                            id_bw.write(new_line);
                        }
                    case 4://change full name
                        PrintWriter full_name_pw = new PrintWriter(users_file);
                        full_name_pw.print("");
                        full_name_pw.close();
                        details = users_information.remove(user_name);
                        details[3] = combineFullName(changed_detail);
                        users_information.put(user_name,details);
                        BufferedWriter full_name_bw = new BufferedWriter(new FileWriter(users_file,true));
                        for(String user_name_hash:users_information.keySet()){
                            new_line = user_name_hash + " "+String.join(" ",users_information.get(user_name_hash));
                            full_name_bw.write(new_line);
                        }
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
