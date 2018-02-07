package org.uulib.algebra.geometry;

import java.util.Comparator;

import org.uulib.algebra.ring.Field;

public interface ScalarField<E> extends Field<E>, Comparator<E> {
	
	E squareRoot(E element) throws IllegalArgumentException;
	
	Angle arccos(E element) throws IllegalArgumentException;
	
	E cosine(Angle angle);
	
	default E getZero() {
		return getAdditiveIdentity();
	}
	
	default boolean isPositive(E element) throws IllegalArgumentException {
		if(!isMember(element)) {
			throw new IllegalArgumentException();
		}
		return compare(element, getZero()) > 0;
	}
	
	default boolean isNonNegative(E element) throws IllegalArgumentException {
		if(!isMember(element)) {
			throw new IllegalArgumentException();
		}
		return compare(element, getZero()) >=0;
	}
	
	default boolean isZero(E element) throws IllegalArgumentException {
		if(!isMember(element)) {
			throw new IllegalArgumentException();
		}
		return compare(element, getZero()) == 0;
	}

}
