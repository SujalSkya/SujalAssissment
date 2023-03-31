package RemoteCoach;

import Base.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseClass {

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "kt_sign_in_submit")
    WebElement signIn;

    @FindBy(xpath = "//div[@class=\"d-flex flex-column ps-1\"]//child::h6")
    WebElement notification;

    @FindBy(xpath = "//*[@class=\"error\"]")
    WebElement labelMesg;

    ExtentTest loginReport= extent.createTest("Login test", "This is to test the login module");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    //Login successfully
    public void signIn() {
        loginReport.log(Status.INFO, "Login module for testing successful credential");

        email.sendKeys(prop.getProperty("username"));
        loginReport.info("Username is " + prop.getProperty("username"));

        password.sendKeys(prop.getProperty("password"));
        loginReport.info("Password is " + prop.getProperty("password"));
        signIn.click();

        try {
            //assert the page loads fine
            Assert.assertEquals("Dashboard | Admin Panel", driver.getTitle());
            loginReport.pass("Successfully login to dashboard");
            System.out.println("Login success");
        } catch (Exception e) {
            loginReport.fail("Login failed");
            System.out.println("Login failed due to " + e);
        }
    }

    public void signInEmpty() {
        loginReport.log(Status.INFO, "Login module for testing empty credential");

        email.sendKeys("");
        loginReport.info("Username is ");

        password.sendKeys("");
        loginReport.info("Password is ");

        signIn.click();

        //assert empty credential
        if (labelMesg.isDisplayed()) {
            Assert.assertEquals("This field is required.", labelMesg.getText().trim());
            System.out.println("Unable to login as email and/or password field is empty");
            loginReport.pass("Couldn't login as email and/or password field is empty");
        } else {
            System.out.println("Login success with empty credential");
            loginReport.fail("Login success with empty credential");
        }
    }

    public void signInEmailNegative() {
        loginReport.log(Status.INFO, "Login module for testing wrong email credential");

        email.sendKeys(prop.getProperty("invalidEmail"));
        loginReport.info("Username is " + prop.getProperty("invalidEmail"));

        password.sendKeys(prop.getProperty("password"));
        loginReport.info("Password is " + prop.getProperty("password"));
        signIn.click();

        if (notification.isDisplayed()) {
            String notify = notification.getText();
            //assert the email
            Assert.assertEquals("Error!!", notify);
            loginReport.pass("Unable to login as email or password is incorrect");
            System.out.println("Unable to login as email or password is incorrect");
        } else {
            loginReport.fail("Login success with invalid credential");
            System.out.println("Login success with invalid credential");
        }
    }

    public void signInPasswordNegative() {
        loginReport.log(Status.INFO, "Login module for testing wrong password credential");

        email.sendKeys(prop.getProperty("username"));
        loginReport.info("Username is " + prop.getProperty("username"));

        password.sendKeys(prop.getProperty("invalidPassword"));
        loginReport.info("Password is " + prop.getProperty("invalidPassword"));
        signIn.click();

        //assert the password
        if (notification.isDisplayed()) {
            String notify = notification.getText();
            //assert the email
            Assert.assertEquals("Error!!", notify);
            loginReport.pass("Unable to login as email or password is incorrect");
            System.out.println("Unable to login as email or password is incorrect");
        } else {
            loginReport.fail("Login success with invalid credential");
            System.out.println("Login success with invalid credential");
        }
    }
}

