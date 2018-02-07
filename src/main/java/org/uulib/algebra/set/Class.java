package org.uulib.algebra.set;

/**
 * Represents the mathematical concept of a proper class.
 */
public interface Class<E> {
	
	/**
	 * Determines if an element is a member of this class.
	 * @param element The element to check for membership
	 * @return {@code true} iff the specified element is a member of this class
	 */
	boolean isMember(E element);

}
