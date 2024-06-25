/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;

import java.io.*;
import java.util.*;

public class BoardReader {
	void readFileForBoard(String filename, Board board) throws IOException {
		int[] positions = new int[General.NUM_POSITIONS];
		FileReader fis = new FileReader(filename);
		BufferedReader br = new BufferedReader(fis);
		String input = null;
		int index = 0;
		for (int row = 0; row < General.NUM_ROWS; row++) {
			if ((input = br.readLine()) == null)
				throw new IOException("Insufficient Lines");
			//System.out.println("Line: " + input);
			StringTokenizer st = new StringTokenizer(input, "|");
			for (int col = 0; col < General.NUM_COLS; col++) {
				if (!st.hasMoreTokens())
					throw new IOException("Insufficient Colums");
				String t = (String) st.nextElement();
				//System.out.println("Element is:"+t+":");
				int value = 0;
				t = t.trim();
				if (! (t.length() == 0)) {
						try {
						value = Integer.parseInt(t);
					} catch (NumberFormatException e) {
						throw new IOException("Error in digit on row " + row + " col " + col 
								+ " line is " + input);
					}
				}
				positions[index] = value;
				index++;
			}

		}
		board.setPositions(positions);
	}

}
