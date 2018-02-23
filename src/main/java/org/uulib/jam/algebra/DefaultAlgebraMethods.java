package org.uulib.jam.algebra;

import org.uulib.jam.algebra.ops.MultiplicationMagma;

import java8.util.function.BiFunction;

public class DefaultAlgebraMethods {
	
	private DefaultAlgebraMethods() {}
	
	public static <E> E pow(MultiplicationMagma<E> magma, E element, int exponent) {
		return repeatAndCompose(new MultiplyOperation<>(magma), element, exponent);
	}
	
	private static <E> E repeatAndCompose(BiFunction<E,E,E> operation, E element, int repetitions) {
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
	
	private static class MultiplyOperation<E> implements BiFunction<E,E,E> {
		private final MultiplicationMagma<E> magma;
		
		MultiplyOperation(MultiplicationMagma<E> magma) {
			this.magma = magma;
		}

		@Override
		public E apply(E t, E u) {
			return magma.multiply(t, u);
		}
		
	}

}
