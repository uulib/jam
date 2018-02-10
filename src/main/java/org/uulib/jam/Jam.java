package org.uulib.jam;

import org.uulib.jam.algebra.ops.AdditionMonoid;

public class Jam {
	
	private Jam() {}
	
	public static <E> E multiply(AdditionMonoid<E> monoid, E element, int times) {
		if(times<0) {
			throw new IllegalArgumentException("Integer multiple must be non-negative.");
		} else if(times==0) {
			return monoid.getZeroElement();
		}
		E rc = element;
		for(int i=1; i<times; ++i) {
			rc = monoid.add(rc, element);
		}
		return rc;
	}

}
