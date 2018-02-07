package org.uulib.algebra.group;

/**
 * Represents the mathematical concept of a monoid: a set with a single closed, associative operation between its
 * elements.
 *
 * @param <E> The element type of this monoid
 */
public interface Monoid<E> extends Magma<E> {
	
	/**
	 * Gets the identity element of this monoid's operation.
	 * @return the identity element of this monoid's operation
	 */
	E getIdentity();

}
