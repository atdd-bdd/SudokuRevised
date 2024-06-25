/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;

import java.io.*;

import sudokutest.Board;
import sudokutest.BoardReader;
import sudokutest.BoardSolver;

public class Main
	{

	/**
	 * @param args
	 */
	public static void main(String[] args)
		{
		Board board = new Board();
		BoardReader reader = new BoardReader();
		BoardSolver boardSolver = new MyBoardSolverMinimum();
		System.out.println("Using " + boardSolver.getClass());
		String dir =System.getProperty("user.dir");
		System.out.println("Working Directory = " + dir);

//			String filename = args[0];
			String filename = dir + "/" + "test1.sud";
		System.out.println("Reading " + filename);

		try
			{
			reader.readFileForBoard(filename, board);
			board.print();
			long startTime = System.currentTimeMillis();
			Board result = boardSolver.solve(board);
			if (result != null)
				{
				long endTime = System.currentTimeMillis();
				long difference = endTime - startTime;
				System.out.println("Solved in milliseconds " + difference);
				result.print();
				} else
				System.out.println("Puzzle not solvable");
			} catch (IOException e)
			{
			System.out.println("***ERROR****\n" + e);
			}

		}

	}
