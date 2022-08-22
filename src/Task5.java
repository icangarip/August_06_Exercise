import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Task5 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Can\\Documents\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebookAdd = driver.findElement(By.xpath("//div[2]//a[1]//div[1]//div[2]//button[1]"));
        ebookAdd.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(iFrame1));
        driver.switchTo().frame(iFrame1);

        WebElement payUsingDebitCC = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        payUsingDebitCC.click();

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("can@can.com");

        WebElement confirmEmail = driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirmEmail.sendKeys("can@can.com");

        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        name.sendKeys("CCC");

        WebElement phone = driver.findElement(By.xpath("//p[@class='Billing-Phone Inline']//input[@placeholder='Optional']"));
        phone.sendKeys("123456789");

        WebElement company = driver.findElement(By.xpath("//p[@class='Billing-Company']//input[@placeholder='Optional']"));
        company.sendKeys("CCC LLC");

        WebElement iFrameCard = driver.findElement(By.xpath("//*[@id='Stripe-Element']/div/iframe"));
        wait.until(ExpectedConditions.visibilityOf(iFrameCard));
        driver.switchTo().frame(iFrameCard);

        WebElement ccNumber = driver.findElement(By.xpath("//input[@placeholder='Card number']"));
        ccNumber.sendKeys("4242 4242 4242 4242");

        WebElement mmYY = driver.findElement(By.xpath("//input[@placeholder='MM / YY']"));
        mmYY.sendKeys("12/22");

        WebElement cvc = driver.findElement(By.xpath("//input[@placeholder='CVC']"));
        cvc.sendKeys("000");

        driver.switchTo().parentFrame();


        WebElement payButton = driver.findElement(By.xpath("//button[normalize-space()='Pay 0.50 USD']"));
        payButton.click();


        //driver.switchTo().defaultContent();

        WebElement greenText = driver.findElement(By.xpath("//span[@class='green_text_margin']"));
        String gt = greenText.getText();

        System.out.println(gt);

        // //span[@class='green_text_margin']
    }
}
