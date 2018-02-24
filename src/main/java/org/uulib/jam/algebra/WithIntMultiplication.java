package org.uulib.jam.algebra;

import java.util.Optional;

public interface WithIntMultiplication<E> {

	Optional<E> multiply(E element, int multiplier);

	Optional<E> divide(E dividend, int divisor);

}