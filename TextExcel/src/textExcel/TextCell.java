package textExcel;

public class TextCell implements Cell {
	private String cell = "";
	public TextCell(String cell) {
		this.cell = cell;
	}

	@Override
	public String abbreviatedCellText() {
		String answer = "";
		//removes quotations at beginning and end of the text cell
		if(cell.length() > 1){
			answer = cell.substring(1, cell.length()-1);
		}
		//adds 10 spaces in case cell is empty
		answer+="          ";
		//returns the first 10 letters/indexes of the text cell
		return answer.substring(0,10);
	}

	@Override
	public String fullCellText() {
		//returns the full text of the text cell
		return cell;
	}

}
