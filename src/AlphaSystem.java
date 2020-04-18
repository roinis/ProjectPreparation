import java.util.Scanner;

public class AlphaSystem {

    public void EnterSystem() {
        //Login LogIn = new Login();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
        String userName = myObj.nextLine();  // Read user input
        System.out.println("Enter Password");
        String Password = myObj.nextLine();  // Read user input
        //int usertype = LogIn.login(userName,Password);
        int usertype = 1;
        System.out.println("Welcome " + userName+"!");
        switch (usertype){
            case 0:{
                System.out.println("You are currently logged in as a guest, please register to use the system's features.");
                break;
            }
            case 1:{
                System.out.println("Main Menu: sataaaasdaa");
                System.out.println("");
                break;
            }
            case 2:{
                System.out.println("You are currently logged in as a guest, please register to use the system's features.");
                break;
            }
            case 3:{
                System.out.println("You are currently logged in as a guest, please register to use the system's features.");
                break;
            }
        }
    }
}
