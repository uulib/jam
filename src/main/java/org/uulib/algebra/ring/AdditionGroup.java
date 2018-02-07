package org.uulib.algebra.ring;

import org.uulib.algebra.group.Group;

class AdditionGroup<E> extends AdditionMonoid<E, Ring<E>> implements Group<E> {

	protected AdditionGroup(Ring<E> delegate) {
		super(delegate);
	}

	@Override
	public E getInverse(E element) throws IllegalArgumentException {
		return delegate.getAdditiveInverse(element);
	}

}
