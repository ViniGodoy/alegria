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
package com.alegria2d.core.driver.graphics;

import java.util.Set;

/**
 * A DisplayModeFinder locates all display modes available in the local Graphics Environment. There is no support for
 * multiple monitors yet.
 * 
 * @author Vinicius G. Mendonca
 */
public interface DisplayModeFinder {
   /**
    * @return the initial desktop display mode.
    */
   DisplayMode getDesktopDisplayMode();

   /**
    * Return a list of all fullscreen capable display modes. Although best attempts to filter out invalid modes are
    * done, any given mode is not guaranteed to be available nor is it guaranteed to be within the current monitor specs
    * (this is especially a problem with the frequency parameter). You will only know for sure if
    * {@link Screen#setSize(boolean, DisplayMode) setSize} gets called on {@link Screen} class and no exception is
    * raised.
    * 
    * Only non-palette-indexed modes are returned (ie. bpp will be 16, 24, or 32). Only DisplayModes from this call can
    * be used when the Display is in fullscreen mode.
    * 
    * @return The display mode set, with no particular order.
    */
   Set<DisplayMode> getAvailableDisplayModes();
}
