name := "native"
version := "0.1.3"
scalaVersion := "2.11.8"
organization := "org.janzhou"

crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.0-M5")

libraryDependencies += "net.java.dev.jna" % "jna" % "4.0.0"

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/projects/mvn-repo")))
