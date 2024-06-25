/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudokutest;


public interface BoardSolver
	{
	public Board solve(Board inBoard);
		// Return null if not solved
	}
