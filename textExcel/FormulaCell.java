package textExcel;

public class FormulaCell extends RealCell{

	private Cell[][] spreadsheet = new Cell[20][12];
	
	public FormulaCell(String input, Cell[][] sheet) {
		//calls super constructor to store input in an instance variable(cell)
		super(input);
		//import entire spreadsheet to use getDoubleValue of cell locations
		this.spreadsheet = sheet;
	}
	
	public double getDoubleValue(){
		//split formula cell into individual operands and into two cell locations if it is a SUM or AVG processCommand
		String[] operands = fullCellText().split(" ");
		String[] baka = operands[2].split("-");
		//add ( to make sure it splits properly later
		String newFormulaString = "( ";
		String total = "( ";
		double answer;
		//counter 
		int avg = 0;
		//if sum or average, create a long string with all locations to be converted to double values and add up later
		if (operands[1].toUpperCase().equals("SUM") || operands[1].toUpperCase().equals("AVG")){
			//get first letter of first cell and compare to first letter of second cell
			for (char col = baka[0].toUpperCase().charAt(0); col <= baka[1].toUpperCase().charAt(0); col++){
				//get row of first cell and compare to row of second cell
				for (int row = Integer.parseInt(baka[0].substring(1)); row <= Integer.parseInt(baka[1].substring(1)); row++){
					//format to the syntax of a formula cell so it can be used later
					if (row < Integer.parseInt(baka[1].substring(1))){
						newFormulaString += (col + "" +  row + " + ");
					}else if(col == baka[1].toUpperCase().charAt(0) && row == Integer.parseInt(baka[1].substring(1))){
						newFormulaString += (col + "" + row + " )");
					}else{
						newFormulaString += (col + "" + row + " + ");
					}
					//add one to counter for each cell in the 2D array
					avg++;
				}
			}
			//split the new string created and get the double values of each cell location and add up to total
			String[] gorilla = newFormulaString.split(" ");
			for (int i = 1; i < gorilla.length - 1; i += 2){
				if (Character.isLetter(gorilla[i].toUpperCase().charAt(0))){
					SpreadsheetLocation loc = new SpreadsheetLocation(gorilla[i]);
					gorilla[i] = "" + ((RealCell) spreadsheet[loc.getRow()][loc.getCol()]).getDoubleValue();
				}
				total += (gorilla[i] + " " + gorilla[i+1] + " ");
			}
			// if processCommand is not SUM or AVG then go through array & test for cell locations and return their double values and add up to total
		}else{
			for (int i = 1; i < operands.length - 1; i += 2){
				if (Character.isLetter(operands[i].toUpperCase().charAt(0))){
					//if it is a cell location, store the location
					SpreadsheetLocation loc = new SpreadsheetLocation(operands[i]);
					//use location to get double value of that cell
					operands[i] = "" +((RealCell) spreadsheet[loc.getRow()][loc.getCol()]).getDoubleValue();
				}
				total += (operands[i] + " " + operands[i+1] + " ");
			}
		}
		//split final string to perform all operations for the answer
		String[] performOP = total.split(" ");
		//store first value in answer
		answer = Double.parseDouble(performOP[1]);
		//goes through array and tests the operator to perform operation indicated and add up to the final answer
		for (int i = 2; i < performOP.length-2; i += 2){
			//test for operator
			if (performOP[i].equals("+")){
				//take double value operands and sum for final answer
	        	answer += Double.parseDouble(performOP[i+1]);
	        }else if(performOP[i].equals("-")){
	        	answer -= Double.parseDouble(performOP[i+1]);
	        }else if(performOP[i].equals("*")){
	        	answer *= Double.parseDouble(performOP[i+1]);
	        }else if(performOP[i].equals("/")){
	        	answer /= Double.parseDouble(performOP[i+1]);
	        }
		}
		//if average, take total answer and divide by counter(number of cells)
		if (operands[1].toUpperCase().equals("AVG")){
			return answer/avg;
		}
		//return total
		return answer;
	}
	
	public String abbreviatedCellText(){
		//return first 10 indexes simplified formula(performed math operations)
		String content = getDoubleValue() + ""; 
		content += "           ";
		return content.substring(0, 10);
	}
}