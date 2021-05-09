package page.objects.registration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import page.objects.BasePage;
import page.objects.login.MyAccountPage;
import waits.WaitForElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class RegistrationFormSecondStepPage extends BasePage {

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

    //Address data

    @FindBy(id = "firstname")
    private WebElement firstNameAddress;

    @FindBy(id = "lastname")
    private WebElement lastNameAddress;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "address2")
    private WebElement addressLine2;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement zipCode;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "other")
    private WebElement additionalInfo;

    @FindBy(id = "phone")
    private WebElement homePhone;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement addressAlias;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;


    public boolean isCreateAnAccountFormDisplayed() {
        waitUntilPageIsLoaded();
        return createAccountForm.isDisplayed();
    }

    public RegistrationFormSecondStepPage waitUntilPageIsLoaded() {
        WaitForElement.waitUntilElementIsVisible(createAccountForm);
        return this;
    }

    public RegistrationFormSecondStepPage fillInPersonalInformation(Title title, String firstName, String lastName, String email, String password, Calendar dateOfBirth,
                                                                    boolean isNewsletterChecked, boolean isSpecialOfferChecked) {
        checkTitleRadio(title);
        typeIntoField(this.firstName, firstName, "first name");
        typeIntoField(this.lastName, lastName, "last name");
        typeIntoField(this.email, email, "email");
        typeIntoField(this.password, password, "password");
        selectDateOfBirth(dateOfBirth);

        return this;
    }

    public RegistrationFormSecondStepPage fillInAddressInformation(String firstNameAddress, String lastNameAddress, String company, String addressLine1, String addressLine2,
                                                                   String city, State state, String zipCode, Country country, String additionalInfo, String homePhone,
                                                                   String mobilePhone, String addressAlias) {
        typeIntoField(this.firstNameAddress, firstNameAddress, "first name");
        typeIntoField(this.lastNameAddress, lastNameAddress, "last name");
        typeIntoField(this.company, company, "company");
        typeIntoField(this.address, addressLine1, "address");
        typeIntoField(this.addressLine2, addressLine2, "address line 2");
        typeIntoField(this.city, city, "city");
        selectState(state);
        typeIntoField(this.zipCode, zipCode, "zip code");
        selectCountry(country);
        typeIntoField(this.additionalInfo, additionalInfo, "additional info");
        typeIntoField(this.homePhone, homePhone, "home phone");
        typeIntoField(this.mobilePhone, mobilePhone, "mobile phone");
        this.addressAlias.clear();
        typeIntoField(this.addressAlias, addressAlias, "address alias");

        return this;
    }

    public void checkTitleRadio(Title title) {
        if(title == Title.MR) {
            titleMrRadio.click();
        } else if(title == Title.MRS) {
            titleMrsRadio.click();
        }
        log().info("Selected title in title field: {}", title.getTitleText());
    }

    public void typeIntoField(WebElement webElement, String content, String description) {
        webElement.sendKeys(content);
        log().info("Typed into {} field: {}", description, content);
    }

    public void selectDateOfBirth(Calendar testedDateOfBirth) {
        Select day = new Select(dateOfBirthDay);
        day.selectByValue(String.valueOf(testedDateOfBirth.get(Calendar.DAY_OF_MONTH)));

        Select month = new Select(dateOfBirthMonth);
        month.selectByValue(String.valueOf(testedDateOfBirth.get(Calendar.MONTH)));

        Select year = new Select(dateOfBirthYear);
        year.selectByValue(String.valueOf(testedDateOfBirth.get(Calendar.YEAR)));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        log().info("Selected date in date of birth field: {}", sdf.format(testedDateOfBirth.getTime()));
    }

    public void selectState(State state) {
        Select stateSelect = new Select(this.state);
        stateSelect.selectByVisibleText(state.getVisibleText());
        log().info("Selected state in state field: {}", state.getVisibleText());
    }

    public void selectCountry(Country country) {
        Select countrySelect = new Select(this.country);
        countrySelect.selectByVisibleText(country.getVisibleText());
        log().info("Selected country in country field: {}", country.getVisibleText());
    }

    public MyAccountPage clickRegisterButton() {
        registerButton.click();
        log().info("Clicked on register button");
        return new MyAccountPage();
    }
}
