package org.uulib.algebra.ring;

import org.uulib.algebra.group.Group;

/**
 * Represents a mathematical field.
 *
 */
public interface Field<E> extends Ring<E> {
	
	/**
	 * Finds the inverse under multiplication of the given element.
	 * @param element The element to find the inverse of
	 * @return The inverse of the given element
	 * @throws IllegalArgumentException If the given element is not a member of the underlying set
	 */
	E getMultiplicativeInverse(E element) throws IllegalArgumentException;
	
	/**
	 * Divides the first given element by the second.
	 * In other words: performs this field's multiplication operation on the first element, and the
	 * {@linkplain #getMultiplicativeInverse(Object) multiplicative inverse} of the second.
	 * @param left The numerator element
	 * @param right The divisor element
	 * @return The resulting element
	 * @throws IllegalArgumentException If either of the given elements is not a member of the underlying set
	 */
	default E divide(E left, E right) throws IllegalArgumentException {
		return multiply(left, getMultiplicativeInverse(right));
	}

	/**
	 * Gets a view of this field as a group under its multiplication operation.
	 * @return This field as a group under multiplication
	 */
	@Override
	default Group<E> asMultiplicationAlgebra() {
		return new MultiplicationGroup<>(this);
	}

}
