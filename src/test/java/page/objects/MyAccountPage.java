package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MyAccountPage {

    @FindBy(className = "navigation_page")
    WebElement pageLabel;

    public MyAccountPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public boolean isMyAccountPageAfterLoginDisplayed() {
        return pageLabel.getText().equals("My account");
    }
}
