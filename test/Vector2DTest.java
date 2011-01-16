import javax.vecmath.Vector2d;

import junit.framework.Assert;

import org.junit.Test;

import com.alegria2d.math.Vector2D;

public class Vector2DTest{

	//TODO: CRIAR OS TESTCASES DA CLASSE VEC2D E DA MATH UTIL 65 +-
	public Vector2DTest(){}
	
	@Test
	public void createVector2DNoParametersTest(){
		
		Vector2D v1 = new Vector2D();
		Assert.assertEquals(0.0f, v1.getX());
		Assert.assertEquals(0.0f, v1.getY());
		
	}
	
	@Test
	public void createVector2DParametersXYTest(){
		
		Vector2D v1 = new Vector2D(0.5f,0.3f);
		Assert.assertEquals(0.5f, v1.getX());
		Assert.assertEquals(0.3f, v1.getY());
		
	}
	
	@Test
	public void createVector2DParameterVector2DTest(){
		
		Vector2D v1 = new Vector2D(new Vector2D());
		Assert.assertEquals(0.0f, v1.getX());
		Assert.assertEquals(0.0f, v1.getY());
		
	}
	
	@Test
	public void createVector2DBySizeAndAngle(){
		
		Vector2D v1 = Vector2D.createBySizeAngle(5, 0.0f);
		Assert.assertEquals(5.0f, v1.getSize());
		Assert.assertEquals(0.0f, v1.getAngleX());
		
	}
	
	@Test
	public void setParametersXYTest(){
		
		Vector2D v1 = new Vector2D();
		v1.set(5.0f, 3.0f);
		Assert.assertEquals(5.0f, v1.getX());
		Assert.assertEquals(3.0f, v1.getY());
		
	}
	
	@Test 
	public void setParameterVectorTest(){
		
		Vector2D v1 = new Vector2D();
		v1.set(new Vector2D(5,3));
		Assert.assertEquals(5.0f, v1.getX());
		Assert.assertEquals(3.0f, v1.getY());
		
	}
	
	@Test 
	public void setXParameterXTest(){
		
		Vector2D v1 = new Vector2D();
		v1.setX(5);
		Assert.assertEquals(5.0f, v1.getX());
		
	}
	
	@Test
	public void getXTest(){
		
		Vector2D v1 = new Vector2D();
		v1.setX(5);
		Assert.assertEquals(5.0f, v1.getX());
		
	}
	
	@Test 
	public void setYParameterYTest(){
		
		Vector2D v1 = new Vector2D();
		v1.setY(3);
		Assert.assertEquals(3.0f, v1.getY());
		
	}
	
	@Test
	public void getYTest(){
		
		Vector2D v1 = new Vector2D();
		v1.setY(3);
		Assert.assertEquals(3.0f, v1.getY());
		
	}
	
	@Test
	public void getSizeTest(){
		
		Vector2D v1 = new Vector2D(1,1);
		v1.setSize(10.0f);
		Assert.assertEquals(10.0f, v1.getSize());
		
	}

	@Test
	public void setSizeParameterSizeTest(){
		
		Vector2D v1 = new Vector2D(1,1);
		float oldAngle = v1.getAngleX();
		v1.setSize(10);
		float newAngle = v1.getAngleX();
		Assert.assertEquals(oldAngle, newAngle);
		Assert.assertEquals(10.0f, v1.getSize());
		
	}
	
	@Test
	public void getSizeSqrTest(){
		
		Vector2D v1 = Vector2D.createBySizeAngle(9.0f, 0);
		Assert.assertEquals(81.0f, v1.getSizeSqr());
		
	}
	
	@Test
	public void isZeroTest(){
		
		Vector2D thatIsZero = new Vector2D();
		Vector2D thatIsNotZero = new Vector2D(1,1);
		
		Assert.assertTrue(thatIsZero.isZero());
		Assert.assertFalse(thatIsNotZero.isZero());
	}
	
	@Test
	public void isNormalTest(){
		
		Vector2D normal = Vector2D.createBySizeAngle(1, 0);
		Vector2D notNormal = Vector2D.createBySizeAngle(4, 0);
		
		Assert.assertTrue(normal.isNormal());
		Assert.assertFalse(notNormal.isNormal());
		
	}
	
	@Test
	public void getAngleXTest(){
		
		Vector2D v1 = Vector2D.createBySizeAngle(1, 0);
		
		Assert.assertEquals(0.0f,v1.getAngleX());
		
	}
	
	@Test
	public void rotateMeParameterAngleTest(){
		
		Vector2D v1 = Vector2D.createBySizeAngle(5, 0);
		
		v1.rotateMe(0.5236f);
		
		Assert.assertEquals(0.5236f, v1.getAngleX());
	}
	
	@Test
	public void rotateParameterAngleTest(){
		
		Vector2D v1 = Vector2D.createBySizeAngle(5, 0);
		
		v1 = v1.rotate(0.5236f);
		
		Assert.assertEquals(0.5236f, v1.getAngleX());
	}
	
	@Test
	public void getPerpendicularTest(){
		
		Vector2D v1 = new Vector2D(5,3);
		Vector2D perpendicular = new Vector2D(-3,5);
		
		Assert.assertEquals(perpendicular, v1.getPerpendicular());
		
	}

	/** TODO: Fix normalizeTest and create normalizeMe test
	@Test
	public void normalizeTest(){

		Vector2D v1 = Vector2D.createBySizeAngle(10,10);
		
		Assert.assertEquals(1.0f, v1.normalize().getSize());
		
	}
	*/
	
	@Test
	public void plusMeParameterVector2DTest(){
		
		Vector2D v1 = new Vector2D(5,5);
		
		v1.plusMe(new Vector2D(1,1));
		
		Assert.assertEquals(new Vector2D(6,6), v1);
	}
	
	@Test
	public void plusTest(){

		Vector2D v1 = new Vector2D(5,5);
		
		v1 = v1.plus(new Vector2D(1,1));
		
		Assert.assertEquals(new Vector2D(6,6), v1);
	}
	
	@Test
	public void minusMeParameterVector2DTest(){
		
		Vector2D v1 = new Vector2D(5,5);
		
		v1.minusMe(new Vector2D(1,1));
		
		Assert.assertEquals(new Vector2D(4,4), v1);
	}
	
	@Test
	public void minusTest(){
		
		Vector2D v1 = new Vector2D(5,5);
		
		v1 = v1.minus(new Vector2D(1,1));
		
		Assert.assertEquals(new Vector2D(4,4), v1);
	}
	
	@Test
	public void multiplyMeParameterScalarTest(){
		
		Vector2D v1 = new Vector2D(5,5);
		
		v1.multiplyMe(2);
		
		Assert.assertEquals(new Vector2D(10,10), v1);
	}
	
	@Test
	public void multiplyTest(){
		
		Vector2D v1 = new Vector2D(5,5);
		
		v1 = v1.multiply(2);
		
		Assert.assertEquals(new Vector2D(10,10), v1);
	}
	
	@Test
	public void divMeParameterScalarTest(){
		
		Vector2D v1 = new Vector2D(10,10);
		
		v1.divMe(2);
		
		Assert.assertEquals(new Vector2D(5,5), v1);
	}
	
	@Test
	public void divTest(){
		
		Vector2D v1 = new Vector2D(10,10);
		
		v1 = v1.div(2);
		
		Assert.assertEquals(new Vector2D(5,5), v1);
	}
	
	@Test
	public void negativeMeTest(){
		
		Vector2D v1 = new Vector2D(5,5);
		
		v1.negativeMe();
		
		Assert.assertEquals(new Vector2D(-5,-5), v1);
	}
	
	@Test
	public void negativeTest(){
		
		Vector2D v1 = new Vector2D(5,5);
		
		v1 = v1.negative();
		
		Assert.assertEquals(new Vector2D(-5,-5), v1);
	}
	
	@Test
	public void equalsTest(){
		
		Vector2D v1 = new Vector2D(1,1);
		Vector2D thatEqualsV1 = new Vector2D(1,1);
		Vector2D thatDoesntEqualsV1 = new Vector2D(3,3);
		
		Assert.assertEquals(v1, thatEqualsV1);
		Assert.assertNotSame(v1, thatDoesntEqualsV1);
		
	}
	
	@Test
	public void hashCodeTest(){

		Vector2D v1 = new Vector2D(1,1);
		Vector2D sameHashV1 = new Vector2D(1,1);
		Vector2D notSameHashV1 = new Vector2D(3,3);
		
		v1.hashCode();
		sameHashV1.hashCode();
		notSameHashV1.hashCode();
		
		Assert.assertEquals(v1.hashCode(), sameHashV1.hashCode());
		Assert.assertNotSame(v1.hashCode(), notSameHashV1.hashCode());
		
	}
	
	@Test 
	public void dotTest(){
		
		Vector2D v1 = new Vector2D(1,1);
		Vector2D v2 = new Vector2D(1,1);
		
		float dot = v1.dot(v2);
		
		Assert.assertEquals(v1.dot(v2), dot);
		
	}
	
	@Test
	public void toStringTest(){
		
		Vector2D v1 = new Vector2D(1,1);
		String v1AsString = v1.toString();
		
		Assert.assertEquals(v1.toString(), v1AsString);
	}	
	
	@Test
	public void cloneTest(){

		Vector2D v1 = new Vector2D(1,1);
		Vector2D v1Clone = v1.clone();
		
		Assert.assertEquals(v1, v1Clone);
	}
	
	@Test
	public void getAtParameterIndexTest(){
		
		Vector2D v1 = new Vector2D();
		
		v1.putAt(0, 3.0f);
		v1.putAt(1, 5.0f);
		
		Assert.assertEquals(3.0f, v1.getAt(0));
		Assert.assertEquals(5.0f, v1.getAt(1));
	}

	@Test
	public void putAtParameterIndexValueTest(){
		
		Vector2D v1 = new Vector2D();
		
		v1.putAt(0, 3.0f);
		v1.putAt(1, 5.0f);
		
		Assert.assertEquals(3.0f, v1.getAt(0));
		Assert.assertEquals(5.0f, v1.getAt(1));
	}
	
	@Test
	public void toArrayTest(){
		
		Vector2D v1 = new Vector2D(1,1);
		float[] array = v1.toArray();
		
		Assert.assertEquals(array[0],v1.getX());
		Assert.assertEquals(array[1],v1.getY());
	}
	
	@Test
	public void compareToParameterVector2DTest(){
		
		Vector2D v1 = new Vector2D(1,1);
		Vector2D equalsV1 = new Vector2D(1,1);
		Vector2D largerV1 = new Vector2D(2,2);
		Vector2D smallerV1 = new Vector2D(0,0);
		
		Assert.assertEquals(0, v1.compareTo(equalsV1));
		Assert.assertEquals(1, v1.compareTo(largerV1));
		Assert.assertEquals(-1, v1.compareTo(smallerV1));
		
	}
	
}
