package ru.netology.tests.api;

import org.junit.jupiter.api.*;
import ru.netology.helpers.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditApiTests extends BaseApiTest {

    @Test
    @DisplayName("Успешная оплата тура в кредит принимаемой кредитной картой с валидными данными формы")
    void testCardTourPurchaseApprovedCard() {
        RestRequestHelper.sendRequest(DataHelper.approvedCardFormData(), creditOperationPath, 200);
        assertEquals("APPROVED", DataHelper.getCreditOperationStatus());
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит непринимаемой картой")
    void testCardTourPurchaseDeclinedCard() {
        RestRequestHelper.sendRequest(DataHelper.declinedCardFormData(), creditOperationPath, 200);
        assertEquals("DECLINED", DataHelper.getCreditOperationStatus());
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит с номером карты в 1 символ")
    void testCardTourPurchaseSendErrorForSingleCharacterCardNumber() {
        RestRequestHelper.sendRequest(DataHelper.oneCharacterCardNumberFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с неверным двузначным форматом 'месяц'")
    void testCardTourPurchaseSendErrorForWrongFormatCardMonth() {
        RestRequestHelper.sendRequest(DataHelper.wrongCardMonthFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с трехзначным форматом параметра 'год'")
    void testCardTourPurchaseSendErrorForWrongFormatCardYear() {
        RestRequestHelper.sendRequest(DataHelper.wrongCardYearFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит  валидной картой с истекшим параметром 'год'")
    void testCardTourPurchaseSendErrorForExpiredCardYear() {
        RestRequestHelper.sendRequest(DataHelper.approvedCardFormDataWithApprovedPreviousYear(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит  с именем владельца из одного слова")
    void testCardTourPurchaseSendErrorForWrongFormatCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.wrongCardHolderFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит  именем владельца карты на кириллице")
    void testCardTourPurchaseSendErrorForCyrillicCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.cyrillicCardHolderFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит  с именем владельца карты цифрами")
    void testCardTourPurchaseErrorForNumbersCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.numbersCardHolderFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит  с именем владельца карты в один символ")
    void testCardTourPurchaseErrorForOneCharacterCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.oneCharacterCardHolderFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит  с именем владельца карты с спец символом")
    void testCardTourPurchaseSpecSymbolsCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.specSymbolsCardHolderFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур в кредит с CVV карты в один символ")
    void testCardTourPurchaseErrorForOneCharacterCardCode() {
        RestRequestHelper.sendRequest(DataHelper.oneCharacterCardCodeFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке тур в кредит картой с пустым номером карты")
    void testCardTourPurchaseErrorForEmptyCardNumber() {
        RestRequestHelper.sendRequest(DataHelper.emptyCardNumberFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с пустым полем 'месяц'")
    void testCardTourPurchaseErrorForEmptyCardMonth() {
        RestRequestHelper.sendRequest(DataHelper.emptyUnknownCardMonthFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с пустым полем 'год'")
    void testCardTourPurchaseErrorForEmptyCardYear() {
        RestRequestHelper.sendRequest(DataHelper.emptyUnknownCardYearFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с пустым полем 'владелец'")
    void testCardTourPurchaseErrorForEmptyCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.emptyCardHolderFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой с пустым полем 'CVV'")
    void testCardTourPurchaseErrorForEmptyCardCode() {
        RestRequestHelper.sendRequest(DataHelper.emptyCardCodeFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой c 00 в поле 'месяц'")
    void testCardTourPurchaseErrorForDoubleZeroMonth() {
        RestRequestHelper.sendRequest(DataHelper.doubleZeroMonthFormData(), creditOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур в кредит случайной картой c 00 в поле 'год'")
    void testCardTourPurchaseErrorForDoubleZeroYear() {
        RestRequestHelper.sendRequest(DataHelper.doubleZeroYearFormData(), creditOperationPath, 500);
    }
}
