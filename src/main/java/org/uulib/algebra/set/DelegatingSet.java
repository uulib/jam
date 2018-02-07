package org.uulib.algebra.set;

public class DelegatingSet<E, C extends Set<E>> implements Set<E> {
	
	protected final C delegate;
	
	protected DelegatingSet(C delegate) {
		this.delegate = delegate;
	}

	@Override
	public boolean isMember(E element) {
		return delegate.isMember(element);
	}

	@Override
	public Cardinality getCardinality() {
		return delegate.getCardinality();
	}

}
