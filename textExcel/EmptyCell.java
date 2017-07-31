/*
 * Patrick Tan
 * 3/3/17
 * 1st period, AP Comp Sci
 * EmptyCell - A class that implements the provided Cell interface, and represents an empty cell.
 */		
package textExcel;

public class EmptyCell implements Cell {

	public EmptyCell() {
		//OMG ITS EMPTY :OOOOOOO
	}

	@Override
	public String abbreviatedCellText() {
		//return 10 spaces
		return "          ";
	}

	@Override
	public String fullCellText() {
		//return an empty string
		return "";
	}

}
