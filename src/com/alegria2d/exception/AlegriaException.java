package com.alegria2d.exception;

import java.util.Calendar;

/**
 * @author Vinicius G. Mendonca
 */
public class AlegriaException extends Exception {
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
   
   public long getTimeStamp()
   {
      return timestamp;
   }
   
   public Calendar getWhen()
   {
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(timestamp);
      return cal;
   }
   
}
