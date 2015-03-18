# Necessary software #
  * [Eclipse Helios for Java Developers](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/heliossr1);
  * [Mercurial Eclipse plugin](http://javaforge.com/project/HGE)

# Setting up the environment #

  * Go to [Source->Checkout](http://code.google.com/p/alegria/source/checkout) and hit the Create a clone button;
  * Give your clone a name. Write this name down, it will be used later.
  * Enter in eclipse;
  * Go to File->New java project
  * Go to Team->Share Project and choose Mercurial
  * Click in next and finish
  * Now, to go to your project root and click in Team->Pull
  * Write down your repository url name. If you named your repository "alegriaclone" and your google account name is "johndoe" it should be:
> > https://johndoe-alegriaclone.googlecode.com/hg/
  * Write your name and password. Remember, your google code password is not the same of your gmail password. You may see it in your [profile settings](https://code.google.com/hosting/settings).
  * Wait until mercurial download all alegria files to your computer

## Setting up project dependencies ##
First of all, download Alegria dependencies at LWJGL website:
  * [LWJGL 2.6](http://sourceforge.net/projects/java-game-lib/files/Official%20Releases/LWJGL%202.6/)
  * [Slick-Util](http://slick.cokeandcode.com/downloads/util/) library;
  * Read [Setting Up LWJGL with Eclipse Tutorial](http://www.lwjgl.org/wiki/index.php?title=Setting_Up_LWJGL_with_Eclipse) and create a user lib for it;
  * Also, create user library with Slick-Util;

# Writing code #
  * Read our [Code Conventions](CodeConventions.md) wiki page. Codes that does not follow these conventions will NOT be accepted;
  * Right click on your project, go to java code style, code templates, click on Enable Project Specific Settings;
  * Import the codetemplates.xml from the eclipse folder;
  * Then, go to java code formatter and enable project specific settings;
  * Import the formatter.xml from the eclipse folder;
  * Write lots of good quality professional code;
  * Use the Team->Commit option to confirm your changes. Write down a meaninful commentary;
  * Use the Team->Push option to send all modifications to your repository clone;
  * Notify one of Alegria commiters about your changes. The code then will be analised and merged in the main project, if accepted;