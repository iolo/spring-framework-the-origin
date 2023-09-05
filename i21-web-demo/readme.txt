

**** Simple MVC demo ****

OVERVIEW

This demo app should be pretty easy to set up.
There are no dependencies on databases or any other external features.

You will need Ant to build it, and the compilation process relies on
Sun's J2EE Reference Implementation (J2SDKEE), which it uses to
source J2EE binaries. If you don't have a J2SDKEE installation,
you can easily modify the Ant build script (build.xml) to
change the compile classpath.

THE DIRECTORY STRUCTURE

/lib contains all the libraries necessary for the demo app.
This includes the compiled Jar files for the Interface21 framework
discussed in the book. (The source code for this framework is available
with the main download.)

/src source for the Java classes in the WAR.

/war JSPs, other resources and deployment descriptors for the WAR

/war/WEB-INF/classes views.properties and messages.properties files,
required by the framework. views.properties defines the views referred
to by name in controllers.

/dist WAR will be build here

Other directories are produced by the build process and can be deleted
at will.


MODIFYING THE BUILD SCRIPT

You'll need to change a few absolute paths, identified early in the Ant
build script (build.xml in this directory). You'll need to tell the build
script the location of
- Your J2SDKEE home
- Your Tomcat or JBoss home directory (depending on which you want to deploy to)
- The name of your JBoss server to install to, if you're using JBoss.

The present values are for a Linux system and refer to my home directory.
If you use Windows, simply change to Windows style paths (c:\yourdir\whatever).
Ant even lets you use forward slashes after the volume identifier.

BUILDING

Type
$ ant war
to compile the sources and build the WAR. The WAR will be found in the
/dist directory.

$ ant tomcat
to build and install to Tomcat.



