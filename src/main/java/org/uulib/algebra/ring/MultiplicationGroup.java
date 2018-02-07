package org.uulib.algebra.ring;

import org.uulib.algebra.group.Group;

class MultiplicationGroup<E> extends MultiplicationMonoid<E, Field<E>> implements Group<E> {

	protected MultiplicationGroup(Field<E> delegate) {
		super(delegate);
	}

	@Override
	public E getInverse(E element) throws IllegalArgumentException {
		return delegate.getMultiplicativeInverse(element);
	}

}
