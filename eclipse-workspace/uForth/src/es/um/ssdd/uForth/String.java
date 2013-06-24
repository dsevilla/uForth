/**
 */
package es.um.ssdd.uForth;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link es.um.ssdd.uForth.String#getStr <em>Str</em>}</li>
 * </ul>
 * </p>
 *
 * @see es.um.ssdd.uForth.UForthPackage#getString()
 * @model
 * @generated
 */
public interface String extends Word {
	/**
	 * Returns the value of the '<em><b>Str</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Str</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Str</em>' attribute.
	 * @see #setStr(java.lang.String)
	 * @see es.um.ssdd.uForth.UForthPackage#getString_Str()
	 * @model required="true"
	 * @generated
	 */
	java.lang.String getStr();

	/**
	 * Sets the value of the '{@link es.um.ssdd.uForth.String#getStr <em>Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Str</em>' attribute.
	 * @see #getStr()
	 * @generated
	 */
	void setStr(java.lang.String value);

} // String
