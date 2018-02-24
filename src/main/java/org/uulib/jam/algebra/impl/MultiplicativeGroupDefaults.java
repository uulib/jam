package org.uulib.jam.algebra.impl;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

import org.uulib.jam.algebra.MultiplicativeGroup;

public interface MultiplicativeGroupDefaults<E> extends AnnihilatingMultiplyDefaults<E>, MultiplicativeGroup<E> {
	
	static <E> UnaryOperator<E> getNonZeroNonUnitReciprocal(MultiplicativeGroup<E> group) {
		return group instanceof MultiplicativeGroupDefaults<?>
				? ((MultiplicativeGroupDefaults<E>) group)::reciprocalNonZeroNonUnit
				: e -> group.reciprocal(e).get();
	}
	
	static <E> BiFunction<E,E,E> getNonZeroDivide(MultiplicativeGroup<E> group) {
		return group instanceof MultiplicativeGroupDefaults<?>
				? ((MultiplicativeGroupDefaults<E>) group)::divideNonZero
				: (a,b) -> group.divide(a, b).get();
	}

	@Override
	default Optional<E> reciprocal(E element) {
		return isZero(element) ? Optional.empty() :
			Optional.of(isUnit(element) ? getUnitElement() : reciprocalNonZeroNonUnit(element));
	}
	
	E reciprocalNonZeroNonUnit(E nonZeroNonUnitElement);

	@Override
	default Optional<E> divide(E dividend, E divisor) {
		if(isZero(divisor)) {
			return Optional.empty();
		}
		return Optional.of( isZero(dividend)||isUnit(divisor)
				? dividend : divideNonZero(dividend, divisor));
	}
	
	default E divideNonZero(E nonZeroDividend, E nonZeroNonUnitDivisor) {
		return multiply(nonZeroDividend, reciprocalNonZeroNonUnit(nonZeroNonUnitDivisor));
	}

}
