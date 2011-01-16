/*
 * Copyright (C) 2011 Alegria contributors
 * 
 * See CREDITS for information about contributors.
 * 
 * http://alegria2d.com
 * 
 * This file is part of Alegria 2D Java Game Framework.
 * 
 * Alegria is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * Alegria is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with Alegria. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package com.alegria2d.math;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

public class Vector2DTest {
   @Test
   public void createVector2DNoParametersTest() {
      Vector2D v1 = new Vector2D();
      assertEquals(0.0f, v1.getX());
      assertEquals(0.0f, v1.getY());
   }

   @Test
   public void createVector2DParametersXYTest() {
      Vector2D v1 = new Vector2D(0.5f, 0.3f);
      assertEquals(0.5f, v1.getX());
      assertEquals(0.3f, v1.getY());
   }

   @Test
   public void createVector2DParameterVector2DTest() {
      Vector2D v1 = new Vector2D(new Vector2D(0.3f, 0.5f));
      assertEquals(0.3f, v1.getX());
      assertEquals(0.5f, v1.getY());
   }

   @Test
   public void createVector2DBySizeAndAngle() {
      Vector2D v1 = Vector2D.createBySizeAngle(5, (float) Math.toRadians(30.0f));
      assertEquals(5.0f, v1.getSize());
      assertEquals(Math.toRadians(30.0f), v1.getAngleX(), 0.00001);
   }

   @Test
   public void setParametersXYTest() {
      Vector2D v1 = new Vector2D();
      v1.set(5.0f, 3.0f);
      assertEquals(5.0f, v1.getX());
      assertEquals(3.0f, v1.getY());
   }

   @Test
   public void setParameterVectorTest() {
      Vector2D v1 = new Vector2D();
      v1.set(new Vector2D(5, 3));
      assertEquals(5.0f, v1.getX());
      assertEquals(3.0f, v1.getY());
   }

   @Test
   public void setX() {
      Vector2D v1 = new Vector2D();
      assertEquals(0.0f, v1.getX());
      v1.setX(5);
      assertEquals(5.0f, v1.getX());
   }

   @Test
   public void getX() {
      Vector2D v1 = new Vector2D();
      assertEquals(0.0f, v1.getX());
      v1.setX(5);
      assertEquals(5.0f, v1.getX());
   }

   @Test
   public void setY() {
      Vector2D v1 = new Vector2D();
      assertEquals(0.0f, v1.getX());
      v1.setX(5);
      assertEquals(5.0f, v1.getX());
   }

   @Test
   public void getY() {
      Vector2D v1 = new Vector2D();
      assertEquals(0.0f, v1.getX());
      v1.setX(5);
      assertEquals(5.0f, v1.getX());
   }

   @Test
   public void getSize() {
      Vector2D v1 = new Vector2D(1, 1);
      v1.setSize(10.0f);
      assertEquals(10.0f, v1.getSize());
   }

   @Test
   public void setSize() {
      Vector2D v1 = new Vector2D(1, 1);
      float oldAngle = v1.getAngleX();
      v1.setSize(10);
      float newAngle = v1.getAngleX();
      assertEquals(oldAngle, newAngle);
      assertEquals(10.0f, v1.getSize());
   }

   @Test
   public void setSizeToZeroVector() {
      Vector2D v1 = new Vector2D();
      v1.setSize(10);
      assertTrue(v1.isZero());
   }

   @Test
   public void getSizeSqrTest() {
      Vector2D v1 = Vector2D.createBySizeAngle(9.0f, 0);
      assertEquals(81.0f, v1.getSizeSqr());
   }

   @Test
   public void isZeroTest() {
      Vector2D thatIsZero = new Vector2D();
      Vector2D thatIsNotZero = new Vector2D(1, 1);

      assertTrue(thatIsZero.isZero());
      assertFalse(thatIsNotZero.isZero());
   }

   @Test
   public void isNormalTest() {
      Vector2D normal = Vector2D.createBySizeAngle(1, (float) Math.toRadians(30));
      Vector2D notNormal = Vector2D.createBySizeAngle(4, 0);

      assertTrue(normal.isNormal());
      assertFalse(notNormal.isNormal());

   }

   @Test
   public void getAngleXTest() {
      Vector2D v1 = Vector2D.createBySizeAngle(1, (float) Math.toRadians(26));
      assertEquals(Math.toRadians(26), v1.getAngleX(), 0.00001);
   }

   @Test
   public void rotateMe() {
      Vector2D v1 = Vector2D.createBySizeAngle(5, 0);
      v1.rotateMe(0.5236f);
      assertEquals(0.5236f, v1.getAngleX(), MathUtil.FLOAT_DELTA);
   }

   @Test
   public void rotate() {
      Vector2D v1 = new Vector2D(5, 0);
      Vector2D rotated = v1.rotate(0.5236f);

      assertEquals(v1, new Vector2D(5, 0));
      assertEquals(0.5236f, rotated.getAngleX(), MathUtil.FLOAT_DELTA);
   }

   @Test
   public void getPerpendicularTest() {
      Vector2D v1 = new Vector2D(5, 3);
      assertTrue(v1.rotate(Math.toRadians(90)).similar(v1.getPerpendicular()));
   }

   @Test
   public void normalizeMe() {
      Vector2D v1 = Vector2D.createBySizeAngle(10, Math.toRadians(10));
      v1.normalizeMe();
      assertTrue(v1.isNormal());
   }

   @Test
   public void normalize() {
      Vector2D v1 = Vector2D.createBySizeAngle(10, Math.toRadians(10));
      Vector2D old = new Vector2D(v1);
      Vector2D normal = v1.normalize();
      assertTrue(normal.isNormal());
      assertEquals(old, v1);
   }

   @Test
   public void plusMe() {
      Vector2D v1 = new Vector2D(5, 10);
      v1.plusMe(new Vector2D(1, -1));
      assertEquals(new Vector2D(6, 9), v1);
   }

   @Test
   public void plus() {
      Vector2D v1 = new Vector2D(5, 10);
      Vector2D sum = v1.plus(new Vector2D(1, -1));
      assertEquals(new Vector2D(5, 10), v1);
      assertEquals(new Vector2D(6, 9), sum);
   }

   @Test
   public void minusMe() {
      Vector2D v1 = new Vector2D(5, 10);
      v1.minusMe(new Vector2D(1, -1));
      assertEquals(new Vector2D(4, 11), v1);

   }

   @Test
   public void minus() {
      Vector2D v1 = new Vector2D(5, 10);
      Vector2D sub = v1.minus(new Vector2D(1, -1));
      assertEquals(new Vector2D(5, 10), v1);
      assertEquals(new Vector2D(4, 11), sub);

   }

   @Test
   public void multiplyMe() {
      Vector2D v1 = new Vector2D(5, 6);
      v1.multiplyMe(2);
      assertEquals(new Vector2D(10, 12), v1);
   }

   @Test
   public void multiply() {
      Vector2D v1 = new Vector2D(5, 6);
      Vector2D product = v1.multiply(2);
      assertEquals(new Vector2D(5, 6), v1);
      assertEquals(new Vector2D(10, 12), product);
   }

   @Test
   public void divMe() {
      Vector2D v1 = new Vector2D(10, 12);
      v1.divMe(2);
      assertEquals(new Vector2D(5, 6), v1);
   }

   @Test
   public void div() {
      Vector2D v1 = new Vector2D(10, 12);
      Vector2D div = v1.div(2);
      assertEquals(new Vector2D(10, 12), v1);
      assertEquals(new Vector2D(5, 6), div);
   }

   @Test
   public void negativeMeTest() {
      Vector2D v1 = new Vector2D(5, 6);
      v1.negativeMe();
      assertEquals(new Vector2D(-5, -6), v1);
   }

   @Test
   public void negative() {
      Vector2D v1 = new Vector2D(5, 6);
      Vector2D neg = v1.negative();
      assertEquals(new Vector2D(5, 6), v1);
      assertEquals(new Vector2D(-5, -6), neg);
   }

   @Test
   public void equalsAndHashcode() {

      Vector2D v1 = new Vector2D(1, 2);
      Vector2D thatEqualsV1 = new Vector2D(1, 2);
      Vector2D thatDoesntEqualsV1 = new Vector2D(3, 3);

      assertEquals(v1, thatEqualsV1);
      assertEquals(v1.hashCode(), thatEqualsV1.hashCode());

      assertNotSame(v1, thatDoesntEqualsV1);

   }

   @Test
   public void dotTest() {
      Vector2D v1 = Vector2D.createBySizeAngle(1, 10);
      Vector2D v2 = Vector2D.createBySizeAngle(1, 40);

      float dot = v1.dot(v2);
      assertEquals(Math.cos(30.0f), dot, 0.00001);
   }

   @Test
   public void cloneTest() {
      Vector2D v1 = new Vector2D(1, 1);
      Vector2D v1Clone = v1.clone();

      assertEquals(v1, v1Clone);
   }

   @Test
   public void getAtParameterIndexTest() {
      Vector2D v1 = new Vector2D();

      v1.putAt(0, 3.0f);
      v1.putAt(1, 5.0f);

      assertEquals(3.0f, v1.getAt(0));
      assertEquals(5.0f, v1.getAt(1));
      assertEquals(1.0f, v1.getAt(2));
   }

   @Test
   public void putAtParameterIndexValueTest() {

      Vector2D v1 = new Vector2D();

      v1.putAt(0, 3.0f);
      v1.putAt(1, 5.0f);
      v1.putAt(2, 5.0f);

      assertEquals(3.0f, v1.getAt(0));
      assertEquals(5.0f, v1.getAt(1));
   }

   @Test
   public void toArrayTest() {
      Vector2D v1 = new Vector2D(1, 1);
      float[] array = v1.toArray();

      assertEquals(v1.getX(), array[0]);
      assertEquals(v1.getY(), array[1]);
   }

   @Test
   public void to3DArrayTest() {
      Vector2D v1 = new Vector2D(1, 1);
      float[] array = v1.to3DArray();

      assertEquals(v1.getX(), array[0]);
      assertEquals(v1.getY(), array[1]);
      assertEquals(1.0f, array[2]);
   }

   @Test
   public void compareToParameterVector2DTest() {
      Vector2D v1 = new Vector2D(1, 1);
      Vector2D equalsV1 = new Vector2D(1, 1);
      Vector2D largerV1 = new Vector2D(2, 2);
      Vector2D smallerV1 = new Vector2D(0, 0);

      assertEquals(0, v1.compareTo(equalsV1));
      assertEquals(-1, v1.compareTo(largerV1));
      assertEquals(1, v1.compareTo(smallerV1));
   }
}
