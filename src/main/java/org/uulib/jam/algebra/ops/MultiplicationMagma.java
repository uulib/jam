package org.uulib.jam.algebra.ops;

import java.util.Optional;

import org.uulib.jam.algebra.DefaultAlgebraMethods;

public interface MultiplicationMagma<E> {
	
	E multiply(E a, E b);
	
	default Optional<E> pow(E base, int exponent) {
		return DefaultAlgebraMethods.repeatAndCompose(this::multiply, base, exponent);
	}
	
	Optional<E> root(E radicand, int degree);

}
