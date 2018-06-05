import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BaseTest {
  protected static WebDriver driver;

  public BaseTest() {
    initChromeDriver();
  }

  public void initChromeDriver() {
    System.setProperty("webdriver.chrome.driver", BaseTest.class.getResource(getDriverFileName()).getPath());
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  private String getDriverFileName() {
    String osType = System.getProperty("os.name");

    osType = osType.toLowerCase(Locale.ENGLISH);
    if (osType.contains("Linux"))
      return "chromedriver";
    if (osType.contains("Windows"))
      return "chromedriver.exe";
    return "chromedriver";

  }


  public void closeChromeDriver() {
    driver.close();
  }

  public void openAdminURL() {
    driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
  }

  public void clickToLogoutButton() {
    WebElement logoutButton = driver.findElement(By.id("header_logout"));
    logoutButton.click();
  }

  public void clickToHeaderMenu() {
    WebElement userMenu = driver.findElement(By.id("header_employee_box"));
    userMenu.click();
  }

  public void clickLoginButton() {
    WebElement loginButton = driver.findElement(By.name("submitLogin"));
    loginButton.click();
  }

  public void enterPassword() {
    WebElement passwordField = driver.findElement(By.id("passwd"));
    passwordField.sendKeys("Xcg7299bnSmMuRLp9ITw");
  }

  public void enterLogin() {
    WebElement loginField = driver.findElement(By.id("email"));
    loginField.sendKeys("webinar.test@gmail.com");
  }

  public void waitForElementsCount(By locator, int amount){
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.numberOfElementsToBe(locator, amount));
  }
}
