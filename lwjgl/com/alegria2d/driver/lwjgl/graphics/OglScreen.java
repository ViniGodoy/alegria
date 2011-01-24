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

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.util.glu.GLU.gluOrtho2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.ImageDataFactory;
import org.newdawn.slick.opengl.LoadableImageData;
import com.alegria2d.core.driver.graphics.DisplayMode;
import com.alegria2d.core.driver.graphics.Renderer;
import com.alegria2d.core.driver.graphics.Screen;
import com.alegria2d.core.driver.graphics.exception.UnableToChangeDisplayModeException;
import com.alegria2d.core.driver.graphics.exception.UnableToOpenWindowException;
import com.alegria2d.core.exception.PrematureCallException;

public class OglScreen implements Screen {
   private Renderer renderer = null;
   private Rectangle2D viewport = null;
   private Rectangle2D coordinates = null;

   @Override
   public void setIcon(String format, InputStream... icons) throws IOException {
      format = format.toLowerCase();
      if (!format.startsWith("."))
         format = "." + format;

      LoadableImageData data = ImageDataFactory.getImageDataFor(format);
      ByteBuffer[] buffers = new ByteBuffer[icons.length];
      for (int i = 0; i < icons.length; i++) {
         buffers[i] = data.loadImage(icons[i], false, true, null);
      }
      Display.setIcon(buffers);

      // Attempt to close all InputStreams
      for (InputStream is : icons)
         is.close();
   }

   @Override
   public void setTitle(String title) {
      Display.setTitle(title);
   }

   @Override
   public String getTitle() {
      return Display.getTitle();
   }

   @Override
   public boolean isFullscreen() {
      return Display.isFullscreen();
   }

   @Override
   public void setSize(boolean fullscreen, DisplayMode dm) throws UnableToChangeDisplayModeException {
      OglDisplayMode ogldm = (OglDisplayMode) dm;

      try {
         if (fullscreen)
            Display.setDisplayModeAndFullscreen(ogldm.getDisplayMode());
         else
            Display.setDisplayMode(ogldm.getDisplayMode());         
      } catch (LWJGLException e) {
         throw new UnableToChangeDisplayModeException(dm, e);
      }
   }

   @Override
   public void setLocation(int x, int y) {
      Display.setLocation(x, y);
   }

   @Override
   public DisplayMode getDisplayMode() {
      return new OglDisplayMode(Display.getDisplayMode());
   }

   @Override
   public Rectangle2D getViewport() {
      if (!isInit())
         throw new PrematureCallException();
      
      return viewport;
   }
   
   @Override
   public void setViewport(int x, int y, int w, int h) {
      if (!isInit())
         throw new PrematureCallException();

      viewport = new Rectangle2D.Float(x, y, w, h);
      glViewport(x, y, w, h);
   }

   @Override
   public void setCoordinates(float minX, float maxX, float minY, float maxY) {
      if (!isInit())
         throw new PrematureCallException();
      
      coordinates = new Rectangle2D.Float(minX, minY, maxX-minX, maxY-minY);
      glMatrixMode(GL_PROJECTION);
      glLoadIdentity();
      gluOrtho2D(minX, maxX, minY, maxY);
      // Volta para a matriz de modelView e a reseta
      glMatrixMode(GL_MODELVIEW);
   }
   
   @Override
   public Rectangle2D getCoordinates() {
      if (coordinates == null)
         throw new PrematureCallException();
      
      return coordinates;
   }

   @Override
   public void setVSync(boolean enable) {
      Display.setVSyncEnabled(enable);
   }

   @Override
   public void init() throws UnableToOpenWindowException {
      if (Display.isCreated())
         return;

      try {
         Display.create();
         setViewport(0, 0, getDisplayMode().getWidth(), getDisplayMode().getHeight());
         setCoordinates(0, getDisplayMode().getWidth(), 0, getDisplayMode().getHeight());
      } catch (LWJGLException e) {
         throw new UnableToOpenWindowException(e);
      }
   }

   @Override
   public void dispose() {
      if (Display.isCreated())
         return;

      Display.destroy();
      renderer = null;
      viewport = null;
   }

   @Override
   public boolean isInit() {
      return Display.isCreated();
   }

   @Override
   public boolean isVisible() {
      return Display.isVisible();
   }

   @Override
   public boolean isActive() {
      return Display.isActive();
   }

   @Override
   public boolean isTryingToClose() {
      return Display.isCloseRequested();
   }

   @Override
   public void update() {
      if (!isInit())
         throw new PrematureCallException();
      Display.update();
   }

   @Override
   public Renderer getRenderer() {
      if (!isInit())
         throw new PrematureCallException();

      if (renderer == null)
         renderer = new OglRenderer();

      return renderer;
   }
}
