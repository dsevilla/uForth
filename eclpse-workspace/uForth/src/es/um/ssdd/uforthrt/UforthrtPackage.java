/**
 */
package es.um.ssdd.uforthrt;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see es.um.ssdd.uforthrt.UforthrtFactory
 * @model kind="package"
 * @generated
 */
public interface UforthrtPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uforthrt";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://uforthrt/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uforthrt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UforthrtPackage eINSTANCE = es.um.ssdd.uforthrt.impl.UforthrtPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.um.ssdd.uforthrt.impl.ProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.um.ssdd.uforthrt.impl.ProgramImpl
	 * @see es.um.ssdd.uforthrt.impl.UforthrtPackageImpl#getProgram()
	 * @generated
	 */
	int PROGRAM = 0;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__IP = 0;

	/**
	 * The feature id for the '<em><b>Memory</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__MEMORY = 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__VARIABLES = 2;

	/**
	 * The feature id for the '<em><b>Variable map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__VARIABLE_MAP = 3;

	/**
	 * The feature id for the '<em><b>Definition map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__DEFINITION_MAP = 4;

	/**
	 * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__DEFINITIONS = 5;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link es.um.ssdd.uforthrt.impl.MemoryLocationImpl <em>Memory Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.um.ssdd.uforthrt.impl.MemoryLocationImpl
	 * @see es.um.ssdd.uforthrt.impl.UforthrtPackageImpl#getMemoryLocation()
	 * @generated
	 */
	int MEMORY_LOCATION = 1;

	/**
	 * The number of structural features of the '<em>Memory Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_LOCATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.um.ssdd.uforthrt.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.um.ssdd.uforthrt.impl.VariableImpl
	 * @see es.um.ssdd.uforthrt.impl.UforthrtPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__POS = 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link es.um.ssdd.uforthrt.impl.DefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.um.ssdd.uforthrt.impl.DefinitionImpl
	 * @see es.um.ssdd.uforthrt.impl.UforthrtPackageImpl#getDefinition()
	 * @generated
	 */
	int DEFINITION = 3;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION__POS = 0;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link es.um.ssdd.uforthrt.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see es.um.ssdd.uforthrt.Program
	 * @generated
	 */
	EClass getProgram();

	/**
	 * Returns the meta object for the attribute '{@link es.um.ssdd.uforthrt.Program#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see es.um.ssdd.uforthrt.Program#getIp()
	 * @see #getProgram()
	 * @generated
	 */
	EAttribute getProgram_Ip();

	/**
	 * Returns the meta object for the containment reference list '{@link es.um.ssdd.uforthrt.Program#getMemory <em>Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Memory</em>'.
	 * @see es.um.ssdd.uforthrt.Program#getMemory()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Memory();

	/**
	 * Returns the meta object for the containment reference list '{@link es.um.ssdd.uforthrt.Program#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see es.um.ssdd.uforthrt.Program#getVariables()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Variables();

	/**
	 * Returns the meta object for the attribute '{@link es.um.ssdd.uforthrt.Program#getVariable_map <em>Variable map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable map</em>'.
	 * @see es.um.ssdd.uforthrt.Program#getVariable_map()
	 * @see #getProgram()
	 * @generated
	 */
	EAttribute getProgram_Variable_map();

	/**
	 * Returns the meta object for the attribute '{@link es.um.ssdd.uforthrt.Program#getDefinition_map <em>Definition map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition map</em>'.
	 * @see es.um.ssdd.uforthrt.Program#getDefinition_map()
	 * @see #getProgram()
	 * @generated
	 */
	EAttribute getProgram_Definition_map();

	/**
	 * Returns the meta object for the containment reference list '{@link es.um.ssdd.uforthrt.Program#getDefinitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Definitions</em>'.
	 * @see es.um.ssdd.uforthrt.Program#getDefinitions()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Definitions();

	/**
	 * Returns the meta object for class '{@link es.um.ssdd.uforthrt.MemoryLocation <em>Memory Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Location</em>'.
	 * @see es.um.ssdd.uforthrt.MemoryLocation
	 * @generated
	 */
	EClass getMemoryLocation();

	/**
	 * Returns the meta object for class '{@link es.um.ssdd.uforthrt.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see es.um.ssdd.uforthrt.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link es.um.ssdd.uforthrt.Variable#getPos <em>Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pos</em>'.
	 * @see es.um.ssdd.uforthrt.Variable#getPos()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Pos();

	/**
	 * Returns the meta object for class '{@link es.um.ssdd.uforthrt.Definition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see es.um.ssdd.uforthrt.Definition
	 * @generated
	 */
	EClass getDefinition();

	/**
	 * Returns the meta object for the attribute '{@link es.um.ssdd.uforthrt.Definition#getPos <em>Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pos</em>'.
	 * @see es.um.ssdd.uforthrt.Definition#getPos()
	 * @see #getDefinition()
	 * @generated
	 */
	EAttribute getDefinition_Pos();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UforthrtFactory getUforthrtFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link es.um.ssdd.uforthrt.impl.ProgramImpl <em>Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.um.ssdd.uforthrt.impl.ProgramImpl
		 * @see es.um.ssdd.uforthrt.impl.UforthrtPackageImpl#getProgram()
		 * @generated
		 */
		EClass PROGRAM = eINSTANCE.getProgram();

		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM__IP = eINSTANCE.getProgram_Ip();

		/**
		 * The meta object literal for the '<em><b>Memory</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__MEMORY = eINSTANCE.getProgram_Memory();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__VARIABLES = eINSTANCE.getProgram_Variables();

		/**
		 * The meta object literal for the '<em><b>Variable map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM__VARIABLE_MAP = eINSTANCE.getProgram_Variable_map();

		/**
		 * The meta object literal for the '<em><b>Definition map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM__DEFINITION_MAP = eINSTANCE.getProgram_Definition_map();

		/**
		 * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__DEFINITIONS = eINSTANCE.getProgram_Definitions();

		/**
		 * The meta object literal for the '{@link es.um.ssdd.uforthrt.impl.MemoryLocationImpl <em>Memory Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.um.ssdd.uforthrt.impl.MemoryLocationImpl
		 * @see es.um.ssdd.uforthrt.impl.UforthrtPackageImpl#getMemoryLocation()
		 * @generated
		 */
		EClass MEMORY_LOCATION = eINSTANCE.getMemoryLocation();

		/**
		 * The meta object literal for the '{@link es.um.ssdd.uforthrt.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.um.ssdd.uforthrt.impl.VariableImpl
		 * @see es.um.ssdd.uforthrt.impl.UforthrtPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__POS = eINSTANCE.getVariable_Pos();

		/**
		 * The meta object literal for the '{@link es.um.ssdd.uforthrt.impl.DefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.um.ssdd.uforthrt.impl.DefinitionImpl
		 * @see es.um.ssdd.uforthrt.impl.UforthrtPackageImpl#getDefinition()
		 * @generated
		 */
		EClass DEFINITION = eINSTANCE.getDefinition();

		/**
		 * The meta object literal for the '<em><b>Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITION__POS = eINSTANCE.getDefinition_Pos();

	}

} //UforthrtPackage
