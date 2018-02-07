package org.uulib.algebra.geometry;

import org.uulib.algebra.set.Set;

public interface MetricSpace<S, P, F extends ScalarField<S>> extends Set<P> {
	
	F getScalarField();
	
	S distance(P a, P b) throws IllegalArgumentException;

}
