
public class Player {
	private int cell=0;
	
	//constructor, all players start at position 0
	public Player(){
		this.cell = 0;
	}
	
	//changes the position of the player depending on the roll
	public void setPosition(int roll){
		if(roll == 4 || roll == 6){
			this.cell -= roll;
		}else{
			this.cell += roll;
		}
		//if they have to move backwards past the start, set their position to the start instead of a negative position
		if(this.cell < 0 ){
			this.cell = 0;
		}
	}
	//gives punishment by sending player back to the start
	public void punishment(){
		this.cell = 0;
	}
	//returns the position of the player
	public int getPosition(){
		return this.cell;
	}
}
