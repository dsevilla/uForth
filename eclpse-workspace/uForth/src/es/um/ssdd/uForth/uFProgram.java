/**
 */
package es.um.ssdd.uForth;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>uF Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link es.um.ssdd.uForth.uFProgram#getWords <em>Words</em>}</li>
 *   <li>{@link es.um.ssdd.uForth.uFProgram#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see es.um.ssdd.uForth.UForthPackage#getuFProgram()
 * @model
 * @generated
 */
public interface uFProgram extends EObject {

	/**
	 * Returns the value of the '<em><b>Words</b></em>' containment reference list.
	 * The list contents are of type {@link es.um.ssdd.uForth.Word}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Words</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Words</em>' containment reference list.
	 * @see es.um.ssdd.uForth.UForthPackage#getuFProgram_Words()
	 * @model containment="true"
	 * @generated
	 */
	EList<Word> getWords();

	/**
	 * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link es.um.ssdd.uForth.Definition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definitions</em>' containment reference list.
	 * @see es.um.ssdd.uForth.UForthPackage#getuFProgram_Definitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Definition> getDefinitions();
} // uFProgram
