package com.sairamkrishna.formatnumber;


/**
 * Generic exception class for errors encountered when parsing phone numbers.
 */
@SuppressWarnings("serial")
public class NumberParseException extends Exception {

    private ErrorType errorType;
    private String message;
    public NumberParseException(ErrorType errorType, String message) {
        super(message);
        this.message = message;
        this.errorType = errorType;
    }

    /**
     * Returns the error type of the exception that has been thrown.
     */
    public ErrorType getErrorType() {
        return errorType;
    }

    @Override
    public String toString() {
        return "Error type: " + errorType + ". " + message;
    }

    /**
     * The reason that a string could not be interpreted as a phone number.
     */
    public enum ErrorType {
        /**
         * The country code supplied did not belong to a supported country or non-geographical entity.
         */
        INVALID_COUNTRY_CODE,
        /**
         * This generally indicates the string passed in had less than 3 digits in it. More
         * specifically, the number failed to match the regular expression VALID_PHONE_NUMBER in
         * PhoneNumberUtil.java.
         */
        NOT_A_NUMBER,
        /**
         * This indicates the string started with an international dialing prefix, but after this was
         * stripped from the number, had less digits than any valid phone number (including country
         * code) could have.
         */
        TOO_SHORT_AFTER_IDD,
        /**
         * This indicates the string, after any country code has been stripped, had less digits than any
         * valid phone number could have.
         */
        TOO_SHORT_NSN,
        /**
         * This indicates the string had more digits than any valid phone number could have.
         */
        TOO_LONG,
    }
}

