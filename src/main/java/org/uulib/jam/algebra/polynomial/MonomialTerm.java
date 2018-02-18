package org.uulib.jam.algebra.polynomial;

class MonomialTerm<E> extends Term<E> {
	
	private E coefficient;
	private int degree;
	
	MonomialTerm(E coefficient, int degree) {
		this.coefficient = coefficient;
		this.degree = degree;
	}
	
	E getCoefficient() {
		return coefficient;
	}
	
	MonomialTerm<E> withCoefficient(E newCoefficient) {
		this.coefficient = newCoefficient;
		return this;
	}
	
	int getDegree() {
		return degree;
	}
	
	MonomialTerm<E> withDegree(int newDegree) {
		this.degree = newDegree;
		return this;
	}

	@Override
	public Term<E> copyOnWrite() {
		return cow;
	}
	
	private final Term<E> cow = new Term<E>() {

		@Override
		E getCoefficient() {
			return coefficient;
		}

		@Override
		int getDegree() {
			return degree;
		}

		@Override
		Term<E> withCoefficient(E coefficient) {
			return new MonomialTerm<E>(coefficient, degree);
		}

		@Override
		Term<E> withDegree(int degree) {
			return new MonomialTerm<E>(coefficient, degree);
		}

		@Override
		Term<E> copyOnWrite() {
			return this;
		}
		
	};

}
