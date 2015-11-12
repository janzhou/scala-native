# Scala Native Api for Linux

## How to use?

### Add resolvers

You can add github resolver by add this line to ``build.sbt``:

    resolvers += "janzhou-github-mvn-repo" at "https://raw.githubusercontent.com/janzhou/mvn-repo/master"

Or add bitbucket resolver by add:

    resolvers += "janzhou-bitbucket-mvn-repo" at "https://bitbucket.org/janzhou/mvn-repo/raw/master"

### Add library

Add the library by using the following line:

    libraryDependencies += "org.janzhou" %% "native" % "version"

**Replace the version number with [a proper tag name in the repository](https://janzhou.org/cgit/scala-native/refs/)** 

## Dependency

- [NVM Library](http://pmem.io/nvml/)

## Contribute

- [Github](https://github.com/janzhou/scala-native)
- [Bitbucket](https://bitbucket.org/janzhou/scala-native)
- [Issue tracker](https://janzhou.org/bugzilla/buglist.cgi?component=Scala%20Native&product=Scala%20Native&resolution=---)
