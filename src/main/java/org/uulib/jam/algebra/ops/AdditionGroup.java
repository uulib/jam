package org.uulib.jam.algebra.ops;

import java.util.Optional;

public interface AdditionGroup<E> extends AdditionMonoid<E> {
	
	E negate(E element);
	
	E subtract(E minuend, E subtrahend);

	@Override
	default Optional<E> multiply(E element, int multiplier) {
		if(multiplier<0) {
			multiplier = -multiplier;
			element = negate(element);
		}
		return AdditionMonoid.super.multiply(element, multiplier);
	}
	
	default E multiply(int multiplier, E element) {
		return multiply(element, multiplier).get();
	}

}
