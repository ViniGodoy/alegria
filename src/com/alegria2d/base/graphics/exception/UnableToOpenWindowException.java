package com.alegria2d.base.graphics.exception;

import com.alegria2d.exception.AlegriaException;

public class UnableToOpenWindowException extends AlegriaException {
   public UnableToOpenWindowException(Throwable cause)
   {
      super("Unable to open window.", cause);
   }
}
