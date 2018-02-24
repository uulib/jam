package org.uulib.jam.algebra;

import java.util.Optional;

public interface MultiplicativeMonoid<E> extends MultiplicativeMagma<E>, EquivalenceRelation<E> {
	
	E getUnitElement();
	
	default boolean isUnit(E element) {
		return equal(getUnitElement(), element);
	}

	@Override
	default Optional<E> pow(E base, int exponent) {
		return exponent==0 || isUnit(base) ? Optional.of(getUnitElement()) : MultiplicativeMagma.super.pow(base, exponent);
	}

}
