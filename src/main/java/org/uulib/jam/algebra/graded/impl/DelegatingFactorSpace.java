package org.uulib.jam.algebra.graded.impl;

import java.util.Optional;

import org.uulib.jam.algebra.Field;
import org.uulib.jam.algebra.NotAMemberException;
import org.uulib.jam.algebra.VectorSpace;
import org.uulib.jam.algebra.graded.GradedVectorSpace;

public class DelegatingFactorSpace<V,S> implements VectorSpace<V,S> {
	
	private final GradedVectorSpace<V,S> superSpace;
	private final int grade;
	private final V zero;
	
	public DelegatingFactorSpace(GradedVectorSpace<V,S> superSpace, int grade, V zero) {
		this.superSpace = superSpace;
		this.grade = grade;
		this.zero = zero;
	}
	
	protected final V checkGrade(V element) {
		if(superSpace.getGrade(element)!=grade) {
			throw new NotAMemberException();
		}
		return element;
	}
	
	@Override
	public V getZeroElement() {
		return zero;
	}

	@Override
	public boolean isZero(V element) {
		return superSpace.isZero(checkGrade(element));
	}


	@Override
	public V negate(V element) {
		return superSpace.negate(checkGrade(element));
	}
	
	@Override
	public V add(V a, V b) {
		return superSpace.add(checkGrade(a), checkGrade(b));
	}

	@Override
	public V subtract(V minuend, V subtrahend) {
		return superSpace.subtract(checkGrade(minuend), checkGrade(subtrahend));
	}
	
	@Override
	public Optional<V> multiply(V element, int multiplier) {
		return superSpace.multiply(checkGrade(element), multiplier);
	}

	@Override
	public Optional<V> divide(V dividend, int divisor) {
		return superSpace.divide(checkGrade(dividend), divisor);
	}

	@Override
	public boolean equal(V a, V b) {
		return superSpace.equal(a, b);
	}

	@Override
	public Field<S> getBaseField() {
		return superSpace.getBaseField();
	}

	@Override
	public V scalarMultiply(V vector, S scalar) {
		return superSpace.scalarMultiply(checkGrade(vector), scalar);
	}

	@Override
	public Optional<S> divideToScalar(V dividend, V divisor) {
		return superSpace.divideToScalar(checkGrade(dividend), checkGrade(divisor));
	}

	@Override
	public Optional<V> scalarDivide(V dividend, S divisor) {
		return superSpace.scalarDivide(dividend, divisor);
	}

}
