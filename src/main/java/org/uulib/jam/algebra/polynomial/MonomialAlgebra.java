package org.uulib.jam.algebra.polynomial;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.uulib.jam.algebra.Field;
import org.uulib.jam.algebra.VectorSpace;
import org.uulib.jam.algebra.graded.DelegatingFactorSpace;
import org.uulib.jam.algebra.graded.GradedDivisionAlgebra;

public class MonomialAlgebra<E> implements GradedDivisionAlgebra<Monomial<E>,E> {
	
	private final Field<E> baseField;
	private final E[] zeroCoefficient;
	private final Monomial<E> unit;
	private final List<VectorSpace<Monomial<E>,E>> cachedFactors;
	
	@SuppressWarnings("unchecked")
	MonomialAlgebra(Field<E> baseField) {
		this.baseField = baseField;
		this.unit = new Monomial<>(0, baseField.getUnitElement());
		this.zeroCoefficient = (E[]) new Object[] {baseField.getZeroElement()};
		this.cachedFactors = Arrays.asList(
				createFactorSpace(0), createFactorSpace(1), createFactorSpace(2));
	}
	
	@Override
	public Field<E> getBaseField() {
		return baseField;
	}

	@Override
	public VectorSpace<Monomial<E>, E> getFactorSpace(int grade) {
		return grade<cachedFactors.size() ? cachedFactors.get(grade) : createFactorSpace(grade);
	}
	
	private VectorSpace<Monomial<E>,E> createFactorSpace(int grade) {
		return new DelegatingFactorSpace<>(this, grade, new Monomial<>(grade, zeroCoefficient));
	}

	@Override
	public int getGrade(Monomial<E> element) {
		return element.getExponent();
	}
	
	@Override
	public Monomial<E> add(Monomial<E> a, Monomial<E> b) throws IllegalArgumentException {
		if(isZero(a)) {
			return b;
		}
		if(isZero(b)) {
			return a;
		}
		if(getGrade(a)!=getGrade(b)) {
			
		}
	}

	@Override
	public Monomial<E> subtract(Monomial<E> minuend, Monomial<E> subtrahend) throws IllegalArgumentException {
		if
	}

	@Override
	public Monomial<E> scalarMultiply(Monomial<E> vector, E scalar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<E> divideToScalar(Monomial<E> dividend, Monomial<E> divisor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Monomial<E> negate(Monomial<E> element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Monomial<E>> divide(Monomial<E> dividend, int divisor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equal(Monomial<E> a, Monomial<E> b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Monomial<E> multiply(Monomial<E> a, Monomial<E> b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Monomial<E>> root(Monomial<E> radicand, int degree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Monomial<E> getUnitElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Monomial<E>> reciprocal(Monomial<E> element) {
		// TODO Auto-generated method stub
		return null;
	}

}
