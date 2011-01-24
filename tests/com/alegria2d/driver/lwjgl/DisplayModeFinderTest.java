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
package com.alegria2d.driver.lwjgl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import org.junit.Before;
import org.junit.Test;
import com.alegria2d.core.driver.graphics.DisplayMode;
import com.alegria2d.core.driver.graphics.DisplayModeFinder;
import com.alegria2d.driver.lwjgl.graphics.OglDisplayModeFinder;

/**
 * Tests the methods of {@link OglDisplayModeFinder} class.
 * 
 * @author Marco Biscaro
 */
public class DisplayModeFinderTest {

   private DisplayModeFinder finder;

   @Before
   public void init() {
      finder = new OglDriverFactory().newDisplayModeFinder();
   }

   @Test
   public void isCreated() {
      assertNotNull(finder);
      assertEquals(OglDisplayModeFinder.class, finder.getClass());
   }

   @Test
   public void currentDisplayMode() {
      // compares the LWJGL's DisplayMode with AWT's one
      DisplayMode dm = finder.getDesktopDisplayMode();
      GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
      java.awt.DisplayMode dm2 = device.getDisplayMode();
      assertEquals(dm2.getWidth(), dm.getWidth());
      assertEquals(dm2.getHeight(), dm.getHeight());
      // only consider the bit depth and refresh rate if it is known
      if (dm2.getBitDepth() != java.awt.DisplayMode.BIT_DEPTH_MULTI) {
         assertEquals(dm2.getBitDepth(), dm.getDepth());
      }
      if (dm2.getRefreshRate() != java.awt.DisplayMode.REFRESH_RATE_UNKNOWN) {
         assertEquals(dm2.getRefreshRate(), dm.getRefreshRate());
      }
   }

   @Test
   public void thereIsDisplayModes() {
      assertFalse(finder.getAvailableDisplayModes().isEmpty());
   }

}
