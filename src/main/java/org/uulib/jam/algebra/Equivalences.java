package org.uulib.jam.algebra;

import java8.util.Optional;

public class Equivalences {
	
	private Equivalences() {}
	
	
	public static <E> UnitalAlgebra<E,E> asAlgebra(Field<E> field) {
		return new FieldAlgebra<>(field);
	}
	
	public static <E> UnitalGradedAlgebra<E, E> asGradedAlgebra(Field<E> field) {
		return trivialGrading(asAlgebra(field));
	}
	
	public static <V,S> UnitalGradedAlgebra<V,S> trivialGrading(UnitalAlgebra<V,S> algebra) {
		return new TiviallyGradedUnitalAlgebra<>(algebra);
	}
	
	public static <V,S> GradedAlgebra<V,S> trivialGrading(Algebra<V,S> algebra) {
		return new TriviallyGradedAlgebra<>(algebra);
	}
	
	public static <V,W,S> VectorSpace<V,S> transform(VectorSpace<W,S> original, Homeomorphism<V,W> transformation) {
		return new IsomorphicVectorSpace<>(original, transformation);
	}
	
	private static final class FieldAlgebra<E> implements UnitalAlgebra<E,E> {
		
		private final Field<E> field;
		
		FieldAlgebra(Field<E> field) {
			this.field = field;
		}

		@Override
		public Field<E> getScalarField() {
			return field;
		}

		@Override
		public E scale(E vector, E scalar) {
			return field.multiply(vector, scalar);
		}

		@Override
		public E negate(E element) {
			return field.negate(element);
		}

		@Override
		public E subtract(E left, E right) {
			return field.subtract(left, right);
		}

		@Override
		public E getZeroElement() {
			return field.getZeroElement();
		}

		@Override
		public E add(E a, E b) {
			return field.add(a, b);
		}

		@Override
		public E multiply(E a, E b) {
			return field.multiply(a, b);
		}

		@Override
		public E getUnitElement() {
			return field.getUnitElement();
		}

		@Override
		public Optional<E> sqrt(E element) {
			return field.sqrt(element);
		}

		@Override
		public int getDimension() {
			return 1;
		}
		
	}
	
	private static class TriviallyGradedAlgebra<V,S> implements GradedAlgebra<V,S>{
		
		private final Algebra<V,S> algebra;
		
		TriviallyGradedAlgebra(Algebra<V,S> algebra) {
			this.algebra = algebra;
		}

		@Override
		public int getMaxDegree() {
			return 0;
		}

		@Override
		public VectorSpace<V, S> getFactorSpace(int degree) {
			if(degree!=0) {
				throw new IllegalArgumentException("No factor space for degree: " + degree);
			}
			return algebra;
		}

		@Override
		public Field<S> getScalarField() {
			return algebra.getScalarField();
		}

		@Override
		public V multiply(V a, V b) {
			return algebra.multiply(a, b);
		}

		@Override
		public Optional<V> sqrt(V element) {
			return algebra.sqrt(element);
		}
		
	}
	
	private static final class TiviallyGradedUnitalAlgebra<V,S> extends TriviallyGradedAlgebra<V,S> implements UnitalGradedAlgebra<V,S> {

		private final UnitalAlgebra<V,S> algebra;
		
		TiviallyGradedUnitalAlgebra(UnitalAlgebra<V, S> algebra) {
			super(algebra);
			this.algebra = algebra;
		}

		@Override
		public V getUnitElement() {
			return algebra.getUnitElement();
		}
		
	}
	
	private static final class IsomorphicVectorSpace<V,W,S> implements VectorSpace<V,S> {
		
		private final VectorSpace<W,S> delegate;
		private final Homeomorphism<V,W> map;
		private final V zero;
		
		IsomorphicVectorSpace(VectorSpace<W,S> delegate, Homeomorphism<V,W> map) {
			this.delegate = delegate;
			this.map = map;
			this.zero = map.applyInverse(delegate.getZeroElement());
		}

		@Override
		public V negate(V element) {
			return map.applyInverse(delegate.negate(map.apply(element)));
		}

		@Override
		public V subtract(V left, V right) {
			return map.applyInverse(delegate.subtract(map.apply(left), map.apply(right)));
		}

		@Override
		public V getZeroElement() {
			return zero;
		}

		@Override
		public V add(V a, V b) {
			return map.applyInverse(delegate.add(map.apply(a), map.apply(b)));
		}

		@Override
		public Field<S> getScalarField() {
			return delegate.getScalarField();
		}

		@Override
		public V scale(V vector, S scalar) {
			return map.applyInverse(delegate.scale(map.apply(vector), scalar));
		}

		@Override
		public int getDimension() {
			return delegate.getDimension();
		}
		
		
	}

}
