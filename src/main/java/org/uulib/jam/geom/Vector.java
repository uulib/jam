package org.uulib.jam.geom;

import org.uulib.jam.algebra.InnerProductSpace;
import org.uulib.jam.algebra.UnitalAlgebra;
import org.uulib.jam.algebra.graded.UnitalGradedAlgebra;

public class Vector<S> {
	
	final S[] components;
	
	Vector(S[] components) {
		this.components = components;
	}
	
	public int getDimension() {
		return components.length;
	}

}
