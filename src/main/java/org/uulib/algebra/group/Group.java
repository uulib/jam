package org.uulib.algebra.group;

/**
 * Represents a mathematical group.
 *
 * @param <E> The element-type of this group.
 */
public interface Group<E> extends Monoid<E> {
	
	/**
	 * Gets the inverse under this group's operation of the given element.
	 * @param element The element to find the inverse of
	 * @return The inverse of the given element
	 * @throws IllegalArgumentException if the given element is not a member of the underlying set
	 */
	E getInverse(E element) throws IllegalArgumentException;

}
