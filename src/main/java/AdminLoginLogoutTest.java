//Скрипт А. Логин в Админ панель
//        1. Открыть страницу Админ панели
//        2. Ввести логин, пароль и нажать кнопку Логин.
//        3. После входа в систему нажать на пиктограмме пользователя в верхнем правом углу и выбрать опцию «Выход.»

//Для доступа в Админ Панель используйте следующие данные:
//        Адрес: http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/
//        Логин: webinar.test@gmail.com
//        Пароль: Xcg7299bnSmMuRLp9ITw

public class AdminLoginLogoutTest extends BaseTest {

  public void adminLoginLogout() {
    openAdminURL();
    //login
    enterLogin();
    enterPassword();
    clickLoginButton();
    //logout
    clickToHeaderMenu();
    clickToLogoutButton();

    closeChromeDriver();
  }
}




