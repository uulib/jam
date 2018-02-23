package org.uulib.jam.algebra.polynomial;

public class Monomial<E> extends Polynomial<E> {

	@SuppressWarnings("unchecked")
	Monomial(int exponent, E coefficient) {
		this(exponent, (E[]) new Object[]{coefficient});
	}
	
	Monomial(int exponent, E[] coefficient) {
		super(exponent, coefficient);
		assert coefficient.length==1;
	}
	
	E getCoeficient() {
		return coefficients[0];
	}
	
	int getExponent() {
		return baseDegree;
	}

}
