/*
 * Patrick Tan
 * 3/3/17
 * 1st period, AP Comp Sci
 * TextExcel - A class with a main method that constructs a Spreadsheet, and has the command loop 
 * (reading commands, calling  the spreadsheet’s processCommand method to process each line of 
 * input, printing the String returned from processCommand, repeating until “quit” is read).
 */		
package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

// Update this file with your own code.
public class TextExcel
{
	public static void main(String[] args)
	{
		//create a spreadsheet
		Spreadsheet Spreadsheet = new Spreadsheet();
		//scanner for command inputs 
		Scanner input = new Scanner(System.in);
		String command = input.nextLine();
		//for loop processes Commands until user inputs 'quit'
    	while(input.next() != "quit"){	
    		Spreadsheet.processCommand(command);
			command = input.nextLine();
		}
	}
}
