package com.alegria2d.base.graphics;

import java.io.IOException;
import java.io.InputStream;

/**
 * Loads images from disk
 * 
 * @author Vinicius G. Mendonca
 */
public interface ImageLoader {   
   /**
    * Loads images of the specified format from disk.
    * 
    * @param format The image format name (e.g. JPG, PNG);
    * @param source Source data
    * @return The loaded image.
    * @throws IOException If a problem occurs while loading.
    */
   public Image load(String format, InputStream source) throws IOException;
}