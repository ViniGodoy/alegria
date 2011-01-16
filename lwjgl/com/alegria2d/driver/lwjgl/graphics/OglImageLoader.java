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
