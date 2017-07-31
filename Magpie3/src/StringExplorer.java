
public class StringExplorer {

	public static void main(String[] args) {
		String sample = "The brown quick fox jumped over the lazy dog.";

		// Demonstrate the indexOf method.			//using one parameter looks for quick throughout the whole string but with 2 parameters we pick the starting point from which to search
		int position = sample.indexOf("quick", 11);  //looks for the word quick after the index of 11 but returns -1 because quick starts at index of 10 so it can find quick fromIndex 11
		System.out.println("sample.indexOf(\"quick\") = " + position);

		// Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println("sample.toLowerCase() = " + lowerCase);
		System.out.println("After toLowerCase(), sample = " + sample);

		// Try other methods here:
		int notFoundPsn = sample.indexOf("slow");

		 System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);
	}

}
