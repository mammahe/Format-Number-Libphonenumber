package com.sairamkrishna.formatnumber;

import android.content.Context;
import android.content.res.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

public class FormatNumber {
    @Deprecated
    public static String getFormattedNumber(String mobile,String format, Context context) {
        format=format.toLowerCase().trim();
        mobile=mobile.trim();
        if (!mobile.isEmpty()) {
            if (mobile.length() < 10) {
                return "PhoneNumber Error";
            }
            String defaultLocale = Resources.getSystem().getConfiguration().locale.toString();
            try {
                PhoneNumberUtil phoneUtil = getPhoneNumberUtilInstance(context);
                Phonenumber.PhoneNumber phoneProto = phoneUtil.parse(mobile, defaultLocale);
                if (phoneUtil.isValidNumber(phoneProto)) {
                    switch (format){
                        case "hyphen":
                            mobile = phoneUtil.format(phoneProto, PhoneNumberUtil.PhoneNumberFormat.RFC3966);
                            break;
                        case "national":
                            mobile = phoneUtil.format(phoneProto, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
                            break;
                        case "international":
                            mobile = phoneUtil.format(phoneProto, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
                            break;
                        case "e164":
                            mobile = phoneUtil.format(phoneProto, PhoneNumberUtil.PhoneNumberFormat.E164);
                            break;
                            default:
                                mobile = phoneUtil.format(phoneProto, PhoneNumberUtil.PhoneNumberFormat.E164);
                                break;



                    }

                } else {
                    return "PhoneNumber Error";
                }

            } catch (NumberParseException e) {

            }
            return mobile.trim().replace("tel:","").trim();
        } else {
            return "PhoneNumber Error";
        }
    }
    private static PhoneNumberUtil getPhoneNumberUtilInstance(final Context context)
    {
        PhoneNumberUtil mPhoneNumberUtil =null;
        if(mPhoneNumberUtil == null)
        {
            mPhoneNumberUtil = PhoneNumberUtil.createInstance(new MetadataLoader()
            {
                @Override
                public InputStream loadMetadata(String metadataFileName)
                {
                    try
                    {
                        String[] stringPieces = metadataFileName.split("/");

                        String metadataName = stringPieces[stringPieces.length - 1];

                        InputStream is = context.getApplicationContext().getAssets().open("data/" + metadataName);

                        return is;
                    }
                    catch (IOException e)
                    {
                        // Handle somehow!
                        return null;
                    }
                }
            });
        }

        return mPhoneNumberUtil;
    }
}
