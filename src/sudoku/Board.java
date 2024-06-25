/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;
public class Board {
	private int [] positions = new int[General.NUM_POSITIONS];
	public void setPositions(int [] inPositions) throws BadFormatException
	{
		if (inPositions.length != General.NUM_POSITIONS)
			throw new BadFormatException("SetPositions input has "
					+ positions.length + " elements "); 
		System.arraycopy( inPositions, 0, this.positions, 0, positions.length);
	}
	public int [] getPositionsAsArray()
	{
		int [] retValue = new int[General.NUM_POSITIONS];
		System.arraycopy(positions, 0, retValue, 0, positions.length);
		return retValue; 
	}
	void print()
	{
		System.out.println("Board is");
		for (int row = 0; row < General.NUM_ROWS; row++) {
			System.out.println();
			for (int col = 0; col < General.NUM_COLS; col++) {
				int value = positions[row * General.NUM_COLS + col];
				if (value == 0)
					System.out.print(' ');
				else 
					System.out.print(value);
				System.out.print(General.SEPARATOR);
			}
		}
		System.out.println();	
	}
	public boolean equals(Object other)
	{
		if (other instanceof Board)
		{
			Board board = (Board) other;
			for (int k = 0; k < board.positions.length; k++)
			{
				if (this.positions[k] != board.positions[k])
					return false;
			}
			return true; 
		}
			
		else
			return false;
			
	}
	
	}
