package org.uulib.algebra.ring;

import org.uulib.algebra.group.Monoid;
import org.uulib.algebra.set.DelegatingSet;

class AdditionMonoid<E, C extends Semiring<E>> extends DelegatingSet<E, C> implements Monoid<E> {

	protected AdditionMonoid(C delegate) {
		super(delegate);
	}

	@Override
	public E operate(E left, E right) throws IllegalArgumentException {
		return delegate.add(left, right);
	}

	@Override
	public E getIdentity() {
		return delegate.getAdditiveIdentity();
	}

}
