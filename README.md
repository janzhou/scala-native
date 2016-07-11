# Scala Native Api for Linux

## How to use?

### Add resolvers

You can add github resolver by add this line to ``build.sbt``:

    resolvers += "janzhou-github-mvn-repo" at "https://raw.githubusercontent.com/janzhou/mvn-repo/master"

### Add library

Add the library by using the following line:

    libraryDependencies += "org.janzhou" %% "native" % "version"

**Replace the version number with [a proper tag name in the repository](https://github.com/janzhou/scala-native/releases)** 

## Dependency

- [NVM Library](http://pmem.io/nvml/) (Only if you use pmem library).

## Contribute

- [Github](https://github.com/janzhou/scala-native)
