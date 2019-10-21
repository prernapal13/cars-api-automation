## Manual Testing: 

Manual test scenarios and steps are available in feature files corresponding to each API.
- [Manufacturer.feature](https://github.com/prernapal13/cars-api-automation/blob/master/src/test/resources/Manufacturer.feature)
- [MainTypes.feature](https://github.com/prernapal13/cars-api-automation/blob/master/src/test/resources/MainTypes.feature)
- [BuiltDates.feature](https://github.com/prernapal13/cars-api-automation/blob/master/src/test/resources/BuiltDates.feature)

**_Findings & Bugs Report:_** All findings & bugs details are mentioned in the [OverallTestReport.pdf](https://github.com/prernapal13/cars-api-automation/blob/master/OverallTestReport.pdf)

## Automation Testing: 

Automation scripts are developed using Java, RestAssured, Cucumber, JUnit & Maven. This project is implemented in Page Object Model (POM) along with BDD which helps in making the code more readable, maintainable and reusable. 

List of all the software and tools required for developing and executing automation framework.

- Java
- Cucumber
- Rest Assured
- JUnit
- TestNG
- Maven
- Intellij or Eclipse

## How to Execute:
**_Pre-Requisite:_** Kindly update **BASE_URL** & **WA_KEY** in [Constants.java](https://github.com/prernapal13/cars-api-automation/blob/master/src/test/java/cars/utilities/Constants.java) file

1. To execute any of the feature files, open feature file, right click in the file and select 'Run As > Cucumber Feature'
2. To execute all the features, open MainRunner.java, right click in the file and select 'Run As > JUnit Test'
3. To execute via command prompt, execute below command from project root directory(execution will take place using TestNG & Maven)

   > `mvn test`
   
## Execution Reports:

- **_Cucumber Report:_** Report generate using cucumber will be available at: './cars-api-automation/target/cucumber/index.html'

![Cucumber Report](https://github.com/prernapal13/cars-api-automation/blob/master/snapshot_for_readme/cucumber_report.png)

- **_Extent Report:_** Report generated using Extent reports will be available at: './cars-api-automation/output/report.html'

![Extent Report](https://github.com/prernapal13/cars-api-automation/blob/master/snapshot_for_readme/extent_report.png)
