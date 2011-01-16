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
package com.alegria2d.base.graphics.exception;

import com.alegria2d.exception.AlegriaException;

/**
 * This exception occurs when was impossible to open the Alegria main window.
 * @author Vinicius G. Mendonca
 */
public class UnableToOpenWindowException extends AlegriaException {
   private static final long serialVersionUID = -6144323433655715502L;

   public UnableToOpenWindowException(Throwable cause)
   {
      super("Unable to open window.", cause);
   }
}
