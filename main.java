import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean cli_status = true;
		Scanner input = new Scanner(System.in);

		while (cli_status) {
			System.out.println("command: ")
			String command = input.nextLine();
			switch(input) {
				case "print2":
					System.out.println("test");
					break;
				case "print":
					System.out.println("print");
					break;
				case "exit":
					cli_status = false;
					System.out.println("Successfully Exited!");
					break;
			}	
		}
	}
}
