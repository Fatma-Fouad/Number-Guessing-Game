import java.util.Scanner;

public class GuessTheNumber {
	
	public static int NumberOfGuesses(int i, int j) {
		return (int)(Math.log(j-i) / Math.log(2)) + 1;
	}
	
	public static int Number(int i, int j) {
		return (int)(Math.random()* (j - i + 1)) + i;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = 0;
		int z = 0;
		while(z == 0) {	
			System.out.println("To start the game, enter 2 integers indicating the range you want.");
			System.out.println("* Higher score is better.");
			int i = sc.nextInt();
			int j = sc.nextInt();
			System.out.println("Enter a number between " + i + " and " + j + ".");
			System.out.println("You have only " + NumberOfGuesses(i, j) + " guesses.");
			int x = Number(i, j);
			int y = sc.nextInt();
			while(y > j || y < i) {
				System.out.println("Error, number out of bounds. Enter another one.");
				y = sc.nextInt();
			}
			int count = NumberOfGuesses(i, j);
			while(y != x) {
				count--;
				if(count == 0) {
					System.out.println("Game over, you lost. You spend all of your guesses.");
					System.out.println("Your current score is " + (score+=count) + ". If you want to play another round enter 0.");
					System.out.println("If not enter 1 to end the game.");
					break;
				}
				if(y < x) {
					System.out.println("Enter a bigger number.");
					System.out.println("Number of guesses left is: " + count + ".");
				}else{
					System.out.println("Enter a smaller number.");
					System.out.println("Number of guesses left is: " + count + ".");
				}
				y = sc.nextInt();
				while(y > j || y < i) {
					System.out.println("Error, number out of bounds. Enter another one.");
					y = sc.nextInt();
				}
			}
			if(count > 0) {
				System.out.println("Congratulations, you won the game. You guessed the number correctly in " + (NumberOfGuesses(i, j)-count) + " guesses.");
				System.out.println("Your current score is " + (score+=count) + ". If you want to play another round enter 0.");
				System.out.println("If not enter 1 to end the game.");
			}
			z = sc.nextInt();
		}
		System.out.println("Game is over. Your final score is " + score + ".");
	}
}
