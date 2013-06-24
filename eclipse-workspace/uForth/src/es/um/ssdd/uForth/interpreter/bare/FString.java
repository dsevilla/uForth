/**
 * 
 */
package es.um.ssdd.uForth.interpreter.bare;

/**
 * @author dsevilla
 *
 */
public class FString extends Word 
{
	private java.lang.String value;
	
	FString(java.lang.String v)
	{
		value = v;
	}

	/**
	 * @return the value
	 */
	public final java.lang.String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public final void setValue(java.lang.String value) {
		this.value = value;
	}
	
	
}
