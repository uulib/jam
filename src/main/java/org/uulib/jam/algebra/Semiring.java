package org.uulib.jam.algebra;

import org.uulib.jam.algebra.ops.AdditionMonoid;
import org.uulib.jam.algebra.ops.MultiplicationMonoid;

/**
 * An interface representing the operations of <a href="https://en.wikipedia.org/wiki/Semiring">semiring</a> algebraic structure.
 *
 * @param <E> The element type this semiring operates on
 */
public interface Semiring<E> extends AdditionMonoid<E>, MultiplicationMonoid<E> {}
