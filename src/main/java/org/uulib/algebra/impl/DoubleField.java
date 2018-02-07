package org.uulib.algebra.impl;

import org.uulib.algebra.geometry.Angle;
import org.uulib.algebra.geometry.ScalarField;
import org.uulib.algebra.set.Cardinality;

public class DoubleField implements ScalarField<Double> {
	
	public static final DoubleField INSTANCE = new DoubleField();
	
	private static final Double ZERO = Double.valueOf(0.0);
	private static final Double ONE = Double.valueOf(1.0);
	
	private DoubleField() {}

	@Override
	public Double getAdditiveInverse(Double element) throws IllegalArgumentException {
		assert isMember(element);
		return Double.valueOf(0.0 - element.doubleValue());
	}

	@Override
	public Double add(Double a, Double b) throws IllegalArgumentException {
		assert isMember(a);
		assert isMember(b);
		return Double.valueOf(a.doubleValue() + b.doubleValue());
	}
	
	@Override
	public Double subtract(Double left, Double right) throws IllegalArgumentException {
		assert isMember(left);
		assert isMember(right);
		return Double.valueOf(left.doubleValue() - right.doubleValue());
	}

	@Override
	public Double getAdditiveIdentity() {
		return ZERO;
	}
	
	@Override
	public Double getMultiplicativeInverse(Double element) throws IllegalArgumentException {
		assert isMember(element);
		return Double.valueOf(1.0 / element.doubleValue());
	}

	@Override
	public Double multiply(Double left, Double right) throws IllegalArgumentException {
		assert isMember(left);
		assert isMember(right);
		return Double.valueOf(left.doubleValue() * right.doubleValue());
	}

	@Override
	public Double divide(Double left, Double right) throws IllegalArgumentException {
		assert isMember(left);
		assert isMember(right);
		if(right.equals(ZERO)) {
			throw new IllegalArgumentException();
		}
		return Double.valueOf(left.doubleValue() / right.doubleValue());
	}

	@Override
	public Double getMultiplicativeIdentity() {
		return ONE;
	}

	@Override
	public Cardinality getCardinality() {
		return Cardinality.UNCOUNTABLE_INFINITY;
	}

	@Override
	public boolean isMember(Double element) {
		return !element.isNaN() && !element.isInfinite();
	}

	@Override
	public int compare(Double o1, Double o2) {
		return o1.compareTo(o2);
	}

	@Override
	public Double squareRoot(Double element) throws IllegalArgumentException {
		return Double.valueOf(Math.sqrt(element.doubleValue()));
	}

	@Override
	public Angle arccos(Double element) throws IllegalArgumentException {
		if(element.isNaN() || element > 1.0) {
			throw new IllegalArgumentException("Value is not in the range [-1,1].");
		}
		return Angle.ofRadians(Math.acos(element));
	}

	@Override
	public Double cosine(Angle angle) {
		return Double.valueOf(Math.cos(angle.getRadians()));
	}

}
