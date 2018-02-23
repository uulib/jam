package org.uulib.jam.algebra.ops;

import java.util.Optional;

import org.uulib.jam.algebra.EquivalenceRelation;

public interface MultiplicationMonoid<E> extends MultiplicationMagma<E>, EquivalenceRelation<E> {
	
	E getUnitElement();
	
	default boolean isUnit(E element) {
		return equal(getUnitElement(), element);
	}

	@Override
	default Optional<E> pow(E base, int exponent) {
		return exponent==0 ? Optional.of(getUnitElement()) : MultiplicationMagma.super.pow(base, exponent);
	}

}
