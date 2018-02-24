package org.uulib.jam.algebra.graded;

import org.uulib.jam.algebra.PseudoModule;
import org.uulib.jam.algebra.VectorSpace;

public interface GradedVectorSpace<V,S> extends PseudoModule<V,S> {
	
	VectorSpace<V,S> getFactorSpace(int grade);
	
	int getGrade(V element);
	
	boolean commensurate(V a, V b);

	/**
	 * TODO explain grade limitation
	 * @param minuend
	 * @param subtrahend
	 * @return
	 */
	V subtract(V minuend, V subtrahend) throws IllegalArgumentException;

	/**
	 * TODO always of grade 0; zeros in factor space equivalent
	 * @return
	 */
	@Override
	default V getZeroElement() {
		return getFactorSpace(0).getZeroElement();
	}

	/**
	 * TODO explain grade limitation
	 * @param a
	 * @param b
	 * @return
	 */
	V add(V a, V b) throws IllegalArgumentException;

}
