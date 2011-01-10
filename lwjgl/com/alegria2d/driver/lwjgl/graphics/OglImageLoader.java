package com.alegria2d.driver.lwjgl.graphics;

import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import java.io.IOException;
import java.io.InputStream;
import org.newdawn.slick.opengl.TextureLoader;
import com.alegria2d.base.graphics.Image;
import com.alegria2d.base.graphics.ImageLoader;

/**
 * @author Vinicius G. Mendonca
 */
public class OglImageLoader implements ImageLoader {
   /**
    * Default Texture filter Types.
    * 
    * @author Vinicius G. Mendonca
    */
   public enum Filter {
      FAST(GL_NEAREST), SMOOTH(GL_LINEAR);

      private int filter;

      private Filter(int filter) {
         this.filter = filter;
      }

      /**
       * Returns the OpenGL filter constant associated with this filter type.
       * 
       * @return The GL11 filter constant.
       */
      public int toOgl() {
         return filter;
      }
   };
   
   private Filter filter = Filter.SMOOTH;

   @Override
   public Image load(String format, InputStream source) throws IOException {
      return new OglImage(TextureLoader.getTexture(format, source, filter.toOgl()));
   }

   /**
    * Allows the user to chooser the texture filtering policy
    * 
    * @param filter The default texture filtering policy
    */
   public void setFilter(Filter filter) {
      this.filter = filter;
   }

   /**
    * Returns the current texture filtering policy
    * 
    * @return the current texture filtering policy
    */
   public Filter getFilter() {
      return filter;
   }
}
