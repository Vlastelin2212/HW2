import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class test2 {

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

        String[] Ids = {"tab-AdminDashboard", "subtab-AdminParentOrders", "subtab-AdminParentCustomer",
                "subtab-AdminParentCustomerThreads", "subtab-AdminStats", "subtab-AdminParentThemes",
                "subtab-AdminParentShipping", "subtab-AdminParentPayment", "subtab-AdminInternational",
                "subtab-ShopParameters", "subtab-AdminAdvancedParameters"};

        for (String Id: Ids){
            Sleep1();
            WebElement item = driver.findElement(By.id(Id));
            item.click();
            Sleep1();
            item = driver.findElement(By.id(Id));
            System.out.println(item.getText());
            driver.navigate().refresh();
            Sleep1();
            item = driver.findElement(By.id(Id));
            if (hasClass(item)){
                System.out.println("OK");
            }
            Sleep1();
        }
        driver.quit();
    }

    public static boolean hasClass(WebElement element) {
        String classes = element.getAttribute("class");
        for (String c : classes.split(" ")) {
            if (c.equals("active")) {
                return true;
            }
        }
        return false;
    }

    public static WebDriver getInitFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver",test.class.getResource("geckodriver.exe").getPath());
        return new FirefoxDriver();
    }

    public static void  Sleep1() throws InterruptedException {
        sleep(4000);
    }
}
