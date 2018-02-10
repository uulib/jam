package org.uulib.jam.algebra;

import org.uulib.jam.algebra.ops.MultiplicationMagma;

public interface GradedAlgebra<V,S> extends GradedVectorSpace<V, S>, MultiplicationMagma<V> {

}
