package page.objects.product.overview;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(name = "Submit")
    private WebElement addToCartButton;

    public ProductPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public ProductAddedModalPage clickAddToCartButton() {
        addToCartButton.click();
        logger.info("Added product to cart");
        return new ProductAddedModalPage();
    }
}
