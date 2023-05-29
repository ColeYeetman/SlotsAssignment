import java.util.Scanner;

public class Slots {
    public static void main(String[] args) throws InterruptedException {
        Scanner keyboard = new Scanner(System.in);

        boolean won = false;
        int spin = 15;
        int tries = 3;
        int[][] machine = new int[9][3];

        Utilities.clear();
        System.out.println("---=== Ultimate Slots ===---");
        System.out.println("How To Win: Create a Line of 3 \nin the 3x3 box highlighted in green\n");

        System.out.println("You Have [ " + tries + " ] tries\n");

        System.out.println("Press ENTER to Play...");
        Utilities.promptEnter();

        while (tries > 0) {
            Utilities.clear();
            generateMachine(machine);

            System.out.println("\n");

            for (int i = 0; i < spin; i++) {
                spin(machine);
                Thread.sleep(300);
                Utilities.clear();
                System.out.println("__.-------.__");
                printMachine(machine);
                System.out.println("--._______.--");
            }

            tries--;
            System.out.println("Spins Left " + tries + "\nPress ENTER to Spin Again");
            Utilities.promptEnter();

            if (winCheck(machine, tries)){
                System.out.println("You Win!");
            }

        }
        if (won == false){
            System.out.println("You Lose :C");
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

    public static boolean winCheck(int[][] machine, int tries) {
        boolean result = false;
        if (machine[3][0] == machine[3][1] && machine[3][0] == machine[3][2]) {
            result = true;
            tries = 0;
        }
        if (machine[4][0] == machine[4][1] && machine[3][0] == machine[4][2]) {
            result = true;
            tries = 0;
        }
        if (machine[5][0] == machine[5][1] && machine[5][0] == machine[5][2]) {
            result = true;
            tries = 0;
        }
        if (machine[3][0] == machine[4][0] && machine[3][0] == machine[5][0]) {
            result = true;
            tries = 0;
        }
        if (machine[3][1] == machine[4][1] && machine[3][1] == machine[5][1]) {
            result = true;
            tries = 0;
        }
        if (machine[3][2] == machine[4][2] && machine[3][2] == machine[5][2]) {
            result = true;
            tries = 0;
        }
        if (machine[3][0] == machine[4][1] && machine[3][0] == machine[5][2]) {
            result = true;
            tries = 0;
        }
        if (machine[3][2] == machine[4][1] && machine[3][2] == machine[5][0]) {
            result = true;
            tries = 0;
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
            System.out.print("  |");
            for (int j = 0; j < machine[i].length; j++) {
                if (i == 3 || i == 4 || i == 5) {
                    System.out.print(" " + Utilities.colour("green", "" + machine[i][j]));
                } else {
                    System.out.print(" " + machine[i][j]);
                }
            }
            System.out.print(" |");
            System.out.print("\n");
        }
    }
}
