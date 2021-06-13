## Mobile Automation with Appium for Wikipedia app 

### Technology Stack
![Java](readme/Java.png)
![Appium](readme/Appium.png)
![Gradle](readme/Gradle.png)
![JUnit5](readme/JUnit5.png)
![Allure_Report](readme/Allure_Report.png)
![Browserstack](readme/Browserstack.png)
![Selenoid](readme/Selenoid.png)
- Java
- Appium
- Gradle
- Junit5
- Allure Report
- Browserstack
- Selenoid

### Run tests
Copy-paste and fill configs from `resources/*.properties.examples` files to `*.properties` files

Run on local device: `gradlew testLocal` or `gradlew test -Ddriver=local`

Run on selenoid: `gradlew testSelenoid` or `gradlew test -Ddriver=selenoid` 

Run on browserstack: `gradlew testBrowserstack` or `gradlew test -Ddriver=browserstack` 

### Allure report
![Allure](readme/Appium_Allure.gif)
### Browserstack
![Browserstack](readme/Appium_Browserstack.gif)
### Selenoid
![Selenoid](readme/Appium_Selenoid.gif)





