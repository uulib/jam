package org.uulib.jam.algebra;

import org.uulib.jam.algebra.ops.MultiplicationMonoid;

public interface UnitalGradedAlgebra<V,S> extends GradedAlgebra<V,S>, MultiplicationMonoid<V> {}
