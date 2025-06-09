# Contributing

## Building and Running

See the [README.md] and [docs/setup.md] for more details on how to build locally.

## Formatting code

Download [version 1.27.0 of the native graal executable of google-java-format](https://github.com/google/google-java-format/releases/tag/v1.27.0) for your platform, and once downloaded, run

```bash
chmod +x google-java-format_linux-x86-64 # just once, use the name of your platform
./google-java-format_linux-x86-64 -i `find proxyserver/src/main/java/edu/suffolk -name *.java ! -name CodeTableConstants.java ! -name FilingCode.java`
```

To format all of your files.

## Linting the code

We use [Spotbugs](https://spotbugs.readthedocs.io/en/latest/introduction.html#) as a java linter. To find linter errors, run this:

```bash
mvn spotbugs:spotbugs
mvn spotbugs:gui
```

The later command will open a GUI to see all of the bugs that it's found.
