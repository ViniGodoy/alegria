package com.alegria2d.driver.lwjgl.graphics;

import static org.lwjgl.opengl.GL11.*;
import com.alegria2d.base.graphics.Image;
import com.alegria2d.base.graphics.ImageLoader;
import com.alegria2d.base.graphics.Renderer;

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
