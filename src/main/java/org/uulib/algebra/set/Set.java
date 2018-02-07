package org.uulib.algebra.set;

/**
 * Represents the mathematical concept of a set.
 * 
 * A set is simply a collection of objects (elements) with a <em>cardinality</em>: analogous to the number of elements
 * in the set, but may be infinite.
 *
 * @param <E> The element type for this set
 */
public interface Set<E> extends Class<E> {
	
	/**
	 * Gets the cardinality of this set.
	 * @return This set's cardinality.
	 */
	Cardinality getCardinality();

}
