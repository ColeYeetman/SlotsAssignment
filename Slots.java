import java.io.IOException;
import java.util.Scanner;

public class Slots {
    public static void main(String[] args) throws InterruptedException, IOException {
        //Runtime.getRuntime().exec("$OutputEncoding = [console]::InputEncoding = [console]::OutputEncoding = New-Object System.Text.UTF8Encoding");
        // Declaring Variables
        boolean won = false;
        int spin = 15;
        int tries = 300000;
        int[][] machine = new int[9][3];

        // Intro to game, rules, and amount of tries
        Utilities.clear();
        System.out.println(Utilities.colour("green", "---=== Ultimate Slots ===---"));
        System.out.println("💰How To Win: Create a Line of 3 \nin the 3x3 box highlighted in green\n");

        System.out.println("You Have [ " + Utilities.colour("red", "" + tries) + " ] tries\n");

        System.out.println("Press " + Utilities.colour("blue", "ENTER") + " to Play...");
        Utilities.promptEnter();

        // While loop to keep the user spinning the wheel until tries hit 0
        while (tries > 0) {
            Utilities.clear();

            // Calls to the generateMachine method to randomize the numbers in the 2D Array "machine"
            generateMachine(machine);

            System.out.println("\n");

            // This loop loops the spinning for the amount of spins ( So it looks more realistically spinning )
            for (int i = 0; i < spin; i++) {
                spin(machine);
                Thread.sleep(300);
                Utilities.clear();
                System.out.println("  ___________");
                System.out.println(" (           )");
                System.out.println(" |   Cole's  |");
                System.out.println(" | S L O T S |");
                System.out.println(" |           |");
                System.out.println(" (_.-------._)");
                printMachine(machine);
                System.out.println("  /         \\");
                System.out.println(" (___________)");
            }

            // End of Loop (Reset or GAME OVER)
            tries--;
            System.out.println("Spins Left " + tries + "\nPress ENTER to Spin Again");
            Utilities.promptEnter();

            // Checks to see if user won at each try at the end of the loop
            if (winCheck(machine)) {
                System.out.println("You Win!");
                tries = 0;
                won = true;
            }

        }

        // Checks to see if player lost at the end of the entire loop
        if (won == false) {
            System.out.println("\033[1mYou Lose :C");
        }

    }

    /**
     * Method to spin the numbers on the machine
     * 
     * @param spin    Amount of times to spin
     * @param machine Machine with array of numbers to spin
     */
    public static void spin(int[][] machine) {
        int temp = 0;
        for (int col = 0; col < machine[0].length; col++) {
            temp = machine[0][col];
            for (int row = 0; row < machine.length - 1; row++) {
                machine[row][col] = machine[row + 1][col];
            }
            machine[machine.length - 1][col] = temp;
        }
    }

    /**
     * Method to check if the user has won the game ex. Row up down, row left right,
     * row diagnol
     * 
     * @param machine Machine to be checked if player has won
     * @return true if player has won, false if player has lost
     */
    public static boolean winCheck(int[][] machine) {
        boolean result = false;
        Scanner in = new Scanner(System.in);
        if (machine[3][0] == machine[3][1] && machine[3][0] == machine[3][2]) {
            result = true;
        }
        else if (machine[4][0] == machine[4][1] && machine[4][0] == machine[4][2]) {
            result = true;
        }
        else if (machine[5][0] == machine[5][1] && machine[5][0] == machine[5][2]) {
            result = true;

        }
        else if (machine[3][0] == machine[4][0] && machine[3][0] == machine[5][0]) {
            result = true;
        }
        else if (machine[3][1] == machine[4][1] && machine[3][1] == machine[5][1]) {
            result = true;
        }
        else if (machine[3][2] == machine[4][2] && machine[3][2] == machine[5][2]) {
            result = true;
        }
        else if (machine[3][0] == machine[4][1] && machine[3][0] == machine[5][2]) {
            result = true;
        }
        else if (machine[3][2] == machine[4][1] && machine[3][2] == machine[5][0]) {
            result = true;
        }
        return result;
    }

    /**
     * Method to generate a random array 9 x 3 for the slot machine with numbers
     * between 1-9
     * 
     * @param machine 2D Array to be filled
     */
    public static void generateMachine(int[][] machine) {
        for (int row = 0; row < machine.length; row++) {
            for (int col = 0; col < machine[row].length; col++) {
                machine[row][col] = (int) (Math.random() * 9 + 1);
            }
        }
    }

    /**
     * Method to print out a 2D Array
     * 
     * @param machine 2D array to be printed out
     */
    public static void printMachine(int[][] machine) {
        for (int i = 0; i < machine.length; i++) {
            System.out.print("  | ");
            for (int j = 0; j < machine[i].length; j++) {
                // Adding Symbols ( did not work )
                if (machine[i][j] == 1){

                }
                if (machine[i][j] == 2){
                    
                }
                if (machine[i][j] == 3){
                    
                }
                if (machine[i][j] == 4){
                    
                }
                if (machine[i][j] == 5){
                    
                }
                if (machine[i][j] == 6){
                    
                }
                if (machine[i][j] == 7){
                    
                }
                if (machine[i][j] == 8){
                    
                }
                if (machine[i][j] == 9){
                    
                }
                if (i == 3 || i == 4 || i == 5) {
                    System.out.print(" " + Utilities.colour("green", "" + machine[i][j]));
                } else {
                    System.out.print(" " + machine[i][j]);
                }
            }
            System.out.print("  |");
            System.out.print("\n");
        }
    }
}
