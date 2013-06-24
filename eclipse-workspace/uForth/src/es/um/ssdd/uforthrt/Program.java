/**
 */
package es.um.ssdd.uforthrt;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link es.um.ssdd.uforthrt.Program#getIp <em>Ip</em>}</li>
 *   <li>{@link es.um.ssdd.uforthrt.Program#getMemory <em>Memory</em>}</li>
 *   <li>{@link es.um.ssdd.uforthrt.Program#getVariables <em>Variables</em>}</li>
 *   <li>{@link es.um.ssdd.uforthrt.Program#getVariable_map <em>Variable map</em>}</li>
 *   <li>{@link es.um.ssdd.uforthrt.Program#getDefinition_map <em>Definition map</em>}</li>
 *   <li>{@link es.um.ssdd.uforthrt.Program#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see es.um.ssdd.uforthrt.UforthrtPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends EObject {
	/**
	 * Returns the value of the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puntero al espacio de programa.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ip</em>' attribute.
	 * @see #setIp(int)
	 * @see es.um.ssdd.uforthrt.UforthrtPackage#getProgram_Ip()
	 * @model required="true"
	 * @generated
	 */
	int getIp();

	/**
	 * Sets the value of the '{@link es.um.ssdd.uforthrt.Program#getIp <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip</em>' attribute.
	 * @see #getIp()
	 * @generated
	 */
	void setIp(int value);

	/**
	 * Returns the value of the '<em><b>Memory</b></em>' containment reference list.
	 * The list contents are of type {@link es.um.ssdd.uforthrt.MemoryLocation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory</em>' containment reference list.
	 * @see es.um.ssdd.uforthrt.UforthrtPackage#getProgram_Memory()
	 * @model containment="true"
	 * @generated
	 */
	EList<MemoryLocation> getMemory();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link es.um.ssdd.uforthrt.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see es.um.ssdd.uforthrt.UforthrtPackage#getProgram_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Variable map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable map</em>' attribute.
	 * @see #setVariable_map(Map)
	 * @see es.um.ssdd.uforthrt.UforthrtPackage#getProgram_Variable_map()
	 * @model required="true" transient="true" derived="true"
	 * @generated
	 */
	Map<String, Integer> getVariable_map();

	/**
	 * Sets the value of the '{@link es.um.ssdd.uforthrt.Program#getVariable_map <em>Variable map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable map</em>' attribute.
	 * @see #getVariable_map()
	 * @generated
	 */
	void setVariable_map(Map<String, Integer> value);

	/**
	 * Returns the value of the '<em><b>Definition map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition map</em>' attribute.
	 * @see #setDefinition_map(Map)
	 * @see es.um.ssdd.uforthrt.UforthrtPackage#getProgram_Definition_map()
	 * @model required="true" transient="true" derived="true"
	 * @generated
	 */
	Map<String, Integer> getDefinition_map();

	/**
	 * Sets the value of the '{@link es.um.ssdd.uforthrt.Program#getDefinition_map <em>Definition map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition map</em>' attribute.
	 * @see #getDefinition_map()
	 * @generated
	 */
	void setDefinition_map(Map<String, Integer> value);

	/**
	 * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link es.um.ssdd.uforthrt.Definition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definitions</em>' containment reference list.
	 * @see es.um.ssdd.uforthrt.UforthrtPackage#getProgram_Definitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Definition> getDefinitions();

} // Program
