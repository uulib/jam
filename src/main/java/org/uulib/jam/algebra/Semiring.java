package org.uulib.jam.algebra;

/**
 * An interface representing the operations of <a href="https://en.wikipedia.org/wiki/Semiring">semiring</a> algebraic structure.
 *
 * @param <E> The element type this semiring operates on
 */
public interface Semiring<E> extends AdditiveMonoid<E>, MultiplicativeMonoid<E> {}
