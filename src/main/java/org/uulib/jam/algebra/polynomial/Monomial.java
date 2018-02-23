package org.uulib.jam.algebra.polynomial;

public class Monomial<E> extends Polynomial<E> {

	Monomial(int baseDegree, E coefficient) {
		super(baseDegree, (E[]) new Object[]{coefficient});
	}

}
