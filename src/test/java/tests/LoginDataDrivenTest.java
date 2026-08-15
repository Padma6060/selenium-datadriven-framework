package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelReader;

public class LoginDataDrivenTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.saucedemo.com");
}

    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {
       return ExcelReader.readData("testdata/logins.xlsx", "Sheet1");
}
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String expected) {
       LoginPage login = new LoginPage(driver);
       login.login(username.trim(), password);

       if (expected.equalsIgnoreCase("success")) {
           Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
               "Expected successful login for: " + username);
       
        } else {
           Assert.assertTrue(login.getErrorMessage().length() > 0,
               "Expected an error for: " + username);
}
}
    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();

}
}
