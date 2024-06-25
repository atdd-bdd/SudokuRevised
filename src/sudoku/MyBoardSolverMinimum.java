/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;

import sudokutest.Board;
import sudokutest.BoardSolver;

public class MyBoardSolverMinimum implements BoardSolver
	{
	public Board solve(Board inBoard)
		{
		MyBoardSolverRecursiveMinimum mbsr = new MyBoardSolverRecursiveMinimum();
		if (!mbsr.setInitialValues(inBoard.getPositionsAsArray()))
			return null;
		int startIndex = mbsr.getFirstIndex();
		try
			{
			MyBoardSolverRecursive.testBoard(mbsr, startIndex);
			} catch (BoardSolvedCondition e)
			{
			return e.solution;
			}
		return null;
		}
	}
