/*
 * Patrick Tan
 * 3/3/17
 * 1st period, AP Comp Sci
 * Spreadsheet - A class that implements part of the provided Grid interface, with correct implementations of the getRows() and getCols() 
 * and initialize a 2D array of cells with all elements containing EmptyCell objects.
 */		
package textExcel;
import java.io.*;
import java.util.Scanner;
public class Spreadsheet implements Grid
{
	//creates a 2D array of empty cells
private Cell[][] spreadsheet = new Cell[20][12];

public Spreadsheet(){
	//stores empty cells in the 2D array of cells
	for( int i = 0; i < 20; i++){
		for (int j = 0; j < 12; j++){
			spreadsheet[i][j] = new EmptyCell();
		}
	}
}
	@Override
	public String processCommand(String command)
	{
		//tests if blank command	
		if(command.equals("")){
			return "";
		}
		//splits the command at the spaces into an array 
		String[] CommandSplit = command.split(" ");
		//turns command to upperCase to avoid multiple case sensitive inputs
		CommandSplit[0] = CommandSplit[0].toUpperCase();
		
		//if save, save command
		if(CommandSplit[0].equals("SAVE")){
			return save(CommandSplit[1]);
		}
		//if open, run open method and store values in type of cell indicated
		if(CommandSplit[0].equals("OPEN")){
			try {
				return open(CommandSplit[1]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		//test if the input is a percent value
		if(command.charAt(command.length()-1)=='%'){
			SpreadsheetLocation location = new SpreadsheetLocation(CommandSplit[0]);
			//gets location of cell and turns it into a percent cell with given input
			spreadsheet[location.getRow()][location.getCol()] = new PercentCell(CommandSplit[2]);
			return getGridText();
		}
		//tests if the command is any form of 'clear'
		if(CommandSplit[0].length() == 5){
			//if clear, tests if it clears one cell or the entire spreadsheet
			if(CommandSplit.length > 1){
				SpreadsheetLocation indvCell = new SpreadsheetLocation(CommandSplit[1]);
				//gets the location of the cell they want to clear and sets that cell to an empty cell
				Cell clear = getCell(indvCell);
				clear = new EmptyCell();
				spreadsheet [indvCell.getRow()][indvCell.getCol()] = clear;
			}else{
				//sets the entire spreadsheet to empty cells to clear all cells
				for(int i = 0; i < 20; i++){
					for (int j = 0; j < 12; j++){
						spreadsheet[i][j] = new EmptyCell();
					}
				}			
			}
			return getGridText();			
		}
		//tests if it is an inspect command
		else if(CommandSplit.length == 1){		
			//gets cell location and returns the full text of that cell
			SpreadsheetLocation location = new SpreadsheetLocation(CommandSplit[0]);
			Cell inspect = getCell(location);
			return inspect.fullCellText();
		}
		//tests if the command is trying to enter input into an empty cell
		else if(CommandSplit[1].equals("=")){	
			//tests if the input is a string containing quotes
			if(CommandSplit[2].substring(0,1).equals("\"")==false){		
				SpreadsheetLocation location= new SpreadsheetLocation(CommandSplit[0]);
				//test to see if it is value input or formula input 
				if (CommandSplit.length==3){
					//if value input store the input into the cell indicated
					spreadsheet[location.getRow()][location.getCol()]=new ValueCell(CommandSplit[2]);
				}else{
					//if formula input, combine all split parts into one formula string and store in indicated cell
				String answer="";
				for(int i=2;i<CommandSplit.length;i++){
					if(i>=3){
						answer+=" ";
					}
						answer+=CommandSplit[i];	
					}
					spreadsheet[location.getRow()][location.getCol()]=new FormulaCell(answer, spreadsheet);	
				}
				return getGridText();
			}
			//gets location of the cell
			SpreadsheetLocation location = new SpreadsheetLocation(CommandSplit[0]);
				String answer = "";
				//since it is split at spaces, uses a for loop to store input into a string if the command enters input 
				for(int i = 2; i<CommandSplit.length; i++){
					if(i>=3){
						answer+=" ";
					}
					answer += CommandSplit[i];
				}
				//sets the cell at the location given to a text cell and sets its value to the text inputed
				spreadsheet [location.getRow()][location.getCol()] = new TextCell(answer);
			return getGridText();
		}
		//if blank command return blank
		return "";
	}

	@Override
	public int getRows()
	{
		// return number of rows in spreadsheet
		return 20;
	}

	@Override
	public int getCols()
	{
		// return number of columns in spreadsheet
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		//gets the integer value of the row and column and returns the cell at that location
		int row = loc.getRow();
		int col = loc.getCol();
		return spreadsheet[row][col];
	}

	@Override
	public String getGridText()
	{
		//prints the first line of the spreadsheet with the alphabet A-L
		String sheet = "   ";
		for(char letter='A'; letter<='L'; letter++){
			sheet += "|"+letter+"         ";
		}
		sheet += "|\n";
		//prints the left hand column 
		for(int i=0;i<20;i++){
			String number = (i+1) + "   ";
			sheet += number.substring(0, 3);
			//makes a 2D array of empty cells and adds them to the spreadsheet
			for(int j=0;j<12;j++){
				sheet += "|";
				String indvcells = spreadsheet[i][j].abbreviatedCellText();
				sheet += indvcells;
			}
			sheet += "|\n";	
		}
		return sheet;
	}
	
	public String open(String cell) throws FileNotFoundException{
		Scanner input = new Scanner(new File(cell));//directing where to find file
		//runs while there is still input
		while(input.hasNext()){
			String Input = input.nextLine();
			//splits input to get which file to open
			String[] fileDirector = Input.split(",");	
			//turns location to upper case to avoid lowercase letters and gets cell location
			fileDirector[0] = fileDirector[0].toUpperCase();
			SpreadsheetLocation location = new SpreadsheetLocation(fileDirector[0]);
			//tests for which kind of cell it is and turns the cell location to type of cell inputed with value it gives
			if(fileDirector[1].equals("TextCell")){
				spreadsheet[location.getRow()][location.getCol()] = new TextCell(fileDirector[2]);
			}
			if(fileDirector[1].equals("PercentCell")){
				//turns content of percent cell from a decimal to a percent
				double percent = Double.parseDouble(fileDirector[2]);
				percent *= 100;
				String percentString = percent + "%";
				spreadsheet[location.getRow()][location.getCol()] = new PercentCell(percentString);
			}
			if(fileDirector[1].equals("ValueCell")){
				spreadsheet[location.getRow()][location.getCol()] = new ValueCell(fileDirector[2]);
			}
			if(fileDirector[1].equals("FormulaCell")){
				spreadsheet[location.getRow()][location.getCol()] = new FormulaCell(fileDirector[2], spreadsheet);
			}
			
		}
		return getGridText();
	}
	
	public String save(String cell){
		String input="";
		//for loop to go through entire array looking for non empty cells
		for(int i=0;i<20;i++){
			for(char j='A';j<'M';j++){
				//stores location to be called later for cell contents
				Cell content = spreadsheet[i][j-'A'];
				//looks for non empty cells and saves the location, type of cell, and content of cell in a string if a non empty cell is found
				if(spreadsheet[i][j-'A'] instanceof FormulaCell){
					input += j + "" + (i+1) + ",FormulaCell," + content.fullCellText() + "\n";
				}
				if(spreadsheet[i][j-'A'] instanceof TextCell){
					input += j + "" + (i+1) + ",TextCell," + content.fullCellText() + "\n";
				}
				if(spreadsheet[i][j-'A'] instanceof ValueCell){
					//if content is 0.0, should save just 0 instead o 0.0
					if(Double.parseDouble(content.fullCellText()) == 0.0){
						input += j + "" + (i+1) + ",ValueCell," + "0" + "\n";
					}else{
						//stores content and value cell
					input += j + "" + (i+1) + ",ValueCell," + content.fullCellText() + "\n";
					}
				}
				if(spreadsheet[i][j-'A'] instanceof PercentCell){
					input += j + "" + (i+1) + ",PercentCell," + content.fullCellText() + "\n";
				}	
			}
		}			
		return input;
	}
}