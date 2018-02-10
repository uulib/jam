package org.uulib.jam.geom;

import org.uulib.jam.algebra.InnerProductSpace;
import org.uulib.jam.algebra.UnitalGradedAlgebra;

public final class CanonicalInnerProductSpace<S,C> extends CanonicalVectorSpace<S,C> implements InnerProductSpace<Vector<C>,S,C> {
	
	private final UnitalGradedAlgebra<C,S> coefficientAlgebra;
	private final int coefficientGrade;
	
	CanonicalInnerProductSpace(UnitalGradedAlgebra<C,S> coefficientAlgebra, int coefficientGrade, int dimension) {
		super(coefficientAlgebra.getFactorSpace(coefficientGrade), dimension);
		this.coefficientAlgebra = coefficientAlgebra;
		this.coefficientGrade = coefficientGrade;
	}

	@Override
	public UnitalGradedAlgebra<C, S> getCoefficientAlgebra() {
		return coefficientAlgebra;
	}

	@Override
	public int getCoefficientGrade() {
		return coefficientGrade;
	}

	@Override
	public C innerProduct(Vector<C> a, Vector<C> b) {
		return dotProduct(a, b);
	}
	
	C dotProduct(Vector<C> a, Vector<C> b) {
		checkDimension(a, b);
		C rc = coefficientAlgebra.multiply(a.components[0], b.components[0]);
		for(int i = 1; i<a.components.length; ++i) {
			rc = getFactorSpace().add(rc, coefficientAlgebra.multiply(a.components[i], b.components[i]));
		}
		return rc;
	}

}
