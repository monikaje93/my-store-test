package page.objects.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.BasePage;
import waits.WaitForElement;

public class ShippingPage extends BasePage {

    @FindBy(id = "cgv")
    private WebElement termsOfServiceCheckbox;

    @FindBy(name = "processCarrier")
    private WebElement proceedToCheckoutButton;


    public ShippingPage selectTermsOfServiceCheckbox() {
        termsOfServiceCheckbox.click();
        log().info("Selected terms of service checkbox");
        return this;
    }

    public PaymentPage clickProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        log().info("Clicked proceed to checkout button on shipping tab");
        return new PaymentPage();
    }
}
