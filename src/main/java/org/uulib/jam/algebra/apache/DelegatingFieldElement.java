package org.uulib.jam.algebra.apache;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.uulib.jam.Jam;

public class DelegatingFieldElement<E> implements FieldElement<DelegatingFieldElement<E>> {
	
	private final DelegatingField<E> field;
	private final org.uulib.jam.algebra.Field<E> delegateField;
	private final E delegate;
	
	DelegatingFieldElement(DelegatingField<E> field, E delegate) {
		this.field = field;
		this.delegateField = field.getDelegate();
		this.delegate = delegate;
	}
	
	private DelegatingFieldElement<E> newValue(E value) {
		return new DelegatingFieldElement<>(field, value);
	}

	@Override
	public DelegatingFieldElement<E> add(DelegatingFieldElement<E> a) throws NullArgumentException {
		return newValue(delegateField.add(delegate, a.delegate));
	}

	@Override
	public DelegatingFieldElement<E> subtract(DelegatingFieldElement<E> a) throws NullArgumentException {
		return newValue(delegateField.subtract(delegate, a.delegate));
	}

	@Override
	public DelegatingFieldElement<E> negate() {
		return newValue(delegateField.negate(delegate));
	}

	@Override
	public DelegatingFieldElement<E> multiply(int n) {
		return newValue(Jam.multiply(delegateField, delegate, n));
	}

	@Override
	public DelegatingFieldElement<E> multiply(DelegatingFieldElement<E> a) throws NullArgumentException {
		return newValue(delegateField.multiply(delegate, a.delegate));
	}

	@Override
	public DelegatingFieldElement<E> divide(DelegatingFieldElement<E> a)
			throws NullArgumentException, MathArithmeticException {
		return newValue(delegateField.divide(delegate, a.delegate));
	}

	@Override
	public DelegatingFieldElement<E> reciprocal() throws MathArithmeticException {
		return newValue(delegateField.reciprocal(delegate));
	}

	@Override
	public Field<DelegatingFieldElement<E>> getField() {
		return field;
	}

}
