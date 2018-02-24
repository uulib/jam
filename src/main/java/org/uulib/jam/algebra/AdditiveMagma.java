package org.uulib.jam.algebra;

import java.util.Optional;

import org.uulib.jam.algebra.impl.DefaultAlgebraMethods;

public interface AdditiveMagma<E> extends WithIntMultiplication<E> {
	
	E add(E a, E b);
	
	@Override
	default Optional<E> multiply(E element, int multiplier) {
		return multiplier<=0 ? Optional.empty() :
			Optional.of(DefaultAlgebraMethods.repeatAndCompose(this::add, element, multiplier));
	}

}
