package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class RegistrationFormSecondStep {

    Logger logger = LogManager.getRootLogger();

    @FindBy(id = "account-creation_form")
    private WebElement createAccountForm;

    //Personal data
    @FindBy(id = "id_gender1")
    private WebElement titleMrRadio;

    @FindBy(id = "id_gender2")
    private WebElement titleMrsRadio;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(css = "select[id = days]")
    private WebElement dateOfBirthDay;

    @FindBy(css = "select[id = months]")
    private WebElement dateOfBirthMonth;

    @FindBy(css = "select[id = years]")
    private WebElement dateOfBirthYear;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;


    public RegistrationFormSecondStep() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isCreateAnAccountFormDisplayed() {
        waitUntilPageIsLoaded();
        return createAccountForm.isDisplayed();
    }

    public RegistrationFormSecondStep waitUntilPageIsLoaded() {
        WaitForElement.waitUntilElementIsVisible(createAccountForm);
        return this;
    }

    public void fillInPersonalInformation(Title title, String firstName, String lastName, String email, Calendar dateOfBirth,
                                          boolean isNewsletterChecked, boolean isSpecialOfferChecked) {
        checkTitleRadio(title);
        typeIntoFirstNameField(firstName);
        typeIntoLastNameField(lastName);
        typeIntoEmailField(email);
        selectDateOfBirth(dateOfBirth);
    }

    public void checkTitleRadio(Title title) {
        if(title == Title.MR) {
            titleMrRadio.click();
        } else if(title == Title.MRS) {
            titleMrsRadio.click();
        }
    }

    public void typeIntoFirstNameField(String testedFirstName) {
        firstName.sendKeys(testedFirstName);
        logger.info("Typed into first name field: {}", testedFirstName);
    }

    public void typeIntoLastNameField(String testedLastName) {
        lastName.sendKeys(testedLastName);
        logger.info("Typed into last name field: {}", testedLastName);
    }

    public void typeIntoEmailField(String testedEmail) {
        email.sendKeys(testedEmail);
        logger.info("Typed into email field: {}", testedEmail);
    }

    public void selectDateOfBirth(Calendar testedDateOfBirth) {

        Select day = new Select(dateOfBirthDay);
        day.selectByValue(String.valueOf(testedDateOfBirth.get(Calendar.DAY_OF_MONTH)));

        Select month = new Select(dateOfBirthMonth);
        month.selectByValue(String.valueOf(testedDateOfBirth.get(Calendar.MONTH)));

        Select year = new Select(dateOfBirthYear);
        year.selectByValue(String.valueOf(testedDateOfBirth.get(Calendar.YEAR)));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        logger.info("Selected date in date of birth field: {}", sdf.format(testedDateOfBirth.getTime()));
    }
}
