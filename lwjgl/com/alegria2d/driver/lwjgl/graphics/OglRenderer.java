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

import static org.lwjgl.opengl.GL11.*;
import com.alegria2d.core.driver.graphics.Image;
import com.alegria2d.core.driver.graphics.ImageLoader;
import com.alegria2d.core.driver.graphics.Renderer;

public class OglRenderer implements Renderer {
   @Override
   public void clearScreen(float r, float g, float b, float a) {
      glClearColor(r, g, b, a);
      glClear(GL_COLOR_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
   }

   @Override
   public void drawImage(Image image, 
         float x, float y, float w, float h,
         float angle, float r, float g, float b) 
   {
      float w2 = w / 2.0f;
      float h2 = h / 2.0f;
      
      OglImage img = (OglImage)image;
      glEnable(GL_TEXTURE_2D);
      
            
      if (image.hasAlpha()) {
         glEnable(GL_BLEND);
         glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
      } else {
         glDisable(GL_BLEND);
      }
                 
      glPushMatrix();      
         glTranslatef(x, y, 0);
         glRotatef(angle, 0, 0, 1);
         
         img.bind();         
         glBegin(GL_QUADS);
            glColor3f(r, g, b);
            glTexCoord2f(1, 0);
            glVertex2f(w2, h2);
            
            glTexCoord2f(1,1);
            glVertex2f(w2, -h2 );
            
            glTexCoord2f(0,1);
            glVertex2f(-w2 , -h2 );
            
            glTexCoord2f(0,0);
            glVertex2f(-w2 , h2);
         glEnd();
      glPopMatrix();      
   }

   @Override
   public ImageLoader newImageLoader() {
      return new OglImageLoader();
   }
}
