import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Appliance {



    public boolean switchOn(boolean on){ return true; }

    public boolean switchOff(boolean on){ return false; }


    public int setTemperature() {
        int temperature = 0;
        boolean correctInput = false;
        while (correctInput == false) {
            try {
                System.out.println("Please enter a temperature as an integer between 80 - 250 degrees: \n");
                Scanner scanner = new Scanner(System.in);
                temperature = scanner.nextInt();
                if (temperature <= 79 || temperature >= 251) {
                    System.out.println("Please enter a number between 80 and 250!");
                    correctInput = false;
                } else {
                    correctInput = true;
                }
            } catch (InputMismatchException exception)
            //Add import java.util.InputMismatchException; at the top
            {
                System.out.println("Error - Please enter an integer");
            }
        }
        System.out.println("Temperature selected: " + temperature + "\n");
        return temperature;
    }

    public int setDegree() {
        int degree = 0;
        boolean correctInput = false;
        while (correctInput == false) {
            try {
                System.out.println("Enter either 20, 40, 60 or 80 degrees: \n");
                Scanner scanner = new Scanner(System.in);
                degree = scanner.nextInt();
                if (degree == 20 || degree == 40 || degree == 60 || degree == 80) {
                    correctInput = true;
                } else {
                    correctInput = false;
                }
            } catch (InputMismatchException exception)
            {
                System.out.println("Error - Please enter an integer");
            }
        }
        System.out.println("Temperature selected: " + degree +"\n");
        return degree;
    }

    class Timer implements Runnable{

        private boolean running;
        private int time = 0;

        //constructor
        public Timer() {
            boolean correctInput = false;
            int timeSelected = 0;
            while (correctInput == false) {
                try {
                    System.out.println("Set the timer between 10 & 14400 (4h) seconds: ");
                    Scanner scanner = new Scanner(System.in);
                    timeSelected = 1000 * scanner.nextInt();
                    if (timeSelected <= 9999 || timeSelected >= 1440001) {
                        System.out.println("Please Enter a valid time value");
                        correctInput = false;
                    } else {
                        correctInput = true;
                        time = timeSelected;
                    }
                } catch (InputMismatchException exception)
                {
                    System.out.println("Error - Please enter an integer");
                }
            }
            System.out.println("Timer set to " + timeSelected / 1000 + " seconds \n");
            running = false;
        }

        public boolean isRunning(){
            return  running;
        }

        public void checkTime(){
            if(isRunning()){
                System.out.println("Timer is at: "+ time/1000 + " seconds"); //modify after implementing decreasing version timer
            }
            System.out.println("Last set time: "+ time/1000 + " seconds");
        }

        @Override
        public void run() {
            try {
                running = true;
                while(time/1000>0){
                    time = time - 1000;
                    //System.out.println("Remaining: "+time/1000+" seconds");
                    Thread.sleep(1000L);
                    if(Thread.interrupted()){
                        System.out.println("TIMER INTERRUPTED");
                        running = false;
                    }
                }
                System.out.println("TIMER FINISHED, RING-RING!!");
                running = false;
            } catch (InterruptedException e) {
                System.out.println("TIMER INTERRUPTED");
                running = false;
            }
        }

    }

    // Automatic Timer
    class AutomaticTimer implements Runnable{

        private boolean running;
        private int time = 0;

        //constructor
        public AutomaticTimer(int presetTime){

            time = presetTime;
            running = false;
        }

        public boolean isRunning(){
            return  running;
        }

        public void checkTime(){
            if(isRunning()){
                System.out.println("Timer is at: "+ time/1000 + " seconds"); //modify after implementing decreasing version timer
            }
            System.out.println("Last set time: "+ time/1000 + " seconds");
        }

        public void checkPercentageCleaningRobot(){
            if(isRunning()){
                System.out.println("The battery has " + time/(72 * 1000) + "% remaining."); //modify after implementing decreasing version timer
            }
            System.out.println("The battery has " + (100 - time/(72 * 1000)) + " % charged.");
        }
        public void checkPercentageRoom(){
            System.out.println(time/(108 * 1000) + "% of the room still needs to be cleaned."); //modify after implementing decreasing version timer
        }

        @Override
        public void run() {
            try {
                running = true;
                Thread.sleep(time);
                running = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
