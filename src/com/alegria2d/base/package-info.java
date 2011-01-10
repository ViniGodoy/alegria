/**
 * Provides basic encapsulation of the Graphics, Sound and Input systems. This package is mostly formed by interfaces,
 * that can be implemented by anyone willing to provide an Alegria driver for these subsystems.
 * <p>
 * Since this lower level package is designed to be extensible, it only contains the strictly necessary classes and
 * methods in order to encapsulate the above mentioned subsystems. No helper or user-friendly structures should will be
 * added. Users interested in developing games must consider using higher level classes, instead of using classes from
 * this package directly.
 * <p>
 * We call a "driver" any implementation of these interfaces that use a specific vendor-dependent API, such as java2d or
 * lwjgl.
 */
package com.alegria2d.base;

