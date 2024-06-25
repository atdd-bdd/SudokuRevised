/***
 * Excerpted from "Interface Oriented Design"
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/kpiod for more book information.
***/
package sudoku;

public class BadFormatException extends RuntimeException
	{
	static final long serialVersionUID = -1;

	public BadFormatException()
		{
		super();
		}

	public BadFormatException(String message)
		{
		super(message);
		}

	}
