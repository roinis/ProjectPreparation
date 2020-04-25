import java.util.Scanner;

public class Stadium {

    private String stadiumName;
    private String city;

    public Stadium(String stadiumName, String city){
        this.stadiumName=stadiumName;
        this.city=city;
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(11,this);
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public String getCity(){
        return city;
    }

    public void editDetails() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("please choose a new name");
        String input=scanner.nextLine();
        setStadiumName(input);
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

}
