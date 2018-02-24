package org.uulib.jam.algebra.graded.impl;

import java.util.Optional;

import org.uulib.jam.algebra.graded.GradedVectorSpace;
import org.uulib.jam.algebra.graded.IncommensurateException;
import org.uulib.jam.algebra.impl.DefaultAddititionSubtraction;
import org.uulib.jam.algebra.impl.DefaultAlgebraMethods;
import org.uulib.jam.algebra.impl.ModuleDefaults;

public interface GradedVectorSpaceDefaults<V,S> extends GradedVectorSpace<V,S>, ModuleDefaults<V,S>, DefaultAddititionSubtraction<V> {
	
	@Override
	default boolean commensurate(V a, V b) {
		return isZero(a) || isZero(b) || areGradesEqual(a, b);
	}
	
	@Override
	default boolean equal(V a, V b) {
		return (isZero(a) && isZero(b)) || (areGradesEqual(a, b) && areCommensurateVectorsEqual(a, b));
	}
	
	default boolean areGradesEqual(V a, V b) {
		return getGrade(a) == getGrade(b);
	}
	
	boolean areCommensurateVectorsEqual(V a, V b);

	@Override
	default V addNonZero(V a, V b) {
		if(!areGradesEqual(a, b)) {
			throw new IncommensurateException("Cannot add elements with differing grades.");
		}
		return addNonZeroCommensurate(a, b);
	}
	
	@Override
	default V multiply(int multiplier, V element) {
		return DefaultAlgebraMethods.multiply(this::addNonZeroCommensurate, this, element, multiplier);
	}

	V addNonZeroCommensurate(V a, V b);

	@Override
	default V subtractNonZeroNonEqual(V minuend, V subtrahend) {
		if(!areGradesEqual(minuend, subtrahend)) {
			throw new IncommensurateException("Cannot add elements with differing grades.");
		}
		return subtractNonZeroNonEqualCommensurate(minuend, subtrahend);
	}
	
	V subtractNonZeroNonEqualCommensurate(V minuend, V subtrahend);
	
	@Override
	default Optional<S> divideNonZeroNonEqualToScalar(V dividend, V divisor) {
		return areGradesEqual(dividend, divisor) ? divideNonZeroNonEqualCommensurateToScalar(dividend, divisor) : Optional.empty();
	}

	Optional<S> divideNonZeroNonEqualCommensurateToScalar(V dividend, V divisor);

}
