/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;

public class Position
	{
	DigitSet digitSet = new DigitSet();

	public int[] comparingPositionIndexes = new int[General.NUM_TO_COMPARE];

	public static Position copy(Position other)
		{
		Position newPos = new Position();
		newPos.digitSet = DigitSet.copy(other.digitSet);
		/*
		 * Not needed - the comparing positions will not change
		 * System.arraycopy(other.comparingPositionIndexes, 0,
		 * newPos.comparingPositionIndexes, 0,
		 * newPos.comparingPositionIndexes.length);
		 */
		newPos.comparingPositionIndexes = other.comparingPositionIndexes;
		return newPos;
		}

	void setupCompare(int index, int[] row, int[] col, int[] box)
		{
		int count = 0;
		for (int i = 0; i < General.NUM_COLS; i++)
			{
			if (row[i] != index)
				{
				comparingPositionIndexes[count] = row[i];
				count++;
				}
			}
		nextrow: for (int i = 0; i < General.NUM_ROWS; i++)
			{
			if (col[i] != index)
				{
				for (int j = 0; j < count; j++)
					{
					if (comparingPositionIndexes[j] == index)
						continue nextrow;
					}
				comparingPositionIndexes[count] = col[i];
				count++;
				}
			}
		nextbox: for (int i = 0; i < General.NUM_ROWS; i++)
			{
			if (box[i] != index)
				{
				for (int j = 0; j < count; j++)
					{
					if (comparingPositionIndexes[j] == box[i])
						{
						continue nextbox;
						}
					}
				comparingPositionIndexes[count] = box[i];
				count++;
				}
			}

		}

	void setInitialValue(int value)
		{
		if (value > 0 && value <= 9)
			digitSet.setInitialValue(value);
		}

	public String toString()
		{
		int i = digitSet.getCurrentValue();
		if (i != 0)
			return Integer.toString(i);
		else
			return " ";
		}

	int getCurrentValue()
		{
		return digitSet.getCurrentValue();
		}

	int getCountValues()
		{
		return digitSet.getCount();
		}

	int getNextValue()
		{
		int i = digitSet.getNext();
		digitSet.setToNext();
		return i;
		}

	void setToNextValue()
		{
		digitSet.setToNext();
		}

	boolean eliminateValue(int value)
		{
		return digitSet.setPossiblityOff(value);
		}

	void print()
		{
		digitSet.printValues();
		}
	}
