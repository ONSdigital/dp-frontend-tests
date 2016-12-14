dp-frontend-tests
=================

Acceptance tests for Florence using Selenium and Cucumber.
This is a maven project.

Getting Started
=============== 
Install Java, maven & git
```
brew install java
brew install maven
brew install git
```

```
git clone https://github.com/ONSdigital/dp-frontend-tests
```

Go to the project dir and run
```
mvn clean test -DfailIfNoTests=false
```
to run all the tests

Reports are under  ```/target/cucumber-html-report/index.html```



### License

Copyright ©‎ 2016, Office for National Statistics (https://www.ons.gov.uk)

Released under MIT license, see [LICENSE](LICENSE.md) for details.
