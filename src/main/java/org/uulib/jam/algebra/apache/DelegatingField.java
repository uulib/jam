package org.uulib.jam.algebra.apache;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

public class DelegatingField<E> implements Field<DelegatingFieldElement<E>> {
	
	private final org.uulib.jam.algebra.Field<E> delegate;
	private final DelegatingFieldElement<E> zero, one;
	
	DelegatingField(org.uulib.jam.algebra.Field<E> delegate) {
		this.delegate = delegate;
		this.zero = new DelegatingFieldElement<>(this, delegate.getZeroElement());
		this.one = new DelegatingFieldElement<>(this, delegate.getUnitElement());
	}

	@Override
	public DelegatingFieldElement<E> getZero() {
		return zero;
	}

	@Override
	public DelegatingFieldElement<E> getOne() {
		return one;
	}
	
	org.uulib.jam.algebra.Field<E> getDelegate() {
		return delegate;
	}

	@Override
	public Class<? extends FieldElement<DelegatingFieldElement<E>>> getRuntimeClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
