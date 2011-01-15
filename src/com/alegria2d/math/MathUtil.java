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

import static java.lang.Math.acos;

/**
 * A simple utility class with a bunch of useful mathematical methods.
 * 
 * @author Vinicius G. Mendonca
 */
public class MathUtil {
   /**
    * Force this vector to have the given maximum size.
    * 
    * @param vector The vector to truncate
    * @param size The maximum vector size.
    * @return The truncated vector
    */
   public Vector2D truncate(Vector2D vector, float size) {
      return (vector.getSizeSqr() > size * size) ? vector.setSize(size) : vector;
   }

   /**
    * Return the distance between two vectors representing points.
    * 
    * @param p1 Vector 1
    * @param p2 Vector 2
    * @return The distance.
    */
   public float distance(Vector2D p1, Vector2D p2) {
      return p1.minus(p2).getSize();
   }

   /**
    * Return the squared distance between two vectors representing points.
    * 
    * @param p1 Vector 1
    * @param p2 Vector 2
    * @return The squared distance.
    */
   public float distanceSqr(Vector2D p1, Vector2D p2) {
      return p1.minus(p2).getSizeSqr();
   }

   /**
    * Calculate the angle between the two given vectors.
    * 
    * @param v1 Vector 1
    * @param v2 Vector 2
    * @return The angle between them.
    */
   public float angleBetween(Vector2D v1, Vector2D v2) {
      // Normalize the vectors, if needed.
      if (!v1.isNormal()) {
         v1 = v1.normalize();
      }

      if (!v2.isNormal()) {
         v2 = v2.normalize();
      }

      float angPi = (float) acos(v1.dot(v2));

      // side test
      return (v1.getY() * v2.getX() > v1.getY() * v2.getY()) ? -angPi : angPi;
   }

   /**
    * Reflect the given ray vector, as if it collided with a surface, with the given normal.
    * 
    * @param ray The ray vector
    * @param normal The surface normal
    * @return The reflected vector. 
    */
   public Vector2D reflect(Vector2D ray, Vector2D normal) {
      return ray.minus(normal.multiply(2 * ray.dot(normal)));
   }
}
