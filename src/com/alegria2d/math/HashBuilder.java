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

/**
 * Build a HASH value based on the added values. If none value is added, DEFAULT_BASE is the hash returned in getHash()
 * method.
 * <p>
 * The calculation used is proposed by Joshua Block in Effective Java p. 38
 * <p>
 * Below there's simple a sample of how to use hashBuilder:
 * 
 * <pre>
 * public class Person {
 *    private String name;
 *    private int age;
 * 
 *    public Person(String name, int age) {
 *       this.name = name;
 *       this.age = age;
 *    }
 * 
 *    public int getAge() {
 *       return age;
 *    }
 * 
 *    public int getName() {
 *       return name;
 *    }
 * 
 *    @Override
 *    public int hashCode() {
 *       return new HashBuilder(name).add(age).hashCode();
 *    }
 * }
 * </pre>
 * 
 * @author Vinicius G. Mendonca
 */
public final class HashBuilder {
   public static final int DEFAULT_BASE = 17;
   public static final int DEFAULT_SEED = 37;

   private int seed;
   private int base;

   private int result;

   /**
    * Create a new hash builder.
    */
   public HashBuilder() {
      this(DEFAULT_BASE, DEFAULT_SEED);
   }

   /**
    * Create a new hashBuilder and computes the given value as the first one.
    * 
    * @param firstValue Value to compute.
    */
   public HashBuilder(int firstValue) {
      this();
      add(firstValue);
   }

   /**
    * Create a new hashBuilder and computes the given value as the first one.
    * 
    * @param firstValue Value to compute.
    */
   public HashBuilder(long firstValue) {
      this();
      add(firstValue);
   }

   /**
    * Create a new hashBuilder and computes the given value as the first one.
    * 
    * @param firstValue Value to compute.
    */
   public HashBuilder(char firstValue) {
      this();
      add(firstValue);
   }

   /**
    * Create a new hashBuilder and computes the given value as the first one.
    * 
    * @param firstValue Value to compute.
    */
   public HashBuilder(boolean firstValue) {
      this();
      add(firstValue);
   }

   /**
    * Create a new hashBuilder and computes the given value as the first one.
    * 
    * @param firstValue Value to compute.
    */
   public HashBuilder(float firstValue) {
      this();
      add(firstValue);
   }

   /**
    * Create a new hashBuilder and computes the given value as the first one.
    * 
    * @param firstValue Value to compute.
    */
   public HashBuilder(double firstValue) {
      this();
      add(firstValue);
   }

   /**
    * Create a new hashBuilder and computes the given value as the first one.
    * 
    * @param firstValue Value to compute.
    */
   public HashBuilder(Object firstValue) {
      this();
      add(firstValue);
   }

   /**
    * Creates a new hashBuilder with the given base prime number and the given seed. The base number will be used as the
    * first prime in hash calculations, and the seed will be multiplied in every subsequent ones.
    * 
    * @param base The first value in calculation
    * @param seed The prime to multiply hashcode in every calculation
    */
   public HashBuilder(int base, int seed) {
      if (base < 3)
         throw new IllegalArgumentException("Base must be bigger than 2!");

      if (seed < 3)
         throw new IllegalArgumentException("Seed must be bigger than 2!");

      this.seed = seed;
      this.base = base;

      result = base;
   }

   /**
    * Resets this {@link HashBuilder} back to the base value, discarding any hash computation already made.
    */
   public void reset() {
      result = base;
   }

   /**
    * Compute the given value into the hash.
    * 
    * @param value The value to compute.
    * @return This hash builder.
    */
   public HashBuilder add(int value) {
      result = seed * result + value;
      return this;
   }

   /**
    * Compute the given value into the hash.
    * 
    * @param value The value to compute.
    * @return This hash builder.
    */
   public HashBuilder add(char value) {
      return add((short) value);
   }

   /**
    * Compute the given value into the hash.
    * 
    * @param value The value to compute.
    * @return This hash builder.
    */
   public HashBuilder add(long value) {
      return add((int) (value ^ (value >>> 32)));
   }

   /**
    * Compute the given value into the hash.
    * 
    * @param value The value to compute.
    * @return This hash builder.
    */
   public HashBuilder add(boolean value) {
      return add(value ? 1 : 0);
   }

   /**
    * Compute the given value into the hash.
    * 
    * @param value The value to compute.
    * @return This hash builder.
    */
   public HashBuilder add(float value) {
      return add(Float.floatToIntBits(value));
   }

   /**
    * Compute the given value into the hash.
    * 
    * @param value The value to compute.
    * @return This hash builder.
    */
   public HashBuilder add(double value) {
      return add(Double.doubleToLongBits(value));
   }

   /**
    * Compute the given value into the hash.
    * 
    * @param value The value to compute.
    * @return This hash builder.
    */
   public HashBuilder add(Object value) {
      return add(value == null ? 0 : value.hashCode());
   }

   /**
    * Compute the given array into the hash.
    * 
    * @param value The value to compute.
    * @return This hash builder.
    */
   public HashBuilder add(byte[] value) {
      for (byte b : value)
         add(b);
      return this;
   }

   /**
    * Compute the given array into the hash.
    * 
    * @param value Array of values to compute.
    * @return This hash builder.
    */
   public HashBuilder add(short[] value) {
      for (short s : value)
         add(s);
      return this;
   }

   /**
    * Compute the given array into the hash.
    * 
    * @param value Array of values to compute.
    * @return This hash builder.
    */
   public HashBuilder add(int[] value) {
      for (int i : value)
         add(i);
      return this;
   }

   /**
    * Compute the given array into the hash.
    * 
    * @param value Array of values to compute.
    * @return This hash builder.
    */
   public HashBuilder add(char[] value) {
      for (char c : value)
         add(c);
      return this;
   }

   /**
    * Compute the given array into the hash.
    * 
    * @param value Array of values to compute.
    * @return This hash builder.
    */
   public HashBuilder add(long[] value) {
      for (long l : value)
         add(l);
      return this;
   }

   /**
    * Compute the given array into the hash.
    * 
    * @param value Array of values to compute.
    * @return This hash builder.
    */
   public HashBuilder add(boolean[] value) {
      for (boolean b : value)
         add(b);
      return this;
   }

   /**
    * Compute the given array into the hash.
    * 
    * @param value Array of values to compute.
    * @return This hash builder.
    */
   public HashBuilder add(float[] value) {
      for (float f : value)
         add(f);
      return this;
   }

   /**
    * Compute the given array into the hash.
    * 
    * @param value Array of values to compute.
    * @return This hash builder.
    */
   public HashBuilder add(double[] value) {
      for (double d : value)
         add(d);
      return this;
   }

   /**
    * Compute the given array into the hash.
    * 
    * @param value Array of values to compute.
    * @return This hash builder.
    */
   public HashBuilder add(Object[] value) {
      for (Object o : value)
         add(o);
      return this;
   }

   /**
    * Compute the given array into the hash.
    * 
    * @param value Array of values to compute.
    * @return This hash builder.
    */
   @Override
   public boolean equals(Object value) {
      if (value == null || value.getClass() != getClass())
         return false;
      
      if (value == this)
         return true;

      HashBuilder other = (HashBuilder) value;
      return other.result == result && other.base == base
                && other.seed == seed;
   }

   /**
    * Calculate the hash code for this HashBuilder.
    * <p>
    * The hashcode will be the result of every calculation made using this object.
    */
   @Override
   public int hashCode() {
      return result;
   }
}
