package org.uulib.algebra.geometry;

public interface EuclideanSpace<S,P,V, F extends ScalarField<S>> extends AffineSpace<S, P, V, F>, MetricSpace<S, P, F> {
	
	@Override
	InnerProductSpace<S, V, F> getVectorSpace();

	@Override
	default S distance(P a, P b) throws IllegalArgumentException {
		return getVectorSpace().norm(subtract(a, b));
	}

	@Override
	default F getScalarField() {
		return AffineSpace.super.getScalarField();
	}

}
