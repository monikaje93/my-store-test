package page.objects.product.overview;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.objects.BasePage;


public class ProductPage extends BasePage {

    @FindBy(name = "Submit")
    private WebElement addToCartButton;


    public ProductAddedModalPage clickAddToCartButton() {
        addToCartButton.click();
        log().info("Added product to cart");
        return new ProductAddedModalPage();
    }
}
