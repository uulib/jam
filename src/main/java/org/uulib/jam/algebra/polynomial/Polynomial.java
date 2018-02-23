package org.uulib.jam.algebra.polynomial;

import java.util.ArrayList;
import java.util.List;
import org.uulib.jam.algebra.Field;

public class Polynomial<E> {
	final int baseDegree;
	final E[] coefficients;
	
	Polynomial(int baseDegree, E[] coefficients) {
		this.baseDegree = baseDegree;
		this.coefficients = coefficients;
	}
	
	E[] newCoefficients() {
		return newCoefficients(coefficients.length);
	}
	
	@SuppressWarnings("unchecked")
	private static <E> E[] newCoefficients(int length) {
		return (E[]) new Object[length];
	}
	
	static class Builder<E> {
		
		private final Field<E> baseField;
		private final List<E> coefficients;
		private int baseDegree = -1;
		
		Builder(Field<E> baseField) {
			this(baseField, -1, new ArrayList<E>());
		}
		
		Builder(Field<E> baseField, int baseDegree, List<E> coefficients) {
			this.baseField = baseField;
			this.baseDegree = baseDegree;
			this.coefficients = coefficients;
		}
		
		Builder<E> addTerm(E coefficient, int degree) {
			if(baseDegree==-1) { // First term
				coefficients.add(coefficient);
				baseDegree = degree;
			} else if(degree < baseDegree) {
				while(baseDegree-- > degree) {
					coefficients.add(0, baseField.getZeroElement());
				}
				coefficients.add(0, coefficient);
			} else if(baseDegree+coefficients.size() <= degree) {
				for(int i=baseDegree+coefficients.size(); i<degree; ++i) {
					coefficients.add(baseField.getZeroElement());
				}
				coefficients.add(coefficient);
			} else {
				coefficients.set(degree-baseDegree,
						baseField.add(coefficients.get(degree-baseDegree), coefficient));
			}
			return this;
		}
		
		private E[] getCoefficientArray() {
			return coefficients.toArray(Polynomial.<E>newCoefficients(coefficients.size()));
		}
		
		Polynomial<E> build() {
			return new Polynomial<>(baseDegree, getCoefficientArray());
		}
		
	}

}
