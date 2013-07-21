package org.celllife.idart.client.person;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h51
 */
public final class MobileTelephoneNumber extends ContactMechanism {

    public String contactNumber;

    public String countryCode;

    public MobileTelephoneNumber() {
    }

    public String toString() {
        return countryCode + contactNumber.substring(1);
    }
}
