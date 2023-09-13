package ru.netology.tests.ui;

import org.junit.jupiter.api.*;
import ru.netology.helpers.DataHelper;
import ru.netology.pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardPositiveTests extends BaseUITest {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Отправка формы покупки тура с принимаемой картой на текущий месяц, " +
            "текущий год и валидными данными для оставшихся полей")
    void testSuccessfulCardPurchaseTourValidExpireDate() {
        mainPage.buyTourViaCard();
        CardCheckoutPage cardCheckoutPage = new CardCheckoutPage();
        cardCheckoutPage.buyThroughCard(DataHelper.approvedCardFormData());
        cardCheckoutPage.successNotification();
        assertEquals("APPROVED", DataHelper.getBuyingOperationStatus());
    }

    @Test
    @DisplayName("Отправка формы покупки тура с принимаемой картой на текущий" +
            " месяц плюс один месяц, текущий год и валидными данными для оставшихся полей")
    void testSuccessfulCardPurchaseTourNextMonthCurrentYear() {
        mainPage.buyTourViaCard();
        CardCheckoutPage cardCheckoutPage = new CardCheckoutPage();
        cardCheckoutPage.buyThroughCard(DataHelper.approvedCardFormDataWithApprovedNextMonth());
        cardCheckoutPage.successNotification();
        assertEquals("APPROVED", DataHelper.getBuyingOperationStatus());
    }

    @Test
    @DisplayName("Отправка формы покупки тура с принимаемой картой на текущий месяц," +
            " текущий год плюс один год и валидными данными для оставшихся полей")
    void testSuccessfulCardPurchaseTourCurrentMonthNextYear() {
        mainPage.buyTourViaCard();
        CardCheckoutPage cardCheckoutPage = new CardCheckoutPage();
        cardCheckoutPage.buyThroughCard(DataHelper.approvedCardFormDataWithApprovedNextYear());
        cardCheckoutPage.successNotification();
        assertEquals("APPROVED", DataHelper.getBuyingOperationStatus());
    }

}