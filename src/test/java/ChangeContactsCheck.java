import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import change_contacts_check.ChangeLocation;
import change_contacts_check.HomePage;

public class ChangeContactsCheck {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetup () {
        //System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test (description = "change of contact details in header")
    public void changeContactInfo() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.openPage();
        homePage.clickContactsArrow();

        ChangeLocation changeLocation = PageFactory.initElements(driver, ChangeLocation.class);
        String locationKharkivgetText = changeLocation.getLocationKharkiv();
        changeLocation.changeLocationToKyiv();
        String locationKyivgetText = changeLocation.getLocationKyiv();

        Assert.assertNotEquals(locationKyivgetText, locationKharkivgetText);
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
