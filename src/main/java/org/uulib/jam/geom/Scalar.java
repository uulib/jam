package org.uulib.jam.geom;

public class Scalar<F> {
	
	private final int grade;
	private final F value;
	
	Scalar(F value, int grade) {
		this.grade = grade;
		this.value = value;
	}
	
	public F asFieldElement() {
		if(grade!=0) {
			throw new IllegalStateException();
		}
		return value;
	}
	
	int getGrade() {
		return grade;
	}
	
	F getValue() {
		return value;
	}

}
