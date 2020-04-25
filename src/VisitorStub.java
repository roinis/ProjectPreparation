//roei cohen

import java.util.HashSet;
import java.util.Random;

public class VisitorStub extends User2 {

    private String user_id_visitor;
    private static HashSet<Integer> id_numbers_visitor = new HashSet<>();

    public VisitorStub(){
        generateVisitorId();
    }

    public void generateVisitorId(){
        String name = "visitor";
        Random rand = new Random();
        int id_num = rand.nextInt(1000000);
        while(this.id_numbers_visitor.contains(id_num)){
            id_num=rand.nextInt(1000000);
        }
        this.id_numbers_visitor.add(id_num);
        String id = Integer.toString(id_num);
        id = name+id;
        this.user_id_visitor=id;
    }





}
