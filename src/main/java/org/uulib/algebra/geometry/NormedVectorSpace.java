package org.uulib.algebra.geometry;

public interface NormedVectorSpace<S, V, F extends ScalarField<S>> extends VectorSpace<S,V,F> {
	
	S norm(V vector) throws IllegalArgumentException;

}
