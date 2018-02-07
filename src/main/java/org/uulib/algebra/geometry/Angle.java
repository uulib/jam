package org.uulib.algebra.geometry;

public final class Angle {
	
	private static final double TAU = Math.PI*2.0;
	private static final double DEGREES_PER_RADIAN = 360.0 / TAU;
	private static final double RADIANS_PER_DEGREE = TAU / 360.0;
	
	private final double radians, degrees;
	
	public static Angle ofRadians(double radians) {
		return new Angle(radians, radians * DEGREES_PER_RADIAN);
	}
	
	public static Angle ofDegrees(double degrees) {
		return new Angle(degrees * RADIANS_PER_DEGREE, degrees);
	}
	
	private static double normalize(double value, double modulus) {
		value = value % modulus;
		if(value < 0) {
			value += modulus;
		}
		assert value>=0 && value<modulus;
		return value;
	}
	
	private Angle(double radians, double degrees) {
		this.radians = radians;
		this.degrees = degrees;
	}
	
	public double getRadians() {
		return radians;
	}
	
	public double getDegrees() {
		return degrees;
	}
	
	public Angle plus(Angle angle) {
		return plusRadians(angle.radians);
	}
	
	public Angle plusRadians(double radians) {
		return ofRadians(this.radians + radians);
	}
	
	public Angle plusDegrees(double degrees) {
		return ofDegrees(this.degrees + degrees);
	}
	
	public Angle minus(Angle angle) {
		return minusRadians(angle.radians);
	}
	
	public Angle minusRadians(double radians) {
		return ofRadians(this.radians - radians);
	}
	
	public Angle minusDegrees(double degrees) {
		return ofDegrees(this.degrees - degrees);
	}
	
	public Angle multiply(double factor) {
		return ofRadians(this.radians*factor);
	}
	
	public Angle divide(double divisor) {
		return ofRadians(this.radians/divisor);
	}
	
	/**
	 * Normalizes this angle to one between 0&deg; and 180&deg;, <em>inclusive</em>, using the following rules:
	 * If the value of this angle is negative, it is assumed to be equivalent to a positive angle with the same
	 * magnitude. The resultant angle is always non-negative
	 * @return A new angle, &theta;, with 0&deg;&leq;&theta;&leq;180&deg; 
	 */
	public Angle normalize_0_180() {
		if(radians>=0 && radians<=Math.PI) {
			return this;
		}
		double newRadians = Math.abs(radians) % TAU;
		if(newRadians > Math.PI) {
			newRadians = TAU - newRadians;
		}
		return ofRadians(newRadians);
	}

}
