# Cloud Run project template

This repo contains a Google Cloud Run project template. It comes with the following design decisions:
- It uses [Spring Boot](/HELP.md) as the web framework.
- It uses Gradle to manage the build.
- It's 100% Kotlin (with Java 8 compatibility).

## Features

Besides the basic functionality provided by Spring Boot, the following features are included:
- A `Makefile` to automate deploying and running locally using Docker (see below for details).
- A sample `RootController` that will print out values for key environment variables.
- Configured to use [GCP Spring extensions](https://github.com/spring-cloud/spring-cloud-gcp) (`spring-cloud-gcp-starter`). 

## Running it locally

During development, you probably want to use IntelliJ IDEA. Simply open the project, the IDE will recognize it's a Spring project and will add the right run configuration.

### Docker

## Deploying
