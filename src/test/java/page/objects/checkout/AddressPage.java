package page.objects.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.BasePage;
import waits.WaitForElement;

public class AddressPage extends BasePage {

    @FindBy(name = "processAddress")
    private WebElement proceedToCheckoutButton;

    public ShippingPage clickProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        log().info("Clicked proceed to checkout button on address tab");
        return new ShippingPage();
    }
}
