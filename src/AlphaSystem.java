import java.util.Scanner;

public class AlphaSystem {
    private static AlphaDatabase DB;
    private static AlphaSystem system;
    private  AlphaSystem(){
        DB = new AlphaDatabase();
    }

    public static AlphaSystem  getSystem(){
        if(system==null) {
            system = new AlphaSystem();
        }
        return system;
    }

//
//    public static void EnterSystem() {
//        //Login LogIn = new Login();
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter username");
//        String userName = myObj.nextLine();  // Read user input
//        System.out.println("Enter Password");
//        String Password = myObj.nextLine();  // Read user input
//        //int usertype = LogIn.login(userName,Password);
//        int usertype = 1;
//        System.out.println("Welcome " + userName+"!");
//        switch (usertype){
//            case 0:{
//                System.out.println("You are currently logged in as a guest, please register to use the system's features.");
//                break;
//            }
//            case 1:{
//                System.out.println("Main Menu: sataaaasdaa");
//                System.out.println("");
//                break;
//            }
//            case 2:{
//                System.out.println("You are currently logged in as a guest, please register to use the system's features.");
//                break;
//            }
//            case 3:{
//                System.out.println("You are currently logged in as a guest, please register to use the system's features.");
//                break;
//            }
//        }
//    }


    /*
      Leagues;  //1
   Members; //2
    Coaches; //3
    Teams;  //4
   TeamManagers; //5
    TeamOwners; //6

     */
    public  Object GetSpecificFromDB(int Type, String Name)
    {
        return DB.Getspecific(Type,Name);
    }

    public  Object GetAllFromDB(int Type)
    {
        return DB.GetAll(Type);
    }

    public void AddtoDB(int Type, Object ToAdd)
    {
        DB.AddtoDB(Type,ToAdd);
    }
}
