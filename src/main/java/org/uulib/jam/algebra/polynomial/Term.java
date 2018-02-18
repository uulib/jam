package org.uulib.jam.algebra.polynomial;

abstract class Term<E> {
	
	abstract E getCoefficient();
	
	abstract int getDegree();
	
	abstract Term<E> withCoefficient(E coefficient);
	
	abstract Term<E> withDegree(int degree);
	
	abstract Term<E> copyOnWrite();

}
