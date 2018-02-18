package org.uulib.jam.algebra.element;

import java8.util.Optional;

public interface AdditiveMagmaElement<E extends AdditiveMagmaElement<E>> {

	E plus(E other);
	
	E times(int times);
	
	Optional<E> divideBy(int divisor);
	
}
