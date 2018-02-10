package org.uulib.jam.algebra;

import org.uulib.jam.algebra.ops.MultiplicationMagma;

public interface Algebra<V,S> extends VectorSpace<V,S>, MultiplicationMagma<V> {

}
