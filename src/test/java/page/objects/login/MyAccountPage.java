package page.objects.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.BasePage;
import waits.WaitForElement;

public class MyAccountPage extends BasePage {

    @FindBy(className = "navigation_page")
    WebElement pageLabel;


    public boolean isMyAccountPageAfterLoginDisplayed() {
        WaitForElement.waitUntilElementIsVisible(pageLabel);
        return pageLabel.getText().equals("My account");
    }
}
