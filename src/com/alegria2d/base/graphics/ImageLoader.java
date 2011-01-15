/* 
 * Copyright (C) 2011 Alegria contributors
 * 
 * See CREDITS for information about contributors.
 * 
 * http://alegria2d.com
 * 
 * This file is part of Alegria 2D Java Game Framework.
 * 
 * Alegria is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alegria is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alegria.  If not, see <http://www.gnu.org/licenses/>.
 */
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
   Image load(String format, InputStream source) throws IOException;
}