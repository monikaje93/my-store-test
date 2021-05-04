package page.objects.checkout;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class OrderConfirmationPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(className = "alert-success")
    private WebElement alert;

    public OrderConfirmationPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isSuccessAlertWithProperAlertMessageDisplayed(String alertMessage) {
        WaitForElement.waitUntilElementIsVisible(alert);
        String actualAlertMessage = alert.getText();
        logger.info("Returned warning message: {}", actualAlertMessage);
        return actualAlertMessage.equals(alertMessage);
    }
}
