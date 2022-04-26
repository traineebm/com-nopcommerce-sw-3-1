package computer;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.awt.*;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void name() throws InterruptedException {
        Thread.sleep(1000);
        mouseHover(By.linkText("Computers"));
        mouseHoverAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

        selectByValueFromDropDown(By.id("products-orderby"),"10");

        // Verify the given products will arrange in 'Low to High' order.
        verifyElements("Error messaged displayed","Price: Low to High",By.xpath("//option[contains(text(),'Price: Low to High')]"));
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //2.1 Click on Computer Menu
        clickOnElement(By.linkText("Computers"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.name("products-orderby"),"Name: A to Z");
        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //2.5 Verify the Text "Build your own computer"
        verifyElements("Error message displayed","Build your own computer",By.xpath("//h1[contains(text(),'Build your own computer')]"));
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"),"8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(500);
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander A[+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
        //2.11 Verify the price "$1,475.00"
        verifyElements("Error message displayed","$1,475.00",By.xpath("//span[@class='price-value-1']"));
        //2.12 Click on "ADD TO CARD" Button
        clickOnElement(By.id("add-to-cart-button-1"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyElements("Error message displayed","The product has been added to your shopping cart",By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(500);
        mouseHover(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        //2.15 Verify the message "Shopping cart"
        verifyElements("error","Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //2.16

        //2.17 Verify the Total"$2,950.00"
        verifyElements("Error message displayed","$2,950.00",By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyElements("Error message displayed","Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //2.21Click on “CHECKOUT AS GUEST”Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"),"Alpa");
        sendTextToElement(By.id("BillingNewAddress_LastName"),"Popat");
        sendTextToElement(By.id("BillingNewAddress_Email"),"alpha789@gmail.com");
        sendTextToElement(By.id("BillingNewAddress_Company"),"Prime Ltd");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"),"London");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"11 Grant Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"WD24 4DX");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"02087967890");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        clickOnElement(By.id("shippingoption_1"));
        clickOnElement(By.xpath("(//button[@class='button-1 shipping-method-next-step-button'])[1]"));
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Master card");
        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"),"Alpa Popat");
        sendTextToElement(By.id("CardNumber"),"6789 5467 8907 3409");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"11");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2023");
        sendTextToElement(By.id("CardCode"),"617");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("(//button[@class='button-1 payment-info-next-step-button'])[1]"));
        verifyElements("Error message displayed","Payment Method:",By.xpath("//span[contains(text(),'Payment Method:')]"));
        //2.30 Verify “Payment Method” is “Credit Card”
        verifyElements("Error message displayed","Credit Card",By.xpath("//span[contains(text(),'Credit Card')]"));
        //2.31 Verify “Shipping Method” is “Next Day Air”
        verifyElements("Error message displayed","Shipping Method:",By.xpath("//span[contains(text(),'Shipping Method:')]"));
        verifyElements("Error message displayed","Next Day Air",By.xpath("//span[contains(text(),'Next Day Air')]"));
        //2.32 Verify Total is “$2,950.00
        verifyElements("Error message displayed","$2,950.00",By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        //2.33 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.34 Verify the Text “Thank You”
        verifyElements("Error message displayed","Thank you",By.xpath("//h1[contains(text(),'Thank you')]"));
        //2.35 Verify the message “Your order has been successfully processed!”
        verifyElements("Error message displayed","Your order has been successfully processed!",By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        //2.36 Click on "Continue"
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        verifyElements("Error message displayed","Welcome to our store",By.xpath("//h2[contains(text(),'Welcome to our store')]\n"));

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
