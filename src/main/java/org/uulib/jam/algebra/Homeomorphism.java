package org.uulib.jam.algebra;

public interface Homeomorphism<A,B> {
	
	B apply(A value);
	
	A applyInverse(B value);

}
