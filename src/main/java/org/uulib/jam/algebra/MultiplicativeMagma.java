package org.uulib.jam.algebra;

import java.util.Optional;

import org.uulib.jam.algebra.impl.DefaultAlgebraMethods;

public interface MultiplicativeMagma<E> {
	
	E multiply(E a, E b);
	
	default Optional<E> pow(E base, int exponent) {
		return exponent<=0 ? Optional.empty() : Optional.of(DefaultAlgebraMethods.repeatAndCompose(this::multiply, base, exponent));
	}
	
	Optional<E> root(E radicand, int degree);

}
