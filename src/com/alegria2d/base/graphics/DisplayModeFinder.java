package com.alegria2d.base.graphics;

import java.util.Set;

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
