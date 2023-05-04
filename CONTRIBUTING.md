# Contributing

## Building and Running

See the [README.md] and [docs/setup.md] for more details here.

## Formatting code

[Download the google-java-format](https://github.com/google/google-java-format/releases/latest) tool, and once installed, run

```bash
java -jar google-java-format-{version-number}-all-deps.jar -i `find src/main/java/edu/suffolk -name *.java ! -name CodeTableConstants.java ! -name FilingCode.java`
```

To format all of your files.

(Note: this command might change slightly! If anything unexpected happens, see if the command in the [GitHub Action workflow](.github/workflows/formatting.yml) has changed first.)

