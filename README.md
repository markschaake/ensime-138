# ensime-138
Example project that illustrates https://github.com/ensime/ensime-sbt/issues/138

How to test:

1. verify `sbt-plugins` project does not compile due to bad scala version:
  ```
  sbt compile
  [info] Updating {file:/Users/markschaake/projects/ensime-138/}plugins...
  [info] Resolving org.scala-lang#scalap;2.11.7 ...
  [info] Done updating.
  [info] Compiling 1 Scala source to /Users/markschaake/projects/ensime-138/sbt-plugins/target/scala-2.11/sbt-0.13/classes...
  [error] /Users/markschaake/projects/ensime-138/sbt-plugins/src/main/scala/FooPlugin.scala:8: can't expand macros compiled by previous versions of Scala
  [error]     libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1200-jdbc41"
  [error]                         ^
  [error] one error found
  [error] (plugins/compile:compileIncremental) Compilation failed
  [error] Total time: 5 s, completed Jan 4, 2016 7:48:25 AM
  ```

2. [uncomment scalaVersion setting in build.sbt](https://github.com/markschaake/ensime-138/blob/master/build.sbt#L11-L12) and verify gen-ensime fails:
  ```
  sbt gen-ensime
  [info] ENSIME update. Please vote for https://github.com/sbt/sbt/issues/2266
  [info] ENSIME updateClassifiers. Please vote for https://github.com/sbt/sbt/issues/1930
  [info] Resolving org.scala-lang#scalap;2.10.5 ...
  [warn] 	[FAILED     ] org.scala-sbt#precompiled-2_8_2;0.13.9!precompiled-2_8_2.jar:  (0ms)
  [warn] ==== typesafe-ivy-releases: tried
  [warn]   https://repo.typesafe.com/typesafe/ivy-releases/org.scala-sbt/precompiled-2_8_2/0.13.9/jars/precompiled-2_8_2.jar
  [warn] ==== sbt-plugin-releases: tried
  [warn]   https://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/org.scala-sbt/precompiled-2_8_2/0.13.9/jars/precompiled-2_8_2.jar
  [warn] ==== local: tried
  [warn]   /Users/markschaake/.ivy2/local/org.scala-sbt/precompiled-2_8_2/0.13.9/jars/precompiled-2_8_2.jar
  [warn] ==== jcenter: tried
  [warn]   https://jcenter.bintray.com/org/scala-sbt/precompiled-2_8_2/0.13.9/precompiled-2_8_2-0.13.9.jar
  [warn] ==== public: tried
  [warn]   https://repo1.maven.org/maven2/org/scala-sbt/precompiled-2_8_2/0.13.9/precompiled-2_8_2-0.13.9.jar
  [warn] 	[FAILED     ] org.scala-sbt#precompiled-2_9_2;0.13.9!precompiled-2_9_2.jar:  (0ms)
  [warn] ==== typesafe-ivy-releases: tried
  [warn]   https://repo.typesafe.com/typesafe/ivy-releases/org.scala-sbt/precompiled-2_9_2/0.13.9/jars/precompiled-2_9_2.jar
  [warn] ==== sbt-plugin-releases: tried
  [warn]   https://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/org.scala-sbt/precompiled-2_9_2/0.13.9/jars/precompiled-2_9_2.jar
  [warn] ==== local: tried
  [warn]   /Users/markschaake/.ivy2/local/org.scala-sbt/precompiled-2_9_2/0.13.9/jars/precompiled-2_9_2.jar
  [warn] ==== jcenter: tried
  [warn]   https://jcenter.bintray.com/org/scala-sbt/precompiled-2_9_2/0.13.9/precompiled-2_9_2-0.13.9.jar
  [warn] ==== public: tried
  [warn]   https://repo1.maven.org/maven2/org/scala-sbt/precompiled-2_9_2/0.13.9/precompiled-2_9_2-0.13.9.jar
  [warn] 	[FAILED     ] org.scala-sbt#precompiled-2_9_3;0.13.9!precompiled-2_9_3.jar:  (0ms)
  [warn] ==== typesafe-ivy-releases: tried
  [warn]   https://repo.typesafe.com/typesafe/ivy-releases/org.scala-sbt/precompiled-2_9_3/0.13.9/jars/precompiled-2_9_3.jar
  [warn] ==== sbt-plugin-releases: tried
  [warn]   https://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/org.scala-sbt/precompiled-2_9_3/0.13.9/jars/precompiled-2_9_3.jar
  [warn] ==== local: tried
  [warn]   /Users/markschaake/.ivy2/local/org.scala-sbt/precompiled-2_9_3/0.13.9/jars/precompiled-2_9_3.jar
  [warn] ==== jcenter: tried
  [warn]   https://jcenter.bintray.com/org/scala-sbt/precompiled-2_9_3/0.13.9/precompiled-2_9_3-0.13.9.jar
  [warn] ==== public: tried
  [warn]   https://repo1.maven.org/maven2/org/scala-sbt/precompiled-2_9_3/0.13.9/precompiled-2_9_3-0.13.9.jar
  [warn] 	::::::::::::::::::::::::::::::::::::::::::::::
  [warn] 	::              FAILED DOWNLOADS            ::
  [warn] 	:: ^ see resolution messages for details  ^ ::
  [warn] 	::::::::::::::::::::::::::::::::::::::::::::::
  [warn] 	:: org.scala-sbt#precompiled-2_8_2;0.13.9!precompiled-2_8_2.jar
  [warn] 	:: org.scala-sbt#precompiled-2_9_2;0.13.9!precompiled-2_9_2.jar
  [warn] 	:: org.scala-sbt#precompiled-2_9_3;0.13.9!precompiled-2_9_3.jar
  [warn] 	::::::::::::::::::::::::::::::::::::::::::::::
  [info] Resolving org.scala-lang#scalap;2.11.7 ...
  [info] ENSIME processing ensime-138 (ensime-138)
  [info] ENSIME processing plugins (plugins)
  [error] You have a different version of scala for your build (2.11.7) and plugins (2.10.5).
  [error] It is highly likely that this is a mistake with your configuration.
  [error] Please read https://github.com/ensime/ensime-sbt/issues/138
  [info] ENSIME processing library (library)
  [warn] Some source directories do not exist and will be ignored by ENSIME.
  [warn] For example: /Users/markschaake/projects/ensime-138/src/main/scala,/Users/markschaake/projects/ensime-138/src/test/scala,/Users/markschaake/projects/ensime-138/sbt-plugins/src/test/scala,/Users/markschaake/projects/ensime-138/library/src/test/scala
  ```
