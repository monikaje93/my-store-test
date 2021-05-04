package page.objects.checkout;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class OrderSummaryPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(css = ".cart_navigation [title = \"Proceed to checkout\"]")
    private WebElement proceedToCheckoutButton;

    public OrderSummaryPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public AddressPage clickProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked proceed to checkout button on order summary tab");
        return new AddressPage();
    }
}
