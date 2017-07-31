import java.io.*;
import java.util.*;
public class change {


	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(new File("src/File/input.txt"));
		double change = 0.0;
		double first = 0.0;
		double second = 0.0;
		first = input.nextDouble();
		while(input.hasNext()){
			second = input.nextDouble();
			change = second - first;
			System.out.println(first + " to " + second + ", " + "Change = " + change);
			first = second;
		}
		

	
	}
}
