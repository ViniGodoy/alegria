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

import com.alegria2d.core.driver.graphics.DisplayMode;

/**
 * Encapsulates an LWJGL display mode and provides the Alegria LWJGL DisplayMode interface.
 * 
 * @author Vinicius G. Mendonca
 */
public class OglDisplayMode implements DisplayMode, Comparable<OglDisplayMode> {
   private org.lwjgl.opengl.DisplayMode displayMode;

   public OglDisplayMode(org.lwjgl.opengl.DisplayMode displayMode) {
      this.displayMode = displayMode;
   }

   @Override
   public int getDepth() {
      return displayMode.getBitsPerPixel();
   }

   @Override
   public int getHeight() {
      return displayMode.getHeight();
   }

   @Override
   public int getWidth() {
      return displayMode.getWidth();
   }

   @Override
   public int getRefreshRate() {
      return displayMode.getFrequency();
   }
   
   public org.lwjgl.opengl.DisplayMode getDisplayMode() {
      return displayMode;
   }

   @Override
   public int compareTo(OglDisplayMode o) {
      if (getWidth() != o.getWidth())
         return o.getWidth() - getWidth();
      if (getHeight() != o.getHeight())
         return o.getHeight() - getHeight();
      if (getDepth() != o.getDepth())
         return o.getDepth() - getDepth();
      return o.getRefreshRate() - getRefreshRate();
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null)
         return false;
      if (obj == this)
         return true;
      if (obj.getClass() != getClass())
         return false;
      OglDisplayMode mode = (OglDisplayMode) obj;
      
      return getWidth() == mode.getWidth() &&
            getHeight() == mode.getHeight() &&
            getDepth() == mode.getDepth() &&
            getRefreshRate() == mode.getRefreshRate();
   }
   
   @Override
   public int hashCode() {
      int result = 17;
      result = 27 * result + getWidth();
      result = 27 * result + getHeight();
      result = 27 * result + getDepth();
      result = 27 * result + getRefreshRate();
      return result;
   }

   @Override
   public String toString() {
      return String.format("%dx%dx%d@%dHz", getWidth(), getHeight(), getDepth(), getRefreshRate());
   }
}
