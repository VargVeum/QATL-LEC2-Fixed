//Комментарии по выполнению:
//
//        1. При определении ОС для подстановки нужного драйвера, проверку имени ОС лучше сделать через метод contains().
//        2. Следует избегать дублирования кода. Шаги с кликом на пункты меню нужно выполнить с помощью цикла
//        3. При проверке нахождения пользователя в том же разделе, название раздела необходимо взять прямо со страницы методом getText()


public class Main {

    public static void main(String[] args) {

//        AdminLoginLogoutTest adminLoginLogoutTest = new AdminLoginLogoutTest();
//        adminLoginLogoutTest.adminLoginLogout();

        WorkWithAdminPanelTest workWithAdminPanelTest = new WorkWithAdminPanelTest();
        workWithAdminPanelTest.workWithAdminPanel();
    }
}
