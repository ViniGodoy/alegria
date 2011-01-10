package com.alegria2d.exception;

import java.util.Calendar;

/**
 * AlegriaRuntimeException is the superclass of those exceptions that can be thrown during the normal operation of 
 * Alegria. 
 * 
 * @author Vinicius G. Mendonca
 */
public class AlegriaRuntimeException extends RuntimeException {
   private long timestamp;

   public AlegriaRuntimeException() {
      super();
      this.timestamp = System.currentTimeMillis();
   }

   public AlegriaRuntimeException(String message, Throwable cause) {
      super(message, cause);
      this.timestamp = System.currentTimeMillis();
   }

   public AlegriaRuntimeException(String message) {
      super(message);
      this.timestamp = System.currentTimeMillis();
   }

   public AlegriaRuntimeException(Throwable cause) {
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
