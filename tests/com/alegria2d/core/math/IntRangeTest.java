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

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.junit.Test;
import com.alegria2d.core.math.FloatRange;
import com.alegria2d.core.math.IntRange;

/**
 * Tests IntRange class
 * @author Vinicius Godoy de Mendonca (ViniGodoy)
 */
public class IntRangeTest {
   private static final float DELTA = 0.000001f;
   /**
    * Test method for constructor {@link IntRange#IntRange(int, int, Random)}.
    */
   @Test
   public void constructorIntIntRandom() {
      TestRandom r = new TestRandom();
      IntRange range = new IntRange(1, 10, r);
      assertEquals(1, range.getFrom());
      assertEquals(10, range.getTo());
      assertEquals(10, range.getSize());
      range.random();
      assertTrue(r.wasUsed());
   }

   /**
    * Test method for constructor {@link IntRange#IntRange(int, int, Random)}. This method tests if the constructor used
    * with equal integer values will generate a single number range. In this case, the randomizer should never be used.
    */
   @Test
   public void constructorIntIntRandomSameInt() {
      TestRandom r = new TestRandom();
      IntRange range = new IntRange(10, 10, r);
      assertEquals(10, range.getFrom());
      assertEquals(10, range.getTo());
      assertEquals(1, range.getSize());
      assertTrue(range.isSingleNumber());
      assertEquals(10, range.random());
      assertFalse(r.wasUsed());
   }

   /**
    * Test method for constructor {@link IntRange#IntRange(int, int)}.
    */
   @Test
   public void constructorIntInt() {
      IntRange range = new IntRange(1, 10);
      assertEquals(1, range.getFrom());
      assertEquals(10, range.getTo());
      assertEquals(10, range.getSize());
   }

   /**
    * Test method for constructor {@link IntRange#IntRange(int, int)}. This method tests if the constructor used with
    * equal integer values will generate a single number range.
    */
   @Test
   public void constructorIntIntSameInt() {
      IntRange range = new IntRange(10, 10);
      assertEquals(10, range.getFrom());
      assertEquals(10, range.getTo());
      assertEquals(1, range.getSize());
      assertTrue(range.isSingleNumber());
   }

   /**
    * Test method for constructor {@link IntRange#IntRange(int)}.
    */
   @Test
   public void constructorInt() {
      IntRange range = new IntRange(10);
      assertEquals(10, range.getFrom());
      assertEquals(10, range.getTo());
      assertEquals(1, range.getSize());
      assertTrue(range.isSingleNumber());
   }

   /**
    * Test method for {@link .IntRange#getFrom()}.
    */
   @Test
   public void getFrom() {
      assertEquals(10, new IntRange(10, 10).getFrom());
      assertEquals(1, new IntRange(1, 15).getFrom());
      assertEquals(-5, new IntRange(-5, -10).getFrom());
   }

   /**
    * Test method for {@link .IntRange#getTo()}.
    */
   @Test
   public void getTo() {
      assertEquals(10, new IntRange(10, 10).getTo());
      assertEquals(15, new IntRange(1, 15).getTo());
      assertEquals(-10, new IntRange(-5, -10).getTo());
   }

   /**
    * Test method for {@link .IntRange#getMin()}.
    */
   @Test
   public void getMin() {
      assertEquals(10, new IntRange(10, 10).getMin());
      assertEquals(1, new IntRange(1, 15).getMin());
      assertEquals(-10, new IntRange(-5, -10).getMin());
   }

   /**
    * Test method for {@link .IntRange#getMax()}.
    */
   @Test
   public void getMax() {
      assertEquals(10, new IntRange(10, 10).getMax());
      assertEquals(15, new IntRange(1, 15).getMax());
      assertEquals(-5, new IntRange(-5, -10).getMax());
   }

   /**
    * Test method for {@link .IntRange#isSingleNumber()}.
    */
   @Test
   public void isSingleNumber() {
      assertFalse(new IntRange(1, 2).isSingleNumber());
      assertTrue(new IntRange(1, 1).isSingleNumber());
      TestRandom r = new TestRandom();
      
      IntRange tr = new IntRange(1,1, r);      
      assertTrue(tr.isSingleNumber());
      tr.random();
      assertFalse(r.wasUsed());
   }

   /**
    * Test method for {@link IntRange#isAscending()}.
    */
   @Test
   public void isAscending() {
      assertTrue(new IntRange(0, 10).isAscending());
      assertFalse(new IntRange(10, 1).isAscending());
      assertTrue(new IntRange(10).isAscending());
   }

   /**
    * Test method for {@link .IntRange#isDescending()}.
    */
   @Test
   public void isDescending() {
      assertFalse(new IntRange(0, 10).isDescending());
      assertTrue(new IntRange(10, 1).isDescending());
      assertFalse(new IntRange(10).isDescending());
   }

   /**
    * Test method for {@link IntRange#random()}.
    */
   @Test
   public void random() {
      IntRange range = new IntRange(1, 10);
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < 1000; i++) {
         int random = range.random();
         
         //Make sure no strange value was generated.
         assertTrue("The value " + random + " was generated out of range!", random >= 1 && random <= 10);
         
         if (!map.containsKey(random)) {
            map.put(random, 1);
         } else {         
            map.put(random, map.get(random)+1);
         }
      }
      
      //Make sure all values was generated at least 75 times.
      for (int i = 1; i < 11; i++) {         
         assertTrue("The value " + i + " was generated only " + map.get(i) + " times!", map.get(i) >= 75);         
      }
   }

   /**
    * Test method for {@link IntRange#isInRange(int)}.
    */
   @Test
   public void isInRange() {
      IntRange range = new IntRange(50, 100);
      for (int i = -50; i < 150; i++) {
         assertEquals(i >= 50 && i <= 100, range.isInRange(i));
      }
   }

   /**
    * Test method for {@link IntRange#getValue(float)}.
    */
   @Test
   public void getValue() {
      IntRange range = new IntRange(0, 100);
      for (float i = 0; i < 1; i += 0.002) {         
         assertEquals(Math.round(i*100), range.getValue(i));
      }
      
      range = range.reverse();
      for (float i = 0f; i < 1; i += 0.002) {     
         assertEquals(100-Math.round(i*100), range.getValue(i));
      }        
      
   }

   /**
    * Test method for {@link IntRange#factorOf(int)}.
    */
   @Test
   public void factorOf() {
      IntRange range = new IntRange(0, 500);
      
      assertEquals(0, range.factorOf(0), DELTA);      
      assertEquals(0.25, range.factorOf(125), DELTA);
      assertEquals(0.50, range.factorOf(250), DELTA);
      assertEquals(0.75, range.factorOf(375), DELTA);
      assertEquals(1, range.factorOf(500), DELTA);
      
      range = range.reverse();
      assertEquals(1, range.factorOf(0), DELTA);      
      assertEquals(0.75, range.factorOf(125), DELTA);
      assertEquals(0.50, range.factorOf(250), DELTA);
      assertEquals(0.25, range.factorOf(375), DELTA);
      assertEquals(0, range.factorOf(500), DELTA);
   }

   /**
    * Test method for {@link IntRange#convert(int, IntRange)}.
    */
   @Test
   public void testConvertIntIntRange() {
      IntRange r = new IntRange(100, 500);
      IntRange r2 = new IntRange(0, 100);
      
      assertEquals(0, r2.convert(100, r));
      assertEquals(25, r2.convert(200, r));
      assertEquals(50, r2.convert(300, r));
      assertEquals(75, r2.convert(400, r));
      assertEquals(100, r2.convert(500, r));
      
      r = r.reverse();
      assertEquals(0, r2.convert(500, r));
      assertEquals(25, r2.convert(400, r));
      assertEquals(50, r2.convert(300, r));
      assertEquals(75, r2.convert(200, r));
      assertEquals(100, r2.convert(100, r));      
   }

   /**
    * Test method for {@link IntRange#convert(float, .FloatRange)}.
    */
   @Test
   public void testConvertFloatFloatRange() {
      FloatRange r = new FloatRange(100, 500);
      IntRange r2 = new IntRange(0, 100);
      
      assertEquals(0, r2.convert(100, r), DELTA);
      assertEquals(25, r2.convert(200, r), DELTA);
      assertEquals(50, r2.convert(300, r), DELTA);
      assertEquals(75, r2.convert(400, r), DELTA);
      assertEquals(100, r2.convert(500, r), DELTA);
      
      r = new FloatRange(500, 100);
      assertEquals(0, r2.convert(500, r), DELTA);
      assertEquals(25, r2.convert(400, r), DELTA);
      assertEquals(50, r2.convert(300, r), DELTA);
      assertEquals(75, r2.convert(200, r), DELTA);
      assertEquals(100, r2.convert(100, r), DELTA);      
   }

   /**
    * Test method for {@link IntRange#reverse()}.
    */
   @Test
   public void reverse() {
      assertEquals(100, new IntRange(0,100).reverse().getFrom());
      assertEquals(0, new IntRange(0,100).reverse().getTo());
      
      //Test if the random number generator is shared.
      TestRandom r = new TestRandom();
      IntRange r1 = new IntRange(0, 10, r);
      r1.reverse().random();      
      assert(r.wasUsed());
   }
   
   @Test
   public void getSize() {
      assertEquals(10, new IntRange(0, 9).getSize());
      assertEquals(5, new IntRange(10, 6).getSize());
   }

}

/**
 * A random class for test cases. It knows when one of it's next methods was called.
 */
@SuppressWarnings("serial")
class TestRandom extends Random {
   private boolean used = false;

   @Override
   protected int next(int bits) {
      used = true;
      return super.next(bits);
   }

   /**
    * @return True if this random was used. Also clears the used status.
    */
   public boolean wasUsed() {
      boolean value = used;
      used = false;
      return value;
   }   
}