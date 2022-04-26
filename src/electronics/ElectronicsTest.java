package electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void textVerified() throws InterruptedException {
        Thread.sleep(1000);
        //1.1 Mouse Hover on “Electronics”Tab
        mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //1.3 Verify the text “Cell phones”
        verifyElements("Error message displayed", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //2.1 Mouse Hover on “Electronics”Tab
        mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //2.3 Verify the text “Cell phones”
        verifyElements("Error message displayed", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));
        //2.4 Click on “List View” tab
        clickOnElement(By.xpath("//a[contains(@class,'viewmode-icon list')]"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        //2.6 Verify the text “Nokia Lumia 1020”
        verifyElements("Error message displayed", "Nokia Lumia 1020", By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        //2.7 Verify the price “$349.00”
        verifyElements("Price error", "$349.00", By.xpath("//div[@class='product-price']/child::span[@id='price-value-20']"));
        //2.8 Change quantity to 2


        //2.9 Click on “ADD TO CART” tab
        mouseHoverAndClick(By.id("add-to-cart-button-20"));
        //2.10
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyElements("Error message", "The product has been added to your shopping cart", By.xpath("//p[contains(text(),'The product has been added to your')]"));
        //closing the bar by clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        //2.11
        //MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverAndClick(By.xpath("//li[@id='topcartlink']"));
        mouseHoverAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.12
        //verify text shopping cart
        verifyElements("Error message displayed", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));

        //2.14 Verify the Total $698.00
        verifyElements("Error message displayed", "$698.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        //2.15
        //click the checkbox of terms & conditions
        clickOnElement(By.id("termsofservice"));
        //2.16
        //click on checkout
        mouseHoverAndClick(By.id("checkout"));
        //2.17
        //Verify the given text “Welcome, Please Sign In!”
        verifyElements("Error message displayed", "Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //2.18 Click on “REGISTER” tab
        mouseHoverAndClick(By.xpath("//button[contains(text(),'Register')]"));
        //2.19
        // Verify the given text “Register”
        verifyElements("Registration unsuccessful", "Register",By.xpath("//h1[contains(text(),'Register')]"));
        //2.20
        //Finding the email field element
        sendTextToElement(By.id("Email"), "alpha789@gmail.com");
        //Finding the password field element
        sendTextToElement(By.name("Password"), "Abc8909");
        //Finding the confirm password field element
        sendTextToElement(By.name("ConfirmPassword"), "Abc8909");
        //2.21
        //Finding the register button and clicking on it
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //2.22 Verify the message “Your registration completed”
        verifyElements("Registration unsuccessful", "Your registration completed", By.xpath("//div[contains(text(),'Your registration completed')]"));
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        //2.24 verify  the given text 'Shopping cart'
        verifyElements("Error message displayed", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        //2.27 Fill the Mandatory fields
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "11 Grant Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "WD24 4DX");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "02087967890");
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));
        //2.30 Click on “CONTINUE”
        mouseHoverAndClick(By.xpath("//button[@onclick='ShippingMethod.save()']"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        //2.31 Click on “CONTINUE”
        mouseHoverAndClick(By.xpath("//button[@onclick='PaymentMethod.save()']"));
        //2.32 Select “visa” From Select credit card dropdown
        selectByValueFromDropDown(By.id("CreditCardType"), "visa");
        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Alpa Popat");
        sendTextToElement(By.id("CardNumber"), "6789 5467 8907 3409");
        selectByValueFromDropDown(By.id("ExpireMonth"), "11");
        selectByValueFromDropDown(By.id("ExpireYear"), "2023");
        sendTextToElement(By.id("CardCode"), "617");
        //2.34 Click on “CONTINUE”CHECKOUT”
        mouseHoverAndClick(By.xpath("//button[@onclick='PaymentInfo.save()']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyElements("Error message displayed", "Payment Method:", By.xpath("//span[contains(text(),'Payment Method:')]"));
        verifyElements("Error message displayed", "Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyElements("Error message displayed", "Shipping Method:", By.xpath("//span[contains(text(),'Shipping Method:')]"));
        verifyElements("Error message displayed", "2nd Day Air", By.xpath("//span[contains(.,'2nd Day Air')]"));
        //2.37 Verify $698.00
        verifyElements("Error message displayed", "$698.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        //2.38 Click on “confirm”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank You”
        verifyElements("Error message displayed", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
        //2.40 Verify the message “Your order has been successfully processed!”
        verifyElements("Error message displayed", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        verifyElements("Error message displayed", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String URL = driver.getCurrentUrl();
        verifyElements("Error message displayed","https://demo.nopcommerce.com/",By.xpath("//body/div[6]/div[1]/div[2]/div[1]/a[1]/img[1]"));
    }
    @After
    public void tearDown() {
         closeBrowser();
    }
}

