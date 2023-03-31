package Base;


import Helper.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;
    public static ExtentReports extent;
    static ExtentTest BrowserTest;

    @BeforeSuite
    public void startReport() {
        Helper hp = new Helper();
        extent = new ExtentReports();
        ExtentSparkReporter reporter;
        reporter = new ExtentSparkReporter("TestReports/" + hp.date() + ".html");
        extent.attachReporter(reporter);
    }

    @BeforeMethod(alwaysRun = true)
    public static void lunchApp() {

        loadConfig();
        BrowserTest = extent.createTest("Browser test", "This is to test if browser opened successfully");

        String browserName = prop.getProperty("BrowserType");

        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
            BrowserTest.log(Status.INFO,"Opening in Chrome Browser");
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
            BrowserTest.log(Status.INFO,"Opening in Safari Browser");
        }
        else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
            BrowserTest.log(Status.INFO,"Opening in Firefox Browser");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));

        try {
            driver.findElement(By.xpath("//img[@alt=\"Logo\"]")).isDisplayed();
            BrowserTest.pass("Website loads fine");
            System.out.println("Page loads fine");
        } catch (Exception e) {
            BrowserTest.fail("Website fails to load");
            System.out.println("Issue while loading page " + e);
        }
    }

    public static void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream io = new FileInputStream("Configuration/config.properties");
            prop.load(io);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        BrowserTest.log(Status.INFO,"Closing browser");
        System.out.println("Closing browser...");
        driver.close();
    }

    @AfterSuite
    public void closeReport() {
        extent.flush();
    }
}
