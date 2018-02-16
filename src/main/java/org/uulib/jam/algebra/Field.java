package org.uulib.jam.algebra;

import java8.util.Optional;

/**
 * 
 * @author rowan
 *
 * @param <E>
 */
public interface Field<E> extends Ring<E> {
	
	Optional<E> reciprocal(E element);
	
	Optional<E> divide(E dividend, E divisor);
	
}
