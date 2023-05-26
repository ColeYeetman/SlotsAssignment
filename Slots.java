import java.util.Scanner;
public class Slots {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        // Declaring Variables
        int spin = 3;
        int spinDuration = 250;
        int[][] machine = new int[9][3];

        generateMachine(machine);
        printMachine(machine);

        System.out.println("\n");

        spin(spin, machine);

        printMachine(machine);

    }
    /**
     * Method to spin the numbers on the machine
     * @param spin Amount of times to spin
     * @param machine Machine with array of numbers to spin
     */
    public static void spin(int spin, int[][] machine){
        for (int i = 0; i < spin; i++){
            int temp = 0;
            for (int col = 0; col < machine[0].length; col++){
                temp = machine[0][col];
                for (int row = 0; row < machine.length -1; row++){
                    machine[row][col] = machine[row + 1][col];
                }
                machine[machine.length - 1][col] = temp;
            }
        }
    }
    /**
     * Method to generate a random array 9 x 3 for the slot machine with numbers between 1-9
     * @param machine 2D Array to be filled
     */
    public static void generateMachine(int[][] machine){
        for (int row = 0; row < machine.length; row++){
            for (int col = 0; col < machine[row].length; col++){
                machine[row][col] = (int) (Math.random() * 9 + 1);
            }
        }
    }
    /**
     * Method to print out a 2D Array
     * @param machine 2D array to be printed out
     */
    public static void printMachine(int[][] machine){
        for (int i = 0; i < machine.length; i++){
            for (int j = 0; j < machine[i].length; j++){
                System.out.print(machine[i][j]);
            }
            System.out.print("\n");
        }
    }
}
