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

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import com.alegria2d.base.graphics.exception.UnableToChangeDisplayModeException;
import com.alegria2d.base.graphics.exception.UnableToOpenWindowException;

/**
 * Represents the screen that is used to render the game. Only one screen can be created.
 * 
 * @author Vinicius G. Mendonca
 */
public interface Screen {
   /**
    * Sets one or more icons for the Display.
    * <ul>
    * <li>On Windows you should supply at least one 16x16 icon and one 32x32.
    * <li>Linux (and similar platforms) expect one 32x32 icon.
    * <li>Mac OS X should be supplied one 128x128 icon.
    * </ul>
    * 
    * @param format The format of icon images on disk. Any of Alegria supported images, and that excludes .ico.
    * @param icons One or more InputStreams containing all the icon data.
    * @throws IOException If the icon data cannot be loaded.
    */
   void setIcon(String format, InputStream... icons) throws IOException;

   /**
    * @param title Changes the window title
    */
   void setTitle(String title);

   /**
    * @return The window title.
    */
   String getTitle();

   /**
    * @return Indicate if it's a full screen application or windowed one.
    */
   boolean isFullscreen();

   /**
    * Sets the window location. If no location is provided, or x and y are equal to -1, the window will be centered.
    * 
    * @param x The x position.
    * @param y The y position.
    */
   void setLocation(int x, int y);

   /**
    * Attempts to create or change the screen with the display mode to the given one. If init() is not yet called, the
    * configurations will be applied as soon as it gets called.
    * <p>
    * After changing the window size, the screen viewport and coordinate system can be in an undefined behavior. So, it is important to call again
    * {@link #setViewport(int, int, int, int)} and {@link #setCoordinates(float, float, float, float)} in order to adjust their values.
    * 
    * @param fullscreen If the window should be displayed in full screen mode. If the display mode or the device is not
    *           capable of showing a full screen window, it will try to initiate a common window.
    * @param dm The display mode.
    */
   void setSize(boolean fullscreen, DisplayMode dm) throws UnableToChangeDisplayModeException;

   /**
    * @return current screen display mode.
    */
   DisplayMode getDisplayMode();

   /**
    * Sets the viewport position and size, in pixels. If no viewport is set, it will use the entire window size. If the
    * window is resized, the new viewport position is undefined.
    * <p>
    * This command must be called only after the screen is initiated with {@link #init()}.
    * 
    * @param x X coordinate of the viewport.
    * @param y Y coordinate of the viewport.
    * @param w Width
    * @param h Height.
    */
   void setViewport(int x, int y, int w, int h);
   
   /**
    * @return The viewport area.
    */
   Rectangle2D getViewport();

   /**
    * Sets the basic coordinate system.
    * <p>
    * The default coordinate system is given by (0-800),(0-600). Notice that y=600 refers to the top of the screen.
    * <p>
    * This command must be called only after the screen is initiated with {@link #init()}.
    * 
    * @param minX Minimum x coordinate (left).
    * @param maxX Maximum x coordinate (right).
    * @param minY Minimum y coordinate (bottom).
    * @param maxY Maximum y coordinate (top).
    */
   void setCoordinates(float minX, float maxX, float minY, float maxY);
   
   /**
    * @return The coordinate system dimensions.
    */
   Rectangle2D getCoordinates();

   /**
    * Enable or disable vertical monitor synchronization. This call is a best-attempt at changing the vertical refresh
    * synchronization of the monitor, and is not guaranteed to be successful.
    * 
    * @param enable True to enable VSync, false to disable.
    */
   void setVSync(boolean enable);

   /**
    * Starts the game window. If not full screen, an window will be opened. Calling init() multiple times has no effect.
    * 
    * @throws UnableToOpenWindowException If the window could not be opened.
    */
   void init() throws UnableToOpenWindowException;
   
   /**
    * Ends the screen execution.
    */
   void dispose();

   /**
    * Indicate if the window is initiated.
    * 
    * @return True if it is.
    */
   boolean isInit();

   /**
    * @return True if the window is visible.
    */
   boolean isVisible();

   /**
    * @return True if the window is active.
    */
   boolean isActive();

   /**
    * @return True if the user is trying to close the window.
    */
   boolean isTryingToClose();

   /**
    * Update this screen buffers. Can only be called after init().
    * <p>
    * This command must be called only after the screen is initiated with {@link #init()}.
    */
   void update();

   /**
    * Returns the screen renderer. Can only be called after init().
    * <p>
    * This command must be called only after the screen is initiated with {@link #init()}.
    * 
    * @return The screen renderer.
    */
   Renderer getRenderer();
}
