import java.util.*;
public class acslLand {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//create 2 players from player object class made
		Player player1 = new Player();
		Player player2 = new Player();
		//stores input in a string
		String moves = input.nextLine();
		String answer1;
		String answer2;
		//parses the input at commas to get the individual numbers
			String []parsedMoves = moves.split(",");
			//turns the string array of individual numbers(the dice rolls) into array of integers 
			int [] indvRolls=new int[parsedMoves.length];
			for(int i=0; i<indvRolls.length; i++){
				indvRolls[i]=Integer.parseInt(parsedMoves[i]);
			}
			//goes through every index(dice roll) of the array and moves the player according to each roll
			for(int i=0; indvRolls[i] != 0; i++){
				//if i is even then player A goes else player B goes. allows for rotating turns
				if(i % 2 == 0){
					player1.setPosition(indvRolls[i]);
					//if one player lands on the same position as the other, the other player gets a penalty and gets sent back
					if(player1.getPosition() == player2.getPosition()){
					player2.punishment();
					}
				}
				if(i %2 != 0){
					player2.setPosition(indvRolls[i]);
					if(player1.getPosition() == player2.getPosition()){
					player1.punishment();
					}			
				}
				//ends the loop(game) when one player reaches the end
				if(player1.getPosition() > 39 || player2.getPosition() > 39){
					indvRolls[i+1] = 0;
				}
		}
			//if one player reaches the end, return their position as "END" instead of 40; otherwise, return their position
			if(player1.getPosition() >= 39){
				answer1 = "END";
			}else{
			answer1 = player1.getPosition() + "";
			}
			if(player2.getPosition() >= 39){
				answer2 = "END";
			}else{
			answer2 = player2.getPosition() + "";
			}
			//print out the position of both players
		System.out.print("A-" + answer1 + " B-" + answer2);
		
	}
}

