name := "native"
version := "0.1.0"
scalaVersion := "2.11.6"
organization := "org.janzhou"

libraryDependencies += "net.java.dev.jna" % "jna" % "4.0.0"

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/mvn-repo")))
