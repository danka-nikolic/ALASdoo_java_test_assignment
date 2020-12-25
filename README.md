# Alas d.o.o. Java developer test assignment

## How to run the application

1. Install Java 8: Go to https://adoptopenjdk.net/ and download version 8. If the Operating System is Windows: set the system environments for `JAVA_HOME` (jdk root folder) and `PATH` (jdk root folder\bin)
2. To start the backend run `mvnw spring-boot:run` command (control + c will kill the application)
3. Build the frontend: `cd src/frontend`, `yarn`. (install `yarn` and `node` if needed)
4. To start the frontend go to `src/frontend` and run `yarn start`. It will run on `localhost:3000`.

## How to run the tests
1. Webdrivers can be downloaded from [download webdrivers](https://www.selenium.dev/ecosystem/)
while Internet Explorer webdriver can be downloaded from [explorer webdriver](https://www.selenium.dev/downloads/)
(By default, all the drivers are located in `src/test/resources` folder)
2. Browser selection can be adjusted by passing system argument `BROWSER_TYPE={type}`, or changing the file `src/test/resources/tests_config.properties`, by changing the value for key `BROWSER` to `{type} = `chrome` (Google Chrome), or `edge` (Microsoft Edge), or `explorer` (Internet Explorer), or `firefox` (Mozilla Firefox). The default value is `firefox`. 
3. Tests can be run from command line `mvnw test -D BROWSER_TYPE={type}` (e.g. `mvnw test -D BROWSER_TYPE=firefox`)