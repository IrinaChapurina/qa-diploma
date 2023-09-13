package ru.netology.tests.ui;

import org.junit.jupiter.api.*;
import ru.netology.helpers.DataHelper;
import ru.netology.pages.CreditCheckoutPage;
import ru.netology.pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditPositiveTests extends BaseUITest {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Отправка формы покупки тура в кредит с принимаемой картой на текущий месяц, " +
            "текущий год и валидными данными для оставшихся полей")
    void testSuccessfulCreditCardPurchaseTourValidExpireDate() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.approvedCardFormData());
        creditCheckoutPage.successNotification();
        assertEquals("APPROVED", DataHelper.getCreditOperationStatus());
    }

    @Test
    @DisplayName("Отправка формы покупки тура в кредит с принимаемой картой на текущий месяц плюс один месяц," +
            " текущий год и валидными данными для оставшихся полей")
    void testSuccessfulCreditCardPurchaseTourNextMonthCurrentYear() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.approvedCardFormDataWithApprovedNextMonth());
        creditCheckoutPage.successNotification();
        assertEquals("APPROVED", DataHelper.getCreditOperationStatus());
    }

    @Test
    @DisplayName("Отправка формы покупки тура в кредит с принимаемой картой на текущий месяц," +
            " текущий год плюс один год и валидными данными для оставшихся полей")
    void testSuccessfulCreditCardPurchaseTourCurrentMonthNextYear() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.approvedCardFormDataWithApprovedNextYear());
        creditCheckoutPage.successNotification();
        assertEquals("APPROVED", DataHelper.getCreditOperationStatus());
    }

}
