package org.uulib.jam.algebra.polynomial;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.uulib.jam.ObjIntFunction;
import org.uulib.jam.algebra.Field;
import org.uulib.jam.algebra.graded.GradedDivisionAlgebra;
import org.uulib.jam.algebra.graded.impl.AbstractUnitalGradedAlgebra;
import org.uulib.jam.algebra.graded.impl.GradedVectorSpaceDefaults;
import org.uulib.jam.algebra.impl.AnnihilatingMultiplyDefaults;
import org.uulib.jam.algebra.impl.DefaultAddititionSubtraction;
import org.uulib.jam.algebra.impl.DefaultIntDivision;
import org.uulib.jam.algebra.impl.MultiplicativeGroupDefaults;
import org.uulib.jam.algebra.impl.MultiplicativeMonoidDefaults;

public class MonomialAlgebra<E> extends AbstractUnitalGradedAlgebra<Monomial<E>,E>
implements GradedDivisionAlgebra<Monomial<E>,E>, GradedVectorSpaceDefaults<Monomial<E>,E>, MultiplicativeGroupDefaults<Monomial<E>> {
	
	private final E[] zeroCoefficient;
	
	private final BiFunction<E,E,E> baseAdd, baseSubtract, baseMultiply, baseDivide;
	private final Function<E,E> baseNegate, baseReciprocal;
	private final ObjIntFunction<E,Optional<E>> baseIntDivide, baseRoot;
	
	
	@SuppressWarnings("unchecked")
	MonomialAlgebra(Field<E> baseField) {
		super(baseField, new Monomial<>(0, baseField.getUnitElement()));
		this.zeroCoefficient = (E[]) new Object[] {baseField.getZeroElement()};
		this.baseAdd = DefaultAddititionSubtraction.getNonZeroAdd(baseField);
		this.baseSubtract = DefaultAddititionSubtraction.getNonZeroNonEqualSubtract(baseField);
		this.baseMultiply = AnnihilatingMultiplyDefaults.getNonZeroNonUnitMultiply(baseField);
		this.baseDivide = MultiplicativeGroupDefaults.getNonZeroDivide(baseField);
		this.baseNegate = DefaultAddititionSubtraction.getNonZeroNegate(baseField);
		this.baseReciprocal = MultiplicativeGroupDefaults.getNonZeroNonUnitReciprocal(baseField);
		this.baseIntDivide = DefaultIntDivision.getNonZeroDivide(baseField);
		this.baseRoot = MultiplicativeMonoidDefaults.getNonUnitRoot(baseField);
	}

	@Override
	public Optional<Monomial<E>> divideNonZero(Monomial<E> dividend, int nonZeroNonOneDivisor) {
		return baseIntDivide.apply(dividend.getCoeficient(), nonZeroNonOneDivisor)
				.map(c -> new Monomial<>(dividend.getExponent(), c));
	}

	@Override
	public Monomial<E> multiply(int multiplier, Monomial<E> element) { //TODO Zero checks
		return new Monomial<>(element.getExponent(), getBaseField().multiply(multiplier, element.getCoeficient()));
	}

	@Override
	public Optional<Monomial<E>> rootNonUnit(Monomial<E> radicand, int nonZeroNonOneDegree) {
		int exp = radicand.getExponent();
		if(exp%nonZeroNonOneDegree!=0) {
			return Optional.empty();
		}
		return baseRoot.apply(radicand.getCoeficient(), nonZeroNonOneDegree)
				.map(c -> new Monomial<>(exp/nonZeroNonOneDegree, c));
	}

	@Override
	public int getGrade(Monomial<E> element) {
		return element.getExponent();
	}

	@Override
	public Monomial<E> scalarMultiplyNonZeroNonUnit(Monomial<E> nonZeroA, E nonZeroNonUnitB) {
		return new Monomial<>(nonZeroA.getExponent(), baseMultiply.apply(nonZeroA.getCoeficient(), nonZeroNonUnitB));
	}

	@Override
	public Monomial<E> scalarDivideNonZeroNonUnit(Monomial<E> nonZeroDividend, E nonZeroNonUnitDivisor) {
		return new Monomial<>(nonZeroDividend.getExponent(), baseDivide.apply(nonZeroDividend.getCoeficient(), nonZeroNonUnitDivisor));
	}

	@Override
	public Monomial<E> negateNonZero(Monomial<E> element) {
		return new Monomial<>(element.getExponent(), baseNegate.apply(element.getCoeficient()));
	}

	@Override
	public Monomial<E> reciprocalNonZeroNonUnit(Monomial<E> nonZeroNonUnitElement) {
		return new Monomial<>(-nonZeroNonUnitElement.getExponent(), baseReciprocal.apply(nonZeroNonUnitElement.getCoeficient()));
	}

	@Override
	public boolean areCommensurateVectorsEqual(Monomial<E> a, Monomial<E> b) {
		return getBaseField().equal(a.getCoeficient(), b.getCoeficient());
	}

	@Override
	public Monomial<E> addNonZeroCommensurate(Monomial<E> a, Monomial<E> b) {
		return new Monomial<>(a.getExponent(), baseAdd.apply(a.getCoeficient(), b.getCoeficient()));
	}

	@Override
	public Monomial<E> subtractNonZeroNonEqualCommensurate(Monomial<E> minuend, Monomial<E> subtrahend) {
		return new Monomial<>(minuend.getExponent(), baseSubtract.apply(minuend.getCoeficient(), subtrahend.getCoeficient()));
	}

	@Override
	public Optional<E> divideNonZeroNonEqualCommensurateToScalar(Monomial<E> dividend, Monomial<E> divisor) {
		return Optional.of(baseDivide.apply(dividend.getCoeficient(), divisor.getCoeficient()));
	}

	@Override
	protected Monomial<E> getGradedZero(int grade) {
		return new Monomial<>(grade, zeroCoefficient);
	}

	@Override
	public Monomial<E> multiplyNonZeroNonUnit(Monomial<E> a, Monomial<E> b) {
		return new Monomial<>(a.getExponent()+b.getExponent(), baseMultiply.apply(a.getCoeficient(), b.getCoeficient()));
	}

	@Override
	public boolean isZero(Monomial<E> element) {
		return getBaseField().isZero(element.getCoeficient());
	}

	@Override
	public Monomial<E> divideNonZero(Monomial<E> nonZeroDividend, Monomial<E> nonZeroNonUnitDivisor) {
		return new Monomial<>(nonZeroDividend.getExponent()-nonZeroNonUnitDivisor.getExponent(),
				baseDivide.apply(nonZeroDividend.getCoeficient(), nonZeroNonUnitDivisor.getCoeficient()));
	}

}
