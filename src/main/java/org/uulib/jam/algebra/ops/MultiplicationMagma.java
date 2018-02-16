package org.uulib.jam.algebra.ops;

import java8.util.Optional;

public interface MultiplicationMagma<E> {
	
	E multiply(E a, E b);
	
	E pow(E base, int exponent);
	
	Optional<E> root(E radicand, int degree);

}
