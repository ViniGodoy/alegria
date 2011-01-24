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

import java.util.Random;

/**
 * This class represents a range of integer values.
 * <p>
 * The range is delimited by two values, called <code>from</code> and <to>to</to>. Both values are inclusive. The
 * interval may be ascending, when from < to, or descending, with from > to.
 * <p>
 * Numbers inside a Range can be retrieved by using a <b>factor</b>, with the {@link #getValue(float)} method. The
 * factor is a floating point value from 0 to 1, where 0 is <code>from</code> and 1 is <code>to</code>, and any other
 * value are the numbers in between proportionally taken. For example, in a range from 0 to 50, the factor 0.5 will
 * represent number 25, and factor 0.1 will represent the number 0. If you have a number inside the range, you can also
 * ask range class what factor represents it, by calling the {@link #factorOf(float)} method.
 * <p>
 * Another way to retrieve a number is randomly, by calling the {@link #random()} method. Any number in the interval
 * will be picked, and retrieved.
 * <p>
 * Ranges intervals and random number generator cannot be changed once assigned. But this does not make Ranges
 * immutable, since the random number generator state will constantly change at each call to {@link #random()}. Only
 * single interval ranges are truly immutable objects.
 * 
 * @author Vinicius Godoy de Mendonca (ViniGodoy)
 * @see FloatRange
 */
public final class IntRange {
   private Random random; // TODO Replace by the new Alegria Random class, when it's ready.
   private int from;
   private int to;

   /**
    * Creates a new range for the given interval, that uses the given random number generator.
    * <p>
    * The <code>from</code> and <code>to</code> numbers mark the limits of the interval. You can provide a value to from
    * that is bigger than the value of "to" and, in this case, you'll have a descending interval (a factor of 1 will
    * return the lowest number, while a factor of 0 will return the biggest one).
    * <p>
    * If from and to numbers are equal, the random number generator will not be used, even if a call to
    * {@link #random()} is made.
    * <p>
    * The provided number generator will be used when {@link #random()} is called. This number generator instance will
    * be <b>shared</b>
    * 
    * @param from Begin of the interval (inclusive)
    * @param to End of the interval (also inclusive)
    * @param random The random number generator
    */
   public IntRange(int from, int to, Random random) {
      this.from = from;
      this.to = to;

      if (from == to)
         this.random = null;
      else
         this.random = (random == null) ? new Random() : random;
   }

   /**
    * Creates a new range for the given interval.
    * <p>
    * The <code>from</code> and <code>to</code> numbers mark the limits of the interval. You can provide a value to from
    * that is bigger than the value of "to" and, in this case, you'll have a descending interval (a factor of 1 will
    * return the lowest number, while a factor of 0 will return the biggest one).
    * 
    * @param from Begin of the interval (inclusive)
    * @param to End of the interval (also inclusive)
    * @see #IntRange(float, float, Random)
    */
   public IntRange(int from, int to) {
      this(from, to, null);
   }

   /**
    * Returns a new range for the given number. Any factor or call to {@link #random()} will return this number.
    * <p>
    * This is just a convenience methods to provide a common number where a range is required.
    * 
    * @param fromTo The number.
    */
   public IntRange(int fromTo) {
      this(fromTo, fromTo, null);
   }

   /**
    * @return the <code>from</code> value of this range. This is the number that begins the range (factor 0). This
    *         number is not necessarily the smallest one in the range, since ranges can be descending. If you are
    *         looking for the smallest number in range, use the {@link #getMin()} method instead.
    * @see #getMin()
    * @see #getTo()
    */
   public int getFrom() {
      return from;
   }

   /**
    * @return the <code>to</code> value of this range. This is the number that ends the range (factor 1). This number is
    *         not necessarily the greatest one in the range, since ranges can be descending. If you are looking for the
    *         biggest number in the range, use the {@link #getMax()} method instead.
    * 
    * @see #getMax()
    * @see #getFrom()
    */
   public int getTo() {
      return to;
   }

   /**
    * @return The smallest value in this interval.
    * @see #getFrom()
    */
   public int getMin() {
      return isAscending() ? from : to;
   }

   /**
    * @return The biggest value in this interval.
    * @see #getTo()
    */
   public int getMax() {
      return isDescending() ? from : to;
   }

   /**
    * Indicate if this range is in fact just a single number. If true, any call to {@link #getValue(float)} or
    * {@link #random()} will return the same number. Also, this range will never affect the random number generator,
    * even if one was provided with the complete constructor.
    * 
    * @return True if this range is formed by a single number, false if not.
    */
   public boolean isSingleNumber() {
      return random == null;
   }

   /**
    * @return True if this range is ascending (from <= to)
    */
   public boolean isAscending() {
      return from <= to;
   }

   /**
    * @return True if this range is descending (to > from)
    */
   public boolean isDescending() {
      return !isAscending();
   }

   /**
    * @return A random number within this range.
    */
   public int random() {
      if (isSingleNumber())
         return to;

      return random.nextInt(getSize()) + from;
   }

   /**
    * @param value Indicate if this value is inside this range.
    */
   public boolean isInRange(int value) {
      return value >= getMin() && value <= getMax();
   }

   /**
    * Retrieve a number inside this range by using the given factor.
    * <p>
    * The factor is a floating point value from 0 to 1, where 0 is <code>from</code> and 1 is <code>to</code>, and any
    * other value are the numbers in between proportionally taken. For example, in a range from 0 to 50, the factor 0.5
    * will represent number 25, and factor 0.1 will represent the number 0.5.
    * <p>
    * If you have a number inside the range, you can also ask range class what factor represents it, by calling the
    * {@link #factorOf(float)} method.
    * 
    * @see #factorOf(float)
    */
   public int getValue(float factor) {
      if (isSingleNumber())
         return to;

      factor = factor < 0 ? 0 : (factor > 1 ? 1 : factor);
      return Math.round(sizeSign() * factor + from);
   }

   /**
    * Retrieve the factor of this number, within this range.
    * <p>
    * The factor is a floating point value from 0 to 1, where 0 is <code>from</code> and 1 is <code>to</code>, and any
    * other value are the numbers in between proportionally taken. For example, in a range from 0 to 50, the factor 0.5
    * will represent number 25, and factor 0.1 will represent the number 0.5.
    * 
    * @see #getValue(float)
    */
   public float factorOf(int number) {
      if (isSingleNumber())
         return to;

      return !isInRange(number) ? 0 : (number - from) / (float) sizeSign();
   }

   private int sizeSign() {
      return to - from;
   }

   /**
    * Converts a value from another range to this range, proportionally. Both numbers will have the same factor in their
    * respective range.
    * <p>
    * For example, a value of 50 in a range varying from 0 to 100, represents a factor of 0.5. In a range of 0 to 200,
    * the converted number will be 100, since its factor is also 0.5.
    * 
    * @param value The value to convert.
    * @param range The destination range
    * @return The converted value
    */
   public int convert(int value, IntRange range) {
      return getValue(range.factorOf(value));
   }

   /**
    * Converts a value from another range to this range, proportionally. Both numbers will have the same factor in their
    * respective range.
    * <p>
    * For example, a value of 50 in a range varying from 0 to 100, represents a factor of 0.5. In a range of 0 to 200,
    * the converted number will be 100, since its factor is also 0.5.
    * 
    * @param value The value to convert.
    * @param range The destination range
    * @return The converted value
    */
   public float convert(float value, FloatRange range) {
      return getValue(range.factorOf(value));
   }

   /**
    * @return Creates a range that is the reversed copy of this one. In the new range, from and to values are switched
    *         and the random number generator is shared.
    */
   public IntRange reverse() {
      return isSingleNumber() ? this : new IntRange(to, from, random);
   }

   /**
    * @return Returns the number of elements in this range.
    */
   public int getSize() {
      return Math.abs(sizeSign())+1;
   }
}
