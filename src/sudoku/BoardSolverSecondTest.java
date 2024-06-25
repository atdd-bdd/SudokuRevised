/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;

import sudokutest.Board;
import sudokutest.BoardSolver;
import junit.framework.TestCase;

public class BoardSolverSecondTest extends TestCase
	{

	/*
	 * Test method for 'sudoku.BoardSolver.solve(Board)'
	 */
	public final void testSolve()
		{
		int[] originalValues = { 3, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 5, 1, 0, 8,
				0, 3, 0, 8, 0, 0, 0, 0, 0, 1, 2, 4, 4, 3, 0, 8, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 8, 6, 5, 9, 6,
				0, 0, 0, 0, 0, 1, 0, 4, 0, 2, 0, 9, 3, 0, 0, 0, 0, 0, 0, 0, 1,
				8, 0, 9,

		};

		int[] solutionValues = { 3, 1, 4, 6, 2, 7, 5, 9, 8, 9, 2, 5, 1, 4, 8,
				6, 3, 7, 8, 6, 7, 9, 5, 5, 1, 2, 4, 4, 3, 1, 8, 9, 6, 7, 5, 2,
				6, 8, 9, 5, 7, 2, 4, 1, 3, 7, 5, 2, 3, 1, 4, 9, 8, 6, 5, 9, 6,
				7, 8, 3, 2, 4, 1, 1, 4, 8, 2, 6, 9, 3, 7, 5, 2, 7, 3, 4, 5, 1,
				8, 6, 9,

		};
		Board original = new Board();
		original.setPositions(originalValues);
		Board solution = new Board();
		solution.setPositions(solutionValues);
		BoardSolver boardSolver = new MyBoardSolver();
		Board computedSolution = boardSolver.solve(original);
		assertEquals("Board solution should be equal", computedSolution,
				solution);
		}

	}
