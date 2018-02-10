package org.uulib.jam.algebra;

import org.uulib.jam.algebra.ops.MultiplicationMonoid;

public interface UnitalAlgebra<V,S> extends Algebra<V,S>, MultiplicationMonoid<V> {}
