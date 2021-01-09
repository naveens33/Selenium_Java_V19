base- TestNG class
	-BaseTest/DriverManager 
		-@BeforeSuite - open the browser(driver), report init.
		-@AfterSuite - close the browser, generate report
		-@AfterMethod - configuring test result in ExtentReport
pages - java class
	-classes for all the pages of the application, which going to maintain the locators and scenario related to the page for example(LoginPage -> username, password, submit, forgot password, etc., and doLogin(),clickOnforgot())
	- BasePage
	- extends BasePage
reports - html
	-reports -> ExtentReport
suite - xml
	-TestNG suite
testdata -excel
	- ReadExcelData
	- testdata.excel 
test -TestNGClasses
	-TestNG Classes
		- extends->BaseTest
		- @test