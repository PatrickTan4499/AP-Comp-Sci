/*
 * Patrick Tan
 * 3/3/17
 * 1st period, AP Comp Sci
 * SpreadsheetLocation - A class that fully implements the Location interface, and contains a constructor taking a single String parametere
 */		
package textExcel;

public class SpreadsheetLocation implements Location
{
	private int row;
	private int col;
    @Override
    public int getRow()
    {
        //return the int value of the row
        return row;
    }
    @Override
    public int getCol()
    {
        //return the int value of the column 
        return col;
    } 
    public SpreadsheetLocation(String cellName)
    {
        //turns the integer value of the row from a string to an integer 	
    	this.row = Integer.parseInt(cellName.substring(1))-1;
    	//stores the integer value of the letter in the row location value   
    	char column = Character.toUpperCase(cellName.charAt(0));
    	this.col = column - 'A';
    }

}
