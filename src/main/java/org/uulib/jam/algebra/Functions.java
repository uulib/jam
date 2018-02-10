package org.uulib.jam.algebra;

public class Functions {
	
	private Functions() {}
	
	public static <A,B> Homeomorphism<B,A> inverse(Homeomorphism<A,B> homeomorphism) {
		if(homeomorphism instanceof InverseHomeomorphism<?,?>) {
			return ((InverseHomeomorphism<B,A>) homeomorphism).original;
		}
		return new InverseHomeomorphism<>(homeomorphism);
	}
	
	private static final class InverseHomeomorphism<A,B> implements Homeomorphism<B,A> {
		
		private final Homeomorphism<A,B> original;
		
		InverseHomeomorphism(Homeomorphism<A,B> original) {
			this.original = original;
		}

		@Override
		public A apply(B value) {
			return original.applyInverse(value);
		}

		@Override
		public B applyInverse(A value) {
			return original.apply(value);
		}
		
	}

}
