/**
 */
package es.um.ssdd.uforthrt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link es.um.ssdd.uforthrt.Variable#getPos <em>Pos</em>}</li>
 * </ul>
 * </p>
 *
 * @see es.um.ssdd.uforthrt.UforthrtPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends EObject {
	/**
	 * Returns the value of the '<em><b>Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Posición de la variable en la memoria.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pos</em>' attribute.
	 * @see #setPos(int)
	 * @see es.um.ssdd.uforthrt.UforthrtPackage#getVariable_Pos()
	 * @model required="true"
	 * @generated
	 */
	int getPos();

	/**
	 * Sets the value of the '{@link es.um.ssdd.uforthrt.Variable#getPos <em>Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos</em>' attribute.
	 * @see #getPos()
	 * @generated
	 */
	void setPos(int value);

} // Variable
