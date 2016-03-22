Simple Scrollax.js module for Lift
==================================================

[![Build Status](https://secure.travis-ci.org/yukoff/lift-scrollax-module.png)](http://travis-ci.org/yukoff/lift-scrollax-module)
[![Gitter](https://badges.gitter.im/yukoff/lift-scrollax-module.svg)](https://gitter.im/yukoff/lift-scrollax-module?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Lift-Scrollax is a [Lift](http://liftweb.net) module that includes
[Scrollax.JS](http://iprodev.github.io/Scrollax.js/) - a smart, smooth, cross-browser
and easy to use parallax scrolling effect plugin for jQuery that will jazz up your
Lift application(s) with the nice parallax scrolling.

***

With this Lift module you will get a hassle-free inclusion and smooth future upgrades of
Scrollax.JS.

The idea behind this module is to make development, maintenance, upgrade and fall-back quick
and easy (typically should be a one-liner change in lift boot), by simultaneously supporting
several versions (there's currently only one at the moment) and, without code or reference
changes, to provide debugable js file in development and minimized file otherwise.

By using this module you'll also get a clean separation of the scrollax file(s) and your
application-specific resources as the module does not clutter your applications web-app
resources directory.

Contribution
------------
Improvements, contributions and suggestions are welcome!

TODO: [Contribution Document](#).

You can also leave an issue report or drop a question/suggestion to the
[Lift's mailing list](http://groups.google.com/group/liftweb/) or use
[Gitter chat](https://gitter.im/yukoff/lift-scrollax-module).

> As _lift-scrollax-module_ uses this
[Git branching model](http://nvie.com/posts/a-successful-git-branching-model/)
the **main branch (master)** is just updated for releases so your pull requests
will be against the [Development branch](https://github.com/yukoff/lift-scrollax-module/blob/develop)

Integrate into your project
---------------------------

### TODO: Dependency settings

> NOTE: The artifacts are not loaded to either repo, so at the moment you have to build
this module by yourself. Even more - it could be later hosted by
[jitpack.io](https://jitpack.io), what in turn will require addition of it's resolver,
eg. `resolvers += "jitpack" at "https://jitpack.io"`

Put the following in your project build.sbt files lift `libraryDependencies` section
```scala
    "net.liftmodules" %% "moduleName_x1.y1 % "x2.y2[.z2][-SNAPSHOT/rcx/mx]"
```
or if you are using Maven
```text.xml.pom
    <dependency>
      <groupId>net.liftmodules</groupId>
      <artifactId>moduleName_x1.y1_a.b.c</artifactId>
      <version>x2.y2[.z2][-SNAPSHOT/rcx/mx]</version>
    </dependency>
```
where x1.y1 is Lift major and minor version numbers and a.b.c is Scala
version number and x2.y2.[z2] is the module's major x2, minor y2 and
eventual incremental numbers z2 followed by a eventual SNAPSHOT
release candidate (rcX) or milestone (mX) version part.

For example:
```scala
    "net.liftmodules" %% "scrollax_2.6 % "1.0.0-SNAPSHOT"
```
or for Maven
```text.xml.pom
    <dependency>
      <groupId>net.liftmodules</groupId>
      <artifactId>scrollax_2.6_2.11.7</artifactId>
      <version>1.0.0-SNAPSHOT</version>
    </dependency>
```

This example will include a module built for lift 2.6.x. If you are using maven observe
then the artifact id also needs the Scala version.

Now do a `sbt clean update` ...

### Lift Scrollax boot hooks

Put the following into your lift Boot
```scala
    import net.liftmodules.Scrollax

    // If you are using defaults - init params can be omitted
    Scrollax.InitParam.Scrollax=Scrollax.[ScrollaxXYZ module option name]

    Scrollax.init()
```

### Lift Scrollax Template hooks

Put something like the following in head section of your Lift template(s)
(see below for available names)
```text.html.basic
    <script type="text/javascript" src="/classpath/scrollax/[script file name]"></script>
```

Available CSS and JavaScript files
----------------------------------

There are two: `scrollax.js` and `scrollax.min.js` (the last is always used in production).

Scala IDE for Eclipse
---------------------
sbteclipse provides SBT command to create Eclipse project files

1) Usage
```text
  project$ sbt eclipse
```
2) In eclipse do:

  File ==> Import ...
  Select General ==> Existing Project into Workspace
  Use "Browse" to look up the project root ...

The project also has plugin for IntelliJ IDEA.

Authors
-------
Scrollax Lift module was written by [yukoff](https://github.com/yukoff) and originally was
insired by the [FoBo](https://github.com/karma4u101/FoBo/) - a comprehensive front-end
toolkit module for Lift written by [Peter Petersson](http://www.media4u101.se).

The Lift Module conventions were developed by the
[Lift community](http://groups.google.com/group/liftweb/).

If you find some non-"best practice" stuff in here and if you find something you
think could be done in a more Scala/Lift fashion way please let me know. Improvements,
contributions and suggestions are welcome!
