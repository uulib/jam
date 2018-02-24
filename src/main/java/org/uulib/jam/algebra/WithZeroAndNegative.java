package org.uulib.jam.algebra;

public interface WithZeroAndNegative<E> extends WithZeroElement<E> {

	E negate(E element);

}