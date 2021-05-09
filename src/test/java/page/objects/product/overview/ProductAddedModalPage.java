package page.objects.product.overview;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.BasePage;
import page.objects.checkout.OrderSummaryPage;
import waits.WaitForElement;

public class ProductAddedModalPage extends BasePage {

    @FindBy(css = "[title = \"Proceed to checkout\"]")
    private WebElement proceedToCheckoutButton;


    public OrderSummaryPage clickProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        log().info("Clicked proceed to checkout button on modal");
        return new OrderSummaryPage();
    }

}
