package org.uulib.jam.geom;

import org.uulib.jam.algebra.Field;
import org.uulib.jam.algebra.VectorSpace;

import java8.util.Objects;

public class CanonicalVectorSpace<S,C> implements VectorSpace<Vector<C>, S> {
	
	private final VectorSpace<C,S> factorSpace;
	private final int dimension;
	private final Vector<C> zero;
	
	CanonicalVectorSpace(VectorSpace<C,S> factorSpace, int dimension) {
		if(dimension < 1) {
			throw new IllegalArgumentException("Dimension must be at least 1.");
		}
		this.factorSpace = Objects.requireNonNull(factorSpace);
		this.dimension = dimension;
		
		C[] cmp = newComponents();
		for(int i=0; i<dimension; ++i) {
			cmp[i] = factorSpace.getZeroElement();
		}
		this.zero = new Vector<>(cmp);
	}
	
	protected final VectorSpace<C,S> getFactorSpace() {
		return factorSpace;
	}
	
	@SafeVarargs
	protected final void checkDimension(Vector<C>... elements) {
		for(Vector<C> element: elements) {
			if(element.getDimension()!=dimension) {
				throw new IllegalArgumentException("Given vector does not have the required dimension.");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private C[] newComponents() {
		return (C[]) new Object[dimension];
	}

	@Override
	public Vector<C> negate(Vector<C> element) {
		checkDimension(element);
		C[] cmp = newComponents();
		for(int i=0; i<dimension; ++i) {
			cmp[i] = factorSpace.negate(element.components[i]);
		}
		return new Vector<>(cmp);
	}

	@Override
	public Vector<C> subtract(Vector<C> left, Vector<C> right) {
		checkDimension(left, right);
		C[] cmp = newComponents();
		for(int i=0; i<dimension; ++i) {
			cmp[i] = factorSpace.subtract(left.components[i], right.components[i]);
		}
		return new Vector<>(cmp);
	}

	@Override
	public Vector<C> getZeroElement() {
		return zero;
	}

	@Override
	public Vector<C> add(Vector<C> a, Vector<C> b) {
		checkDimension(a, b);
		C[] cmp = newComponents();
		for(int i=0; i<dimension; ++i) {
			cmp[i] = factorSpace.add(a.components[i], b.components[i]);
		}
		return new Vector<>(cmp);
	}

	@Override
	public Field<S> getScalarField() {
		return factorSpace.getScalarField();
	}

	@Override
	public Vector<C> scale(Vector<C> vector, S scalar) {
		checkDimension(vector);
		C[] cmp = newComponents();
		for(int i=0; i<dimension; ++i) {
			cmp[i] = factorSpace.scale(vector.components[i], scalar);
		}
		return new Vector<>(cmp);
	}

	@Override
	public int getDimension() {
		return dimension;
	}

}
