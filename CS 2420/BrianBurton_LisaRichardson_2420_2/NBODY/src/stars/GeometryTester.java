package stars;

import static org.junit.Assert.*;
import org.junit.Test;

public class GeometryTester {
	
	@Test
	public void copy() {
		
		//Base case
		Geometry_Vector v1 = new Geometry_Vector(3, 4);
		Geometry_Vector v2 = new Geometry_Vector(v1);
		
		assertEquals(v1, v2);
		
		//Negative numbers
		Geometry_Vector v3 = new Geometry_Vector(-3, -4);
		Geometry_Vector v4 = new Geometry_Vector(v3);
		
		assertEquals(v3, v4);
		
		//Negative numbers & 0
		Geometry_Vector v5 = new Geometry_Vector(0, -4);
		Geometry_Vector v6 = new Geometry_Vector(v5);
		
		assertEquals(v5, v6);
	}

	@Test
	public void add_to_me() {
		
		//Base Case
		Geometry_Vector v1 = new Geometry_Vector(3, 4);
		Geometry_Vector v2 = new Geometry_Vector(3, 4);
		Geometry_Vector v3 = new Geometry_Vector(6, 8);
		
		v1.add_to_me(v2);
		
		assertEquals(v3, v1);
		
		//Negative numbers
		Geometry_Vector v4 = new Geometry_Vector(3, 4);
		Geometry_Vector v5 = new Geometry_Vector(5, -1);
		Geometry_Vector v6 = new Geometry_Vector(8, 3);
		
		v4.add_to_me(v5);
		
		assertEquals(v6, v4);
		
		//Negative numbers & 0
		Geometry_Vector v7 = new Geometry_Vector(0, -1);
		Geometry_Vector v8 = new Geometry_Vector(-4, -1);
		Geometry_Vector v9 = new Geometry_Vector(-4, -2);
		
		v7.add_to_me(v8);
		
		assertEquals(v9, v7);
	}
	
	@Test
	public void subtract_from_me() {
		
		//Base Case
		Geometry_Vector v1 = new Geometry_Vector(3, 4);
		Geometry_Vector v2 = new Geometry_Vector(3, 4);
		Geometry_Vector v3 = new Geometry_Vector(0, 0);
		
		v1.subtract_from_me(v2);
		
		assertEquals(v3, v1);
		
		//Negative numbers
		Geometry_Vector v4 = new Geometry_Vector(6, 2);
		Geometry_Vector v5 = new Geometry_Vector(-8, 8);
		Geometry_Vector v6 = new Geometry_Vector(14, -6);
		
		v4.subtract_from_me(v5);
		
		assertEquals(v6, v4);
		
		//Negative numbers & 0
		Geometry_Vector v7 = new Geometry_Vector(0, -5);
		Geometry_Vector v8 = new Geometry_Vector(0, -2);
		Geometry_Vector v9 = new Geometry_Vector(0, -3);
		
		v7.subtract_from_me(v8);
		
		assertEquals(v9, v7);
	}
	
	@Test 
	public void divide_by() {
		
		//Base Case
		Geometry_Vector v1 = new Geometry_Vector(3, 9);
		Geometry_Vector v2 = new Geometry_Vector(1, 3);
		
		v1.divide_by(3);
		
		assertEquals(v2, v1);
		
		//Negative numbers
		Geometry_Vector v3 = new Geometry_Vector(-3, -9);
		Geometry_Vector v4 = new Geometry_Vector(-1, -3);
		
		v3.divide_by(3);
		
		assertEquals(v4, v3);
		
		//Negative numbers & 0
		Geometry_Vector v5 = new Geometry_Vector(3, 0);
		Geometry_Vector v6 = new Geometry_Vector(1, 0);
		
		v5.divide_by(3);
		
		assertEquals(v6, v5);
	}
	
	@Test
	public void multiply_me_by() {
		
		//Base Case
		Geometry_Vector v1 = new Geometry_Vector(3, 9);
		Geometry_Vector v2 = new Geometry_Vector(9, 27);
		
		v1.multiply_me_by(3);
		
		assertEquals(v2, v1);
		
		//Negative numbers
		Geometry_Vector v3 = new Geometry_Vector(-3, -9);
		Geometry_Vector v4 = new Geometry_Vector(-9, -27);
		
		v3.multiply_me_by(3);
		
		assertEquals(v4, v3);
		
		//Negative numbers & 0
		Geometry_Vector v5 = new Geometry_Vector(3, 0);
		Geometry_Vector v6 = new Geometry_Vector(9, 0);
		
		v5.multiply_me_by(3);
		
		assertEquals(v6, v5);
	}
	
	@Test
	public void magnitude() {
		
		//Base Case
		Geometry_Vector v1 = new Geometry_Vector(3, 4);
		
		double answer = v1.magnitude();
		
		assertEquals(5, answer, 0.001);
		
		//Negative numbers
		Geometry_Vector v2 = new Geometry_Vector(-3, 4);
		
		double answer2 = v2.magnitude();
		
		assertEquals(5, answer2, 0.001);
		
		//Negative numbers & 0
		Geometry_Vector v3 = new Geometry_Vector(-3, 0);
		
		double answer3 = v3.magnitude();
		
		assertEquals(3, answer3, 0.001);
	}
	
	@Test
	public void normalize() {
		
		//Base case
		Geometry_Vector v1 = new Geometry_Vector(4, 4);
		Geometry_Vector v2 = new Geometry_Vector(4/Math.sqrt(32), 4/Math.sqrt(32));
		
		v1.normalize();
		
		assertEquals(v2, v1);
		
		//Negative numbers
		Geometry_Vector v3 = new Geometry_Vector(4, -9);
		Geometry_Vector v4 = new Geometry_Vector(4/Math.sqrt(97), -9/Math.sqrt(97));
		
		v3.normalize();
		
		assertEquals(v4, v3);
		
		//Negative numbers & 0
		Geometry_Vector v5 = new Geometry_Vector(0, -9);
		Geometry_Vector v6 = new Geometry_Vector(0, -1);
		
		v5.normalize();
		
		assertEquals(v6, v5);
	}
}
