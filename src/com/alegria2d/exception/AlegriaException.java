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

import java.util.Calendar;

/**
 * Basic alegria exception class. All Alegria exceptions include a timestamp. You may read it by using the
 * {@link #getTimeStamp()} and {@link #getWhen()} methods. All Alegria exceptions include a timestamp. You may read it
 * by using the {@link #getTimeStamp()} and {@link #getWhen()} methods. *
 * 
 * @author Vinicius G. Mendonca
 */
public class AlegriaException extends Exception {
   private static final long serialVersionUID = 4361345062188348873L;

   private long timestamp;

   public AlegriaException() {
      super();
      this.timestamp = System.currentTimeMillis();
   }

   public AlegriaException(String message, Throwable cause) {
      super(message, cause);
      this.timestamp = System.currentTimeMillis();
   }

   public AlegriaException(String message) {
      super(message);
      this.timestamp = System.currentTimeMillis();
   }

   public AlegriaException(Throwable cause) {
      super(cause);
      this.timestamp = System.currentTimeMillis();
   }

   public long getTimeStamp() {
      return timestamp;
   }

   public Calendar getWhen() {
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(timestamp);
      return cal;
   }

}
