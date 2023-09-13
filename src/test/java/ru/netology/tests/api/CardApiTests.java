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
        RestRequestHelper.sendRequest(DataHelper.approvedCardFormData(), buyOperationPath);
        assertEquals("APPROVED", DataHelper.getBuyingOperationStatus());
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур непринимаемой картой")
    void testCardTourPurchaseDeclinedCard() {
        RestRequestHelper.sendRequest(DataHelper.declinedCardFormData(), buyOperationPath);
        assertEquals("DECLINED", DataHelper.getBuyingOperationStatus());
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур с номером карты в 1 символ")
    void testCardTourPurchaseSendErrorForSingleCharacterCardNumber() {
        RestRequestHelper.sendBadRequest(DataHelper.oneCharacterCardNumberFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур случайной картой с неверным двузначным форматом 'месяц'")
    void testCardTourPurchaseSendErrorForWrongFormatCardMonth() {
        RestRequestHelper.sendBadRequest(DataHelper.wrongCardMonthFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур случайной картой с трехзначным форматом параметра 'год'")
    void testCardTourPurchaseSendErrorForWrongFormatCardYear() {
        RestRequestHelper.sendBadRequest(DataHelper.wrongCardYearFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить тур валидной картой с истекшим параметром 'год'")
    void testCardTourPurchaseSendErrorForExpiredCardYear() {
        RestRequestHelper.sendBadRequest(DataHelper.approvedCardFormDataWithApprovedPreviousYear(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур с именем владельца из одного слова")
    void testCardTourPurchaseSendErrorForWrongFormatCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.wrongCardHolderFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур именем владельца карты на кириллице")
    void testCardTourPurchaseSendErrorForCyrillicCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.cyrillicCardHolderFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур с именем владельца карты цифрами")
    void testCardTourPurchaseErrorForNumbersCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.numbersCardHolderFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур с именем владельца карты в один символ")
    void testCardTourPurchaseErrorForOneCharacterCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.oneCharacterCardHolderFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур с именем владельца карты с спец символом")
    void testCardTourPurchaseSpecSymbolsCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.specSymbolsCardHolderFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить картой тур с CVV карты в один символ")
    void testCardTourPurchaseErrorForOneCharacterCardCode() {
        RestRequestHelper.sendBadRequest(DataHelper.oneCharacterCardCodeFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке картой с пустым номером карты")
    void testCardTourPurchaseErrorForEmptyCardNumber() {
        RestRequestHelper.sendBadRequest(DataHelper.emptyCardNumberFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой с пустым полем 'месяц'")
    void testCardTourPurchaseErrorForEmptyCardMonth() {
        RestRequestHelper.sendBadRequest(DataHelper.emptyUnknownCardMonthFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой с пустым полем 'год'")
    void testCardTourPurchaseErrorForEmptyCardYear() {
        RestRequestHelper.sendBadRequest(DataHelper.emptyUnknownCardYearFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой с пустым полем 'владелец'")
    void testCardTourPurchaseErrorForEmptyCardHolder() {
        RestRequestHelper.sendBadRequest(DataHelper.emptyCardHolderFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой с пустым полем 'CVV'")
    void testCardTourPurchaseErrorForEmptyCardCode() {
        RestRequestHelper.sendBadRequest(DataHelper.emptyCardCodeFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой c 00 в поле 'месяц'")
    void testCardTourPurchaseErrorForDoubleZeroMonth() {
        RestRequestHelper.sendBadRequest(DataHelper.doubleZeroMonthFormData(), buyOperationPath);
    }

    @Test
    @DisplayName("Отказ при попытке оплатить случайной картой c 00 в поле 'год'")
    void testCardTourPurchaseErrorForDoubleZeroYear() {
        RestRequestHelper.sendBadRequest(DataHelper.doubleZeroYearFormData(), buyOperationPath);
    }
}
