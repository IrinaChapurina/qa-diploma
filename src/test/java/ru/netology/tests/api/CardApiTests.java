package ru.netology.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.helpers.DataHelper;
import ru.netology.helpers.RestRequestHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardApiTests extends BaseApiTest {

    @Test
    @DisplayName("Успешная оплата тура принимаемой картой с валидными данными формы")
    void testCardTourPurchaseApprovedCard() {
        RestRequestHelper.sendRequest(DataHelper.approvedCardFormData(), buyOperationPath, 200);
        assertEquals("APPROVED", DataHelper.getBuyingOperationStatus());
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур непринимаемой картой")
    void testCardTourPurchaseDeclinedCard() {
        RestRequestHelper.sendRequest(DataHelper.declinedCardFormData(), buyOperationPath, 200);
        assertEquals("DECLINED", DataHelper.getBuyingOperationStatus());
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур с номером карты в 1 символ")
    void testCardTourPurchaseSendErrorForSingleCharacterCardNumber() {
        RestRequestHelper.sendRequest(DataHelper.oneCharacterCardNumberFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур случайной картой с неверным двузначным форматом 'месяц'")
    void testCardTourPurchaseSendErrorForWrongFormatCardMonth() {
        RestRequestHelper.sendRequest(DataHelper.wrongCardMonthFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур случайной картой с трехзначным форматом параметра 'год'")
    void testCardTourPurchaseSendErrorForWrongFormatCardYear() {
        RestRequestHelper.sendRequest(DataHelper.wrongCardYearFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур валидной картой с истекшим параметром 'год'")
    void testCardTourPurchaseSendErrorForExpiredCardYear() {
        RestRequestHelper.sendRequest(DataHelper.approvedCardFormDataWithApprovedPreviousYear(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур с именем владельца из одного слова")
    void testCardTourPurchaseSendErrorForWrongFormatCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.wrongCardHolderFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур именем владельца карты на кириллице")
    void testCardTourPurchaseSendErrorForCyrillicCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.cyrillicCardHolderFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур с именем владельца карты цифрами")
    void testCardTourPurchaseErrorForNumbersCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.numbersCardHolderFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур с именем владельца карты в один символ")
    void testCardTourPurchaseErrorForOneCharacterCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.oneCharacterCardHolderFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур с именем владельца карты с спец символом")
    void testCardTourPurchaseSpecSymbolsCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.specSymbolsCardHolderFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур с CVV карты в один символ")
    void testCardTourPurchaseErrorForOneCharacterCardCode() {
        RestRequestHelper.sendRequest(DataHelper.oneCharacterCardCodeFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке картой с пустым номером карты")
    void testCardTourPurchaseErrorForEmptyCardNumber() {
        RestRequestHelper.sendRequest(DataHelper.emptyCardNumberFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой с пустым полем 'месяц'")
    void testCardTourPurchaseErrorForEmptyCardMonth() {
        RestRequestHelper.sendRequest(DataHelper.emptyUnknownCardMonthFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой с пустым полем 'год'")
    void testCardTourPurchaseErrorForEmptyCardYear() {
        RestRequestHelper.sendRequest(DataHelper.emptyUnknownCardYearFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой с пустым полем 'владелец'")
    void testCardTourPurchaseErrorForEmptyCardHolder() {
        RestRequestHelper.sendRequest(DataHelper.emptyCardHolderFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой с пустым полем 'CVV'")
    void testCardTourPurchaseErrorForEmptyCardCode() {
        RestRequestHelper.sendRequest(DataHelper.emptyCardCodeFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой c 00 в поле 'месяц'")
    void testCardTourPurchaseErrorForDoubleZeroMonth() {
        RestRequestHelper.sendRequest(DataHelper.doubleZeroMonthFormData(), buyOperationPath, 500);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой c 00 в поле 'год'")
    void testCardTourPurchaseErrorForDoubleZeroYear() {
        RestRequestHelper.sendRequest(DataHelper.doubleZeroYearFormData(), buyOperationPath, 500);
    }
}
