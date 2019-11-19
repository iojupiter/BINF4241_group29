
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    private Oven oven = new Oven();

    private int menuType = -1;

    public void mainMenu(){


        ArrayList appliances = new ArrayList();
        appliances.add(oven);
        appliances.add("Microwave");

        System.out.println("###### MAIN MENU ######");
        System.out.println("Select an appliance:");
        for(int i=0;i<appliances.size();i++){
            System.out.println("["+i+"]"+ appliances.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        int userInput;

        do {
            userInput = scanner.nextInt();

        }while(userInput < 0 || userInput > 5);

        if (menuType == -1){
            if (userInput == 0){
                // call submenu of oven
                oven.cmd(-1);
            }
            else if (userInput == 1){
                // call submenu of microwave
            }
        }
        else {
            if (userInput == 0){
                oven.cmd(userInput);
            }
        }
        menuType = userInput;



        //print MAIN MENU
        //wait for u c
        //oven.cmd(-1);

    }

}
