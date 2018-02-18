package org.uulib.jam.algebra.element;

public interface AdditiveGroupElement<E extends AdditiveGroupElement<E>> extends AdditiveMagmaElement<E> {
	
	E negate();
	
	E minus(E subtrahend);

}
