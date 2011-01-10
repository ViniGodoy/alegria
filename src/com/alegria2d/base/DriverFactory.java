package com.alegria2d.base;

import com.alegria2d.base.graphics.DisplayModeFinder;
import com.alegria2d.base.graphics.Screen;

/**
 * This class is able to construct all basic Alegria structures, and act as the basic entry-point for an Alegria Driver.
 * 
 * @author Vinicius G. Mendonca
 */
public interface DriverFactory {
   /**
    * Creates a screen
    * 
    * @return The new screen
    */
   Screen newScreen();

   /**
    * Creates a new Display Mode Finder
    * 
    * @return The new display mode finder
    */
   DisplayModeFinder newDisplayModeFinder();     
}
