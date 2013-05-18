/**
 * 
 */
package es.um.ssdd.uForth.interpreter.bare;

/**
 * @author dsevilla
 *
 */
public class PlainId extends Word 
{
	private java.lang.String id;
	
	PlainId(String id)
	{
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public final java.lang.String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(java.lang.String id) {
		this.id = id;
	}
	
	
}
