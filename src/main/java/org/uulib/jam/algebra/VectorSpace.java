package org.uulib.jam.algebra;

import org.uulib.jam.algebra.ops.AdditionGroup;

public interface VectorSpace<V,S> extends AdditionGroup<V> {
	
	Field<S> getScalarField();
	
	V scale(V vector, S scalar);
	
	int getDimension();

}
