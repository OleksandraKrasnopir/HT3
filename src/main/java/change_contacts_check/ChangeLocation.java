package change_contacts_check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangeLocation {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(//strong[text()='Харків'])[2]")
    private WebElement locationKharkiv;

    @FindBy(xpath = "(//a[text()='Київ'])[2]")
    private WebElement changeLocationToKyivButton;

    @FindBy(xpath = "(//a[@class='active'])[2]")
    private WebElement locationKyiv;

    private By locationKharkivBy = By.xpath("(//strong[text()='Харків'])[2]");
    private By changeLocationToKyivButtonBy = By.xpath("(//a[text()='Київ'])[2]");
    private By locationKyivBy = By.xpath("(//a[@class='active'])[2]");


    public ChangeLocation(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public String getLocationKharkiv() {
        wait.until(ExpectedConditions.presenceOfElementLocated(locationKharkivBy));
        return locationKharkiv.findElement(locationKharkivBy).getText();
    }

    public void changeLocationToKyiv() {
        wait.until(ExpectedConditions.presenceOfElementLocated(changeLocationToKyivButtonBy));
        changeLocationToKyivButton.click();
    }

    public String getLocationKyiv() {
        wait.until(ExpectedConditions.presenceOfElementLocated(locationKyivBy));
        return locationKyiv.findElement(locationKyivBy).getText();
    }
}


