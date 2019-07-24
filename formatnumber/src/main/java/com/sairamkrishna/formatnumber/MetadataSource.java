package com.sairamkrishna.formatnumber;

import com.sairamkrishna.formatnumber.Phonemetadata.PhoneMetadata;

/**
 * A source for phone metadata for all regions.
 */
interface MetadataSource {

    /**
     * Gets phone metadata for a region.
     *
     * @param regionCode the region code.
     * @return the phone metadata for that region, or null if there is none.
     */
    PhoneMetadata getMetadataForRegion(String regionCode);

    /**
     * Gets phone metadata for a non-geographical region.
     *
     * @param countryCallingCode the country calling code.
     * @return the phone metadata for that region, or null if there is none.
     */
    PhoneMetadata getMetadataForNonGeographicalRegion(int countryCallingCode);
}

