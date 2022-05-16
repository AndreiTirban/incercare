# Whiteboard App

# Configure the application docker

Go to Whiteboard Application root directory and run the following command: <br/>
```docker-compose -f docker-compose-dev.yml up --build``` <br/> After the containers are
(re)created frontend, SonarQube, Keycloak and Flyway are up and running.

# Configure SonarQube

SonarQube is an open-source platform developed for continuous inspection to perform automatic
reviews with static analysis of code to detect bugs, code smells and security vulnerabilities. It
uses a different tool called Jacoco to generate code coverage metrics, the result is then
interpreted and shown within SonarQube web interface.

### Steps to configure SonarQube locally

After the SonarQube image is up, you should follow these steps:

-[ ] Check if you cand access **localhost:9000**
-[ ] Insert the **admin/admin** credentials
-[ ] Change the password if necessary
-[ ] Go to your account icon -> my account -> security and generate a token, copy it
-[ ] Go to Environment Variables on your system -> User variables and add two new system variables,
 one with name **SONAR_TOKEN** and for the value paste your token, and the other one with the name
 **SONAR_URL** and the value **http://localhost:9000/**
-[ ] Restart your IDE and then Build Gradle to load the changes

Wait for the SonarQube to be up, and then in the IDE terminal you can
run```gradlew test jacocoRootReport sonarqube```  command, then you can check on the GUI if the
project is up and you can see the analysis of the code.

# Configure Keycloak

Keycloak is an open-source software that includes features such as:

- [ ] User Registration
- [ ] Social login
- [ ] Single Sign-On
- [ ] 2-factor authentication

After the docker-compose command, you can access the keycloak admin console by introducing the
following credentials:

- Username: **admin**
- Password: **Pa55w0rd**

In the admin console you can configure a client, add/manage users and groups in session and add
multiple features depending on your needs.

# Configure Flyway

Flyway is an open-source database migration tool. It is based around just 7 basic commands: Migrate,
Clean, Info, Validate, Undo, Baseline and Repair. Migrations can be written in SQL or Java.

### Steps to run Flyway

Before running the application you should follow these steps:

- [ ] install postresql
- [ ] test the connection with user **postgres**
- [ ] create a postgres database: **whiteboard**

Run the spring boot application, and also Flyway will run at this step. You can see the result in
console and postgres database.

Where and how to create a migration script:

- [ ] path for the migration scripts: **resources/db/migration**
- [ ] migration script name example: **V1.1.0_01__create_schema.sql**

Versioned SQL migrations have the following file name structure: **
prefixVERSIONseparatorDESCRIPTIONsuffix**:

- [ ] prefix: **V for versioned, U for undo and R for repeatable migrations**
- [ ] VERSION: **1.1.0_01**
- [ ] separator: **__**
- [ ] DESCRIPTION: **create_schema**
- [ ] suffix: **.sql**

Other valid names would be **V1.1.0_02__Another_desc.sql**

# Configure Swagger

Swagger is an Interface Description Language for describing RESTful APIs expressed using JSON. It is
used together with a set of open-source software tools to design, build, document, and use RESTful
web services.

### Steps to access Swagger UI

After running the application, you should follow these steps:

- [ ] access **http://localhost:8080/swagger-ui.html**

You will be redirected to Keycloak's login page.

Login credentials are:

- [ ] username: **user**
- [ ] password: **user**

After logging in, Swagger's UI will appear.

To get the file containing the API description, access:

- [ ] **http://localhost:8080/whiteboard-docs.yaml**
  A yaml formatted file will be automatically downloaded to your computer.

#Configure Grafana
Grafana is an open source visualization and analytics platform that unifies data sets across your company into an interactive diagnostic workspace.
Grafana is built on a plug-in architecture that allows you to interact with the underlying data sources without creating data copies.

###Steps to run Grafana
Before running the application you should follow these steps:
- [ ] Check if localhost:3000 is up
- [ ] Connect using username: admin and password: admin
- [ ] On the left panel go to Configuration -> Data sources and click on "Add data source"
- [ ] Select Prometheus and type in the URL box "http://localhost:9090"
- [ ] Then change the Access to Browser and click on the "Save & Test" button
- [ ] Next go on the left panel again and select "Import" from "+"(Create)
- [ ] Type "4701" click "Load"
- [ ] Select "Prometheus" as a data source and click import

#Configure Kibana

##Your window into the Elastic Stack

Kibana is a free and open user interface that lets you visualize your Elasticsearch data and navigate the Elastic Stack.
Do anything from tracking query load to understanding the way requests flow through your apps. 

###Steps to access Kibana UI
After running the application, you should follow these steps:
- [ ]  access **http://localhost:5601**
- [ ]  in the top search bar type "Stack Management" then click on the "Index Patterns" from Kibana
- [ ]  click the "Create index pattern" button
- [ ]  type "whiteboard-logs" for the index pattern name
- [ ]  from Time field select "@timestamp" and click the create button
- [ ]  next go to the menu and select "Discover" from "Analytics" to see your logs
