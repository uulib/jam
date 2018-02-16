package org.uulib.jam.algebra.ops;

import java8.util.Optional;

public interface AdditionMagma<E> {
	
	E add(E a, E b);
	
	E multiply(E element, int multiplier);
	
	Optional<E> divide(E dividend, int divisor);

}
