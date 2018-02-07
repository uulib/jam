package org.uulib.algebra.ring;

import org.uulib.algebra.group.Group;

/**
 * Represents the mathematical concept of a ring.
 *
 * @param <E> The element type of this ring
 */
public interface Ring<E> extends Semiring<E> {
	
	/**
	 * Finds the inverse under addition of the given element.
	 * @param element The element to find the inverse of
	 * @return The inverse of the given element
	 * @throws IllegalArgumentException If the given element is not a member of the underlying set
	 */
	E getAdditiveInverse(E element) throws IllegalArgumentException;
	
	/**
	 * Subtracts the second given element from the first.
	 * In other words: performs this ring's addition operation on the first element, and the
	 * {@linkplain #getAdditiveInverse(Object) additive inverse} of the second.
	 * @param left The element to subtract from
	 * @param right The element to subtract
	 * @return The resulting element
	 * @throws IllegalArgumentException If either of the given elements is not a member of the underlying set
	 */
	default E subtract(E left, E right) throws IllegalArgumentException {
		return add(left, getAdditiveInverse(right));
	}

	/**
	 * Gets a view of this ring as a group under its addition operation.
	 * @return This ring as a group under addition
	 */
	@Override
	default Group<E> asAdditionAlgebra() {
		return new AdditionGroup<>(this);
	}

}
