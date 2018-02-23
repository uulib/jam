package org.uulib.jam.algebra.graded;

import org.uulib.jam.algebra.VectorSpace;

public interface GradedVectorSpace<V,S> extends VectorSpace<V,S> {
	
	VectorSpace<V,S> getFactorSpace(int grade);
	
	int getGrade(V element);
	
	default boolean commensurate(V a, V b) {
		return isZero(a) || isZero(b) || getGrade(a)==getGrade(b);
	}

	/**
	 * TODO explain grade limitation
	 * @param minuend
	 * @param subtrahend
	 * @return
	 */
	@Override
	V subtract(V minuend, V subtrahend) throws IllegalArgumentException;

	/**
	 * TODO always of grade 0; zeros in factor space equivalent
	 * @return
	 */
	@Override
	default V getZeroElement() {
		return getFactorSpace(0).getZeroElement();
	}

	@Override
	default boolean isZero(V element) {
		return getFactorSpace(getGrade(element)).isZero(element);
	}

	/**
	 * TODO explain grade limitation
	 * @param a
	 * @param b
	 * @return
	 */
	@Override
	V add(V a, V b) throws IllegalArgumentException;

}
