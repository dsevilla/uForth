package es.um.ssdd.uForth.interpreter.bare;

public class Number extends Word 
{
	private double value;

	Number(double v)
	{
		value = v;
	}
	
	/**
	 * @return the value
	 */
	public final double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public final void setValue(double value) {
		this.value = value;
	}

}
