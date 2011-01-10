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