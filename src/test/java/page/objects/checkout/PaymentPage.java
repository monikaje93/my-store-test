package page.objects.checkout;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(className = "bankwire")
    private WebElement bankWirePaymentButton;

    @FindBy(className = "cheque")
    private WebElement checkPaymentButton;

    @FindBy(css = ".cart_navigation [type = \"submit\"]")
    private WebElement confirmOrderButton;

    public PaymentPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public PaymentPage selectBankWirePayment() {
        bankWirePaymentButton.click();
        logger.info("Selected bank wire payment");
        return this;
    }

    public PaymentPage selectCheckPayment() {
        checkPaymentButton.click();
        logger.info("Selected check payment");
        return this;
    }

    public OrderConfirmationPage clickConfirmOrderButton() {
        confirmOrderButton.click();
        logger.info("Clicked confirm order button");
        return new OrderConfirmationPage();
    }
}
