/**
 */
package es.um.ssdd.uForth;

import java.lang.String;
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
 * @see es.um.ssdd.uForth.UForthFactory
 * @model kind="package"
 * @generated
 */
public interface UForthPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uForth";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:es.um.ssdd.uForth";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "es.um.ssdd.uForth";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UForthPackage eINSTANCE = es.um.ssdd.uForth.impl.UForthPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.um.ssdd.uForth.impl.uFProgramImpl <em>uF Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.um.ssdd.uForth.impl.uFProgramImpl
	 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getuFProgram()
	 * @generated
	 */
	int UF_PROGRAM = 0;

	/**
	 * The feature id for the '<em><b>Words</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UF_PROGRAM__WORDS = 0;

	/**
	 * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UF_PROGRAM__DEFINITIONS = 1;

	/**
	 * The number of structural features of the '<em>uF Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UF_PROGRAM_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link es.um.ssdd.uForth.impl.WordImpl <em>Word</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.um.ssdd.uForth.impl.WordImpl
	 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getWord()
	 * @generated
	 */
	int WORD = 1;

	/**
	 * The number of structural features of the '<em>Word</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link es.um.ssdd.uForth.impl.DefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.um.ssdd.uForth.impl.DefinitionImpl
	 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getDefinition()
	 * @generated
	 */
	int DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Words</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION__WORDS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION__NAME = 1;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link es.um.ssdd.uForth.impl.PlainIdImpl <em>Plain Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.um.ssdd.uForth.impl.PlainIdImpl
	 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getPlainId()
	 * @generated
	 */
	int PLAIN_ID = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_ID__ID = WORD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Plain Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_ID_FEATURE_COUNT = WORD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link es.um.ssdd.uForth.impl.NumberImpl <em>Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.um.ssdd.uForth.impl.NumberImpl
	 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getNumber()
	 * @generated
	 */
	int NUMBER = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER__VALUE = WORD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FEATURE_COUNT = WORD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link es.um.ssdd.uForth.impl.StringImpl <em>String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.um.ssdd.uForth.impl.StringImpl
	 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getString()
	 * @generated
	 */
	int STRING = 5;

	/**
	 * The feature id for the '<em><b>Str</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING__STR = WORD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_FEATURE_COUNT = WORD_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link es.um.ssdd.uForth.uFProgram <em>uF Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>uF Program</em>'.
	 * @see es.um.ssdd.uForth.uFProgram
	 * @generated
	 */
	EClass getuFProgram();

	/**
	 * Returns the meta object for the containment reference list '{@link es.um.ssdd.uForth.uFProgram#getWords <em>Words</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Words</em>'.
	 * @see es.um.ssdd.uForth.uFProgram#getWords()
	 * @see #getuFProgram()
	 * @generated
	 */
	EReference getuFProgram_Words();

	/**
	 * Returns the meta object for the containment reference list '{@link es.um.ssdd.uForth.uFProgram#getDefinitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Definitions</em>'.
	 * @see es.um.ssdd.uForth.uFProgram#getDefinitions()
	 * @see #getuFProgram()
	 * @generated
	 */
	EReference getuFProgram_Definitions();

	/**
	 * Returns the meta object for class '{@link es.um.ssdd.uForth.Word <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Word</em>'.
	 * @see es.um.ssdd.uForth.Word
	 * @generated
	 */
	EClass getWord();

	/**
	 * Returns the meta object for class '{@link es.um.ssdd.uForth.Definition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see es.um.ssdd.uForth.Definition
	 * @generated
	 */
	EClass getDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link es.um.ssdd.uForth.Definition#getWords <em>Words</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Words</em>'.
	 * @see es.um.ssdd.uForth.Definition#getWords()
	 * @see #getDefinition()
	 * @generated
	 */
	EReference getDefinition_Words();

	/**
	 * Returns the meta object for the attribute '{@link es.um.ssdd.uForth.Definition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see es.um.ssdd.uForth.Definition#getName()
	 * @see #getDefinition()
	 * @generated
	 */
	EAttribute getDefinition_Name();

	/**
	 * Returns the meta object for class '{@link es.um.ssdd.uForth.PlainId <em>Plain Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plain Id</em>'.
	 * @see es.um.ssdd.uForth.PlainId
	 * @generated
	 */
	EClass getPlainId();

	/**
	 * Returns the meta object for the attribute '{@link es.um.ssdd.uForth.PlainId#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see es.um.ssdd.uForth.PlainId#getId()
	 * @see #getPlainId()
	 * @generated
	 */
	EAttribute getPlainId_Id();

	/**
	 * Returns the meta object for class '{@link es.um.ssdd.uForth.Number <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number</em>'.
	 * @see es.um.ssdd.uForth.Number
	 * @generated
	 */
	EClass getNumber();

	/**
	 * Returns the meta object for the attribute '{@link es.um.ssdd.uForth.Number#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see es.um.ssdd.uForth.Number#getValue()
	 * @see #getNumber()
	 * @generated
	 */
	EAttribute getNumber_Value();

	/**
	 * Returns the meta object for class '{@link es.um.ssdd.uForth.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String</em>'.
	 * @see es.um.ssdd.uForth.String
	 * @generated
	 */
	EClass getString();

	/**
	 * Returns the meta object for the attribute '{@link es.um.ssdd.uForth.String#getStr <em>Str</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Str</em>'.
	 * @see es.um.ssdd.uForth.String#getStr()
	 * @see #getString()
	 * @generated
	 */
	EAttribute getString_Str();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UForthFactory getUForthFactory();

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
		 * The meta object literal for the '{@link es.um.ssdd.uForth.impl.uFProgramImpl <em>uF Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.um.ssdd.uForth.impl.uFProgramImpl
		 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getuFProgram()
		 * @generated
		 */
		EClass UF_PROGRAM = eINSTANCE.getuFProgram();
		/**
		 * The meta object literal for the '<em><b>Words</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UF_PROGRAM__WORDS = eINSTANCE.getuFProgram_Words();
		/**
		 * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UF_PROGRAM__DEFINITIONS = eINSTANCE.getuFProgram_Definitions();
		/**
		 * The meta object literal for the '{@link es.um.ssdd.uForth.impl.WordImpl <em>Word</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.um.ssdd.uForth.impl.WordImpl
		 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getWord()
		 * @generated
		 */
		EClass WORD = eINSTANCE.getWord();
		/**
		 * The meta object literal for the '{@link es.um.ssdd.uForth.impl.DefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.um.ssdd.uForth.impl.DefinitionImpl
		 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getDefinition()
		 * @generated
		 */
		EClass DEFINITION = eINSTANCE.getDefinition();
		/**
		 * The meta object literal for the '<em><b>Words</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINITION__WORDS = eINSTANCE.getDefinition_Words();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITION__NAME = eINSTANCE.getDefinition_Name();
		/**
		 * The meta object literal for the '{@link es.um.ssdd.uForth.impl.PlainIdImpl <em>Plain Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.um.ssdd.uForth.impl.PlainIdImpl
		 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getPlainId()
		 * @generated
		 */
		EClass PLAIN_ID = eINSTANCE.getPlainId();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAIN_ID__ID = eINSTANCE.getPlainId_Id();
		/**
		 * The meta object literal for the '{@link es.um.ssdd.uForth.impl.NumberImpl <em>Number</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.um.ssdd.uForth.impl.NumberImpl
		 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getNumber()
		 * @generated
		 */
		EClass NUMBER = eINSTANCE.getNumber();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER__VALUE = eINSTANCE.getNumber_Value();
		/**
		 * The meta object literal for the '{@link es.um.ssdd.uForth.impl.StringImpl <em>String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.um.ssdd.uForth.impl.StringImpl
		 * @see es.um.ssdd.uForth.impl.UForthPackageImpl#getString()
		 * @generated
		 */
		EClass STRING = eINSTANCE.getString();
		/**
		 * The meta object literal for the '<em><b>Str</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING__STR = eINSTANCE.getString_Str();

	}

} //UForthPackage
