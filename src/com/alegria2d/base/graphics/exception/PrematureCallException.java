package com.alegria2d.base.graphics.exception;

import com.alegria2d.exception.AlegriaRuntimeException;

/**
 * Indicate that some method was not allowed to be called yet.
 * @author Vinicius G. Mendonca
 */
public class PrematureCallException extends AlegriaRuntimeException {
   public PrematureCallException() {
      this("This method must be called after init()");
   }
   
   public PrematureCallException(String message) {
      super(message);
   }
}
