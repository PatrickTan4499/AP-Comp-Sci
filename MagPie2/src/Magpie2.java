
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String response = "";
		int trimResponse = statement.length();
		if( trimResponse == 0) {
			response = "Say something, please.";
		}
		if (statement.indexOf("no") >= 0) {
			response = "Why so negative?";
		} else if (statement.indexOf("Ms. Ronina") >= 0
				|| statement.indexOf("Ms. Dreyer") >= 0
				|| statement.indexOf("Ms. Louie") >= 0
				|| statement.indexOf("Mr. Phillips") >= 0) {
			response = "Tell me more about your teachers.";
		} else if(statement.indexOf("dad") >= 0){
		response = "Your dad is like a magician. He is never there.";
		} else if(statement.indexOf("monica") >= 0){
		response = "kill yourself";
		}else if(statement.indexOf("harambe") >=0 ){
			response = "He will be remembered.";
		}else{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if (whichResponse == 4) {
			response = "Who?";
		} else if (whichResponse == 5) {
			response = "I'm triggered.";
		}

		return response;
	}
}
