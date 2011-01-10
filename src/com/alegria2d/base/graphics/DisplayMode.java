package com.alegria2d.base.graphics;

/**
 * Represents a display mode that can be applied to the screen.
 * 
 * @author Vinicius G. Mendonca
 */
public interface DisplayMode {
   /**
    * @return the color depth, in bytes per pixel (bpp).
    */
   int getDepth();
   
   /**
    * @return the display mode height, in pixels.
    */
   int getHeight();
   
   /**
    * @return the display mode width, in pixels.
    */
   int getWidth();
   
   /**
    * @return The refresh rate, in hertz. 
    */
   int getRefreshRate();
}
