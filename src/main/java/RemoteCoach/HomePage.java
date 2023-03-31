package RemoteCoach;

import Base.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(id = "total-subscribers-total")
    WebElement subscriber;

    ExtentTest homepageReport = extent.createTest("Dashboard test", "This is to test the home page dashboard");

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void getSubscriber() {
        homepageReport.log(Status.INFO, "Homepage module for testing dashboard subscriber");
        try {
            Thread.sleep(2000);
            String subscriberText = subscriber.getText();
            int subs = Integer.parseInt(subscriberText);

            if (subs > 0) {
                homepageReport.pass("Total subscribers = " + subs + ". Which is greater then 0");
                System.out.println("Total subscribers = " + subs + ". Which is greater then 0");
            } else {
                homepageReport.fail("Total subscribers = " + subs);
                System.out.println("Total subscribers = " + subs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
