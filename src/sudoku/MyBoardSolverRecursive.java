/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;

import sudokutest.Board;

public class MyBoardSolverRecursive
	{
	protected Position[] positions = new Position[General.NUM_POSITIONS];

	MyBoardSolverRecursive copy()
		{
		MyBoardSolverRecursive newB = new MyBoardSolverRecursive();
		copyInto(newB);
		return newB;
		}

	void copyInto(MyBoardSolverRecursive mbsr)
		{
		for (int i = 0; i < mbsr.positions.length; i++)
			{
			mbsr.positions[i] = Position.copy(this.positions[i]);
			}
		mbsr.currentIndex = this.currentIndex;

		}

	public MyBoardSolverRecursive()
		{
		for (int i = 0; i < positions.length; i++)
			{
			positions[i] = new Position();
			}
		}

	boolean setInitialValues(int[] input)
		{

		for (int i = 0; i < positions.length; i++)
			{
			positions[i].setInitialValue(input[i]);
			int which_row = i / General.NUM_COLS;
			int which_col = i % General.NUM_ROWS;
			int which_box = which_boxes[i];
			positions[i].setupCompare(i, rows[which_row], columns[which_col],
					boxes[which_box]);
			}
		for (int i = 0; i < positions.length; i++)
			{
			if (positions[i].getCountValues() == 1)
				{
				int value = positions[i].getCurrentValue();
				if (!eliminateValues(i, value))
					{
					System.out.println("BAD BOARD - Cannot solve");
					return false;
					}
				}
			}
		// this.printPotentialValues();
		return true;
		}

	void print()
		{
		System.out.println("Recursive Board is");
		for (int row = 0; row < General.NUM_ROWS; row++)
			{
			System.out.println();
			for (int col = 0; col < General.NUM_COLS; col++)
				{
				System.out.print(positions[row * General.NUM_COLS + col]);
				System.out.print(General.SEPARATOR);
				}
			}
		System.out.println();
		}

	int[] getPositionsAsArray()
		{
		int[] result = new int[positions.length];
		for (int i = 0; i < positions.length; i++)
			{
			result[i] = positions[i].getCurrentValue();
			}
		return result;

		}

	static MyBoardSolverRecursive testBoard(MyBoardSolverRecursive inBoard,
			int index) throws BoardSolvedCondition
		{
		// Recursive method terminating condition
		if (index >= MyBoardSolverRecursive.DONE)
			{
			Board result = new Board();
			result.setPositions(inBoard.getPositionsAsArray());
			throw new BoardSolvedCondition(result);
			}
		// System.out.println("Doing index " + index + " count "
		// + inBoard.positions[index].getCountValues());
		// inBoard.positions[index].print();
		// System.out.println("");
		if (inBoard.positions[index].getCountValues() == 0)
			{
			// System.out.println("No choices");
			return null;
			}
		if (inBoard.positions[index].getCountValues() == 1)
			{
			MyBoardSolverRecursive newBoard = inBoard.copy();
			int value = inBoard.positions[index].getCurrentValue();
			// System.out.println("Index " + index + " remains at " + value);
			if (newBoard.eliminateValues(index, value))
				{
				// newBoard.print();
				MyBoardSolverRecursive ret_board = testBoard(newBoard, newBoard
						.getNextIndex());
				return ret_board;
				} else
				{
				// inBoard.printPotentialValues();
				// System.out.println("CURRENT BOARD NOT SOLUTION");
				return null;
				}
			}
		for (int i = 0; i < inBoard.positions[index].getCountValues(); i++)
			{
			int value = inBoard.positions[index].getNextValue();
			// System.out.println("Setting index " + index + " to " + value);
			MyBoardSolverRecursive newBoard = inBoard.copy();
			if (newBoard.eliminateValues(index, value))
				{
				newBoard.positions[index].setToNextValue();
				// newBoard.print();
				MyBoardSolverRecursive ret_board = testBoard(newBoard, newBoard
						.getNextIndex());
				if (ret_board == null)
					continue;
				} else
				{
				// inBoard.printPotentialValues();
				// System.out.println("BOARD NOT SOLUTION");
				continue;
				}
			}
		// System.out.println("NO SOLUTION FOR THIS BOARD");
		return null;
		}

	boolean eliminateValues(int index, int value)
		{
		// System.out.println("Eliminating values for index " + index + " value
		// "
		// + value);
		for (int k = 0; k < General.NUM_TO_COMPARE; k++)
			{
			int pos = this.positions[index].comparingPositionIndexes[k];
			if (!this.positions[pos].eliminateValue(value))
				{
				// System.out.println("***** Cannot turn off " + pos
				// + " for value " + value + " ");
				// positions[pos].print();
				// System.out.println();
				return false;
				}
			}
		return true;
		}

	void printPotentialValues()
		{
		for (int k = 0; k < positions.length; k++)
			{
			System.out.print("Index " + k + " ");
			positions[k].print();
			System.out.println("");
			}
		}

	private int currentIndex = 0;

	public static final int DONE = General.NUM_POSITIONS;

	public int getFirstIndex()
		{
		currentIndex = 0;
		return currentIndex;
		}

	private int getNextIndex()
		{
		currentIndex++;
		return currentIndex;
		}

	private static int[][] rows = { { 0, 1, 2, 3, 4, 5, 6, 7, 8 },
			{ 9, 10, 11, 12, 13, 14, 15, 16, 17 },
			{ 18, 19, 20, 21, 22, 23, 24, 25, 26 },
			{ 27, 28, 29, 30, 31, 32, 33, 34, 35 },
			{ 36, 37, 38, 39, 40, 41, 42, 43, 44 },
			{ 45, 46, 47, 48, 49, 50, 51, 52, 53 },
			{ 54, 55, 56, 57, 58, 59, 60, 61, 62 },
			{ 63, 64, 65, 66, 67, 68, 69, 70, 71 },
			{ 72, 73, 74, 75, 76, 77, 78, 79, 80 }, };

	private static int[][] columns = { { 0, 9, 18, 27, 36, 45, 54, 63, 72 },
			{ 1, 10, 19, 28, 37, 46, 55, 64, 73 },
			{ 2, 11, 20, 29, 38, 47, 56, 65, 74 },
			{ 3, 12, 21, 30, 39, 48, 57, 66, 75 },
			{ 4, 13, 22, 31, 40, 49, 58, 67, 76 },
			{ 5, 14, 23, 32, 41, 50, 59, 68, 77 },
			{ 6, 15, 24, 33, 42, 51, 60, 69, 78 },
			{ 7, 16, 25, 34, 43, 52, 61, 70, 79 },
			{ 8, 17, 26, 35, 44, 53, 62, 71, 80 }, };

	private static int[][] boxes = { { 0, 1, 2, 9, 10, 11, 18, 19, 20, },
			{ 3, 4, 5, 12, 13, 14, 21, 22, 23, },
			{ 6, 7, 8, 15, 16, 17, 24, 25, 26, },

			{ 27, 28, 29, 36, 37, 38, 45, 46, 47, },
			{ 30, 31, 32, 39, 40, 41, 48, 49, 50, },
			{ 33, 34, 35, 42, 43, 44, 51, 52, 53 },

			{ 54, 55, 56, 63, 64, 65, 72, 73, 74, },
			{ 57, 58, 59, 66, 67, 68, 75, 76, 77, },
			{ 60, 61, 62, 69, 70, 71, 78, 79, 80, }, };

	static int[] which_boxes = { 0, 0, 0, 1, 1, 1, 2, 2, 2, 0, 0, 0, 1, 1, 1,
			2, 2, 2, 0, 0, 0, 1, 1, 1, 2, 2, 2,

			3, 3, 3, 4, 4, 4, 5, 5, 5, 3, 3, 3, 4, 4, 4, 5, 5, 5, 3, 3, 3, 4,
			4, 4, 5, 5, 5,

			6, 6, 6, 7, 7, 7, 8, 8, 8, 6, 6, 6, 7, 7, 7, 8, 8, 8, 6, 6, 6, 7,
			7, 7, 8, 8, 8, };

	}
