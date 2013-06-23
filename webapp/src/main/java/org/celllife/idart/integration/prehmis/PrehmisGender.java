package org.celllife.idart.integration.prehmis;

import org.celllife.idart.udm.common.Gender;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 12h22
 */
public enum PrehmisGender {

    MALE("male", Gender.M),
    FEMALE("female", Gender.F);

    private final String prehmisCode;

    private final Gender gender;

    PrehmisGender(String prehmisCode, Gender gender) {

        this.prehmisCode = prehmisCode;
        this.gender = gender;
    }

    public static Gender findByPrehmisCode(String prehmisCode) {
        for (PrehmisGender prehmisToIdartGenderMapping : values()) {
            if (prehmisToIdartGenderMapping.prehmisCode.equalsIgnoreCase(prehmisCode)) {
                return prehmisToIdartGenderMapping.gender;
            }
        }
        return null;
    }

}
