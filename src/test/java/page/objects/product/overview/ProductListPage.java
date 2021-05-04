package page.objects.product.overview;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ProductListPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "(//*[@class=\"product_img_link\"])[1]")
    private WebElement firstProduct;

    public ProductListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public ProductPage clickFirstProduct() {
        WaitForElement.waitUntilElementIsClickable(firstProduct);
        firstProduct.click();
        logger.info("Clicked on first product on the page");
        return new ProductPage();
    }
}
