package org.uulib.jam.algebra;

import java.util.Optional;

public interface MultiplicativeGroup<E> extends MultiplicativeMonoid<E>, WithZeroElement<E> {
	
	Optional<E> reciprocal(E element);
	
	default Optional<E> divide(E dividend, E divisor) {
		return reciprocal(divisor).map(d -> multiply(dividend, d));
	}

	@Override
	default Optional<E> pow(E base, int exponent) {
		return exponent<0
				? reciprocal(base).flatMap(b -> MultiplicativeMonoid.super.pow(b, -exponent))
				: MultiplicativeMonoid.super.pow(base, exponent);
	}

}
