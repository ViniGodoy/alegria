/* 
 * Copyright (C) 2011 Alegria contributors
 * 
 * See CREDITS for information about contributors.
 * 
 * http://alegria2d.com
 * 
 * This file is part of Alegria 2D Java Game Framework.
 * 
 * Alegria is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alegria is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alegria.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.alegria2d.driver.lwjgl.graphics;

import java.util.Set;
import java.util.TreeSet;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import com.alegria2d.core.driver.graphics.DisplayMode;
import com.alegria2d.core.driver.graphics.DisplayModeFinder;
import com.alegria2d.core.exception.AlegriaRuntimeException;

public class OglDisplayModeFinder implements DisplayModeFinder {
   @Override
   public DisplayMode getDesktopDisplayMode() {
      return new OglDisplayMode(Display.getDesktopDisplayMode());
   }

   @Override
   public Set<DisplayMode> getAvailableDisplayModes() {
      
      Set<DisplayMode> displayModes = new TreeSet<DisplayMode>();
      try
      {
         for (org.lwjgl.opengl.DisplayMode dm : Display.getAvailableDisplayModes()) {
            displayModes.add(new OglDisplayMode(dm));
         }
      } catch (LWJGLException e) {
         throw new AlegriaRuntimeException(e);
      }
      
      return displayModes;
   }
}
