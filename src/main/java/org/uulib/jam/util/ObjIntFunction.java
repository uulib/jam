package org.uulib.jam.util;

@FunctionalInterface
public interface ObjIntFunction<I,O> {
	
	O apply(I a, int b);

}
