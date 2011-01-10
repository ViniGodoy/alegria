package com.alegria2d.driver.lwjgl.graphics;

import java.util.Set;
import java.util.TreeSet;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import com.alegria2d.base.graphics.DisplayMode;
import com.alegria2d.base.graphics.DisplayModeFinder;
import com.alegria2d.exception.AlegriaRuntimeException;

public class OglDisplayModeFinder implements DisplayModeFinder {
   @Override
   public DisplayMode getDesktopDisplayMode() {
      return new OglDisplayMode(Display.getDesktopDisplayMode());
   }

   @Override
   public Set<DisplayMode> getAvailableDisplayModes() {
      
      Set<DisplayMode> displayModes = new TreeSet<DisplayMode>();
      try
      {
         for (org.lwjgl.opengl.DisplayMode dm : Display.getAvailableDisplayModes()) {
            displayModes.add(new OglDisplayMode(dm));
         }
      } catch (LWJGLException e) {
         throw new AlegriaRuntimeException(e);
      }
      
      return displayModes;
   }
}
