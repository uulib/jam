package org.uulib.jam.algebra.impl;

import java.util.function.BiFunction;

import org.uulib.jam.algebra.WithZeroAndNegative;
import org.uulib.jam.algebra.WithZeroElement;

public class DefaultAlgebraMethods {
	
	private DefaultAlgebraMethods() {}
	
	public static <E> E multiply(BiFunction<E,E,E> addition, WithZeroAndNegative<E> structure, E element, int multiplier) {
		if(multiplier==0 || structure.isZero(element)) {
			return structure.getZeroElement();
		}
		if(multiplier<1) {
			multiplier = -multiplier;
			element = structure.negate(element);
		}
		return repeatAndCompose(addition, element, multiplier);
	}
	
	public static <E> E repeatAndCompose(BiFunction<E,E,E> operation, E element, int repetitions) {
		assert repetitions>0;
		int reversed = Integer.reverse(repetitions);
		reversed = reversed >> (Integer.numberOfLeadingZeros(repetitions));
		E val = element;
		while((reversed >>= 1) > 0) {
			val = operation.apply(val, val);
			if((reversed & 1)>0) {
				val = operation.apply(val, element);
			}
		}
		return val;
	}

}
