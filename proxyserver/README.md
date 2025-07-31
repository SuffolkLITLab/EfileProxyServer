# Proxy Server

The actual server package itself. Usually run inside a docker container (see [the project's main README](../README.md)).

## Running 
This server can also be run directly with java, for remote debugging or speed of development.

### Prerequisites 

* install JDK 21 and Maven
* install the [python tool `dotenv`](https://pypi.org/project/python-dotenv/).
* start a postgres database. 
    * Edit your `.env` file, particularly `POSTGRES_URL` and `POSTGRES_PORT`, to match how you will be running the db
      (`POSTGRES_URL` can be `localhost` if just running it locally / through a docker container).
    * If you still want to use docker for this, run
      `docker run -p 5432:5432 --env-file .env --volume efileproxyserver_data-volume:/var/lib/postgresql/data postgres:14`.
* `mvn package` to build the output JAR artifact.
* `cd proxyserver` (if not already there), and then `./run_server.sh`

Your server will be started with a remote debugging port of 5001. You can point any Java Debugger at that port. 
If using VS Code, add the below configuration to your `.vscode/launch.json`:

```
{
    "version": "0.2.0",
    "configurations": [
        {
        "type": "java",
        "name": "Debug (Attach)",
        "projectName": "EfileProxyServer",
        "request": "attach",
        "hostName": "localhost",
        "port": 5001
        },
        ...
    ]
}
```