# Salary Calculator
Java Web Application created with Spring Boot framework, that allows to calculate monthly salary in PLN for contractors 
working abroad.

This application can be runned on its own or combined with Angular frontend from this [repository](https://github.com/s-kaczmarek/salary-calculator-frontend).

## Installation

### Linux (Debian based distributions)
* Click on "Clone or download" button and choose "Download ZIP".
* Unpack archive in location of your choice.
* Open terminal and navigate to location of unpacked archive.
* Make sure you have Maven installed on your system. You can
check that by typing in terminal:
```bash
$ mvn -v
```
* If you receive Maven version as output, than procede to the 
next step. If not, than install Maven from terminal:
```bash
$ sudo apt install maven
```
* Create .jar file. Type in terminal:
```bash
$ mvn clean install
```
* Navigate to ./target , list all files and run created 
.jar file with command:
```bash
$ java -jar filename-version-SNAPSHOT.jar
``` 
### Windows

* Install [Chocolatey](https://chocolatey.org/install) package manager for Windows.
* Open cmd as administrator and type:
```cmd
choco install maven
```
* Click on "Clone or download" button and choose "Download ZIP".
* Unpack archive in location of your choice.
* Open terminal and navigate to location of unpacked archive.
* Create .jar file. Type in terminal:
```cmd
mvn clean install
```
* Navigate to ./target , list all files and run created 
.jar file with command:
```cmd
java -jar filename-version-SNAPSHOT.jar
``` 
## How to use this program
* Once application is up and running, please open your web browser 
and navigate to address:
```$xslt
localhost:8080
```
* In order to count monthly salary, please pass values of country code 
and daily earnings in URL for example:
```$xslt
http://localhost:8080/calculateNettSalaryInPLN/UK/100.70
```
