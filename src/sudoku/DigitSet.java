/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;

public class DigitSet
	{
	// CurrentValue of 0 means that no potential value has been set

	boolean[] possibility = new boolean[General.NUM_VALUES];

	int currentValue = 0;

	public static DigitSet copy(DigitSet other)
		{
		DigitSet newDS = new DigitSet();
		newDS.currentValue = other.currentValue;
		System.arraycopy(other.possibility, 0, newDS.possibility, 0,
				other.possibility.length);
		return newDS;
		}

	public DigitSet()
		{
		possibility[0] = false;
		for (int i = 1; i < possibility.length; i++)
			{
			possibility[i] = true;
			}
		}

	int findOneThatsSet()
		{
		for (int i = 1; i < possibility.length; i++)
			{
			if (possibility[i])
				return i;
			}
		System.out.println("*** Error Not find one that's set");
		return 0;
		}

	void setCurrentValueToFirstPossibility()
		{
		for (int i = 1; i < possibility.length; i++)
			{
			if (possibility[i])
				{
				currentValue = i;
				return;
				}
			}
		System.out
				.println("*** ERROR - trying to set possiblity when none exist");
		}

	boolean setPossiblityOff(int index)
		{

		boolean ret = true;
		if (getCount() > 1)
			{
			possibility[index] = false;
			} else
			{
			if (findOneThatsSet() == index)
				{
				// This will be tested by caller - if
				// it occurs, then the board is not a solution
				ret = false;
				} else
				setCurrentValueToFirstPossibility();
			}
		return ret;
		}

	boolean isFixed()
		{
		if (getCount() == 1 && currentValue != 0)
			return true;
		else
			return false;
		}

	void setOnlyValue(int value)
		{
		for (int i = 1; i < possibility.length; i++)
			{
			possibility[i] = false;
			}
		currentValue = value;
		possibility[value] = true;
		}

	int getNext()
		{
		for (int i = currentValue + 1; i < possibility.length; i++)
			{
			if (possibility[i])
				{
				return i;
				}
			}
		System.out.println("Get next cannot find next " + currentValue);
		return 0;

		}

	int setToNext()
		{
		if (getCount() > 1)
			{
			for (int i = currentValue + 1; i < possibility.length; i++)
				{
				if (possibility[i])
					{
					currentValue = i;
					return i;
					}
				}
			return 0;
			} else
			return currentValue;
		}

	int getCount()
		{
		int count = 0;
		for (int i = 1; i < possibility.length; i++)
			{
			if (possibility[i])
				count++;
			}
		return count;
		}

	void setInitialValue(int value)
		{
		setOnlyValue(value);
		}

	int getCurrentValue()
		{
		return currentValue;
		}

	void printValues()
		{
		System.out.print("Count " + this.getCount() + " Iter " + currentValue
				+ " ");
		for (int i = 1; i < possibility.length; i++)
			{
			if (possibility[i])
				System.out.print(i + " ");
			}
		}
	}
