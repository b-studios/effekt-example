# Effekt Example Projects
This repo contains (almost) empty example projects to use Effekt in scala (in subproject `scala-effekt`) and dotty (in subproject `scala-dotty`).

One can observe the current differences in the interface, which already is visible in the `helloWorld.scala` file. 

```
git diff --no-index --color-words scala-effekt/src/main/scala/helloWorld.scala dotty-effekt/src/main/scala/helloWorld.scala
```

To run the examples in sbt, change to the corresponding project. That is, to run Effekt with Scala

```text
> sbt
[info] Loading global plugins from /Users/jonathan/.sbt/0.13/plugins
[info] Loading project definition from ...
[info] Set current project to demo (in build file:/...)
> project scala
[info] Set current project to scala-effekt (in build file:/...)
> console
[info] Compiling 1 Scala source to ...
[info] Starting scala interpreter...
[info]
Welcome to Scala 2.12.4 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_25).
Type in expressions for evaluation. Or try :help.

scala>
```

To run Effekt with Dotty, just use `project dotty` instead.
