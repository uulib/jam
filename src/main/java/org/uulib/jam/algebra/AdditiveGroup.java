package org.uulib.jam.algebra;

import java.util.Optional;

import org.uulib.jam.algebra.impl.DefaultAlgebraMethods;

public interface AdditiveGroup<E> extends AdditiveMonoid<E>, WithZeroAndNegative<E>, IntMultiplicationClosed<E> {
	
	E subtract(E minuend, E subtrahend);
	
	default E multiply(int multiplier, E element) {
		return DefaultAlgebraMethods.multiply(this::add, this, element, multiplier);
	}

	@Override
	default Optional<E> multiply(E element, int multiplier) {
		return IntMultiplicationClosed.super.multiply(element, multiplier);
	}

}
