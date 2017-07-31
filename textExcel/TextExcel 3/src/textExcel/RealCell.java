package textExcel;

public class RealCell implements Cell {
private String cell = "";
	public RealCell(String input) {
		//stores input for real cell in an instance variable
		this.cell = input;
	}

	@Override
	public String abbreviatedCellText() {
		//adds 10 spaces to the content of the real cell in case it is blank 
		String answer = this.cell + "          ";
		//returns the first 10 indexes in the string of the content 
		return answer.substring(0,10);
	}

	@Override
	public String fullCellText() {
		//returns the full text of the Real Cell
	return this.cell;
	}
	
	public String setContent(String input){
		//changes the content of the Real Cell
		this.cell = input;
		return this.cell;
	}
	
	public String getContent(){
		//returns the content of the Real Cell
		return this.cell;
	}
	public double getDoubleValue(){
			return 0;
	}
		

}
