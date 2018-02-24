package org.uulib.jam.algebra;

import java.util.Optional;

public interface AdditiveMonoid<E> extends AdditiveMagma<E>, EquivalenceRelation<E>, WithZeroElement<E> {
	
	@Override
	default Optional<E> multiply(E element, int multiplier) {
		return multiplier==0 || isZero(element) ? Optional.of(getZeroElement()) : AdditiveMagma.super.multiply(element, multiplier);
	}

}
