package org.uulib.jam.algebra;

public interface InnerProductSpace<V,S,C> extends VectorSpace<V, S> {
	
	/**
	 * The algebra that represents operations on the coefficients of this vector space.
	 * 
	 * This must be 1-dimensional.
	 * @return
	 */
	UnitalGradedAlgebra<C, S> getCoefficientAlgebra();
	
	int getCoefficientGrade();
	
	C innerProduct(V a, V b);

}
