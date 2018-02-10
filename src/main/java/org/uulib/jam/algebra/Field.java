package org.uulib.jam.algebra;

import org.uulib.jam.algebra.ops.MultiplicationGroup;

import java8.util.Optional;

/**
 * 
 * @author rowan
 *
 * @param <E>
 */
public interface Field<E> extends Ring<E>, MultiplicationGroup<E> {}
