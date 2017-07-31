import java.util.Scanner;
public class classWork {


    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in);
    	produceAnswer(input.next());
input.close();
    }
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] parts = input.split(" ");
    	String Operand1 = parts[0];
    	String Operator = parts[1];
    	String Operand2 = parts[2];
    	return parts[2];      
    }

}
