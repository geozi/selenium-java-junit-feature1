# selenium-java-junit-feature1
![Functional Testing Demo App](https://img.shields.io/badge/demo_app-blue)

### About the project
The project showcases the use of Selenium with Java and JUnit for performing functional tests on a pop-up window.

### Website[^1]
The website where the element is located is the https://www.netcompany-intrasoft.com/ .

### Web element under test

The web element tested was the cookie pop-up window found on the landing page of the website:

<div align="center">
  <img src="https://github.com/user-attachments/assets/183fa067-e0e9-4c18-a9bd-e60fe477b37e">
</div>

### OOP

To make full use of Java as a pure Object-Oriented language and, by extension, optimize code organization, a small class hierarchy was developed. Each subclass simulates a concrete user action.

<div align="center">
	<img src="https://github.com/user-attachments/assets/4e7e00c4-c54b-42e3-8234-e38519ec3efa">
</div>

### Prerequisites
* Java 17 or higher,
* Intellij IDEA (or any other Java IDE),
* Maven,
* Selenium.

### Dependencies
```
  <dependencies>
    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.23.0</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-firefox-driver -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-firefox-driver</artifactId>
      <version>4.23.0</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-chrome-driver</artifactId>
      <version>4.23.0</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine -->
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-engine</artifactId>
      <version>5.10.3</version>
      <scope>test</scope>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-api</artifactId>
      <version>5.10.3</version>
      <scope>test</scope>
    </dependency>
```

### Further documentation

For more information, please check the provided javadoc.

<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,idea,maven,selenium&theme=light"/>
	 
  </a>
</p>

[^1]: Disclaimer: This website was tested in order to showcase the use of Selenium with Java and JUnit 5, and such testing does not constitute an endorsement or promotion of said website.
