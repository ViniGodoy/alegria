/*
 * Copyright (C) 2011 Alegria contributors
 * 
 * See CREDITS for information about contributors.
 * 
 * http://alegria2d.com
 * 
 * This file is part of Alegria 2D Java Game Framework.
 * 
 * Alegria is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * Alegria is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with Alegria. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package com.alegria2d.exception;

/**
 * Exception for mathematical problems.
 * 
 * @author Vinicius G. Mendonca
 */
public class MathException extends AlegriaRuntimeException {
   private static final long serialVersionUID = -7549196113034094158L;

   /**
    * Create a new MathException
    */
   public MathException() {
      super();
   }

   /**
    * Create a new MathException with the given message.
    * 
    * @param message The message.
    */
   public MathException(String message) {
      super(message);
   }

   /**
    * Create a new MathException with the given message and cause.
    * 
    * @param message The message.
    * @param cause The cause
    */
   public MathException(String message, Throwable cause) {
      super(message, cause);
   }

   /**
    * Create a new MathException with the given cause.
    * 
    * @param cause The cause
    */
   public MathException(Throwable cause) {
      super(cause);
   }
}
