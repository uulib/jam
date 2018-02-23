package org.uulib.jam.algebra.ops;

import java.util.Optional;

import org.uulib.jam.algebra.EquivalenceRelation;

public interface AdditionMonoid<E> extends AdditionMagma<E>, EquivalenceRelation<E> {
	
	E getZeroElement();
	
	default boolean isZero(E element) {
		return equal(getZeroElement(), element);
	}

	@Override
	default Optional<E> multiply(E element, int multiplier) {
		return multiplier==0 ? Optional.of(getZeroElement()) : AdditionMagma.super.multiply(element, multiplier);
	}

}
