//Скрипт Б. Проверка работоспособности главного меню Админ панели
//        1. Войти в Админ панель (по аналогии с предыдущим скриптом)
//        2. Кликнуть на каждом видимом пункте главного меню (Dashboard, Заказы, Каталог, Клиенты...) для открытия соответствующего раздела и выполнить следующее:
//        a. Вывести в консоль заголовок открытого раздела.
//        b. Выполнить обновление (рефреш) страницы и проверить, что пользователь остается в том же разделе после перезагрузки страницы.

//Для доступа в Админ Панель используйте следующие данные:
//        Адрес: http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/
//        Логин: webinar.test@gmail.com
//        Пароль: Xcg7299bnSmMuRLp9ITw

import org.openqa.selenium.By;
import org.testng.Assert;

public class WorkWithAdminPanelTest extends BaseTest {
  private By menuItemLocator = By.cssSelector("ul.menu>li>a");
  private By menuItemWithBugLocator = By.cssSelector("ul.main-menu>li>a");
  private By pageTitleLocator = By.cssSelector("h2");

  public void workWithAdminPanel() {
    openAdminURL();
    //login
    enterLogin();
    enterPassword();
    clickLoginButton();

    int amount = driver.findElements(menuItemLocator).size();
    for(int i = 0; i < amount; i++) {
      // только для пункта меню Каталог и Modules - они с багом отображения подменю и у них другой html-код страницы
      if (i == 3 || i==7) {
        waitForElementsCount(menuItemWithBugLocator, amount);
        checkMenuItem(i, menuItemWithBugLocator);
      }
      // Для всех остальных пунктов
      else {
        waitForElementsCount(menuItemLocator, amount);
        checkMenuItem(i, menuItemLocator);
      }
    }
    closeChromeDriver();
  }

  private void checkMenuItem(int itemIndex, By menuItemLocator) {
    driver.findElements(menuItemLocator).get(itemIndex).click();
    String expectedTitle = getPageTitle();
    System.out.println(expectedTitle);
    driver.navigate().refresh();
    Assert.assertEquals(getPageTitle(), expectedTitle);
  }

  private String getPageTitle(){
    return driver.findElement(pageTitleLocator).getText();
  }
}
