package textExcel;

public class ValueCell extends RealCell {
private String content = "";
	public ValueCell(String input) {
		//call real cell constructor
			super(input);
			this.content = input;
	}
	public double getDoubleValue(){
		//gets the content of the cell and turns that value to a double
		String cellContent= getContent();
		double answer = Double.parseDouble(cellContent);
		return answer;
	}
	
	public String abbreviatedCellText(){
		//gets the content of the cell and test if it is an integer
		String cellContent = getDoubleValue()+"";
		if(cellContent.indexOf(".")==-1){
			//if it is an integer turn it into a double by adding .0 to the end
			cellContent+=(".0");
		}
		cellContent += "               ";
		//return the first ten indexes of the content of the cell
		return cellContent.substring(0,10);
	}
	public String fullCellText(){
		//gets the content of the cell
		String answer = getDoubleValue()+"";
		//test of the content is a decimal and if it was originally an integer and  .0 was added on
		if(answer.indexOf(".") == answer.length()-2 && answer.indexOf("0") == answer.length()-1 && content.contains(".") == false){
			//remove the .0 at the end since it was originally an integer
			answer = answer.substring(0, answer.length()-2);
		}
		return  answer;
	}

}
