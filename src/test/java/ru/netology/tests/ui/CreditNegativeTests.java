package ru.netology.tests.ui;

import org.junit.jupiter.api.*;
import ru.netology.helpers.DataHelper;
import ru.netology.pages.CreditCheckoutPage;
import ru.netology.pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditNegativeTests  extends BaseUITest {

    MainPage mainPage = new MainPage();

    private final String subMessageWrongDataFormat = "Неверный формат";
    private final String subMessageWrongDate = "Неверно указан срок действия карты";
    private final String subMessageEmptyData = "Поле обязательно для заполнения";
    private final String subMessageExpiredDate = "Истёк срок действия карты";

    @Test
    @DisplayName("Отправка формы покупки тура с пустым полем номера карты и валидными данными")
    void testFailedCreditPurchaseTourEmptyCardNumber() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.emptyCardNumberFormData());
        creditCheckoutPage.cardNumberFieldSubMessage(subMessageWrongDataFormat);
    }

    @Test
    @DisplayName("Отправка формы покупки тура с принимаемой картой и пустым полем “месяц” " +
            " и оставшимися валидными данными для полей")
    void testFailedValidCreditPurchaseTourValidCardEmptyMonth() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.emptyCardMonthFormData());
        creditCheckoutPage.cardMonthFieldSubMessage(subMessageWrongDataFormat);
    }

    @Test
    @DisplayName("Отправка формы покупки тура с принимаемой картой и пустым полем “год”" +
            " и оставшимися валидными данными для полей")
    void testFailedValidCreditPurchaseTourValidCardEmptyYear() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.emptyCardYearFormData());
        creditCheckoutPage.cardYearFieldSubMessage(subMessageWrongDataFormat);
    }

    @Test
    @DisplayName("Отправка формы покупки тура с принимаемой картой и пустым полем “Владелец”" +
            " и оставшимися валидными данными для полей")
    void testFailedValidCreditPurchaseTourValidCardEmptyHolder() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.emptyCardHolderFormData());
        creditCheckoutPage.cardHolderFieldSubMessage(subMessageEmptyData);
    }

    @Test
    @DisplayName("Отправка формы покупки тура с принимаемой картой и пустым полем “CVV/CVS”" +
            " и оставшимися валидными данными для полей")
    void testFailedValidCreditPurchaseTourValidCardEmptyCVV() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.emptyCardCodeFormData());
        creditCheckoutPage.cardCodeFieldSubMessage(subMessageWrongDataFormat); //todo: тут баг, подсвечивается поле с кардхолдером, как пустое
    }

    @Test
    @DisplayName("Отправка пустой формы покупки тура с принимаемой картой")
    void testFailedSendEmptyCreditDataFields() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.sendEmptyCreditForm();
        creditCheckoutPage.cardNumberFieldSubMessage(subMessageWrongDataFormat);
        creditCheckoutPage.cardMonthFieldSubMessage(subMessageWrongDataFormat);
        creditCheckoutPage.cardYearFieldSubMessage(subMessageWrongDataFormat);
        creditCheckoutPage.cardHolderFieldSubMessage(subMessageEmptyData);
        creditCheckoutPage.cardCodeFieldSubMessage(subMessageWrongDataFormat);
    }

    @Test
    @DisplayName("Отправка формы покупки тура со случайными числами в поле “номер карты”" +
            " и оставшимися валидными данными для полей")
    void testFailedCreditPurchaseViaUnknownCard() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.wrongCardHolderFormData());
        creditCheckoutPage.cardHolderFieldSubMessage(subMessageWrongDataFormat);
    }

    @Test
    @DisplayName("Отправка формы покупки тура с вводом в поле “год” невалидного значения " +
            "равного предшествующему году от текущего года и оставшимися валидными данными для полей")
    void testFailedCreditPurchaseInvalidExpireDate() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.expiredCardYearFormData());
        creditCheckoutPage.cardYearFieldSubMessage(subMessageExpiredDate);
    }

    @Test
    @DisplayName("Отправка формы покупки тура с вводом в поле “месяц”" +
            " невалидных значений месяцев в один символ и оставшимися валидными данными для полей")
    void testFailedCreditPurchaseOneCharMonthDataFormat() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.oneCharacterMonthNumberFormData());
        creditCheckoutPage.cardMonthFieldSubMessage(subMessageWrongDataFormat);
    }

    @Test
    @DisplayName("Отправка формы покупки тура с вводом в поле “месяц” невалидного" +
            "значения из двух нулей и оставшимися валидными данными для полей")
    void testFailedCreditPurchaseInvalidMonthDoubleZeroDataFormat() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.approvedCardFormDataWithDoubleZeroMonth());
        creditCheckoutPage.cardMonthFieldSubMessage(subMessageWrongDataFormat); //todo: тут баг, с двумя 00 удается купить
    }

    @Test
    @DisplayName("Отправка формы покупки тура с вводом в поле “месяц”" +
            "несуществующего значения месяца и оставшимися валидными данными для полей")
    void testFailedCreditPurchaseMonthDataFormat() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.wrongCardMonthFormData());
        creditCheckoutPage.cardMonthFieldSubMessage(subMessageWrongDate);
    }


    @Test
    @DisplayName("Отправка формы покупки тура в кредит с принимаемой картой" +
            "на текущий месяц (currentMonth - 1) и текущий год (currentYear) и валидными данными для оставшихся полей")
    void testSuccessfulCreditCardPurchaseTourPreviousMonthCurrentYear() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.approvedCardFormDataWithPreviousMonth());
        creditCheckoutPage.successNotification();
        assertEquals("APPROVED", DataHelper.getCreditOperationStatus());
    }

    @Test
    @DisplayName("Отправка формы покупки в кредит тура с принимаемой картой" +
            "на текущий месяц (currentMonth) и текущий год (currentYear - 1) и валидными данными для оставшихся полей")
    void testFailedCreditCardPurchaseTourCurrentMonthPreviousYear() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.approvedCardFormDataWithApprovedPreviousYear());
        creditCheckoutPage.cardYearFieldSubMessage(subMessageExpiredDate);
    }

    @Test
    @DisplayName("Отправка формы покупки тура в кредит с отклоненным номером карты и валидными данными формы")
    void testFailedCreditCardPurchaseDeclinedCardValidFormData() {
        mainPage.buyTourViaCreditCard();
        CreditCheckoutPage creditCheckoutPage = new CreditCheckoutPage();
        creditCheckoutPage.buyThroughCredit(DataHelper.declinedCardFormData());
        creditCheckoutPage.errorNotification(); //todo: тест логически правильный, тут баг
        assertEquals("DECLINED", DataHelper.getCreditOperationStatus());
    }

}
