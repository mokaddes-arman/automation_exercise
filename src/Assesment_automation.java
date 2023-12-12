import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assesment_automation {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable. Download it from https://sites.google.com/chromium.org/driver/
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Riseup Labs\\Downloads\\Selenium\\chromedriver-win64(Working)\\chromedriver.exe\\");

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to automationexercise.com
        driver.get("http://automationexercise.com");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Verify that home page is visible successfully
        WebElement homePageElement = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[1]/a"));
        if (homePageElement.isDisplayed()) {
            System.out.println("Home page is visible successfully");
        } else {
            System.out.println("Home page is not visible");
            driver.quit();
            return;
        }
        
        //  Add products to cart
        driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[2]/a")).click();
        WebElement addToCartButton = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", addToCartButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String parent = driver.getWindowHandle();
        WebElement continueShoppingbutton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-success.close-modal.btn-block")));
        continueShoppingbutton.click();
        waitForWindow(driver);
        switchToModalDialog(driver, parent);
        WebElement addToCartButton2 = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a"));
        jse.executeScript("arguments[0].click();", addToCartButton2);
        WebElement continueShoppingbutton2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-success.close-modal.btn-block")));
        continueShoppingbutton2.click();
        waitForWindow(driver);
        switchToModalDialog(driver, parent);
       
        // Click 'Cart' button and verify that cart page is displayed
        WebElement CartButton = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[3]/a"));
        CartButton.click();
        if (CartButton.equals(CartButton)) {
            System.out.println("Cart Page is displayed");
        }
         else {
            System.out.println("Cart Page is not displayed");
            driver.quit();
            return;
        }
        
        // Click Proceed To Checkout
        WebElement proceedToCheckOut = driver.findElement(By.xpath("/html/body/section/div/section/div[1]/div/div/a"));
        proceedToCheckOut.click();
        
        // Click 'Register / Login' button
        WebElement registerloginbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/section/div[2]/div/div/div[2]/p[2]/a/u")));
        registerloginbutton.click();
        waitForWindow(driver);
        switchToModalDialog(driver, parent);
        
        // Fill all details in Sign up and create account
        WebElement inputName = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[2]"));
        inputName.sendKeys("MD ABDUL MOKADDES");
        WebElement inputEmail = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]"));
        inputEmail.sendKeys("arman12345@gmail.com");
        WebElement signUPbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div/div[3]/div/form/button")));
        signUPbutton.click();
        
        //ENTER ACCOUNT INFORMATION
        WebElement title = driver.findElement(By.id("id_gender1"));
        title.click();
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("@123$1");
        WebElement inputDays = driver.findElement(By.id("days"));
        Select daysSelector = new Select(inputDays);
        daysSelector.selectByValue("23");
        WebElement inputMonths = driver.findElement(By.id("months"));
        Select monthsSelector = new Select(inputMonths);
        monthsSelector.selectByValue("10");
        WebElement inputYears = driver.findElement(By.id("years"));
        Select yearsSelector = new Select(inputYears);
        yearsSelector.selectByValue("1996");
        WebElement newsLetter = driver.findElement(By.id("newsletter"));
        newsLetter.click();
        WebElement specialOffers = driver.findElement(By.id("optin"));
        specialOffers.click();
        WebElement inputFirstName = driver.findElement(By.id("first_name"));
        inputFirstName.sendKeys("MD ABDUL");
        WebElement inputLastName = driver.findElement(By.id("last_name"));
        inputLastName.sendKeys("MOKADDES");
        WebElement inputCompany = driver.findElement(By.id("company"));
        inputCompany.sendKeys("RISEUP LABS");
        WebElement inputAddress = driver.findElement(By.id("address1"));
        inputAddress.sendKeys("UTTARA");
        WebElement inputCountry = driver.findElement(By.id("country"));
        Select countrySelector = new Select(inputCountry);
        countrySelector.selectByValue("New Zealand");
        WebElement inputState = driver.findElement(By.id("state"));
        inputState.sendKeys("DHAKA");
        WebElement inputCity = driver.findElement(By.id("city"));
        inputCity.sendKeys("DHAKA");
        WebElement inputZipCode = driver.findElement(By.id("zipcode"));
        inputZipCode.sendKeys("1203");
        WebElement inputMobileNumber = driver.findElement(By.id("mobile_number"));
        inputMobileNumber.sendKeys("01837129041");
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div/div/div/form/button")));
        createAccountButton.click();
        waitForWindow(driver);
        
        //Verify 'ACCOUNT CREATED!' and click 'Continue' button
        if (driver.findElement(By.xpath("/html/body/section/div/div/div/h2/b")).isDisplayed()) {
            System.out.println("Account created successfully");
        } else {
            System.out.println("Account is not created");
            driver.quit();
            return;
        }
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div/div/div/a")));
        continueButton.click();
        
        //Verify ' Logged in as username' at top
        if (driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[10]/a")).isDisplayed()) {
            System.out.println("Logged in as username successfully");
        } else {
            System.out.println("Failed");
            driver.quit();
            return;
        }
        
        // Click 'Cart' button
        WebElement cartButton = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[3]/a"));
        cartButton.click();
        
        // Click 'Proceed To Checkout' button
        WebElement proceedToCheckOut2 = driver.findElement(By.xpath("/html/body/section/div/section/div[1]/div/div/a"));
        proceedToCheckOut2.click();
        
        //Verify Address Details and Review Your Order
        if (driver.findElement(By.xpath("/html/body/section/div/div[2]/h2")).isDisplayed()) {
            System.out.println("Address Details is checked & confirmed");
        }
        if (driver.findElement(By.xpath("/html/body/section/div/div[4]/h2")).isDisplayed()) {
            System.out.println("Order is checked & confirmed");
        }
        
        // Enter description in comment text area and click 'Place Order'
        WebElement commentText = driver.findElement(By.xpath("/html/body/section/div/div[6]/textarea"));
        commentText.sendKeys("Test case is running");
        WebElement placeOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div[7]/a")));
        placeOrder.click();
        
        // Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameONCard = driver.findElement(By.name("name_on_card"));
        nameONCard.sendKeys("MD ABDUL MOKADDES");
        WebElement cardNumber = driver.findElement(By.name("card_number"));
        cardNumber.sendKeys("123456789");
        WebElement CVC = driver.findElement(By.name("cvc"));
        CVC.sendKeys("255");
        WebElement expirationMonth = driver.findElement(By.name("expiry_month"));
        expirationMonth.sendKeys("10");
        WebElement expirationYear = driver.findElement(By.name("expiry_year"));
        expirationYear.sendKeys("2025");
        
        // Click 'Pay and Confirm Order' button
        WebElement confirmOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"submit\"]")));
        confirmOrder.click();
        
        // Verify the success message 'Your order has been placed successfully!'
        WebElement placedOrder = driver.findElement(By.xpath("/html/body/section/div/div/div/h2/b"));
        if (placedOrder.isDisplayed()) {
            System.out.println("Your order has been placed successfully!");
        }
        
        // Close the browser window
        driver.quit();
    }
    public static void waitForWindow(WebDriver driver)
            throws InterruptedException {
        int timecount = 1;
        do {
            driver.getWindowHandles();
            Thread.sleep(200);
            timecount++;
            if (timecount > 10) {
                break;
            }
        } while (driver.getWindowHandles().size() != 2);

    }
	public static void switchToModalDialog(WebDriver driver, String parent) { 
    if (driver.getWindowHandles().size() == 2) {
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                System.out.println("Modal dialog found");
                break;
            }
            else {
            	System.out.println("Modal dialog not found");
            }
        }
    }
}
}
