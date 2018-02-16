package org.uulib.jam.algebra.apache;

import java8.util.function.Function;

public interface Bijection<I,O> extends Function<I,O> {
	
	I applyInverse(O argument);

}
