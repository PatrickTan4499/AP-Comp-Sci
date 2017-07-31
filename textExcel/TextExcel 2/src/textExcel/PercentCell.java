package textExcel;

public class PercentCell extends RealCell {

	public PercentCell(String input) {
		super(input);
	}
	
	public double getDoubleValue(){
		String cellContents = getContent();
		//removes the percent sign at the end
		cellContents = cellContents.substring(0, cellContents.length()-1);
		//changes from string to a double to do calculation
		double answer = Double.parseDouble(cellContents);
		//divide by 100 to turn from percent to decimal value
		return answer/100;
	}
	
	public String abbreviatedCellText(){
		String cellContent = getContent();
		//test if it is a decimal equivalent of percent value
		if(cellContent.indexOf(".")!=-1){
			//adds a percent sign to the end of the cell content
			cellContent= cellContent.substring(0, cellContent.indexOf("."))+"%";
		}
		cellContent+="                    ";
		return cellContent.substring(0,10);
	}
	public String fullCellText(){
		//return decimal version of the percent cell content
		return ""+getDoubleValue();
	}

}
