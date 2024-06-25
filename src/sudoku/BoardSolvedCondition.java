/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;

import sudokutest.Board;

public class BoardSolvedCondition extends Exception {
	static final long serialVersionUID = -1;
	Board solution = null;
	public BoardSolvedCondition(Board solution) {
		super();
		this.solution = solution; 
	}


}
