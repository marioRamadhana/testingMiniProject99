package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;


    @BeforeTest
    public void beforeTest(){

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "santaraReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("santaraReport");
        htmlReporter.config().setReportName("TestResult");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Santara Dev","Mario Gilang");

    }


    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void beforeMethod(String browserName, Method testMethod){
        logger = extent.createTest(testMethod.getName());
        setUpDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void afterMethod(ITestResult result){

        if (result.getStatus()==ITestResult.SUCCESS){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case " + methodName + " PASS";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        }
        else if (result.getStatus()==ITestResult.FAILURE){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case " + methodName + " FAIL";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,m);
        }
        else if (result.getStatus()==ITestResult.SKIP){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case " + methodName + " SKIPPED";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP,m);
        }
//        driver.quit();

    }


    @AfterTest
    public void afterTest(){
        extent.flush();

    }

    public void setUpDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdiver.chrome.driver","/usr/bin/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("headlessChrome")){
            System.setProperty("webdiver.chrome.driver","/usr/bin/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        } else {
            System.setProperty("webdiver.chrome.driver","/usr/bin/chromedriver");
            driver = new ChromeDriver();
        }
    }
}
