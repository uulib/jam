package org.uulib.jam.algebra.graded.impl;

import java.util.ArrayList;
import java.util.List;
import org.uulib.jam.algebra.Field;
import org.uulib.jam.algebra.VectorSpace;
import org.uulib.jam.algebra.graded.GradedVectorSpace;

public abstract class AbstractGradedVectorSpace<V,S> implements GradedVectorSpace<V,S> {
	
	private static final int FACTOR_CACHE_SIZE = 3;
	
	private final Field<S> baseField;
	private final List<VectorSpace<V,S>> cachedFactors = new ArrayList<>(FACTOR_CACHE_SIZE);
	
	protected AbstractGradedVectorSpace(Field<S> baseField) {
		this.baseField = baseField;
	}

	@Override
	public Field<S> getBaseField() {
		return baseField;
	}

	@Override
	public VectorSpace<V, S> getFactorSpace(int grade) {
		return (grade>=0 && grade<FACTOR_CACHE_SIZE) ? getCachedFactorSpace(grade) : createFactorSpace(grade);
	}
	
	private VectorSpace<V,S> getCachedFactorSpace(int grade) {
		for(int i=cachedFactors.size(); i<=grade; ++i) {
			cachedFactors.set(i, createFactorSpace(i));
		}
		return cachedFactors.get(grade);
	}
	
	private VectorSpace<V,S> createFactorSpace(int grade) {
		return new DelegatingFactorSpace<>(this, grade, getGradedZero(grade));
	}
	
	protected abstract V getGradedZero(int grade);

}
