package org.uulib.algebra.geometry;

import org.uulib.algebra.ring.Field;
import org.uulib.algebra.set.Set;

public interface AffineSpace<S,P,V,F extends Field<S>> extends Set<P> {
	
	VectorSpace<S,V,F> getVectorSpace();
	
	P add(P point, V vector) throws IllegalArgumentException;
	
	V subtract(P left, P right) throws IllegalArgumentException;
	
	default V addVectors(V a, V b) throws IllegalArgumentException {
		return getVectorSpace().add(a, b);
	}
	
	default V subtractVectors(V left, V right) throws IllegalArgumentException {
		return getVectorSpace().subtract(left, right);
	}
	
	default V getZeroVector() {
		return getVectorSpace().getZeroVector();
	}
	
	default int getDimension() {
		return getVectorSpace().getDimension();
	}
	
	default F getScalarField() {
		return getVectorSpace().getScalarField();
	}

}
