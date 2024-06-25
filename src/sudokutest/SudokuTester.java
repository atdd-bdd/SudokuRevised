/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudokutest;

import java.io.IOException;

public class SudokuTester
	{

	/**
	 * @param args
	 */
	public static void main(String[] args)
		{
//		if (args.length < 3)
//			{
//			System.out
//					.println("You must specify a class, a board test file, and a board solution file");
//			System.exit(0);
//
			args = new String[] {"sudoku.MyBoardSolver", "test1.sud", "solution1.sud",
					"test2.sud", "solution2.sud",
					"test3.sud", "solution3.sud"};
			String dir =System.getProperty("user.dir");
			System.out.println("Working Directory = " + dir);



			BoardSolver bs = null;
		String classname = args[0]; 
		try
			{
			
			Object o= Class.forName(classname).newInstance();
			if (o instanceof sudokutest.BoardSolver)
				{
				bs = (BoardSolver) o;
				} 
			else
				{
				System.out.println("Class " + classname + " is not instance of Board Solver");
				System.out.println("Class is " + o.getClass()); 
				System.exit(0);
				}
			}
		catch (InstantiationException e)
			{
			System.out.println("Instantiation Exception"); 
			System.exit(0);
			} 
		catch (IllegalAccessException e)
			{
			System.out.println("Illegal Access Exception"); 
			System.exit(0);
			}
			catch (ClassNotFoundException e)
			{
			// TODO Auto-generated catch block
			System.out.println("Unable to find class " + classname);
			System.exit(0);
			}
		int numberBoards = (args.length - 1) / 2;
		Board[] boards = new Board[numberBoards];
		Board[] solutions = new Board[numberBoards];
		BoardReader br = new BoardReader();
		int argCount = 1; 
		for (int i = 0; i < numberBoards; i++)
			{
			String name = args[argCount];
			String nameSolution = args[argCount + 1];
			argCount += 2; 
			boards[i] = new Board();
			solutions[i] = new Board(); 
			try
				{
				br.readFileForBoard(name, boards[i]);
				br.readFileForBoard(nameSolution, solutions[i]);
				boards[i].print();
				solutions[i].print();
				} 
			catch (IOException e)
				{
				System.out.println("Unable to read " + name + " or " + nameSolution);
				boards[i] = null; 
				solutions[i] = null;
				}
			}

		// Now all set up, do the test 
		test(bs, boards, solutions);
		}
	static void test(BoardSolver boardSolver, Board [] boards,
			Board [] solutions)
		{
		System.out.println("Starting test");
		System.gc();
		long startTime = System.currentTimeMillis();
		long startMemory = Runtime.getRuntime().freeMemory();
		for (int i = 0; i < boards.length; i++)
			{
			if (boards[i] == null)
				{
				System.out.println("Skipping board " + i);
				continue;
				}
			Board b = boardSolver.solve(boards[i]);
			if (b == null)
				System.out.println("Result board " + i + " unsolvable");
			else
				{
				if (!b.equals(solutions[i]))
					System.out.println("ERROR - Did not find solution board " + i);
				else
					System.out.println("Solved " + i); 
				}
			}
		long stopTime = System.currentTimeMillis();
		long millisecondsUsed = stopTime - startTime; 
		long stopMemory = Runtime.getRuntime().freeMemory();
		long memoryUsed = startMemory - stopMemory; 
				
		System.out.println("Ending test");
		System.out.println("Memory used " + memoryUsed);
		System.out.println("Milliseconds used " + millisecondsUsed); 
		
		}
	}
