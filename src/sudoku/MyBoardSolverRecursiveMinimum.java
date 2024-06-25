/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;

public class MyBoardSolverRecursiveMinimum extends MyBoardSolverRecursive
	{

	public MyBoardSolverRecursiveMinimum()
		{
		super();
		// TODO Auto-generated constructor stub
		for (int k = 0; k < tried_position.length; k++)
			{
			tried_position[k] = false;
			}
		}

	MyBoardSolverRecursive copy()
		{
		MyBoardSolverRecursiveMinimum newB = new MyBoardSolverRecursiveMinimum();
		super.copyInto(newB);
		System.arraycopy(this.tried_position, 0, newB.tried_position, 0,
				this.tried_position.length);
		return newB;
		}

	/*
	 * public MyBoardSolverRecursiveMinimum copy() {
	 * MyBoardSolverRecursiveMinimum newBSR = }
	 */

	public static final int DONE = General.NUM_POSITIONS;

	boolean[] tried_position = new boolean[General.NUM_POSITIONS];

	private int findNext()
		{
		// Find minimum (greater than 1
		int minimum = 100;
		for (int k = 0; k < positions.length; k++)
			{
			if (!tried_position[k])
				{
				int count = positions[k].getCountValues();
				if (count == 1)
					{
					tried_position[k] = true;
					return k;
					}
				if (count < minimum)
					{
					minimum = count;
					}
				}
			}
		// Found minimum greater than 0, then use that one
		for (int k = 0; k < positions.length; k++)
			{
			if (!tried_position[k])
				{
				int count = positions[k].getCountValues();
				if (count == minimum)
					{
					tried_position[k] = true;
					return k;
					}
				}
			}
		return MyBoardSolverRecursive.DONE;
		}

	public int getFirstIndex()
		{
		return findNext();
		}

	public int getNextIndex()
		{
		return findNext();
		}

	}
