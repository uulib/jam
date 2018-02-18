package org.uulib.jam.algebra.element;

import java8.util.Optional;

public interface FieldElement<E extends FieldElement<E>> extends RingElement<E> {
	
	Optional<E> reciprocal();
	
	Optional<E> divideBy(E divisor);

}
