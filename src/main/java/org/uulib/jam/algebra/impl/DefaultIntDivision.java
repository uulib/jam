package org.uulib.jam.algebra.impl;

import java.util.Optional;

import org.uulib.jam.algebra.WithIntMultiplication;
import org.uulib.jam.algebra.WithZeroElement;
import org.uulib.jam.util.ObjIntFunction;

public interface DefaultIntDivision<E> extends WithIntMultiplication<E>, WithZeroElement<E> {
	
	static <E> ObjIntFunction<E, Optional<E>> getNonZeroDivide(WithIntMultiplication<E> structure) {
		return structure instanceof DefaultIntDivision<?>
				? ((DefaultIntDivision<E>) structure)::divideNonZero
				: structure::divide;
	}
	
	@Override
	default Optional<E> divide(E dividend, int divisor) {
		if(divisor==0) {
			return Optional.empty();
		}
		if(divisor==1 || isZero(dividend)) {
			return Optional.of(dividend);
		}
		return divideNonZero(dividend, divisor);
	}
	
	Optional<E> divideNonZero(E dividend, int nonZeroNonOneDivisor);

}
