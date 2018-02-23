package org.uulib.jam.algebra;

import org.uulib.jam.algebra.graded.GradedDivisionAlgebra;

public interface InnerProductSpace<V,S,C> extends VectorSpace<V,S> {
	
	/**
	 * The algebra that represents operations on the coefficients of this vector space.
	 * 
	 * This must be 1-dimensional.
	 * @return
	 */
	GradedDivisionAlgebra<C,S> getCoefficientAlgebra();
	
	C innerProduct(V a, V b);

}
