import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        URL resource = Main.class.getResource("resources/drivers/chromedriver.exe");
        File f = new File("Driver");
        if (!f.exists()) {
            f.mkdirs();
        }
        File chromeDriver = new File("Driver" + File.separator + "chromedriver.exe");
        if (!chromeDriver.exists()) {
            try {
                chromeDriver.createNewFile();
                org.apache.commons.io.FileUtils.copyURLToFile(resource, chromeDriver);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(resource);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        Thread.sleep(500);
        WebDriver driver = new ChromeDriver();
        driver.get("https:\\gmail.com");
        WebElement email = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        email.sendKeys("automatestingFrost@gmail.com", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10L);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("123456*Qa", Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"T-I T-I-KE L3\"]")));
        WebElement write = driver.findElement(By.xpath("//div[@class=\"T-I T-I-KE L3\"]"));
        write.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@name=\"to\"]")));
        WebElement emailWrite = driver.findElement(By.xpath("//textarea[@name=\"to\"]"));
        emailWrite.sendKeys("testfrost7@gmail.com");
        WebElement themeWrite = driver.findElement(By.xpath("//input[@name=\"subjectbox\"]"));
        themeWrite.sendKeys("Definitely not a test");
        WebElement textWrite = driver.findElement(By.xpath("//div[@aria-multiline=\"true\"]"));
        textWrite.sendKeys("Hello world" + Keys.LEFT_CONTROL + Keys.ENTER);
        Thread.sleep(15000);
        driver.quit();
    }
}
