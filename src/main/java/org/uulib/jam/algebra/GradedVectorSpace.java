package org.uulib.jam.algebra;

public interface GradedVectorSpace<V,S> {
	
	VectorSpace<V,S> getFactorSpace(int degree);
	
	Field<S> getScalarField();

}
