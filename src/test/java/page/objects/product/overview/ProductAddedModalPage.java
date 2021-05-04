package page.objects.product.overview;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.objects.checkout.OrderSummaryPage;
import waits.WaitForElement;

public class ProductAddedModalPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(css = "[title = \"Proceed to checkout\"]")
    private WebElement proceedToCheckoutButton;

    public ProductAddedModalPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public OrderSummaryPage clickProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked proceed to checkout button on modal");
        return new OrderSummaryPage();
    }

}
