package page.objects.checkout;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class AddressPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(name = "processAddress")
    private WebElement proceedToCheckoutButton;

    public AddressPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public ShippingPage clickProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked proceed to checkout button on address tab");
        return new ShippingPage();
    }
}
