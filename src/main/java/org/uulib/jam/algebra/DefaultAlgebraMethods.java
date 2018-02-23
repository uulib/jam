package org.uulib.jam.algebra;

import java.util.Optional;
import java.util.function.BiFunction;

public class DefaultAlgebraMethods {
	
	private DefaultAlgebraMethods() {}
	
	public static <E> Optional<E> repeatAndCompose(BiFunction<E,E,E> operation, E element, int repetitions) {
		if(repetitions<=0) {
			return Optional.empty();
		}
		int reversed = Integer.reverse(repetitions);
		reversed = reversed >> (Integer.numberOfLeadingZeros(repetitions));
		E val = element;
		while((reversed >>= 1) > 0) {
			val = operation.apply(val, val);
			if((reversed & 1)>0) {
				val = operation.apply(val, element);
			}
		}
		return Optional.of(val);
	}

}
