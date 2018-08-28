import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class test {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=getInitFirefoxDriver();

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");
        Sleep1();
        By.id("email").findElement(driver).sendKeys("webinar.test@gmail.com");
        Sleep1();
        By.id("passwd").findElement(driver).sendKeys("Xcg7299bnSmMuRLp9ITw");
        Sleep1();
        WebElement button=driver.findElement(By.name("submitLogin"));
        Sleep1();
        button.click();
        WebElement icon=driver.findElement(By.className("employee_avatar_small"));
        icon.click();
        Sleep1();
        WebElement button1=driver.findElement(By.id("header_logout"));
        button1.click();
        Sleep1();
        driver.quit();
    }




    public static WebDriver getInitFirefoxDriver(){


        System.setProperty("webdriver.gecko.driver",test.class.getResource("geckodriver.exe").getPath());
    return new FirefoxDriver();

    }

public static void  Sleep1() throws InterruptedException {

        sleep(4000);

    }


}
