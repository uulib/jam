package org.uulib.jam;

@FunctionalInterface
public interface ObjIntFunction<I,O> {
	
	O apply(I a, int b);

}
