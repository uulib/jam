package org.uulib.jam.algebra.polynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.uulib.jam.algebra.DefaultAlgebraMethods;
import org.uulib.jam.algebra.Field;
import org.uulib.jam.algebra.UnitalAlgebra;
import org.uulib.jam.algebra.polynomial.Polynomial.Builder;

public class PolynomialField<E> implements UnitalAlgebra<Polynomial<E>,E> {
	
	private final Field<E> baseField;
	private final Polynomial<E> zero;
	private final Polynomial<E> unit;
	
	@SuppressWarnings("unchecked")
	PolynomialField(Field<E> baseField) {
		this.baseField = baseField;
		this.zero = new Polynomial<>(0, (E[]) new Object[]{baseField.getZeroElement()});
		this.unit = new Polynomial<>(0, (E[]) new Object[]{baseField.getUnitElement()});
	}

	@Override
	public Polynomial<E> getZeroElement() {
		return zero;
	}

	@Override
	public Polynomial<E> add(Polynomial<E> a, Polynomial<E> b) {
		if(equal(a, zero)) {
			return b;
		}
		if(equal(b, zero)) {
			return a;
		}
		return addAll(a, b);
	}

	@Override
	public Polynomial<E> multiply(Polynomial<E> element, int multiplier) {
		switch(multiplier) {
		case 0: return zero;
		case 1: return element;
		default:
			E[] newCoefficients = element.newCoefficients();
			for(int i=0; i<element.coefficients.length; ++i) {
				newCoefficients[i] = baseField.multiply(element.coefficients[i], multiplier);
			}
			return new Polynomial<>(element.baseDegree, newCoefficients);
		}
	}

	@Override
	public Optional<Polynomial<E>> divide(Polynomial<E> dividend, int divisor) {
		switch(divisor) {
		case 0: return Optional.empty();
		case 1: return Optional.of(dividend);
		default:
			E[] newCoefficients = dividend.newCoefficients();
			
			for(int i=0; i<dividend.coefficients.length; ++i) {
				Optional<E> quotient = baseField.divide(dividend.coefficients[i], divisor);
				if(!quotient.isPresent()) {
					return Optional.empty();
				}
				newCoefficients[i] = quotient.get();
			}
			return Optional.of(new Polynomial<>(dividend.baseDegree, newCoefficients));
		}
	}

	@Override
	public Polynomial<E> getUnitElement() {
		return unit;
	}

	@Override
	public Polynomial<E> multiply(Polynomial<E> a, Polynomial<E> b) {
		if(b.coefficients.length > a.coefficients.length) {
			Polynomial<E> c = a;
			a = b;
			b = c;
		}
		@SuppressWarnings("unchecked") Polynomial<E>[] addenda = new Polynomial[b.coefficients.length];
		for(int i=0; i<b.coefficients.length; ++i) {
			addenda[i] = multiply(a, b.coefficients[i], b.baseDegree + i);
		}
		return addAll(addenda);
	}

	@Override
	public Optional<Polynomial<E>> root(Polynomial<E> radicand, int degree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equal(Polynomial<E> a, Polynomial<E> b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Polynomial<E> negate(Polynomial<E> element) {
		return multiply(element, -1);
	}

	@Override
	public Polynomial<E> subtract(Polynomial<E> minuend, Polynomial<E> subtrahend) {
		if(equal(subtrahend, zero)) {
			return minuend;
		}
		if(equal(minuend, subtrahend)) {
			return zero;
		}
		Builder<E> builder = new Builder<>(baseField, minuend.baseDegree,
				new ArrayList<E>(Arrays.asList(minuend.coefficients)));
		for(int j=0; j<subtrahend.coefficients.length; ++j) {
			builder.addTerm(baseField.negate(subtrahend.coefficients[j]), subtrahend.baseDegree+j);
		}
		return builder.build();
	}
	
	@SafeVarargs
	private final Polynomial<E> addAll(Polynomial<E>... addenda) {
		if(addenda.length==1) {
			return addenda[0];
		} else {
			Builder<E> builder = new Builder<>(baseField, addenda[0].baseDegree,
					new ArrayList<E>(Arrays.asList(addenda[0].coefficients)));
			for(int i=1; i<addenda.length; ++i) {
				for(int j=0; j<addenda[i].coefficients.length; ++j) {
					builder.addTerm(addenda[i].coefficients[j], addenda[i].baseDegree+j);
				}
			}
			return builder.build();
		}
	}

	@Override
	public Field<E> getBaseField() {
		return baseField;
	}

	@Override
	public Polynomial<E> scalarMultiply(Polynomial<E> vector, E scalar) {
		return multiply(vector, scalar, 0);
	}

	@Override
	public Optional<Polynomial<E>> scalarDivide(Polynomial<E> vector, E scalar) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Polynomial<E> multiply(Polynomial<E> p, E coefficient, int exponent) {
		if(baseField.equal(baseField.getZeroElement(), coefficient)) {
			return zero;
		}
		boolean unitCoefficient = baseField.equal(baseField.getUnitElement(), coefficient);
		if(unitCoefficient && exponent==0) {
			return p;
		}
		E[] coefficients = p.coefficients;
		if(!unitCoefficient) {
			coefficients = p.newCoefficients();
			for(int i=0; i<coefficients.length; ++i) {
				coefficients[i] = baseField.multiply(coefficient, coefficients[i]);
			}
		}
		return new Polynomial<>(p.baseDegree+exponent, coefficients);
	}

}
