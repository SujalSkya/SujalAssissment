package test;

import Base.BaseClass;
import RemoteCoach.LoginPage;
import RemoteCoach.HomePage;

import org.testng.annotations.Test;

public class HomePageRunner extends BaseClass {

    //Login success
    @Test(groups="Regression")
    public void totalSubscriber() {
        LoginPage login = new LoginPage();
        HomePage home = new HomePage();

        login.signIn();
        home.getSubscriber();
    }
}
