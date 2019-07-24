package com.sairamkrishna.formatnumber;

import com.sairamkrishna.formatnumber.Phonemetadata.PhoneNumberDesc;

/**
 * Internal phonenumber matching API used to isolate the underlying implementation of the
 * matcher and allow different implementations to be swapped in easily.
 */
public interface MatcherApi {
    /**
     * Returns whether the given national number (a string containing only decimal digits) matches
     * the national number pattern defined in the given {@code PhoneNumberDesc} message.
     */
    boolean matchNationalNumber(CharSequence number, PhoneNumberDesc numberDesc,
                                boolean allowPrefixMatch);
}