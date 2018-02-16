package org.uulib.jam.algebra.ops;

public interface AdditionGroup<E> extends AdditionMonoid<E> {
	
	E negate(E element);
	
	E subtract(E minuend, E subtrahend);

}
