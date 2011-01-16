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
 * Draws images on the screen
 * 
 * @author Vinicius G. Mendonca
 */
public interface Renderer {
   /**
    * @return a <b>new</b> image loader for this renderer.
    */
   ImageLoader newImageLoader();
   
   /**
    * Clears the window background with the specific color.
    * <p>
    * This command must be called only after the screen is initiated with {@link #init()}.
    * 
    * @param r The red component, from 0 to 1.
    * @param g The green component, from 0 to 1.
    * @param b The blue component, from 0 to 1.
    * @param a The alpha component, from 0 to 1.
    */
   void clearScreen(float r, float g, float b, float a);
   
   /**
    * Draws an image on screen. A more advanced version of this method should be provided, after the math classes are
    * ready.
    * 
    * @param image The image to draw.
    * @param x The center x position
    * @param y The center y position
    * @param w Image width.
    * @param h Image height.
    * @param angle Angle, in degrees
    * @param r Red component
    * @param g Green component
    * @param b Blue component.
    */
   void drawImage(Image image,
         float x, float y, float w, float h,
         float angle, float r, float g, float b);
}
