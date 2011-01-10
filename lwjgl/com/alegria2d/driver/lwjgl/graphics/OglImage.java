package com.alegria2d.driver.lwjgl.graphics;

import org.newdawn.slick.opengl.Texture;
import com.alegria2d.base.graphics.Image;

public class OglImage implements Image {
   Texture texture;

   public OglImage(Texture texture) {
      this.texture = texture;
   }

   /**
    * @return The The image width, in pixels. This may not be the original image size, since rescaling operations can be
    * done by the image loader, in order to provide a power of two sided image.
    */
   @Override
   public int getWidth() {
      return texture.getTextureWidth();
   }
   
   /**
    * @return The The image height, in pixels. This may not be the original image size, since rescaling operations can be
    * done by the image loader, in order to provide a power of two sided image.
    */
   @Override
   public int getHeight() {
      return texture.getTextureHeight();
   }

   /**
    * Returns the width of the image before any rescaling operation.
    */
   public int getOriginalWidth() {
      return texture.getImageWidth();
   }

   /**
    * Returns the height of the image before any rescaling operation.
    */
   public int getOriginalHeight() {
      return texture.getImageHeight();
   }

   @Override
   public boolean hasAlpha() {
      return texture.hasAlpha();
   }

   public void bind() {
      texture.bind();
   }

   @Override
   public int hashCode() {
      return texture.getTextureID();
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == this)
         return true;
      if (obj == null)
         return false;
      if (obj.getClass() != getClass())
         return false;

      return texture.getTextureID() == ((OglImage) obj).texture.getTextureID();
   }
}
