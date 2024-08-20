package org.brayan.cinebackend.Utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RoutinesTest {

    String STRING_NULL;
    final String STRING_EMPTY = "";
    final String STRING_WITH_VALUES = "Hello";

    final String EMAIL_VALID = "ariasbrayan897@gmail.com";
    final String EMAIL_VALID1 = "jose.jose22@kasdi.com";
    final String EMAIL_INVALID = "arias.brayangmail.com";

    final String IDENTIFICATION_VALID = "1061783051";
    final String IDENTIFICATION_INVALID = "106278201";

    final String DATE_VALID = "12/03/2024";
    final String DATE_INVALID = "12/13/1990";
    final String DATE_INVALID2 = "33/12/2024";
    final String DATE_INVALID3 = "12-12-1990";

    final String PASSWORD_VALID = "Arias@04081995";
    final String PASSWORD_INVALID = "arias.1";


    @Test
    void isEmpty() {
        assertAll(
                () ->assertTrue(Routines.isEmpty(STRING_NULL)),
                () ->assertTrue(Routines.isEmpty(STRING_EMPTY)),
                () ->assertFalse(Routines.isEmpty(STRING_WITH_VALUES))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {EMAIL_VALID,EMAIL_VALID1})
    void isEmailValid(String string) {
        assertTrue(Routines.isEmailValid(string.trim()));
    }

    @ParameterizedTest
    @ValueSource(strings = {EMAIL_INVALID})
    void isEmailInvalid(String string) {
        assertFalse(Routines.isEmailValid(string.trim()));
    }

    @Test
    void newIsNotNull() {
    }

    @Test
    void isEmptyOrNull() {
    }

    @Test
    void identificationIsValid() {
        assertAll(
                () -> assertTrue(Routines.identificationIsValid(IDENTIFICATION_VALID)),
                () -> assertFalse(Routines.identificationIsValid(IDENTIFICATION_INVALID))
        );
    }

    @Test
    void compareDate() {
    }

    @Test
    void isGreater() {
    }

    @Test
    void isGreaterOrEqual() {
    }

    @Test
    void isLess() {
    }

    @Test
    void isLessOrEqual() {
    }

    @Test
    void isDateValid() {
        assertAll(
                () -> assertTrue(Routines.isDateValid(DATE_VALID)),
                () -> assertFalse(Routines.isDateValid(DATE_INVALID)),
                () -> assertFalse(Routines.isDateValid(DATE_INVALID2)),
                () -> assertFalse(Routines.isDateValid(DATE_INVALID3))
        );
    }

    @Test
    void isPasswordValid() {
        assertAll(
                () -> assertTrue(Routines.isPasswordValid(PASSWORD_VALID)),
                () -> assertFalse(Routines.isPasswordValid(PASSWORD_INVALID))
        );
    }
}