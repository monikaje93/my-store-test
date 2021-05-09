package page.objects.product.overview;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.BasePage;
import waits.WaitForElement;

public class ProductListPage extends BasePage {

    @FindBy(xpath = "(//*[@class=\"product_img_link\"])[1]")
    private WebElement firstProduct;


    public ProductPage clickFirstProduct() {
        WaitForElement.waitUntilElementIsClickable(firstProduct);
        firstProduct.click();
        log().info("Clicked on first product on the page");
        return new ProductPage();
    }
}
