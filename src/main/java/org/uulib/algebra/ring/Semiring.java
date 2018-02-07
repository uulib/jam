package org.uulib.algebra.ring;

import org.uulib.algebra.group.Monoid;
import org.uulib.algebra.set.Set;

public interface Semiring<E> extends Set<E> {

	/**
	 * Performs this ring's addition operation on the given elements.
	 * @param a The first element to add
	 * @param b The second element to add
	 * @return The result of adding the given elements
	 * @throws IllegalArgumentException If either of the given elements is not a member of the underlying set
	 */
	E add(E a, E b) throws IllegalArgumentException;

	/**
	 * Gets the additive identity element of this ring.
	 * @return The additive identity
	 */
	E getAdditiveIdentity();

	/**
	 * Perform this ring's multiplication operation on the given elements.
	 * @param left The element on the left hand side of the multiplication
	 * @param right The element on the right hand side of the multiplication
	 * @return The resultant group element
	 * @throws IllegalArgumentException if either element is not a member of the underlying set
	 */
	E multiply(E left, E right) throws IllegalArgumentException;

	/**
	 * Gets the multiplicative identity element of this ring.
	 * @return The multiplicative identity
	 */
	E getMultiplicativeIdentity();
	
	/**
	 * Gets a view of this ring as a monoid under its addition operation.
	 * @return This ring as a monoid under addition
	 */
	default Monoid<E> asAdditionAlgebra() {
		return new AdditionMonoid<>(this);
	}

	/**
	 * Gets a view of this ring as a monoid under its multiplication operation.
	 * @return This ring as a monoid under multiplication
	 */
	default Monoid<E> asMultiplicationAlgebra() {
		return new MultiplicationMonoid<>(this);
	}

}