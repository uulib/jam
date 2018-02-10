package org.uulib.jam.algebra.ops;

public interface MultiplicationGroup<E> extends MultiplicationMonoid<E> {
	
	E reciprocal(E element);
	
	E divide(E left, E right);

}
