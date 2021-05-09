package page.objects.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.BasePage;
import waits.WaitForElement;

public class OrderSummaryPage extends BasePage {

    @FindBy(css = ".cart_navigation [title = \"Proceed to checkout\"]")
    private WebElement proceedToCheckoutButton;


    public AddressPage clickProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        log().info("Clicked proceed to checkout button on order summary tab");
        return new AddressPage();
    }
}
