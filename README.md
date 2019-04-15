# Cloud Run project template

This repo contains a [GCP Run](https://cloud.google.com/run/) project template. It comes with the following design decisions:
- It uses [Spring Boot](/HELP.md) as the web framework.
- It uses Gradle to manage the build.
- It's 100% Kotlin (with Java 8 compatibility).

## Features

Besides the basic functionality provided by Spring Boot, the following features are included:
- A `Makefile` to automate deploying and running locally using Docker (see below for details).
- A `Dockerfile` suited for Gradle-based projects.
- A sample `RootController` that will print out values for key environment variables.
- Configured to use [GCP Spring extensions](https://github.com/spring-cloud/spring-cloud-gcp) (`spring-cloud-gcp-starter`). 

## Running it locally

During development, you probably want to use IntelliJ IDEA. Simply open the project, the IDE will recognize it's a Spring project and will add the right run configuration.

### Docker

The `Makefile` automates the basic tasks you need from this project:
- `make build-image`: Builds the Docker image using GCP Cloud Build.
- `make run-image`: Runs the Docker image locally (for testing purposes).
- `make deploy-image`: Deploys the image. One important thing is that we increment the standard memory to 1G, otherwise, your Spring project will typically run out of memory.

## Endpoints

- `/`: Should respond `OK.` with a 200.
- `/info`: It'll print a JSON object with a number of environment variables. A sample output would look like:

```json
{
  "now": 1555286644082,
  "port": "8080",
  "javaVersion": "jdk8u202-b08",
  "krevision": "template-00003",
  "kservice": "template",
  "kconfiguration": "template"
}

```

## Contributing

If you find any issues, of thing of features that could benefit a majority of users, please [cut a ticket](https://github.com/zugaldia/cloudrun-template/issues) or open a PR. Enjoy!
