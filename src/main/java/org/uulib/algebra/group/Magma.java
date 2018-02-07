package org.uulib.algebra.group;

import org.uulib.algebra.set.Set;

/**
 * Represents the mathematical concept of a magma: a set with a single closed operation defined on it.
 *
 * @param <E> The element type of this magma
 */
public interface Magma<E> extends Set<E> {
	
	/**
	 * Perform the operation on the given elements.
	 * @param left The element on the left hand side of the operation
	 * @param right The element on the right hand side of the operation
	 * @return The resultant group element
	 * @throws IllegalArgumentException if either element is not a member of the underlying set
	 */
	E operate(E left, E right) throws IllegalArgumentException;

}
