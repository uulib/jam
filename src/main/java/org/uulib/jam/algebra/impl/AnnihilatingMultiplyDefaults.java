package org.uulib.jam.algebra.impl;

import java.util.function.BiFunction;

import org.uulib.jam.algebra.MultiplicativeMonoid;
import org.uulib.jam.algebra.WithZeroElement;

public interface AnnihilatingMultiplyDefaults<E> extends MultiplicativeMonoidDefaults<E>, WithZeroElement<E> {
	
	static <E> BiFunction<E,E,E> getNonZeroNonUnitMultiply(MultiplicativeMonoid<E> monoid) {
		return
				monoid instanceof AnnihilatingMultiplyDefaults<?> ? ((AnnihilatingMultiplyDefaults<E>) monoid)::multiplyNonZeroNonUnit :
				monoid instanceof MultiplicativeMonoidDefaults<?> ? ((MultiplicativeMonoidDefaults<E>) monoid)::multiplyNonUnit :
					monoid::multiply;
	}

	@Override
	default E multiplyNonUnit(E a, E b) {
		if(isZero(a) || isZero(b)) {
			return getZeroElement();
		}
		return multiplyNonZeroNonUnit(a, b);
	}
	
	E multiplyNonZeroNonUnit(E a, E b);

}
