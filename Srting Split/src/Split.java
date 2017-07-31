/*Patrick Tan
 * 10/27/16
 * 1st period APCS
 * String Split method to split a sandwich and return the contents within the sandwich
 */
public class Split 
{

	public static void main(String[] args) 
	{
			String test = bread("failbreadbread");
					System.out.println(test);
	}
		//String.split();
		//It's a method that acts on a string, <StringName>.split(<String sp>);
		//Where sp is the string where the string splits
		//And it returns an array
		// Example: "I like apples!".split(" "); 
		//		it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples"split("really")
		//		it will split at the word "really" and return an array of ["I "," like "," apples!"]
		
		//play around with String.split! what happens if you "I reallyreally like apples".split("really") ?
		
		
		//Your task:
		/* 
		 * What if it's a fancy sandwich with multiple pieces of bread?
		*/
	//part 1
	public static String bread(String string)
	{
		String[] parts = string.split("bread");	
		int breadCount=0;
		String contents = "";
		String testForBread=string;  //makes a extra variable to test for # of pieces of bread
		String emptySandwitch=string.substring(string.indexOf("bread"));
		emptySandwitch=emptySandwitch.replace("bread", "");  //use to test if there is anything between two pieces of bread
		while(testForBread.indexOf("bread")!=-1){
			int index=testForBread.indexOf("bread");
			testForBread=testForBread.substring(index+4);
			breadCount++;  //test for # of pieces of bread and stores the # of bread found
		}
			if(breadCount >= 2){
				if(emptySandwitch.equals("")){
					contents = "not a sandwich";
				}
				else{
					for(int i=2; i < parts.length; i++){  //returns what is in between pieces of bread
						contents += parts[i-1];
					}
				if(string.endsWith("bread")){
					contents+=parts[parts.length-1];
				}
			}
			}else{
				contents = "not a sandwich";  //if less than 2 pieces of bread then it is NAS
			}
			if(contents.equals("")){
				contents = "not a sandwich";  //exception for "breadbreadxy" and "xybreadbread"
			}
				
			return contents;
	}
		//Your task pt 2:
		/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
		 * use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		 * Again, what if it's a fancy sandwich with multiple pieces of bread?
		*/
//part 2 
	public static String bread2(String string){
		
		String[] parts=string.split(" "); //takes out all the and separates into array
		String part1String="";
		for(int i=0;i<parts.length;i++){
			part1String+=parts[i];			// puts all the parts together into one long string to put into part 1 method
		}
		String contents =bread(part1String);
		return contents;
	}
		

					

}
