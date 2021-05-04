package page.objects.checkout;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ShippingPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(id = "cgv")
    private WebElement termsOfServiceCheckbox;

    @FindBy(name = "processCarrier")
    private WebElement proceedToCheckoutButton;

    public ShippingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public ShippingPage selectTermsOfServiceCheckbox() {
        termsOfServiceCheckbox.click();
        logger.info("Selected terms of service checkbox");
        return this;
    }

    public PaymentPage clickProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked proceed to checkout button on shipping tab");
        return new PaymentPage();
    }
}
