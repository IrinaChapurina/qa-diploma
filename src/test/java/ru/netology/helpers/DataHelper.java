package ru.netology.helpers;

import com.github.javafaker.Faker;
import lombok.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    private static final Faker faker = new Faker(new Locale("en"));

    @Value
    public static class FormData {
        String number;
        String month;
        String year;
        String holder;
        String cvc;
    }

    public static String getApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getDeclinedCardNumber() {
        return "4444 4444 4444 4442";
    }

    public static String getUnknownCardNumber() {
        return faker.number().digits(16);
    }

    public static String getCardMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getNextCardMonth() {
        return LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getPreviousCardMonth() {
        return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getCardYearActual() {
        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getCardNextYear() {
        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getCardPreviousYear() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getCardHolder() {
        return faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase();
    }

    public static String getCardCode() {
        return faker.number().digits(3);
    }

    public static String getOneNumber(){
        return faker.number().digits(1);
    }

    public static String getWrongCardMonth() {
        return String.valueOf(faker.number().numberBetween(13,99) | faker.number().numberBetween(0,9));
    }

    public static String getDoubleZeroData() {
        return "00";
    }

    public static String getWrongCardYear() {
        return String.valueOf(faker.number().numberBetween(0,999));
    }

    public static String getCardYearExpired() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getWrongCardHolder() {
        return faker.name().firstName().toUpperCase();
    }

    public static String getCyrillicCardHolder() {
        final Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName().toUpperCase() + ' ' + faker.name().lastName().toUpperCase() ;
    }

    public static String getNumbersCardHolder() {
        return String.valueOf(faker.number().numberBetween(100,99999));
    }

    public static String getOneCharacter() {
        return faker.letterify("?").toUpperCase();
    }

    public static FormData approvedCardFormData() {
        FormData formData = new FormData(getApprovedCardNumber(), getCardMonth(),
                getCardYearActual(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData approvedCardFormDataWithApprovedNextMonth() {
        FormData formData = new FormData(getApprovedCardNumber(), getNextCardMonth(),
                getCardYearActual(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData approvedCardFormDataWithApprovedNextYear() {
        FormData formData = new FormData(getApprovedCardNumber(), getCardMonth(),
                getCardNextYear(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData approvedCardFormDataWithApprovedPreviousYear() {
        FormData formData = new FormData(getApprovedCardNumber(), getCardMonth(),
                getCardPreviousYear(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData approvedCardFormDataWithDoubleZeroMonth() {
        FormData formData = new FormData(getApprovedCardNumber(), getDoubleZeroData(),
                getCardYearActual(), getCardHolder(), getCardCode());
        return formData;
    }


    public static FormData approvedCardFormDataWithPreviousMonth() {
        FormData formData = new FormData(getApprovedCardNumber(), getPreviousCardMonth(),
                getCardYearActual(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData declinedCardFormData() {
        FormData formData = new FormData(getDeclinedCardNumber(), getCardMonth(),
                getCardYearActual(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData unknownCardFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getCardMonth(),
                getCardYearActual(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData oneCharacterCardNumberFormData() {
        FormData formData = new FormData(getOneNumber(), getCardMonth(),
                getCardYearActual(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData oneCharacterMonthNumberFormData() {
        FormData formData = new FormData(getApprovedCardNumber(), getOneNumber(),
                getCardYearActual(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData wrongCardMonthFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getWrongCardMonth(),
                getCardYearActual(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData wrongCardYearFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getCardMonth(),
                getWrongCardYear(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData expiredCardYearFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getCardMonth(),
                getCardYearExpired(), getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData wrongCardHolderFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getCardMonth(),
                getCardYearActual(), getWrongCardHolder(), getCardCode());
        return formData;
    }

    public static FormData cyrillicCardHolderFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getCardMonth(),
                getCardYearActual(), getCyrillicCardHolder(), getCardCode());
        return formData;
    }
    public static FormData numbersCardHolderFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getCardMonth(),
                getCardYearActual(), getNumbersCardHolder(), getCardCode());
        return formData;
    }

    public static FormData oneCharacterCardHolderFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getCardMonth(),
                getCardYearActual(),getOneCharacter(), getCardCode());
        return formData;
    }

    public static FormData specSymbolsCardHolderFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getCardMonth(),
                getCardYearActual(),getCardHolder() + "!@#$%^&*№;%:?", getCardCode());
        return formData;
    }

    public static FormData oneCharacterCardCodeFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getCardMonth(),
                getCardYearActual(),getCardHolder(), getOneNumber());
        return formData;
    }

    public static FormData emptyCardNumberFormData() {
        FormData formData = new FormData("", getCardMonth(),
                getCardYearActual(),getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData emptyUnknownCardMonthFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), "",
                getCardYearActual(),getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData emptyCardMonthFormData() {
        FormData formData = new FormData(getApprovedCardNumber(), "",
                getCardYearActual(),getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData emptyUnknownCardYearFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getCardMonth(),
                "",getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData emptyCardYearFormData() {
        FormData formData = new FormData(getApprovedCardNumber(), getCardMonth(),
                "",getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData emptyCardHolderFormData() {
        FormData formData = new FormData(getApprovedCardNumber(), getCardMonth(),
                getCardYearActual(),"", getCardCode());
        return formData;
    }

    public static FormData emptyCardCodeFormData() {
        FormData formData = new FormData(getApprovedCardNumber(), getCardMonth(),
                getCardYearActual(),getCardHolder(), "");
        return formData;
    }

    public static FormData doubleZeroMonthFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getDoubleZeroData(),
                getCardYearActual(),getCardHolder(), getCardCode());
        return formData;
    }

    public static FormData doubleZeroYearFormData() {
        FormData formData = new FormData(getUnknownCardNumber(), getCardMonth(),
                getDoubleZeroData(),getCardHolder(), getCardCode());
        return formData;
    }

    @SneakyThrows
    public static String getBuyingOperationStatus() {
        var runner = new QueryRunner();
        var getStatus = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";

        try (var conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass");) {
            return runner.query(conn, getStatus, new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static String getCreditOperationStatus() {
        var runner = new QueryRunner();
        var getStatus = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";

        try (var conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass");) {
            return runner.query(conn, getStatus, new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static void cleanData() {
        var runner = new QueryRunner();
        var deletePaymentEntitySQL = "DELETE FROM payment_entity";
        var deleteOrderEntitySQL = "DELETE FROM order_entity";
        var deleteRequestEntitySQL = "DELETE FROM credit_request_entity";

        try (var conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass");) {
            runner.update(conn, deletePaymentEntitySQL);
            runner.update(conn, deleteOrderEntitySQL);
            runner.update(conn, deleteRequestEntitySQL);
        }
    }
}