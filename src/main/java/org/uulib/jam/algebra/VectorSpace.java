package org.uulib.jam.algebra;

import org.uulib.jam.algebra.ops.AdditionGroup;

import java8.util.Optional;

public interface VectorSpace<V,S> extends AdditionGroup<V> {
	
	Field<S> getScalarField();
	
	V scalarMultiply(V vector, S scalar);
	
	Optional<V> scalarDivide(V vector, S scalar);

}
