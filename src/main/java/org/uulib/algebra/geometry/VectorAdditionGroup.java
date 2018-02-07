package org.uulib.algebra.geometry;

import org.uulib.algebra.group.Group;
import org.uulib.algebra.set.DelegatingSet;

class VectorAdditionGroup<V> extends DelegatingSet<V, VectorSpace<?,V,?>> implements Group<V> {

	protected VectorAdditionGroup(VectorSpace<?, V, ?> delegate) {
		super(delegate);
	}

	@Override
	public V getIdentity() {
		return delegate.getZeroVector();
	}

	@Override
	public V operate(V left, V right) throws IllegalArgumentException {
		return delegate.add(left, right);
	}

	@Override
	public V getInverse(V element) throws IllegalArgumentException {
		return delegate.getAdditiveInverse(element);
	}

}
