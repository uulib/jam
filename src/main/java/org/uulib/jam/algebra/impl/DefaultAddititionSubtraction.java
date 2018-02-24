package org.uulib.jam.algebra.impl;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

import org.uulib.jam.algebra.AdditiveGroup;
import org.uulib.jam.algebra.AdditiveMagma;
import org.uulib.jam.algebra.WithZeroAndNegative;

public interface DefaultAddititionSubtraction<E> extends WithZeroAndNegative<E> {
	
	@SuppressWarnings("unchecked")
	public static <E> BiFunction<E,E,E> getNonZeroAdd(AdditiveMagma<E> magma) {
		return magma instanceof DefaultAddititionSubtraction<?>
			? ((DefaultAddititionSubtraction<E>) magma)::addNonZero
			: magma::add;
	}
	
	@SuppressWarnings("unchecked")
	public static<E> BiFunction<E,E,E> getNonZeroNonEqualSubtract(AdditiveGroup<E> group) {
		return (group instanceof DefaultAddititionSubtraction<?>)
			? ((DefaultAddititionSubtraction<E>) group)::subtractNonZeroNonEqual
			: group::subtract;
	}
	
	@SuppressWarnings("unchecked")
	public static<E> UnaryOperator<E> getNonZeroNegate(AdditiveGroup<E> group) {
		return (group instanceof DefaultAddititionSubtraction<?>)
			? ((DefaultAddititionSubtraction<E>) group)::negateNonZero
			: group::negate;
	}

	default E add(E a, E b) {
		if(isZero(a)) {
			return b;
		}
		if(isZero(b)) {
			return a;
		}
		return addNonZero(a, b);
	}
	
	E addNonZero(E a, E b);
	
	default E subtract(E minuend, E subtrahend) {
		if(isZero(subtrahend)) {
			return minuend;
		}
		if(isZero(minuend)) {
			return negateNonZero(subtrahend);
		}
		if(equal(minuend, subtrahend)) {
			return getZeroElement();
		}
		return subtractNonZeroNonEqual(minuend, subtrahend);
	}
	
	E subtractNonZeroNonEqual(E minuend, E subtrahend);

	@Override
	default E negate(E element) {
		return isZero(element) ? element : negateNonZero(element);
	}
	
	E negateNonZero(E element);

}
