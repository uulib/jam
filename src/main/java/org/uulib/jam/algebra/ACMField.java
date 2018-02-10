package org.uulib.jam.algebra;

import org.apache.commons.math3.FieldElement;

import java8.util.Optional;

public class ACMField<E extends FieldElement<E>> implements Field<E> {
	
	private final org.apache.commons.math3.Field<E> apacheField;
	
	ACMField(org.apache.commons.math3.Field<E> apacheField) {
		this.apacheField = apacheField;
	}

	@Override
	public E getZeroElement() {
		return apacheField.getZero();
	}

	@Override
	public E add(E a, E b) {
		return a.add(b);
	}

	@Override
	public E getUnitElement() {
		return apacheField.getOne();
	}

	@Override
	public E multiply(E a, E b) {
		return a.multiply(b);
	}

	@Override
	public Optional<E> sqrt(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equal(E a, E b) {
		a.
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E negate(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E subtract(E left, E right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E reciprocal(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E divide(E left, E right) {
		// TODO Auto-generated method stub
		return null;
	}

}
