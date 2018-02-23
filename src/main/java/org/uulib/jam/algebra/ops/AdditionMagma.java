package org.uulib.jam.algebra.ops;

import java.util.Optional;

import org.uulib.jam.algebra.DefaultAlgebraMethods;

public interface AdditionMagma<E> {
	
	E add(E a, E b);
	
	default Optional<E> multiply(E element, int multiplier) {
		return DefaultAlgebraMethods.repeatAndCompose(this::add, element, multiplier);
	}
	
	Optional<E> divide(E dividend, int divisor);

}
