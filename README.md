# Scala Native Access

## How to use?

### Add resolvers

You can add github resolver by add this line to ``build.sbt``:

```scala
resolvers += "Jian Zhou Release" at "https://raw.githubusercontent.com/janzhou/mvn-repo/release"
```

### Add library

Add the library by using the following line:

    libraryDependencies += "org.janzhou" %% "native" % "version"

**Replace the version number with [a proper tag name in the repository](https://github.com/janzhou/scala-native/releases)**

### Libc library

Libc library is The GNU C Library which defines the ``system calls'' and other basic facilities. You can use the libc interface in scala:

```scala
import org.janzhou.native._
val fd = libc.run.open("filename", libc.O_RDWR)
val mem = libc.run().malloc(8)
libc.run.ioctl(fd, COMMAND, mem)
libc.run().free(mem)
libc.run().close(fd)
```

## Dependency

- [NVM Library](http://pmem.io/nvml/) (Only if you use pmem library).

## Contribute

- [Github](https://github.com/janzhou/scala-native)
