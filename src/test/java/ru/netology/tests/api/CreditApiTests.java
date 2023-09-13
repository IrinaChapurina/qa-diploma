package ru.netology.tests.api;

import org.junit.jupiter.api.*;
import ru.netology.helpers.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditApiTests extends BaseApiTest {

    @Test
    @DisplayName("Успешная оплата тура в кредит принимаемой кредитной картой с валидными данными формы")
    void testCardTourPurchaseApprovedCard() {
        RestRequestHelper.sendRequest(DataHelper.approvedCardFormData(), creditOperationPath);
        assertEquals("APPROVED", DataHelper.getCreditOperationStatus());
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит непринимаемой картой")
    void testCardTourPurchaseDeclinedCard() {
        RestRequestHelper.sendRequest(DataHelper.declinedCardFormData(), creditOperationPath);
        assertEquals("DECLINED", DataHelper.getCreditOperationStatus());
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит с номером карты в 1 символ")
    void testCardTourPurchaseSendErrorForSingleCharacterCardNumber() {
        RestRequestHelper.sendBadRequest(DataHelper.oneCharacterCardNumberFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с неверным двузначным форматом 'месяц'")
    void testCardTourPurchaseSendErrorForWrongFormatCardMonth() {
        RestRequestHelper.sendBadRequest(DataHelper.wrongCardMonthFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с трехзначным форматом параметра 'год'")
    void testCardTourPurchaseSendErrorForWrongFormatCardYear() {
        RestRequestHelper.sendBadRequest(DataHelper.wrongCardYearFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит  валидной картой с истекшим параметром 'год'")
    void testCardTourPurchaseSendErrorForExpiredCardYear() {
        RestRequestHelper.sendBadRequest(DataHelper.approvedCardFormDataWithApprovedPreviousYear(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит  с именем владельца из одного слова")
    void testCardTourPurchaseSendErrorForWrongFormatCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.wrongCardHolderFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит  именем владельца карты на кириллице")
    void testCardTourPurchaseSendErrorForCyrillicCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.cyrillicCardHolderFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит  с именем владельца карты цифрами")
    void testCardTourPurchaseErrorForNumbersCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.numbersCardHolderFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит  с именем владельца карты в один символ")
    void testCardTourPurchaseErrorForOneCharacterCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.oneCharacterCardHolderFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит  с именем владельца карты с спец символом")
    void testCardTourPurchaseSpecSymbolsCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.specSymbolsCardHolderFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит с CVV карты в один символ")
    void testCardTourPurchaseErrorForOneCharacterCardCode() {
        RestRequestHelper.sendBadRequest(DataHelper.oneCharacterCardCodeFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке тур в кредит картой с пустым номером карты")
    void testCardTourPurchaseErrorForEmptyCardNumber() {
        RestRequestHelper.sendBadRequest(DataHelper.emptyCardNumberFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с пустым полем 'месяц'")
    void testCardTourPurchaseErrorForEmptyCardMonth() {
        RestRequestHelper.sendBadRequest(DataHelper.emptyUnknownCardMonthFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с пустым полем 'год'")
    void testCardTourPurchaseErrorForEmptyCardYear() {
        RestRequestHelper.sendBadRequest(DataHelper.emptyUnknownCardYearFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с пустым полем 'владелец'")
    void testCardTourPurchaseErrorForEmptyCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.emptyCardHolderFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с пустым полем 'CVV'")
    void testCardTourPurchaseErrorForEmptyCardCode() {
        RestRequestHelper.sendBadRequest(DataHelper.emptyCardCodeFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой c 00 в поле 'месяц'")
    void testCardTourPurchaseErrorForDoubleZeroMonth() {
        RestRequestHelper.sendBadRequest(DataHelper.doubleZeroMonthFormData(), creditOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой c 00 в поле 'год'")
    void testCardTourPurchaseErrorForDoubleZeroYear() {
        RestRequestHelper.sendBadRequest(DataHelper.doubleZeroYearFormData(), creditOperationPath);
    }

}
