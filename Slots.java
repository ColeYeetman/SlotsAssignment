import java.util.Scanner;

public class Slots {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int spin = 10;
        int spinDuration = 250;
        int[][] machine = new int[9][3];

        generateMachine(machine);
        printMachine(machine);

    }
    public static void spin(int spin, int[][] machine, int spinDuration){
        int temp = 0;
    }
    public static void generateMachine(int[][] machine){
        for (int row = 0; row < machine.length; row++){
            for (int col = 0; col < machine[row].length; col++){
                machine[row][col] = (int) (Math.random() * 9 + 1);
            }
        }
    }
    public static void printMachine(int[][] machine){
        for (int i = 0; i < machine.length; i++){
            for (int j = 0; j < machine[i].length; j++){
                System.out.print(machine[i][j]);
            }
            System.out.print("\n");
        }
    }
}
