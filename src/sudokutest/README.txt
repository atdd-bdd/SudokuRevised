SudokuTester 
SudokuTester requires at least three arguments:
	ClassName - class that implements sudokutester.BoardSolver 
		BoardSolver is 
		public interface BoardSolver
			{
			public Board solve(Board inBoard);
			// Return null if not solved 
			}
	InputBoard - nine lines of nine digits, digits separated by |
	SolutionBoard - same format as InputBoard and correct solution 
	
Supplied are three sets of InputBoard/SolutionBoard:
	test1.sud, solution1.sud - A solver should solve this 
	test2.sud, solution2.sud - A solver should always get this wrong
		The result in solution2.sud is incorrect 
	test3.sud, solution3.sud - A solver should not be able to solve this
		It is unsolvable 
	