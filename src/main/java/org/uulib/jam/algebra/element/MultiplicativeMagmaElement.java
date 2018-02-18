package org.uulib.jam.algebra.element;

import java8.util.Optional;

public interface MultiplicativeMagmaElement<E extends MultiplicativeMagmaElement<E>> {
	
	E times(E other);
	
	E pow(int exponent);
	
	Optional<E> root(int degree);

}
