package org.uulib.jam.geom;

import org.uulib.jam.algebra.Field;

public class Angle<E> {
	
	private static final double PI = Math.PI;
	private static final double TAU = Math.PI*2;
	private static final double DEGREES_PER_RADIAN = 180.0/PI;
	private static final double RADIANS_PER_DEGREE = PI/180;
	
	private final Field<E> field;
	
	private E sine, cosine;
	private final int wind;
	private double radians, degrees;
	
	public static <E> Angle<E> ofDegrees(Field<E> field, double degrees) {
		return new Angle<E>(field, null, null, (int)(degrees/360), degrees*RADIANS_PER_DEGREE, degrees);
	}
	
	public static <E> Angle<E> ofRadians(Field<E> field, double radians) {
		return new Angle<>(field, null, null, (int)(radians/TAU), radians, radians*DEGREES_PER_RADIAN);
	}
	
	public static <E> Angle<E> ofWholeTurns(Field<E> field, int turns) {
		return new Angle<>(field, field.getZeroElement(), field.getUnitElement(), turns, TAU*turns, 360*turns);
	}
	
	public static <E> Angle<E> ofCosine(Field<E> field, E cosine) {
		return ofSineAndCosine(field, null, cosine);
	}
	
	public static <E> Angle<E> ofSineAndCosine(Field<E> field, E sine, E cosine) {
		return ofSineAndCosine(field, sine, cosine, 0);
	}
	
	public static <E> Angle<E> ofSineAndCosine(Field<E> field, E sine, E cosine, int wind) {
		return new Angle<>(field, sine, cosine, wind, Double.NaN, Double.NaN);
	}
	
	private Angle(Field<E> field, E sine, E cosine, int wind, double radians, double degrees) {
		this.field = field;
		this.sine = sine;
		this.cosine = cosine;
		this.wind = wind;
		this.radians = radians;
		this.degrees = degrees;
	}
	
	private static <E> E sineFromCosine(Field<E> field, E cosine) {
		return field.sqrt(field.subtract(field.getUnitElement(), field.multiply(cosine, cosine))).get();
	}

}
