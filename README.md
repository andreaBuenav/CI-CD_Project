# CI-CD_Project Using SourceDemoAutomationProject
## Content table
 [Description](#description)<br/>
 [Disclaimers](#disclaimers)<br/>
 [Chromedriver](#chromedriver)<br/>
 [Contact](#contact)<br/>
 [Clone this](#clone) <br/>
 [Report](#report)<br/>
 <br/>
 <br/>
### Description
This is a web automation project for the page [Swag Lab](https://www.saucedemo.com/).<br/>
We will test different methods for different users to be able to know how the page is working for each one of them, and at the same time<br/>
register all the problems hat these users encounter.<br/><br/>
### Disclaimers
1. There is a WebElementWait that is able to wait for 1 second, if an element is not showed within that seocnd, a TimeoutException
   will be caught.<br/>
2. The project is made with an openjdk-23.<br/>
3. When a TimeoutException is caught that user test is automatically assigned as a failed test.<br/>
4. There are 3 types of test that will be done one after another, this means that:<br/>
   - All purchase tests of all the users will be done first.<br/><br/>
   - Then all the remove items tests of all users will be done.<br/><br/>
   - Finally all the logout tests of all users will be done.<br/><br/>
5. Data providers are used for the tests, I didn't include users that are not registeres nor unnaccepted because it would
   automatically create a failed test for that username in each one of the tests that are done during the execution of the .xml file.<br/>
5.JavaFaker was used to provide all the names, last names and zip codes, meaning that every test has a different user with different
 personal data to interact with the page.<br/>
6. If the chromedirver of the project is not compatible with your device's Chrome, please go back to the content table and select "ChromeDriver"
   to install a chrome driver that is compatible for your Chrome's version.<br/>
7. The user "performance_glitch_user" can execute all the tests, however, the time response is very slow, so in order to register it, all the tests have a duration time registered.
8. All the tests have a comment to know where the test of that user failed.
### Chromedriver 
[ChromeDriver for testing](https://googlechromelabs.github.io/chrome-for-testing/)<br/>      
 To set the new chrome driver just delete the one in this path of the project: PomPractice/drivers/chromedriver.exe
then drag the new chromedriver.exe that you downloaded into the path where the deleted chromedriver was originally.<br/>
### Contact 
for any questions or suggestions pleasse contact to this mail:<br/>
[Mail](andrea.buenaventura@globant.com)<br/>
### Clone
git clone https://github.com/andreaBuenav/CI-CD_Project
### Report
# Informe de Allure
Para ver el informe, visita: [Informe de Allure](http://192.168.100.195:62470/index.html)
