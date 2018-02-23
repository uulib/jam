package org.uulib.jam.algebra;

import java.util.Optional;

import org.uulib.jam.algebra.ops.AdditionGroup;

public interface VectorSpace<V,S> extends AdditionGroup<V> {
	
	Field<S> getBaseField();
	
	V scalarMultiply(V vector, S scalar);
	
	Optional<S> divideToScalar(V dividend, V divisor);
	
	default Optional<V> scalarDivide(V vector, S scalar) {
		return getBaseField().reciprocal(scalar).map(d -> scalarMultiply(vector, d));
	}

}
