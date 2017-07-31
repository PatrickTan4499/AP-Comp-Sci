/*
 * @author Patrick Tan
 * date: 9/29/16
 * period: 1st period
 * Program description:
 * write a program called ProcessingNumbers that does the following
 * 1) Accepts as user input a string of numbers.
 * 2) Prints the smallest and largest of all the numbers supplied by the user.
 * 3) Print the sum of all the even numbers the user typed, along with the largest even number typed.
 */
import java.util.*;
public class processingNumbers {

	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
		int totalSum = 0;
		int nextNum;
		int min;
		int max;
		int evenMax;
		System.out.print("How many numbers would you like to enter? ");
		int totalNum = userInput.nextInt();
		System.out.println();
		System.out.print("What is your first even number?"); // assumes they will have 1 even number to set a starting point to test for max even number
		nextNum = userInput.nextInt();
		totalSum = nextNum;
		evenMax = nextNum;
		min = nextNum;				//sets max to an initial number so i could compare it with other numbers
		max = nextNum;				/*allows me to use negative numbers or i could have assigned min and max to 0
									if it was assumed that all values were positive*/
		for(int i=1; i<=totalNum; i++){
			System.out.println("Enter the next number: ");
			nextNum = userInput.nextInt();
			if(nextNum >= max){
				max = nextNum;
			}
			if(nextNum <= min){
				min = nextNum;
			}
			if(nextNum % 2 == 0){
				totalSum += nextNum;
				if(nextNum >= evenMax){
					evenMax = nextNum;	
				}
			}
		}
		System.out.println("The max number is: " + max);
		System.out.println("The min number is: " + min);
		System.out.println("The total of all even numbers is: " + totalSum);
		System.out.println("The max even number is: " + evenMax);
		userInput.close();
	}

}
