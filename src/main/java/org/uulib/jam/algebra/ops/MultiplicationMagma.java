package org.uulib.jam.algebra.ops;

import java8.util.Optional;

public interface MultiplicationMagma<E> {
	
	E multiply(E a, E b);
	
	Optional<E> sqrt(E element);

}
