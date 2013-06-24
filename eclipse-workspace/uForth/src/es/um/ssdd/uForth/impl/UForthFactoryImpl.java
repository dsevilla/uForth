/**
 */
package es.um.ssdd.uForth.impl;

import es.um.ssdd.uForth.Definition;
import es.um.ssdd.uForth.PlainId;
import es.um.ssdd.uForth.UForthFactory;
import es.um.ssdd.uForth.UForthPackage;
import es.um.ssdd.uForth.Word;
import es.um.ssdd.uForth.uFProgram;
import es.um.ssdd.uForth.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UForthFactoryImpl extends EFactoryImpl implements UForthFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UForthFactory init() {
		try {
			UForthFactory theUForthFactory = (UForthFactory)EPackage.Registry.INSTANCE.getEFactory("urn:es.um.ssdd.uForth"); 
			if (theUForthFactory != null) {
				return theUForthFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UForthFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UForthFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UForthPackage.UF_PROGRAM: return createuFProgram();
			case UForthPackage.WORD: return createWord();
			case UForthPackage.DEFINITION: return createDefinition();
			case UForthPackage.PLAIN_ID: return createPlainId();
			case UForthPackage.NUMBER: return createNumber();
			case UForthPackage.STRING: return createString();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public uFProgram createuFProgram() {
		uFProgramImpl uFProgram = new uFProgramImpl();
		return uFProgram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Word createWord() {
		WordImpl word = new WordImpl();
		return word;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Definition createDefinition() {
		DefinitionImpl definition = new DefinitionImpl();
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlainId createPlainId() {
		PlainIdImpl plainId = new PlainIdImpl();
		return plainId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public es.um.ssdd.uForth.Number createNumber() {
		NumberImpl number = new NumberImpl();
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public es.um.ssdd.uForth.String createString() {
		StringImpl string = new StringImpl();
		return string;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UForthPackage getUForthPackage() {
		return (UForthPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UForthPackage getPackage() {
		return UForthPackage.eINSTANCE;
	}

} //UForthFactoryImpl
