package org.uulib.algebra.set;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

public final class Cardinality implements Comparable<Cardinality> {
	
	public static final Cardinality ZERO = integer(BigInteger.ZERO);
	public static final Cardinality ONE = integer(BigInteger.ONE);
	public static final Cardinality COUNTABLE_INFINITY = aleph(BigInteger.ZERO);
	public static final Cardinality UNCOUNTABLE_INFINITY = aleph(BigInteger.ONE);

	private final boolean finite;
	private final BigInteger index;
	
	public static Cardinality integer(BigInteger value) {
		if(negative(value)) {
			throw new IllegalArgumentException("Cardinality must be non-negative.");
		}
		return new Cardinality(true, value);
	}
	
	public static Cardinality aleph(BigInteger alephNumber) {
		if(negative(alephNumber)) {
			throw new IllegalArgumentException("Aleph-number must be non-negative.");
		}
		return new Cardinality(false, alephNumber);
	}
	
	private Cardinality(boolean finite, BigInteger index) {
		this.finite = finite;
		this.index = index;
	}
	
	/**
	 * Determines if this cardinality is finite (i.e. an integer).
	 * @return {@code true} if this cardinality is finite.
	 */
	public boolean isFinite() {
		return finite;
	}
	
	public Optional<BigInteger> getFiniteValue() {
		return isFinite() ? Optional.of(index) : Optional.empty();
	}

	@Override
	public int compareTo(Cardinality o) {
		int cmp = 0;
		if(isFinite()) --cmp;
		if(o.isFinite()) ++cmp;
		
		if(cmp==0) {
			cmp = index.compareTo(o.index);
		}
		
		return cmp;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(finite, index);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj instanceof Cardinality) {
			Cardinality o = (Cardinality) obj;
			return finite==o.finite && index.equals(o.index);
		}
		return false;
	}
	
	private static boolean negative(BigInteger value) {
		return value.compareTo(BigInteger.ZERO) < 0;
	}

}
