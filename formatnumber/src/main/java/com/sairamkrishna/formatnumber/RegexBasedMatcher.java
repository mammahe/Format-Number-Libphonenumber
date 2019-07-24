package com.sairamkrishna.formatnumber;

import com.sairamkrishna.formatnumber.Phonemetadata.PhoneNumberDesc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of the matcher API using the regular expressions in the PhoneNumberDesc
 * proto message to match numbers.
 */
public final class RegexBasedMatcher implements MatcherApi {
    private final RegexCache regexCache = new RegexCache(100);

    private RegexBasedMatcher() {
    }

    public static MatcherApi create() {
        return new RegexBasedMatcher();
    }

    private static boolean match(CharSequence number, Pattern pattern, boolean allowPrefixMatch) {
        Matcher matcher = pattern.matcher(number);
        if (!matcher.lookingAt()) {
            return false;
        } else {
            return (matcher.matches()) || allowPrefixMatch;
        }
    }

    // @Override
    public boolean matchNationalNumber(CharSequence number, PhoneNumberDesc numberDesc,
                                       boolean allowPrefixMatch) {
        String nationalNumberPattern = numberDesc.getNationalNumberPattern();
        // We don't want to consider it a prefix match when matching non-empty input against an empty
        // pattern.
        if (nationalNumberPattern.length() == 0) {
            return false;
        }
        return match(number, regexCache.getPatternForRegex(nationalNumberPattern), allowPrefixMatch);
    }
}

