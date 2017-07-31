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
		 * for example 69 fahrenheit is actually 38.333333 in celcius but I just left it as 38 because 
		 * I'm using int instead of double. 
		 */
		int fahrenheit = (-32);					
		int celcius;
		celcius = fahrenheit * (5/9);
		System.out.print(fahrenheit + " ° fahrenheit is equal to ");
		System.out.println(celcius + " ° celcius");
		
		
		fahrenheit = (69);
		celcius = (fahrenheit * 5/9);
		System.out.print(fahrenheit + " ° fahrenheit is equal to ");
		System.out.println(celcius + " ° celcius");
		
		fahrenheit = (420);
		celcius = (fahrenheit * 5/9);
		System.out.print(fahrenheit + " ° fahrenheit is equal to ");
		System.out.println(celcius + " ° celcius");
		

	}

}
