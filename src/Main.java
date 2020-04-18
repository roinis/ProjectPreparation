
import java.util.Date;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> teams = new LinkedList<>();
        teams.add("a");
        teams.add("b");
        teams.add("c");
        teams.add("d");
        teams.add("e");
        for (int i=0;i<2;i++){
            LinkedList<String> usedTeames=new LinkedList<>();
            while (teams.size()>0){
                String home=teams.removeFirst();
                for (String away:teams) {
                    String s = home + away;
                    System.out.println(s);
                }
                usedTeames.addFirst(home);
            }
            teams=usedTeames;
            System.out.println("////////////////");
        }
    }
}
