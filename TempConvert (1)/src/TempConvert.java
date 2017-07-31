/**
 * 
 */

/**
 * @author patricktan
 *date: 8/31/16
 *TempConvert Fahrenheit to Celcius
 */
public class TempConvert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*I'm not sure if you want celcius to be rounded or with exact decimals 
		 * for example 67 fahrenheit is actually 17.7777 in celcius but we normally read it as just 18
		 * I'm using double instead of int. 
		 */
		int fahrenheit = (32);					
		double celcius;
		double constant = (0.555555555556);
		celcius = (fahrenheit-32) * constant;
		System.out.print(fahrenheit + "° F is equal to ");
		System.out.println(celcius + "° C");
		
		
		fahrenheit = (64);
		celcius = (fahrenheit-32) * constant;
		System.out.print(fahrenheit + "° F is equal to ");
		System.out.println(celcius + "° C");
		
		fahrenheit = (420);
		celcius = (fahrenheit-32) * constant;
		System.out.print(fahrenheit + "° F is equal to ");
		System.out.println(celcius + "° C");
		

	}

}

