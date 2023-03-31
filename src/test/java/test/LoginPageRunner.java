package test;

import Base.BaseClass;
import RemoteCoach.LoginPage;
import org.testng.annotations.Test;

public class LoginPageRunner extends BaseClass {

    //Login success
    @Test(groups={"positive","Regression"})
    public void Login() {
        LoginPage login = new LoginPage();
        login.signIn();
    }

    //Login failed with empty credentials
    @Test(groups={"empty","Regression","negative"})
    public void LoginEmpty(){
        LoginPage login = new LoginPage();
        login.signInEmpty();
    }

    //Login failed with wrong email credentials
    @Test(groups={"negative","Regression"})
    public void LoginEmailInvalid(){
        LoginPage login = new LoginPage();
        login.signInEmailNegative();
    }

    //Login failed with wrong password credentials
    @Test(groups={"negative","Regression"})
    public void LoginPasswordInvalid(){
        LoginPage login = new LoginPage();
        login.signInPasswordNegative();
    }
}
