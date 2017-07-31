package textExcel;

public class FormulaCell extends RealCell{

	private Cell[][] spreadsheet = new Cell[20][12];
	
	public FormulaCell(String input, Cell[][] sheet) {
		//calls super constructor to store input in an instance variable(cell)
		super(input);
		this.spreadsheet = sheet;
	}
	
	public double getDoubleValue(){
		//splits content of the cell at spaces to get individual operators and operands
		String[] operands = fullCellText().split(" ");
		if(operands[1].toUpperCase() == ("SUM") || operands[1].toUpperCase() == ("AVG")){
			int sum = 0;
			int avg = 0;
			operands[2] = operands[2].toUpperCase();
			String[] intervals = operands[2].split("-");
			int start = Integer.parseInt(intervals[0].substring(1));
			int end = Integer.parseInt(intervals[1].substring(1));
			char lastCol = intervals[1].charAt(0);
				for(char firstCol = intervals[0].charAt(0); firstCol<=lastCol; firstCol++){
					for(int row = start; row<=end; row++){
						String loc = Character.toString(firstCol)+row;
						SpreadsheetLocation location = new SpreadsheetLocation(loc);
						System.out.println(spreadsheet[location.getRow()][location.getCol()].fullCellText());
						sum += Double.parseDouble(spreadsheet[location.getRow()][location.getCol()].fullCellText());
						avg++;
					}
				if(operands[1].toUpperCase() == ("SUM")){
					return sum;
				}else{
					return sum/avg;
				}
			}	
		}
		//store first number in answer as a double 
		double answer = 0.0;
		double performOperation = 0.0;
		if(Character.isLetter(operands[1].charAt(0))){
			SpreadsheetLocation loc = new SpreadsheetLocation(operands[1]);
			answer = Double.parseDouble(spreadsheet[loc.getRow()][loc.getCol()].fullCellText());;
		} else{
			answer = Double.parseDouble(operands[1]);
		}
		//for loop going through the array and performing operations on every other index so it skips the operators
		for(int i = 3; i< operands.length; i+=2){
			if(Character.isLetter(operands[i].charAt(0))){
				System.out.println(operands[i]);
				SpreadsheetLocation location = new SpreadsheetLocation(operands[i]);
				//System.out.println(spreadsheet[location.getRow()][location.getCol()].fullCellText() + "rrr");
				performOperation = Double.parseDouble(spreadsheet[location.getRow()][location.getCol()].fullCellText());;
			}else{
			//temporarily stores number at certain index as a double to add onto the answer later
			performOperation = Double.parseDouble(operands[i]);
			}
			//looking for sign of operator to perform operation
			if(operands[i-1].equals("+")){
				answer += performOperation;
			}
			if(operands[i-1].equals("-")){
				answer -= performOperation;
			}
			if(operands[i-1].equals("*")){
				answer *= performOperation;
			}
			if(operands[i-1].equals("/")){
				answer /= performOperation;
				
			}
			
		}
		return answer;
		
	}
	public String abbreviatedCellText(){
		//return first 10 indexes simplified formula(performed math operations)
		String content = getDoubleValue() + ""; 
		content += "           ";
		return content.substring(0, 10);
	}


}
