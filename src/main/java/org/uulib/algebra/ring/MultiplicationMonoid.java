package org.uulib.algebra.ring;

import org.uulib.algebra.group.Monoid;
import org.uulib.algebra.set.DelegatingSet;

class MultiplicationMonoid<E, C extends Semiring<E>> extends DelegatingSet<E, C> implements Monoid<E> {

	protected MultiplicationMonoid(C delegate) {
		super(delegate);
	}

	@Override
	public E operate(E left, E right) throws IllegalArgumentException {
		return delegate.multiply(left, right);
	}

	@Override
	public E getIdentity() {
		return delegate.getMultiplicativeIdentity();
	}

}
