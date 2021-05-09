package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.product.overview.ProductListPage;

public class HeaderPage extends BasePage{

    @FindBy(css = "#block_top_menu >ul > li >  [title = \"T-shirts\"]")
    private WebElement tshirtCategoryMenuLink;


    public ProductListPage clickTshirtCategoryMenuLink() {
        tshirtCategoryMenuLink.click();
        log().info("Clicked on Tshirt category from menu");
        return new ProductListPage();
    }
}
