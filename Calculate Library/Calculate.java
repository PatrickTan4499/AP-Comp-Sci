/**
 * 
 */

/**
 * @author patricktan
 *9/24/16
 *1st period AP Comp Sci
 *Math Library Part 1-4
 *implements a bunch of methods to do math functions
 */
public class Calculate {
	// PART 1
	public static int square(int number){		//takes the square of a number
		int answer;
		answer = (number * number);
		return answer;
	}
	
	public static int cube(int number){			//takes the cube of a number
		int answer;
		answer = (number * number * number);
		return answer;
	}
	
	public static double average(double number1, double number2){		// takes the average of two doubles
		double answer;
		answer = (number1 + number2)/ 2;
		return answer;
	}
	
	public static double average(double number1, double number2, double number3){		//takes the average of 3 doubles
		double answer;
		answer = (number1 + number2 + number3) / 3.0;
		return answer;
	}
	
	public static double toDegrees(double radian){		//converts from radians to degrees
		double answer;
		answer = (radian * 180 / 3.14159);
		return answer;
	}
	
	public static double toRadians(double degree){		//converts from degrees to radians
		double answer;
		answer = (degree * 3.14159 / 180);
		return answer;
	}
	
	public static double discriminant(double numA, double numB, double numC){		//finds the discriminant with the coefficients of a quadratic formula
		double answer;
		answer = ((numB * numB) - (4 * numA * numC));
		return answer;
	}
	
	public static String toImproperFrac(int wholeNum, int numerator, int denominator){		// converts a mixed number to an improper fraction
		if (denominator == 0){
			throw new IllegalArgumentException("you cannot divide by 0");
		}
		int answer;
		answer =  denominator * wholeNum + numerator;
		return (answer + "/" + denominator);
	}
	
	public static String toMixedNum(int improperFrac, int denominator){		//converts an improper fraction to a mixed number
		if(denominator == 0){
			throw new IllegalArgumentException("can't divide by 0");
		}
		int wholeNum = improperFrac / denominator;
		int numerator = improperFrac % denominator;
		if(numerator == 0){
			return(wholeNum + "");
		}
		return (wholeNum + "_" + numerator + "/" + denominator);
	}
	
	public static String foil(int numA, int numB, int numC, int numD, String n){		//converts a binomial multiplication form to a quadratic equation
		int letterA = numA * numC;
		int letterB = numC * numB + numA * numD;
		int letterC = numB * numD;
		
		return(letterA + n + "^2 + " + letterB + n + " + " + letterC);
	}
	// PART 2
	
	public static boolean isDivisibleBy(int num1, int num2){		//determines whether or not one integer is evenly divisible by another
		if(num2 == 0){
			throw new IllegalArgumentException("a number divided by 0 is undefined");
		}
		if (num1 % num2 > 0){
			return false;
		}else{
			return true;
		}
	}
	
	public static double absValue(double number){		//returns absolute value of a number
		if (number <= 0.0){
			number = number * (-1);
			return number;	
		}else{
			return number;
		}				
	}
	
	public static int max(int num1, int num2){		//returns the larger of 2 values passed
		if(num1 == num2){
			throw new IllegalArgumentException("the two numbers are equal to each other");
		}
		if (num1 > num2){
			return num1;
		}else{
			return num2;
		}
	}
	
	public static double max (double num1, double num2, double num3){		//returns the larger of 3 values passed
       if((num1 == num2) || (num1 == num3) || (num2 == num3)){
    	   throw new IllegalArgumentException("two or more numbers equal each other");
       }
		int maximum = Calculate.max((int) num1, (int)num2);
            if (maximum > num3){
                return(maximum);
            }else{
                return(num3);
        }
    }
	
	public static int min(int num1, int num2){		//returns the smaller of 2 values passed
		if(num1 == num2){
			throw new IllegalArgumentException("the two numbers are the same");
		}
		if (num1 > num2){
			return num2;
		}else{
			return num1;
		}
	}
	
	public static double round2(double num1){ // Rounds a large decimal to 2 places
		if (num1 >= 0){
			num1 = num1 * 100;
			num1 += .5;
			num1 = (int)num1;
			return (num1/100);
		}else{
			num1 = num1 * 100;
			num1 -= .5;
			num1 = (int)num1;
			return (num1/100);		
		}
	}

	// Part 3 
	
	public static double exponent(double base, int power){		//raises a value to a positive integer power
		if(power < 0){
			throw new IllegalArgumentException("does not take a negative exponent");
		}
		  double answer = 1.0;		
		  if (power == 0){
				return (1);
		  }
			for (int k = 1; k <= power; k++){
				answer *= base;
			}
			return(answer);
		}

	public static int factorial(int num1){		//returns the factorial of a number passed
		if(num1 < 0){
			throw new IllegalArgumentException("can't get the factorial of a negative number");
		}
	    int fact = 1; 
	    for(int i = 1; i <= num1; i++){
	    	fact *= i;
	    }
	        return fact;
	}
			
	public static boolean isPrime(int number){		//determines whether or not an integer is prime
		if(number < 2){
			throw new IllegalArgumentException("prime numbers must be greater than 2");
		}
			boolean check;
			for (int k = number - 1; k > 1; k--){
				check = Calculate.isDivisibleBy(number, k);
				if(check == true){
					return(false);
				}
			}
			return(true);		
		}
		
	public static int gcf(int num1, int num2){		// finds the greatest common factor of two integers
		if(num2 == 0){
			throw new IllegalArgumentException("can't take the greatest common factor of 0");
		}
	      int gcf=1;
	        for(int i=1;i<=num1;i++){
	            if(isDivisibleBy(num1,i) && isDivisibleBy(num2,i)){
	                gcf=i;
	            }
	        }
	        return(gcf);
	    }
		
	public static double sqrt(double num){		//rounds a number to 2 decimal places
        if (num<0){
            throw new IllegalArgumentException("Cannot take the square root of a negative number");
        }
        double y;
        double sqrt = num / 2;
        do {
            y = sqrt;
            sqrt = (y + num/y)/2;
        } while ((y-sqrt) != 0);
        return Calculate.round2(sqrt);
	}

	// Part 4
	
    public static String quadForm(int a, int b, int c){  // Takes 3 integers and plugs them into the quadratic formula
        double root1;
        double root2;
        int discrim = (int) Calculate.discriminant(a, b, c);
        if (discrim < 0){
            return ("no real roots");
        }
        if (discrim == 0){
            root1 = b * (-1) / (2 * a);
            root1 = Calculate.round2(root1);
            return ("The root is: " + root1);
        }
        if (discrim > 0){
            root1 = (b * (-1) + sqrt(discrim)) / (2 * a);
            root1 = Calculate.round2(root1);
            root2 = (b * (-1) - sqrt(discrim)) / (2 * a);
            root2 = Calculate.round2(root2);
            double min = Calculate.min((int) root1, (int) root2);
            double max = Calculate.max((int) root1, (int) root2);
            return ("The roots are: " + min + " and " + max);
        }
        return ("");
	}
}



	