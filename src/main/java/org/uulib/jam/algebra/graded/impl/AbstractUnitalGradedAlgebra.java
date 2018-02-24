package org.uulib.jam.algebra.graded.impl;

import org.uulib.jam.algebra.Field;
import org.uulib.jam.algebra.graded.GradedUnitalAlgebra;

public abstract class AbstractUnitalGradedAlgebra<V,S> extends AbstractGradedVectorSpace<V,S> implements GradedUnitalAlgebra<V,S> {
	
	private final V unit;

	protected AbstractUnitalGradedAlgebra(Field<S> baseField, V unit) {
		super(baseField);
		this.unit = unit;
	}

	@Override
	public V getUnitElement() {
		return unit;
	}

}
