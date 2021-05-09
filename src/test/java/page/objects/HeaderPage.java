package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
