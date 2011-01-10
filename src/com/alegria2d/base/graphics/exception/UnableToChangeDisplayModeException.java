package com.alegria2d.base.graphics.exception;

import com.alegria2d.base.graphics.DisplayMode;
import com.alegria2d.exception.AlegriaException;

public class UnableToChangeDisplayModeException extends AlegriaException {
   private DisplayMode desired;
   
   public UnableToChangeDisplayModeException(DisplayMode desired, Throwable cause)
   {
      super("Unable to change display mode to " + desired.toString(), cause);
      this.desired = desired;
   }
   
   public DisplayMode getDesiredDisplayMode() {
      return desired;
   }
}
