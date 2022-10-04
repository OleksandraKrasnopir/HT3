package change_contacts_check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://avic.ua/ua";
    private WebDriver driver;

    @FindBy(xpath = "(//i[@class='icon-down icon'])[1]")
    private WebElement contactsArrow;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@class='icon-down icon'])[1]")));
    }
    public void clickContactsArrow() {
        contactsArrow.click();
    }
}