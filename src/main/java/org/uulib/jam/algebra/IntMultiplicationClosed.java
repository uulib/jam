package org.uulib.jam.algebra;

import java.util.Optional;

public interface IntMultiplicationClosed<E> extends WithIntMultiplication<E> {
	
	E multiply(int multiplier, E element);

	@Override
	default Optional<E> multiply(E element, int multiplier) {
		return Optional.of(multiply(multiplier, element));
	}

}
