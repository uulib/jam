package org.uulib.algebra.geometry;

public interface InnerProductSpace<S, V, F extends ScalarField<S>> extends NormedVectorSpace<S, V, F> {
	
	S innerProduct(V a, V b) throws IllegalArgumentException;

	@Override
	default S norm(V vector) throws IllegalArgumentException {
		return getScalarField().squareRoot(innerProduct(vector, vector));
	}
	
	default boolean orthogonal(V a, V b) throws IllegalArgumentException {
		return getScalarField().getAdditiveIdentity().equals(innerProduct(a, b));
	}
	
	default boolean parallel(V a, V b) throws IllegalArgumentException {
		F field = getScalarField();
		S ip = innerProduct(a, b);
		return field.isPositive(ip) &&
				field.multiply(innerProduct(a,a), innerProduct(b,b)).equals(field.multiply(ip, ip));
	}
	
	default Angle angle(V a, V b) throws IllegalArgumentException {
		F field = getScalarField();
		S ip  = innerProduct(a, b);
		return field.arccos(field.squareRoot(field.divide(field.multiply(ip, ip),
				field.multiply(innerProduct(a, a), innerProduct(b, b)))));
	}
	
	default S parallelLengthAlong(V vector, V ref) {
		return getScalarField().divide(innerProduct(vector, ref), norm(ref));
	}
	
	

}
