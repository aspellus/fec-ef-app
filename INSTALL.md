# Installation and Local Development

## Prerequisites
The application can be run on a single laptop with the right tools installed, but it is also designed to be packaged and run in any Docker-oriented environment. We chose to deploy and run in Kubernetes, and we included the necessary YAML files to yield a fully functional platform. Because Docker is self-contained, there are no prequisites to deploy the application beyond Docker itself. The following application components are required:

* Frontend App (Angular4 app)
* Backend App (Spring Boot app)
* PostgreSQL (Database - can be run in Docker or standalone)

Because of our compressed schedule, we did not have time to make the application follow as 12-factor design as we wished. Therefore, the front-end app will need to be "wired" to the back-end app by updating the environments files in the Angular app.

## Installation and Local Deployment
The application consists of a frontend app and backend app, each of which use different technology stacks. However, both can be run side-by-side, with or without Docker.

### Front-end Deployment
The front-end application uses Angular4 and various dependencies. It can be deployed through the Angular CLI using the native ng server, which is most appropriate for local development. Node is required to install Angular and other various dependencies.

* [Node Installation on Mac and Windows](https://nodejs.org/en/download/)

Once Node is installed, the following commands will install the necessary dependencies. Note that AngularCLI must be installed separately as it is not conventionally included as a package dependency, since it may not be needed upon deployment.

*Mac Instructions*
```
sudo npm install -g @angular/cli 
npm install
```

```
npm install -g @angular/cli 
npm install
```

After this, the front-end application can be started with:

```
ng serve
```

The application may be accessed at http://localhost:4200

### Back-end Deployment

The back-end application is a Spring Boot app, which is a fully self contained application that includes its own container and all needed dependencies. It is necessary to have JDK8 installed. A bootstrapper is included, which will automatically install an embedded Maven instance to process all of the application dependencies.

```
./mvnw spring-boot:run
```

The application may be accessed at http://localhost:8080

### Database (local)

PostgreSQL may be installed readily on Mac and Windows. Suggested methods are:

* [Mac Installation](http://postgresapp.com)
* [Windows Installation](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads#windows)

A set of scripts in etc/data will create an initial database and SQL scripts. Please note that the scripts do not create the local user for you automatically. This can be done with the following command:

```
CREATE USER fecefapp WITH PASSWORD 'YOUR_PASSWORD';
```

### Docker deployment
Deploying through Docker requires first publishing the Docker files to a registry such as Dockerhub. See the Build notes for information on this process.

You may either run PostgreSQL as a local service or deploy it via Docker as well:

```
docker run --publish 5432:5432 --rm --env POSTGRESQL_USER=fecefapp,POSTGRESQL_PASSWORD=YOUR_PASSWORD registry.access.redhat.com/rhscl/postgresql-95-rhel7
```

Then, you can start the frontend and backend apps:

```
docker run --publish 4200:4200 --rm salientcrgt/fec-ef-app-frontend
docker run --publish 8080:8080 --rm --env EF_DB_PASSWORD=YOUR_PSASWORD salientcrgt/fec-ef-app-backend
```

A set of scripts in etc/data will create an initial database and SQL scripts. Please note if you are using a local Postgres instance, you will need to create the initial user for you. The scripts expect this to be done already, as the Docker image does this automatically.

### Local Development
While the application is designed to be installed and run locally with minimal existing tools, local development does require a few additional requirements.

* [Maven](http://maven.apache.org/download.cgi)
* Docker (only required to build Docker images)
* Eclipse (recommended)

Eclipse is the recommended IDE, as it is open source and has various plugins that facilitate development in the technology stack we are using. It is recommended to create projects for the front-end app (client), back-end app (server) and Selenium tests (selenium). The Spring Boot and Selenium apps use Maven to manage dependencies. Eclipse configurations for these apps can be directly configured as follows:

```
mvn -f server/pom.xml eclipse:clean eclipse:eclipse
mvn -f selenium/pom.xml eclipse:clean eclipse:eclipse
```

Gitignore files are already configured to ignore the build output of both Maven and Eclipse.

### Docker Images
The application includes 3 Docker images in addition to the optional Redhat-supplied PostgreSQL image. The Docker images that are part of the application can be built as follows:

```
cd client
docker build --file=Dockerfile.runner --tag=salientcrgt/fec-ef-app-ngrunner:latest --rm=true .
docker build --file=Dockerfile --tag=salientcrgt/fec-ef-app-frontend:latest --rm=true --build-arg env=dev .
cd ..

cd server
docker build --file=Dockerfile --tag=fec-ef-app-backend:latest --rm=true .
cd ..
```

Note that the `fec-ef-app-ngrunner` image is used to bootstrap the Angular CLI in order to run the native ng server. 
