package org.uulib.jam.algebra;

public class GScalar<F> {
	
	private final int grade;
	private final F coefficient;
	
	GScalar(int grade, F coefficient) {
		this.grade = grade;
		this.coefficient = coefficient;
	}
	
	int getGrade() {
		return grade;
	}
	
	F asScalar() {
		if(grade!=0) {
			throw new IllegalStateException("Only grade-0 GScalars can be converted to underlying scalars.");
		}
		return coefficient;
	}

}
