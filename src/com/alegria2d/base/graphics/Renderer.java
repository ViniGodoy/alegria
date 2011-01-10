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
