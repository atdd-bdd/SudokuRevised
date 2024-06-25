/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;

import sudokutest.Board;
import sudokutest.BoardSolver;
import junit.framework.TestCase;

public class BoardSolverTest extends TestCase
	{

	/*
	 * Test method for 'sudoku.BoardSolver.solve(Board)'
	 */
	public final void testSolve()
		{
		int[] originalValues = { 0, 6, 0, 1, 0, 4, 0, 5, 0, 0, 0, 8, 3, 0, 5,
				6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 8, 0, 0, 4, 0, 7, 0, 0, 6,
				0, 0, 6, 0, 0, 0, 3, 0, 0, 7, 0, 0, 9, 0, 1, 0, 0, 4, 5, 0, 0,
				0, 0, 0, 0, 0, 2, 0, 0, 7, 2, 0, 6, 9, 0, 0, 0, 4, 0, 5, 0, 8,
				0, 7, 0, };

		int[] solutionValues = { 9, 6, 3, 1, 7, 4, 2, 5, 8, 1, 7, 8, 3, 2, 5,
				6, 4, 9, 2, 5, 4, 6, 8, 9, 7, 3, 1, 8, 2, 1, 4, 3, 7, 5, 9, 6,
				4, 9, 6, 8, 5, 2, 3, 1, 7, 7, 3, 5, 9, 6, 1, 8, 2, 4, 5, 8, 9,
				7, 1, 3, 4, 6, 2, 3, 1, 7, 2, 4, 6, 9, 8, 5, 6, 4, 2, 5, 9, 8,
				1, 7, 3, };
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
