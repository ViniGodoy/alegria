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
package com.alegria2d.core.exception;


/**
 * Basic alegria runtime exception class. 
 * 
 * @author Vinicius G. Mendonca
 */
public class AlegriaRuntimeException extends RuntimeException {   
   private static final long serialVersionUID = -4479684697326401294L;
   
   /**
    * Constructs a new exception with <code>null</code> as its detail message. The cause is not initialized, and may
    * subsequently be initialized by a call to {@link #initCause}.
    */
   public AlegriaRuntimeException() {
      super();
   }
   
   /**
    * Constructs a new exception with the specified detail message. The cause is not initialized, and may subsequently
    * be initialized by a call to {@link #initCause}.
    * 
    * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
    *           method.
    */
   public AlegriaRuntimeException(String message) {
      super(message);
   }
   /**
    * Constructs a new exception with the specified detail message and cause.
    * <p>
    * Note that the detail message associated with <code>cause</code> is <i>not</i> automatically incorporated in this
    * exception's detail message.
    * 
    * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
    * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt>
    *           value is permitted, and indicates that the cause is nonexistent or unknown.)
    */
   public AlegriaRuntimeException(String message, Throwable cause) {
      super(message, cause);
   }

   /**
    * Constructs a new exception with the specified cause and a detail message of
    * <tt>(cause==null ? null : cause.toString())</tt> (which typically contains the class and detail message of
    * <tt>cause</tt>). This constructor is useful for exceptions that are little more than wrappers for other throwables
    * (for example, {@link java.security.PrivilegedActionException}).
    * 
    * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt>
    *           value is permitted, and indicates that the cause is nonexistent or unknown.)
    */
   public AlegriaRuntimeException(Throwable cause) {
      super(cause);
   }
}
