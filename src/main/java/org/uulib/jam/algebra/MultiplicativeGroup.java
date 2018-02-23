package org.uulib.jam.algebra;

import org.uulib.jam.algebra.ops.MultiplicationMonoid;

import java8.util.Optional;

public interface MultiplicativeGroup<E> extends MultiplicationMonoid<E> {
	
	Optional<E> reciprocal(E element);
	
	Optional<E> divide(E dividend, E divisor);

}
