import java.util.Scanner;

public class Utilities {

	public static void main(String[] args){
		prn(colour("yellow", "Welcome to Utilities!"));
	}

	public static void clear(){
		System.out.print("\033[H\033[2J");
	}

	public static void promptEnter(){
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
		System.out.println("Press ENTER To Continue");
		System.out.print("\033[H\033[2J");
	}

    public static <T> void prn(T thing) {
		System.out.println(thing);
	}

    public static int randomInt(int low, int high) {
		return (int) ((high - low + 1) * Math.random() + low);
	}

	public static String fancify(String string){
		return "_..--==^^** " + string + " **^^==--.._";
	}

	public static String colour(String colour, String string){
		if (colour.equals("red") || colour.equals("Red")){
			return "\u001B[31m" + string + "\u001B[0m";
		}
		if (colour.equals("green") || colour.equals("Green")){
			return "\u001B[32m" + string + "\u001B[0m";
		}
		if (colour.equals("yellow") || colour.equals("Yellow")){
			return "\u001B[33m" + string + "\u001B[0m";
		}
		if (colour.equals("blue") || colour.equals("Blue")){
			return "\u001B[34m" + string + "\u001B[0m";
		}
		if (colour.equals("purple") || colour.equals("Purple")){
			return "\u001B[35m" + string + "\u001B[0m";
		}
		if (colour.equals("cyan") || colour.equals("Cyan")){
			return "\u001B[36m" + string + "\u001B[0m";
		}
		return string;
	}

	public static void repeatPrint(String string, int times){
		for (int i = 0; i < times; i++){
			System.out.print(string);
		}
	}
}
