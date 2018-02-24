package org.uulib.jam.algebra;

import java.util.Optional;

public interface PseudoModule<V, S> extends IntMultiplicationClosed<V>, WithZeroAndNegative<V> {

	Field<S> getBaseField();

	V scalarMultiply(V a, S b);

	Optional<S> divideToScalar(V dividend, V divisor);

	Optional<V> scalarDivide(V dividend, S divisor);

}