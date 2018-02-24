package org.uulib.jam.algebra.impl;

import java.util.Optional;

import org.uulib.jam.algebra.PseudoModule;

public interface ModuleDefaults<V,S> extends PseudoModule<V,S>, DefaultIntDivision<V> {

	@Override
	default V scalarMultiply(V a, S b) {
		if(getBaseField().isZero(b) || isZero(a)) {
			return getZeroElement();
		}
		if(getBaseField().isUnit(b)) {
			return a;
		}
		return scalarMultiplyNonZeroNonUnit(a, b);
	}
	
	V scalarMultiplyNonZeroNonUnit(V nonZeroA, S nonZeroNonUnitB);

	@Override
	default Optional<S> divideToScalar(V dividend, V divisor) {
		return
				isZero(divisor)          ? Optional.empty() :
				isZero(dividend)         ? Optional.of(getBaseField().getZeroElement()) :
				equal(dividend, divisor) ? Optional.of(getBaseField().getUnitElement()) :
					divideNonZeroNonEqualToScalar(dividend, divisor);
	}
	
	Optional<S> divideNonZeroNonEqualToScalar(V dividend, V divisor);

	@Override
	default Optional<V> scalarDivide(V dividend, S divisor) {
		if(getBaseField().isZero(divisor)) {
			return Optional.empty();
		}
		return Optional.of( getBaseField().isUnit(divisor)||isZero(dividend)
				? dividend : scalarDivideNonZeroNonUnit(dividend, divisor));
	}
	
	V scalarDivideNonZeroNonUnit(V nonZeroDividend, S nonZeroNonUnitDivisor);

}
