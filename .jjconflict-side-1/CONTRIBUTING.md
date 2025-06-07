# Contributing

## Building and Running

See the [README.md] and [docs/setup.md] for more details here.

## Formatting code

Download [version 1.27.0 of the native graal executable of google-java-format](https://github.com/google/google-java-format/releases/tag/v1.27.0) for your platform, and once downloaded, run

```bash
chmod +x google-java-format_linux-x86-64 # just once, use the name of your platform
./google-java-format_linux-x86-64 -i `find src/main/java/edu/suffolk -name *.java ! -name CodeTableConstants.java ! -name FilingCode.java`
```

To format all of your files.

(Note: this command might change slightly! If anything unexpected happens, see if the command in the [GitHub Action workflow](.github/workflows/formatting.yml) has changed first.)

## Transforming `.wsdl` mock files

We need to modify newly downloaded `.wsdl` files to allow them to be tested with a mock server and to make them more readable. We hope to eventually automate this.

**Copy**

Duplicate the updated "illinois" `.wsdl` files in `/src/main/resources/wsdl/test`. Replace "illinois" with "mock" and delete any additional text that the duplication may have added (like "copy" or "(1)").

**Format**

<!-- Discuss: what do we want the indentation to be for attributes? 1 indent or extra indentation? -->

This assumes you're using a dedicated code editor, like VSCode or SublimeText.

* Copy and paste the current code into https://toolboxfy.com/tool/wsdl-beautifier.
* Replace the text of the current file with the result of the beautifier.
* Put attributes on new lines:
   * "Find all" with a regular expression: `[^=\s]+:?[^=\s]+="`.
   * Select the space before all found items and replace with a new line.
   * Some editors may indent correctly. For SublimeText use cmd/ctrl+shift+p, type in "reindent", and choose to "Reindent lines".

Now the changes you need to make will be easier to see.

**Modify values**

* If you're copying the `illinois` files, replace `https://illinois-test.tylertech.cloud` with http://host.docker.internal:8080 (find regex that patterns "illinois-text")
* Remove all `Policy` elements

## Linting the code

We use [Spotbugs](https://spotbugs.readthedocs.io/en/latest/introduction.html#) as a java linter. To find linter errors, run this:

```bash
mvn spotbugs:spotbugs
mvn spotbugs:gui
```

The later command will open a GUI to see all of the bugs that it's found.
