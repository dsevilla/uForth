/**
 */
package es.um.ssdd.uForth.impl;

import es.um.ssdd.uForth.Definition;
import es.um.ssdd.uForth.UForthPackage;
import es.um.ssdd.uForth.Word;
import es.um.ssdd.uForth.uFProgram;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>uF Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link es.um.ssdd.uForth.impl.uFProgramImpl#getWords <em>Words</em>}</li>
 *   <li>{@link es.um.ssdd.uForth.impl.uFProgramImpl#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class uFProgramImpl extends EObjectImpl implements uFProgram {
	/**
	 * The cached value of the '{@link #getWords() <em>Words</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWords()
	 * @generated
	 * @ordered
	 */
	protected EList<Word> words;
	/**
	 * The cached value of the '{@link #getDefinitions() <em>Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Definition> definitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected uFProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UForthPackage.Literals.UF_PROGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Word> getWords() {
		if (words == null) {
			words = new EObjectContainmentEList<Word>(Word.class, this, UForthPackage.UF_PROGRAM__WORDS);
		}
		return words;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Definition> getDefinitions() {
		if (definitions == null) {
			definitions = new EObjectContainmentEList<Definition>(Definition.class, this, UForthPackage.UF_PROGRAM__DEFINITIONS);
		}
		return definitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UForthPackage.UF_PROGRAM__WORDS:
				return ((InternalEList<?>)getWords()).basicRemove(otherEnd, msgs);
			case UForthPackage.UF_PROGRAM__DEFINITIONS:
				return ((InternalEList<?>)getDefinitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UForthPackage.UF_PROGRAM__WORDS:
				return getWords();
			case UForthPackage.UF_PROGRAM__DEFINITIONS:
				return getDefinitions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UForthPackage.UF_PROGRAM__WORDS:
				getWords().clear();
				getWords().addAll((Collection<? extends Word>)newValue);
				return;
			case UForthPackage.UF_PROGRAM__DEFINITIONS:
				getDefinitions().clear();
				getDefinitions().addAll((Collection<? extends Definition>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UForthPackage.UF_PROGRAM__WORDS:
				getWords().clear();
				return;
			case UForthPackage.UF_PROGRAM__DEFINITIONS:
				getDefinitions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UForthPackage.UF_PROGRAM__WORDS:
				return words != null && !words.isEmpty();
			case UForthPackage.UF_PROGRAM__DEFINITIONS:
				return definitions != null && !definitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //uFProgramImpl
