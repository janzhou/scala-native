name := "native"
version := "0.1.1-SNAPSHOT"
scalaVersion := "2.11.7"
organization := "org.janzhou"

crossScalaVersions := Seq("2.9.3", "2.10.6")

libraryDependencies += "net.java.dev.jna" % "jna" % "4.0.0"

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/mvn-repo")))
