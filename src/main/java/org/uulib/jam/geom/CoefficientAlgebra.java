package org.uulib.jam.geom;

import org.uulib.jam.algebra.Equivalences;
import org.uulib.jam.algebra.Field;
import org.uulib.jam.algebra.Homeomorphism;
import org.uulib.jam.algebra.UnitalGradedAlgebra;
import org.uulib.jam.algebra.VectorSpace;

import java8.util.Optional;

public class CoefficientAlgebra<E> implements UnitalGradedAlgebra<Scalar<E>, E> {
	
	private final Field<E> scalarField;z
	private final Scalar<E> unit;
	
	CoefficientAlgebra(Field<E> scalarField) {
		this.scalarField = scalarField;
		this.unit = new Scalar<>(scalarField.getUnitElement(), 0);
	}

	@Override
	public int getMaxDegree() {
		return -1;
	}

	@Override
	public VectorSpace<Scalar<E>, E> getFactorSpace(int degree) {
		return Equivalences.transform(Equivalences.asAlgebra(scalarField), new FactorHomeomorphism<E>(degree));
	}

	@Override
	public Field<E> getScalarField() {
		return scalarField;
	}

	@Override
	public Scalar<E> multiply(Scalar<E> a, Scalar<E> b) {
		return new Scalar<>(scalarField.multiply(a.getValue(), b.getValue()), a.getGrade() + b.getGrade());
	}

	@Override
	public Optional<Scalar<E>> sqrt(Scalar<E> element) {
		int grade = element.getGrade();
		if(grade%2==0) {
			Optional<E> fSqrt = scalarField.sqrt(element.getValue());
			if(fSqrt.isPresent()) {
				return Optional.of(new Scalar<>(fSqrt.get(), grade/2));
			}
		}
		return Optional.empty();
	}

	@Override
	public Scalar<E> getUnitElement() {
		return unit;
	}
	
	private static class FactorHomeomorphism<E> implements Homeomorphism<Scalar<E>,E> {
		
		private final int degree;
		
		FactorHomeomorphism(int degree) {
			this.degree = degree;
		}

		@Override
		public E apply(Scalar<E> value) {
			if(value.getGrade()!=degree) {
				throw new IllegalArgumentException("Incompatible scalar grade.");
			}
			return value.getValue();
		}

		@Override
		public Scalar<E> applyInverse(E value) {
			return new Scalar<>(value, degree);
		}
		
	}

}
