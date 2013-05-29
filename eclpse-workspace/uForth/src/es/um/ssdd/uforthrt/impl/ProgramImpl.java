/**
 */
package es.um.ssdd.uforthrt.impl;

import es.um.ssdd.uforthrt.Definition;
import es.um.ssdd.uforthrt.MemoryLocation;
import es.um.ssdd.uforthrt.Program;
import es.um.ssdd.uforthrt.UforthrtPackage;
import es.um.ssdd.uforthrt.Variable;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link es.um.ssdd.uforthrt.impl.ProgramImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link es.um.ssdd.uforthrt.impl.ProgramImpl#getMemory <em>Memory</em>}</li>
 *   <li>{@link es.um.ssdd.uforthrt.impl.ProgramImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link es.um.ssdd.uforthrt.impl.ProgramImpl#getVariable_map <em>Variable map</em>}</li>
 *   <li>{@link es.um.ssdd.uforthrt.impl.ProgramImpl#getDefinition_map <em>Definition map</em>}</li>
 *   <li>{@link es.um.ssdd.uforthrt.impl.ProgramImpl#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProgramImpl extends EObjectImpl implements Program {
	/**
	 * The default value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected static final int IP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected int ip = IP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMemory() <em>Memory</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemory()
	 * @generated
	 * @ordered
	 */
	protected EList<MemoryLocation> memory;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;

	/**
	 * The cached value of the '{@link #getVariable_map() <em>Variable map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable_map()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Integer> variable_map;

	/**
	 * The cached value of the '{@link #getDefinition_map() <em>Definition map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition_map()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Integer> definition_map;

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
	protected ProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UforthrtPackage.Literals.PROGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIp() {
		return ip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIp(int newIp) {
		int oldIp = ip;
		ip = newIp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UforthrtPackage.PROGRAM__IP, oldIp, ip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MemoryLocation> getMemory() {
		if (memory == null) {
			memory = new EObjectContainmentEList<MemoryLocation>(MemoryLocation.class, this, UforthrtPackage.PROGRAM__MEMORY);
		}
		return memory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<Variable>(Variable.class, this, UforthrtPackage.PROGRAM__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Integer> getVariable_map() {
		return variable_map;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable_map(Map<String, Integer> newVariable_map) {
		Map<String, Integer> oldVariable_map = variable_map;
		variable_map = newVariable_map;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UforthrtPackage.PROGRAM__VARIABLE_MAP, oldVariable_map, variable_map));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Integer> getDefinition_map() {
		return definition_map;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition_map(Map<String, Integer> newDefinition_map) {
		Map<String, Integer> oldDefinition_map = definition_map;
		definition_map = newDefinition_map;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UforthrtPackage.PROGRAM__DEFINITION_MAP, oldDefinition_map, definition_map));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Definition> getDefinitions() {
		if (definitions == null) {
			definitions = new EObjectContainmentEList<Definition>(Definition.class, this, UforthrtPackage.PROGRAM__DEFINITIONS);
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
			case UforthrtPackage.PROGRAM__MEMORY:
				return ((InternalEList<?>)getMemory()).basicRemove(otherEnd, msgs);
			case UforthrtPackage.PROGRAM__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
			case UforthrtPackage.PROGRAM__DEFINITIONS:
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
			case UforthrtPackage.PROGRAM__IP:
				return getIp();
			case UforthrtPackage.PROGRAM__MEMORY:
				return getMemory();
			case UforthrtPackage.PROGRAM__VARIABLES:
				return getVariables();
			case UforthrtPackage.PROGRAM__VARIABLE_MAP:
				return getVariable_map();
			case UforthrtPackage.PROGRAM__DEFINITION_MAP:
				return getDefinition_map();
			case UforthrtPackage.PROGRAM__DEFINITIONS:
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
			case UforthrtPackage.PROGRAM__IP:
				setIp((Integer)newValue);
				return;
			case UforthrtPackage.PROGRAM__MEMORY:
				getMemory().clear();
				getMemory().addAll((Collection<? extends MemoryLocation>)newValue);
				return;
			case UforthrtPackage.PROGRAM__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends Variable>)newValue);
				return;
			case UforthrtPackage.PROGRAM__VARIABLE_MAP:
				setVariable_map((Map<String, Integer>)newValue);
				return;
			case UforthrtPackage.PROGRAM__DEFINITION_MAP:
				setDefinition_map((Map<String, Integer>)newValue);
				return;
			case UforthrtPackage.PROGRAM__DEFINITIONS:
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
			case UforthrtPackage.PROGRAM__IP:
				setIp(IP_EDEFAULT);
				return;
			case UforthrtPackage.PROGRAM__MEMORY:
				getMemory().clear();
				return;
			case UforthrtPackage.PROGRAM__VARIABLES:
				getVariables().clear();
				return;
			case UforthrtPackage.PROGRAM__VARIABLE_MAP:
				setVariable_map((Map<String, Integer>)null);
				return;
			case UforthrtPackage.PROGRAM__DEFINITION_MAP:
				setDefinition_map((Map<String, Integer>)null);
				return;
			case UforthrtPackage.PROGRAM__DEFINITIONS:
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
			case UforthrtPackage.PROGRAM__IP:
				return ip != IP_EDEFAULT;
			case UforthrtPackage.PROGRAM__MEMORY:
				return memory != null && !memory.isEmpty();
			case UforthrtPackage.PROGRAM__VARIABLES:
				return variables != null && !variables.isEmpty();
			case UforthrtPackage.PROGRAM__VARIABLE_MAP:
				return variable_map != null;
			case UforthrtPackage.PROGRAM__DEFINITION_MAP:
				return definition_map != null;
			case UforthrtPackage.PROGRAM__DEFINITIONS:
				return definitions != null && !definitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ip: ");
		result.append(ip);
		result.append(", variable_map: ");
		result.append(variable_map);
		result.append(", definition_map: ");
		result.append(definition_map);
		result.append(')');
		return result.toString();
	}

} //ProgramImpl
