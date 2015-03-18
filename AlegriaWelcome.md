# Introduction #

The aim of this project is to create a hardware accelerated 2D game engine.

# Details #
Alegria will support powerful features such as:
  * Dynamic lighting and blending;
  * Shaders;
  * Camera positioning and zoom;
  * Multi-layering and parallax scrolling;
  * Tile maps and isometric tiles;
  * Particles generation;
  * Scripting;
  * 5.1 sound;
  * Several game input systems;

See more in our [brainstorm](brainstorm.md) list.

Alegria is divided into three main layers:
  * Base: That will contain low-level classes that manage input, network and graphics abstracting platform specific details;
  * Game: That will contain game objects, tile maps, physics, AI and other game related stuff;
  * Editors: Which will help users to create their game and configure all Alegria components to work together;

# Dependencies #
Alegria is built on top of LWJGL 2.6 and Java 6.
This API uses Slick-Utils.jar.

## Contributing to the project ##
If your are a developer and is interested to contribute with Alegria, write us an e-mail. Also, read our [Contributing](Contributing.md) article, that explains how you can create a project clone, setup the environment and write code following our [Code Conventions](CodeConventions.md).

You can contribute with anything you feel confortable: Writing classes, reviewing code, fixing small bugs, profiling, writing test classes or even just reviewing our javadoc spelling mistakes.

# Credits #
Alegria is a Brazilian project created by:

  * Vinícius Godoy de Mendonça - project owner - http://www.pontov.com.br
  * Marcos Antonio de Vasconcelos Junior: main contributor - http://markytechs.wordpress.com/

We also specially thank:
  * Marco Biscaro: Code review and comments.