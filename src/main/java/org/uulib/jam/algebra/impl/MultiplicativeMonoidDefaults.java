package org.uulib.jam.algebra.impl;

import java.util.Optional;
import java.util.function.BiFunction;

import org.uulib.jam.ObjIntFunction;
import org.uulib.jam.algebra.MultiplicativeMonoid;

public interface MultiplicativeMonoidDefaults<E> extends MultiplicativeMonoid<E> {
	
	static <E> BiFunction<E,E,E> getNonUnitMultiply(MultiplicativeMonoid<E> monoid) {
		return monoid instanceof MultiplicativeMonoidDefaults<?>
				? ((MultiplicativeMonoidDefaults<E>) monoid)::multiplyNonUnit
				: monoid::multiply;
	}
	
	static <E> ObjIntFunction<E,Optional<E>> getNonUnitRoot(MultiplicativeMonoid<E> monoid) {
		return monoid instanceof MultiplicativeMonoidDefaults<?>
				? ((MultiplicativeMonoidDefaults<E>) monoid)::rootNonUnit
				: monoid::root;
	}

	@Override
	default E multiply(E a, E b) {
		return
				isUnit(a) ? b :
				isUnit(b) ? a :
					multiplyNonUnit(a, b);
	}
	
	E multiplyNonUnit(E a, E b);

	@Override
	default Optional<E> root(E radicand, int degree) {
		return
				degree==0                     ? Optional.empty() :
				degree==1 || isUnit(radicand) ? Optional.of(radicand) :
					rootNonUnit(radicand, degree);
	}
	
	Optional<E> rootNonUnit(E radicand, int nonZeroNonOneDegree);

}
