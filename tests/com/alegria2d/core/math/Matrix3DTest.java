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

package com.alegria2d.core.math;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Matrix3D
 * 
 * @author Tacio Dias Palhao Mendes
 * @author Vinicius Godoy de Mendonca (ViniGodoy)
 */
public class Matrix3DTest {

   private Matrix3D matrix3d;
   private Matrix3D other;

   @Before
   public void setup() {
      matrix3d = new Matrix3D(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9);

      other = new Matrix3D(
            1, 9, 2,
            8, 3, 7,
            4, 6, 5);
   }

   @Test
   public void constructorFloatArray() {
      assertEquals(1.0f, matrix3d.getA());
      assertEquals(2.0f, matrix3d.getB());
      assertEquals(3.0f, matrix3d.getC());
      assertEquals(4.0f, matrix3d.getD());
      assertEquals(5.0f, matrix3d.getE());
      assertEquals(6.0f, matrix3d.getF());
      assertEquals(7.0f, matrix3d.getG());
      assertEquals(8.0f, matrix3d.getH());
      assertEquals(9.0f, matrix3d.getK());
   }

   @Test
   public void equals() {
      Matrix3D other = new Matrix3D(matrix3d);
      assertTrue(matrix3d.equals(matrix3d));
      assertFalse(matrix3d.equals("Other class"));
      assertTrue(matrix3d.equals(other));
      other.set(0, 0, 1.1f);
      assertFalse(matrix3d.equals(other));
   }

   @Test
   public void hashCodeTest() {
      Matrix3D copy = new Matrix3D(matrix3d);
      assertEquals(copy.hashCode(), matrix3d.hashCode());
      assertFalse(other.hashCode() == matrix3d.hashCode());
   }

   @Test
   public void constructorFloatMatrix() {
      float[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
      };

      Matrix3D matrix3d = new Matrix3D(matrix);
      assertEquals(1.0f, matrix3d.getA());
      assertEquals(2.0f, matrix3d.getB());
      assertEquals(3.0f, matrix3d.getC());
      assertEquals(4.0f, matrix3d.getD());
      assertEquals(5.0f, matrix3d.getE());
      assertEquals(6.0f, matrix3d.getF());
      assertEquals(7.0f, matrix3d.getG());
      assertEquals(8.0f, matrix3d.getH());
      assertEquals(9.0f, matrix3d.getK());
   }

   @Test
   public void copyConstructor() {
      Matrix3D matrix = new Matrix3D(matrix3d);

      assertEquals(1.0f, matrix.getA());
      assertEquals(2.0f, matrix.getB());
      assertEquals(3.0f, matrix.getC());
      assertEquals(4.0f, matrix.getD());
      assertEquals(5.0f, matrix.getE());
      assertEquals(6.0f, matrix.getF());
      assertEquals(7.0f, matrix.getG());
      assertEquals(8.0f, matrix.getH());
      assertEquals(9.0f, matrix.getK());
   }

   @Test
   public void newIdentity() {
      Matrix3D identity = Matrix3D.newIdentity();

      assertEquals(1.0f, identity.getA());
      assertEquals(0.0f, identity.getB());
      assertEquals(0.0f, identity.getC());
      assertEquals(0.0f, identity.getD());
      assertEquals(1.0f, identity.getE());
      assertEquals(0.0f, identity.getF());
      assertEquals(0.0f, identity.getG());
      assertEquals(0.0f, identity.getH());
      assertEquals(1.0f, identity.getK());
   }

   @Test
   public void setterAndGetter() {

      Matrix3D matrix3d = new Matrix3D(
            0, 0, 0,
            0, 0, 0,
            0, 0, 0);

      matrix3d.set(0, 0, 1.0f);
      matrix3d.set(0, 1, 2.0f);
      matrix3d.set(0, 2, 3.0f);
      matrix3d.set(1, 0, 4.0f);
      matrix3d.set(1, 1, 5.0f);
      matrix3d.set(1, 2, 6.0f);
      matrix3d.set(2, 0, 7.0f);
      matrix3d.set(2, 1, 8.0f);
      matrix3d.set(2, 2, 9.0f);

      assertEquals(1.0f, matrix3d.get(0, 0));
      assertEquals(2.0f, matrix3d.get(0, 1));
      assertEquals(3.0f, matrix3d.get(0, 2));
      assertEquals(4.0f, matrix3d.get(1, 0));
      assertEquals(5.0f, matrix3d.get(1, 1));
      assertEquals(6.0f, matrix3d.get(1, 2));
      assertEquals(7.0f, matrix3d.get(2, 0));
      assertEquals(8.0f, matrix3d.get(2, 1));
      assertEquals(9.0f, matrix3d.get(2, 2));
   }

   @Test
   public void getA() {
      assertEquals(1.0f, matrix3d.getA());
   }

   @Test
   public void getB() {
      assertEquals(2.0f, matrix3d.getB());
   }

   @Test
   public void getC() {
      assertEquals(3.0f, matrix3d.getC());
   }

   @Test
   public void getD() {
      assertEquals(4.0f, matrix3d.getD());
   }

   @Test
   public void getE() {
      assertEquals(5.0f, matrix3d.getE());
   }

   @Test
   public void getF() {
      assertEquals(6.0f, matrix3d.getF());
   }

   @Test
   public void getG() {
      assertEquals(7.0f, matrix3d.getG());
   }

   @Test
   public void getH() {
      assertEquals(8.0f, matrix3d.getH());
   }

   @Test
   public void getK() {
      assertEquals(9.0f, matrix3d.getK());
   }

   @Test
   public void plusMeMatrix3D() {
      matrix3d.plusMe(other);

      assertEquals(2.0f, matrix3d.getA());
      assertEquals(11.0f, matrix3d.getB());
      assertEquals(5.0f, matrix3d.getC());
      assertEquals(12.0f, matrix3d.getD());
      assertEquals(8.0f, matrix3d.getE());
      assertEquals(13.0f, matrix3d.getF());
      assertEquals(11.0f, matrix3d.getG());
      assertEquals(14.0f, matrix3d.getH());
      assertEquals(14.0f, matrix3d.getK());
   }

   @Test
   public void plusMatrix3D() {
      Matrix3D old = new Matrix3D(matrix3d);
      Matrix3D result = matrix3d.plus(other);

      assertEquals(2.0f, result.getA());
      assertEquals(11.0f, result.getB());
      assertEquals(5.0f, result.getC());
      assertEquals(12.0f, result.getD());
      assertEquals(8.0f, result.getE());
      assertEquals(13.0f, result.getF());
      assertEquals(11.0f, result.getG());
      assertEquals(14.0f, result.getH());
      assertEquals(14.0f, result.getK());
      assertEquals(old, matrix3d);
   }

   @Test
   public void minusMe() {
      matrix3d.minusMe(other);

      assertEquals(0.0f, matrix3d.getA());
      assertEquals(-7.0f, matrix3d.getB());
      assertEquals(1.0f, matrix3d.getC());
      assertEquals(-4.0f, matrix3d.getD());
      assertEquals(2.0f, matrix3d.getE());
      assertEquals(-1.0f, matrix3d.getF());
      assertEquals(3.0f, matrix3d.getG());
      assertEquals(2.0f, matrix3d.getH());
      assertEquals(4.0f, matrix3d.getK());
   }

   @Test
   public void minusMatrix3D() {
      Matrix3D old = new Matrix3D(matrix3d);
      Matrix3D result = matrix3d.minus(other);

      assertEquals(0.0f, result.getA());
      assertEquals(-7.0f, result.getB());
      assertEquals(1.0f, result.getC());
      assertEquals(-4.0f, result.getD());
      assertEquals(2.0f, result.getE());
      assertEquals(-1.0f, result.getF());
      assertEquals(3.0f, result.getG());
      assertEquals(2.0f, result.getH());
      assertEquals(4.0f, result.getK());
      assertEquals(old, matrix3d);
   }

   @Test
   public void multiplyMatrix3D() {
      Matrix3D old = new Matrix3D(matrix3d);
      Matrix3D other = new Matrix3D(9.0f, 8.0f, 7.0f, 6.0f, 10.0f, 4.0f, 3.0f, 2.0f, 1.0f);
      Matrix3D result = matrix3d.multiply(other);

      assertEquals(30.0f, result.getA());
      assertEquals(34.0f, result.getB());
      assertEquals(18.0f, result.getC());
      assertEquals(84.0f, result.getD());
      assertEquals(94.0f, result.getE());
      assertEquals(54.0f, result.getF());
      assertEquals(138.0f, result.getG());
      assertEquals(154.0f, result.getH());
      assertEquals(90.0f, result.getK());
      assertEquals(old, matrix3d);
   }

   @Test
   public void multiplyMeMatrix3D() {
      Matrix3D other = new Matrix3D(9.0f, 8.0f, 7.0f, 6.0f, 10.0f, 4.0f, 3.0f, 2.0f, 1.0f);

      matrix3d.multiplyMe(other);

      assertEquals(30.0f, matrix3d.getA());
      assertEquals(34.0f, matrix3d.getB());
      assertEquals(18.0f, matrix3d.getC());
      assertEquals(84.0f, matrix3d.getD());
      assertEquals(94.0f, matrix3d.getE());
      assertEquals(54.0f, matrix3d.getF());
      assertEquals(138.0f, matrix3d.getG());
      assertEquals(154.0f, matrix3d.getH());
      assertEquals(90.0f, matrix3d.getK());
   }

   @Test
   public void multiplyMeInt() {
      matrix3d.multiplyMe(3);

      assertEquals(3.0f, matrix3d.getA());
      assertEquals(6.0f, matrix3d.getB());
      assertEquals(9.0f, matrix3d.getC());
      assertEquals(12.0f, matrix3d.getD());
      assertEquals(15.0f, matrix3d.getE());
      assertEquals(18.0f, matrix3d.getF());
      assertEquals(21.0f, matrix3d.getG());
      assertEquals(24.0f, matrix3d.getH());
      assertEquals(27.0f, matrix3d.getK());
   }

   @Test
   public void multiplyInt() {
      Matrix3D old = new Matrix3D(matrix3d);
      Matrix3D result = matrix3d.multiply(3);

      assertEquals(3.0f, result.getA());
      assertEquals(6.0f, result.getB());
      assertEquals(9.0f, result.getC());
      assertEquals(12.0f, result.getD());
      assertEquals(15.0f, result.getE());
      assertEquals(18.0f, result.getF());
      assertEquals(21.0f, result.getG());
      assertEquals(24.0f, result.getH());
      assertEquals(27.0f, result.getK());
      assertEquals(old, matrix3d);
   }

   @Test
   public void multiplyVector2D() {
      Vector2D other = new Vector2D(2.0f, 3.0f);
      Vector2D result = matrix3d.multiply(other);

      assertEquals(11.0f, result.getX());
      assertEquals(29.0f, result.getY());
   }

   @Test
   public void nonZeroDeterminant() {
      Matrix3D matrix3d = new Matrix3D(
             5, 0, 1,
            -2, 3, 4,
             0, 2, -1);

      assertEquals(-59, matrix3d.getDeterminant(), MathUtil.FLOAT_DELTA);
   }

   @Test
   public void zeroDeterminant() {
      Matrix3D matrix3d = new Matrix3D(
             1, 3, 10,
            -1, 1, 10,
             0, 2, 10);

      assertEquals(0, matrix3d.getDeterminant(), MathUtil.FLOAT_DELTA);
   }

   @Test
   public void isInvertible() {
      Matrix3D notInvertible = new Matrix3D(
            1, 3, 10,
            -1, 1, 10,
            0, 2, 10);

      Matrix3D invertible = new Matrix3D(
            3, 0, 2,
            9, 1, 7,
            1, 0, 1);

      assertFalse(notInvertible.isInvertible());
      assertTrue(invertible.isInvertible());
   }

   @Test
   public void inverseMe() {
      Matrix3D invertible = new Matrix3D(
            3, 0, 2,
            9, 1, 7,
            1, 0, 1);

      invertible.inverseMe();

      assertEquals(1.0f, invertible.getA());
      assertEquals(0.0f, invertible.getB());
      assertEquals(-2.0f, invertible.getC());
      assertEquals(-2.0f, invertible.getD());
      assertEquals(1.0f, invertible.getE());
      assertEquals(-3.0f, invertible.getF());
      assertEquals(-1.0f, invertible.getG());
      assertEquals(0.0f, invertible.getH());
      assertEquals(3.0f, invertible.getK());
   }

   @Test
   public void inverse() {
      Matrix3D invertible = new Matrix3D(3.0f, 0.0f, 2.0f, 9.0f, 1.0f, 7.0f, 1.0f, 0.0f, 1.0f);
      Matrix3D old = new Matrix3D(invertible);

      Matrix3D result = invertible.inverse();

      assertEquals(1.0f, result.getA());
      assertEquals(0.0f, result.getB());
      assertEquals(-2.0f, result.getC());
      assertEquals(-2.0f, result.getD());
      assertEquals(1.0f, result.getE());
      assertEquals(-3.0f, result.getF());
      assertEquals(-1.0f, result.getG());
      assertEquals(0.0f, result.getH());
      assertEquals(3.0f, result.getK());
      assertEquals(old, invertible);
   }

   @Test
   public void transpose() {
      Matrix3D old = new Matrix3D(matrix3d);
      Matrix3D result = matrix3d.transpose();

      assertEquals(1.0f, result.getA());
      assertEquals(4.0f, result.getB());
      assertEquals(7.0f, result.getC());
      assertEquals(2.0f, result.getD());
      assertEquals(5.0f, result.getE());
      assertEquals(8.0f, result.getF());
      assertEquals(3.0f, result.getG());
      assertEquals(6.0f, result.getH());
      assertEquals(9.0f, result.getK());
      assertEquals(old, matrix3d);
   }

   @Test
   public void transposeMe() {
      matrix3d.transposeMe();

      assertEquals(1.0f, matrix3d.getA());
      assertEquals(4.0f, matrix3d.getB());
      assertEquals(7.0f, matrix3d.getC());
      assertEquals(2.0f, matrix3d.getD());
      assertEquals(5.0f, matrix3d.getE());
      assertEquals(8.0f, matrix3d.getF());
      assertEquals(3.0f, matrix3d.getG());
      assertEquals(6.0f, matrix3d.getH());
      assertEquals(9.0f, matrix3d.getK());
   }

   @Test
   public void cloneTest() {
      Matrix3D clone = matrix3d.clone();

      // Avoid a "return this" implementation
      assertNotSame(matrix3d, clone);
      assertEquals(matrix3d, clone);
   }

   @Test
   public void toArray() {
      Matrix3D matrix3d = new Matrix3D(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);

      float[][] array = matrix3d.toArray();

      assertEquals(matrix3d.getA(), array[0][0]);
      assertEquals(matrix3d.getB(), array[0][1]);
      assertEquals(matrix3d.getC(), array[0][2]);
      assertEquals(matrix3d.getD(), array[1][0]);
      assertEquals(matrix3d.getE(), array[1][1]);
      assertEquals(matrix3d.getF(), array[1][2]);
      assertEquals(matrix3d.getG(), array[2][0]);
      assertEquals(matrix3d.getH(), array[2][1]);
      assertEquals(matrix3d.getK(), array[2][2]);

      // Make sure it's not returning the internal array
      matrix3d.set(0, 0, 90);
      assertEquals(1.0, array[0][0], MathUtil.FLOAT_DELTA);
   }

   @Test
   public void getAtInt() {
      assertEquals(1.0f, matrix3d.getAt(0).getAt(0));
      assertEquals(2.0f, matrix3d.getAt(0).getAt(1));
      assertEquals(3.0f, matrix3d.getAt(0).getAt(2));
      assertEquals(4.0f, matrix3d.getAt(1).getAt(0));
      assertEquals(5.0f, matrix3d.getAt(1).getAt(1));
      assertEquals(6.0f, matrix3d.getAt(1).getAt(2));
      assertEquals(7.0f, matrix3d.getAt(2).getAt(0));
      assertEquals(8.0f, matrix3d.getAt(2).getAt(1));
      assertEquals(9.0f, matrix3d.getAt(2).getAt(2));
   }
}
