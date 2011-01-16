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
package com.alegria2d.base.graphics;


/**
 * Represents a bitmap image that can be draw on screen
 * 
 * @author Vinicius G. Mendonca
 */
public interface Image {

   /**
    * @return The image width, in pixels
    */
   int getWidth();
   
   /**
    * @return The image height in pixels
    */
   int getHeight();
   
   /**
    * @return True if the image supports an alpha channel 
    */
   boolean hasAlpha();
}