/*
 * Patrick Tan
 * 12/4/16
 * 1st period
 * FracCalc
 * create a fractional calculator that can add,divide,multiply,subtract fractions and reduce the answer as far as possible
 */		
package fracCalc;
import java.util.*;
public class FracCalc {
	public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in);
    	while(input.next() != "quit"){				
    	//keeps calls produce answer while the input is not quit
    	produceAnswer(input.next());
    	}
input.close();
    }    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	//splits the input at blank spaces to get the 2 operands and operator and stores it into string array
    	String[] parts = input.split(" ");
    	String answer = "";
    	String Operand1 = parts[0];
    	String Operator = parts[1];
    	String Operand2 = parts[2];
    	//error handling, if the input has multiple operators like "++" it will return an error message
    	if(Operator.length() != 1){
    		throw new IllegalArgumentException("input is in a invalid format");
    	}
    	//splits both operands to get the whole number numerator and denominator and then calls toImproperFrac to change these values into the numerator and denominator of an improper fraction
    	int[] op1 = componentsOfOperand(Operand1);
    	int[] op2 = componentsOfOperand(Operand2);
    	//error handling, tests if denominator is zero and returns error message if it is
    	if(op1[2]  == 0){
    		throw new IllegalArgumentException("cannot divide by zero");
    	}
    	if(op2[2]  == 0){
    		throw new IllegalArgumentException("cannot divide by zero");
    	}
    	int[] impropOp1 = toImproperFrac(op1[0], op1[1], op1[2]);	
    	int[] impropOp2 = toImproperFrac(op2[0], op2[1], op2[2]);	  
    	//searches for which operator is being used and calls a certain method depending on the operation
    	if(Operator.equals("+")){
    		answer = add(impropOp1[0], impropOp1[1], impropOp2[0], impropOp2[1], "+");
    	}else if (Operator.equals("-")){
    		answer = add(impropOp1[0], impropOp1[1], impropOp2[0], impropOp2[1], "-");
    	} else if (Operator.equals("*")){
    		answer = multiply(impropOp1[0], impropOp1[1], impropOp2[0], impropOp2[1]);
    	} else{
    		answer = divide(impropOp1[0], impropOp1[1], impropOp2[0], impropOp2[1]);
    	}
    	//reduces the fraction as far as possible and tests if it can be turned into a mixed number, if yes then convert to a mixed number
    	answer = Simplify(answer);
    	int [] simp = componentsOfOperand(answer);
    	if(simp[1] != 0 && Math.abs(simp[2]) > Math.abs(simp[1])){
    		return answer;
    	}
    	answer =toMixedNum(simp[1], simp[2]); 
    	return answer;
    } 
    // TODO: Fill in the space below with any helper methods that you think you will need 
   // checkpoint 2
    public static int[] componentsOfOperand(String Operand){
    int[] parts = new int[3];
    parts[2] = 1;
    if(Operand.contains("_")){
    		//splits at "_" get get whole number and fraction and then splits at "/" to get numerator and denominator
    		String[] components = Operand.split("_");
    		//turns whole number from string to integer and stores it in array 
    		int wholeNumber = Integer.parseInt(components[0]);			
    		parts[0] = wholeNumber;
    		String fraction = components[1];
    		String[] fractionComponents = fraction.split("/");
    		//turns numerator and denominator from string to integer and stores it in array
    		int numerator = Integer.parseInt(fractionComponents[0]);			
    		int denominator = Integer.parseInt(fractionComponents[1]);
    		parts[1] = numerator;
    		parts[2] = denominator;
    }else if(!Operand.contains("_") && Operand.contains("/")) {
    		// if no whole number then dont store anything in whole number and split at "/" for numerator and denominator, change them from string to int and store in array
    		String[] splitFrac = Operand.split("/");
    		int numerator = Integer.parseInt(splitFrac[0]);
    		int denominator = Integer.parseInt(splitFrac[1]);
    		parts[1] = numerator;
    		parts[2] = denominator;
    } else{
    	//if it is blank or just a integer and not a fraction then it stores it into whole number 
    	 String[] blank = Operand.split(" ");
    	 int number = Integer.parseInt(blank[0]);
    	 parts[0] = number;
    }
    return parts;
    }
   // checkpoint 3
public static String add(int Numerator1, int Denominator1, int Numerator2, int Denominator2, String operator){
	String answer;
	int numerator = 0;
	//default denominator to 1 so its not 0
	int denominator = 1; 
	//multiply both denominators for common factors so the fractions can be added
	denominator = Denominator1 * Denominator2;
	//tests if the operator is add or subtract to know whether to add or subtract the numerators for the new numerator
	if(operator == "+"){
	//b/c the denominators got multiplied i also have to multiply the numerators by denominators of opposite fractions to add or subtract the numerators
	numerator = (Numerator1 * Denominator2) + (Numerator2 * Denominator1);
	}else{
		numerator = (Numerator1 * Denominator2) - (Numerator2 * Denominator1);
	}
	answer = numerator + "/" + denominator;
	return answer;	
}
public static String multiply(int Numerator1, int Denominator1, int Numerator2, int Denominator2){
	String answer;
	int numerator = 0;
	int denominator = 1;
	//multiplies across so denominator multiplies with denominator for new denominator and numerator multiplies with numerator for new numerator then converts to a string
	denominator = Denominator1 * Denominator2;
	numerator = Numerator1 * Numerator2;
	answer = numerator + "/" + denominator;
	return answer;	
}
public static String divide(int Numerator1, int Denominator1, int Numerator2, int Denominator2){
	String answer;
	int reciprocalNum = 0;
	int reciprocalDenom = 1;
	//finds the reciprocal of 2nd operand and then multiplies the two operands by calling multiply 
	reciprocalNum = Denominator2;
	reciprocalDenom = Numerator2;
	answer = multiply(Numerator1, Denominator1, reciprocalNum, reciprocalDenom);
	return answer;	
}
public static int[] toImproperFrac(int wholeNum, int numerator, int denominator){		
	// converts a mixed number to an improper fraction
	int [] answer = new int[2];
	if(wholeNum < 0){
		//if whole number is negative, change it to positive before creating the new numerator with calculations and then change it back to negative
		answer[0] = denominator * (wholeNum * -1) + numerator;
		answer[0] = answer[0] * -1;
	}else{
		answer[0] =  denominator * wholeNum + numerator;
		}
	answer[1] = denominator;
	return answer;
}
//finishing touches
public static String Simplify(String unreducedFraction){
	String answer = "";
	int [] parse = componentsOfOperand(unreducedFraction);
	int greatestCommonFactor = 1;
	int newNumerator = 0;
	int newDenominator = 1;
	//finds gcf of numerator and denominator and then divides them by gcf for new numerator and denominator
	greatestCommonFactor = gcf(parse[1], parse[2]);				
	newNumerator = parse[1] / greatestCommonFactor;
	newDenominator = parse[2] / greatestCommonFactor;
	//takes out negative in the fraction which should be in the whole number and returns a string
	if (newDenominator < 0 && newNumerator > 0){			
		newNumerator = newNumerator * -1;
		newDenominator = newDenominator * -1;
	}
	answer = newNumerator + "/" + newDenominator;
	return answer;
}
public static int gcf(int num1, int num2){		
	// finds the greatest common factor of two integers
	int gcf=1;
        for(int i=1;i<=Math.abs(num2);i++){
        	//if both nums are divisible by i then set i to gcf and keep checking
            if(isDivisibleBy(num1,i) && isDivisibleBy(num2,i)){  
                gcf=i;
            }
        }
        return(gcf);
    }
public static boolean isDivisibleBy(int num1, int num2){		
	//determines whether or not one integer is evenly divisible by another
	if (num1 % num2 == 0){
		return true;						
	}else{
		return false;
	}
}
public static String toMixedNum(int numerator, int denominator){		
	//converts an improper fraction to a mixed number
	String answer;
	//whole number is the numerator divided by the denominator and the new numerator is the remainder of that calculation
	int wholeNum = numerator / denominator;
	int Newnumerator = numerator % denominator;
	if(Newnumerator == 0){	
		//returns whole number only if numerator is 0
		return(wholeNum + "");
	}
	if(Newnumerator < 0){
		Newnumerator = Newnumerator * -1; 			
		//removes negative from numerator and denominator if they are negative b/c whole number should be negative and not the fraction
	}
	if(denominator < 0){
		denominator = denominator *-1;
	}
	answer = Newnumerator + "/" + denominator;
	//calls simplify to simplify the fractional part of the mixed number 
	answer = Simplify(answer);						
	//if there is no whole number, only return the fractional part
	if(wholeNum == 0){
		return answer;
	}	
	return (wholeNum + "_" + answer);
}
}