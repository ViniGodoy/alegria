package com.alegria2d.driver.lwjgl;

import com.alegria2d.base.DriverFactory;
import com.alegria2d.base.graphics.DisplayModeFinder;
import com.alegria2d.base.graphics.Screen;
import com.alegria2d.driver.lwjgl.graphics.OglDisplayModeFinder;
import com.alegria2d.driver.lwjgl.graphics.OglScreen;

public class OglDriverFactory implements DriverFactory {

   @Override
   public Screen newScreen() {
      return new OglScreen();
   }

   @Override
   public DisplayModeFinder newDisplayModeFinder() {
      return new OglDisplayModeFinder();
   }

}
