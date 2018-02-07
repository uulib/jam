package org.uulib.algebra.geometry;

import org.uulib.algebra.group.Group;
import org.uulib.algebra.ring.Field;
import org.uulib.algebra.set.Set;

public interface VectorSpace<S, V, F extends Field<S>> extends Set<V> {
	
	F getScalarField();
	
	int getDimension();
	
	V add(V a, V b) throws IllegalArgumentException;
	
	V getZeroVector();
	
	V getAdditiveInverse(V vector) throws IllegalArgumentException;
	
	default V subtract(V left, V right) {
		return add(left, getAdditiveInverse(right));
	}
	
	V multiply(V vector, S scalar) throws IllegalArgumentException;
	
	default V divide(V vector, S scalar) throws IllegalArgumentException {
		return multiply(vector, getScalarField().getMultiplicativeInverse(scalar));
	}
	
	default Group<V> asGroupUnderAddition() {
		return new VectorAdditionGroup<>(this);
	}

}
