package org.uulib.jam.algebra.graded;

import java.util.Optional;

import org.uulib.jam.algebra.Field;
import org.uulib.jam.algebra.VectorSpace;

public class AbstractGradedVectorSpace<V,S> implements GradedVectorSpace<V,S> {
	
	private final Field<S> baseField;
	
	protected AbstractGradedVectorSpace(Field<S> baseField) {
		this.baseField = baseField;
	}

	@Override
	public Field<S> getBaseField() {
		return baseField;
	}

	@Override
	public V scalarMultiply(V vector, S scalar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<S> divideToScalar(V dividend, V divisor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V negate(V element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<V> divide(V dividend, int divisor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equal(V a, V b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VectorSpace<V, S> getFactorSpace(int grade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGrade(V element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public V subtract(V minuend, V subtrahend) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V add(V a, V b) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
