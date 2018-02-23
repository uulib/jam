package org.uulib.jam.algebra;

import java.util.Optional;

import org.uulib.jam.algebra.ops.MultiplicationMonoid;

public interface MultiplicativeGroup<E> extends MultiplicationMonoid<E> {
	
	Optional<E> reciprocal(E element);
	
	default Optional<E> divide(E dividend, E divisor) {
		return reciprocal(divisor).map(d -> multiply(dividend, d));
	}

	@Override
	default Optional<E> pow(E base, int exponent) {
		return exponent<0
				? reciprocal(base).flatMap(b -> MultiplicationMonoid.super.pow(b, -exponent))
				: MultiplicationMonoid.super.pow(base, exponent);
	}

}
