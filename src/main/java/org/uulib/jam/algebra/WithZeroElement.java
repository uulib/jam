package org.uulib.jam.algebra;

public interface WithZeroElement<E> extends EquivalenceRelation<E> {

	E getZeroElement();

	default boolean isZero(E element) {
		return equal(getZeroElement(), element);
	}

}