package page.objects.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.BasePage;

public class PaymentPage extends BasePage {

    @FindBy(className = "bankwire")
    private WebElement bankWirePaymentButton;

    @FindBy(className = "cheque")
    private WebElement checkPaymentButton;

    @FindBy(css = ".cart_navigation [type = \"submit\"]")
    private WebElement confirmOrderButton;


    public PaymentPage selectBankWirePayment() {
        bankWirePaymentButton.click();
        log().info("Selected bank wire payment");
        return this;
    }

    public PaymentPage selectCheckPayment() {
        checkPaymentButton.click();
        log().info("Selected check payment");
        return this;
    }

    public OrderConfirmationPage clickConfirmOrderButton() {
        confirmOrderButton.click();
        log().info("Clicked confirm order button");
        return new OrderConfirmationPage();
    }
}
