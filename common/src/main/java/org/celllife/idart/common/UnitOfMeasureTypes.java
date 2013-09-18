package org.celllife.idart.common;

import static org.celllife.idart.common.UnitOfMeasureTypeCode.unitOfMeasureTypeCode;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-18
 * Time: 12h27
 */
public enum UnitOfMeasureTypes {

    ARBITRARY_CONCENTRATION_CONTENT(unitOfMeasureTypeCode("ARBITRARY_CONCENTRATION_CONTENT"), "Arbitrary Concentration Content "),
    ARBITRARY_CONCENTRATION(unitOfMeasureTypeCode("ARBITRARY_CONCENTRATION"), "Arbitrary Concentration "),
    ARBITRARY_NUMBER(unitOfMeasureTypeCode("ARBITRARY_NUMBER"), "Arbitrary Number "),
    ARBITRARY(unitOfMeasureTypeCode("ARBITRARY"), "Arbitrary "),
    AREIC_MASS(unitOfMeasureTypeCode("AREIC_MASS"), "Areic Mass "),
    AREIC_NUMBER(unitOfMeasureTypeCode("AREIC_NUMBER"), "Areic Number "),
    AREIC_SUBSTANCE(unitOfMeasureTypeCode("AREIC_SUBSTANCE"), "Areic Substance "),
    CATALYTIC_FRACTION_OR_ARBITRARY_FRACTION(unitOfMeasureTypeCode("CATALYTIC_FRACTION_OR_ARBITRARY_FRACTION"), "Catalytic Fraction Or Arbitrary Fraction "),
    ENERGY_CONTENT(unitOfMeasureTypeCode("ENERGY_CONTENT"), "Energy Content "),
    ENGLISH_AREA(unitOfMeasureTypeCode("ENGLISH_AREA"), "English Area "),
    ENGLISH_LENGTH(unitOfMeasureTypeCode("ENGLISH_LENGTH"), "English Length "),
    ENGLISH_MASS(unitOfMeasureTypeCode("ENGLISH_MASS"), "English Mass "),
    ENGLISH_VOLUME(unitOfMeasureTypeCode("ENGLISH_VOLUME"), "English Volume "),
    ENTITIC_NUMBER(unitOfMeasureTypeCode("ENTITIC_NUMBER"), "Entitic Number "),
    GENERAL_FRACTION_UNIT(unitOfMeasureTypeCode("GENERAL_FRACTION_UNIT"), "General Fraction Unit"),
    LINEIC_MASS(unitOfMeasureTypeCode("LINEIC_MASS"), "Lineic Mass "),
    MASS_CONCENTRATION(unitOfMeasureTypeCode("MASS_CONCENTRATION"), "Mass Concentration "),
    MASS_OR_SUBSTANCE_FRACTION(unitOfMeasureTypeCode("MASS_OR_SUBSTANCE_FRACTION"), "Mass Or Substance Fraction "),
    MASS_OR_SUBSTANCE_RATE_FRACTION(unitOfMeasureTypeCode("MASS_OR_SUBSTANCE_RATE_FRACTION"), "Mass Or Substance Rate Fraction "),
    MASS_RATIO_OR_MASS_FRACTION_OR_MASS_CONTENT(unitOfMeasureTypeCode("MASS_RATIO_OR_MASS_FRACTION_OR_MASS_CONTENT"), "Mass Ratio Or Mass Fraction Or Mass Content "),
    MASSIVE_DISTANCE(unitOfMeasureTypeCode("MASSIVE_DISTANCE"), "Massive Distance "),
    MOLAR_MASS(unitOfMeasureTypeCode("MOLAR_MASS"), "Molar Mass "),
    MOST_COMMON_HEALTHCARE(unitOfMeasureTypeCode("MOST_COMMON_HEALTHCARE"), "Most Common Healthcare "),
    NUMBER_CONCENTRATION(unitOfMeasureTypeCode("NUMBER_CONCENTRATION"), "Number Concentration "),
    NUMBER_CONTENT(unitOfMeasureTypeCode("NUMBER_CONTENT"), "Number Content "),
    NUMBER_FRACTION(unitOfMeasureTypeCode("NUMBER_FRACTION"), "Number Fraction "),
    PLANE_ANGLE(unitOfMeasureTypeCode("PLANE_ANGLE"), "Plane Angle "),
    SI_AREA(unitOfMeasureTypeCode("SI_AREA"), "SI Area "),
    SI_LENGTH(unitOfMeasureTypeCode("SI_LENGTH"), "SI Length "),
    SI_MASS(unitOfMeasureTypeCode("SI_MASS"), "SI Mass "),
    SI_VOLUME(unitOfMeasureTypeCode("SI_VOLUME"), "SI Volume "),
    SUBSTANCE_CONCENTRATION(unitOfMeasureTypeCode("SUBSTANCE_CONCENTRATION"), "Substance Concentration "),
    SUBSTANCE_CONTENT(unitOfMeasureTypeCode("SUBSTANCE_CONTENT"), "Substance Content "),
    SUBSTANCE_RATE_CONTENT(unitOfMeasureTypeCode("SUBSTANCE_RATE_CONTENT"), "Substance Rate Content "),
    SUBSTANCE_RATIO_OR_SUBSTANCE_FRACTION(unitOfMeasureTypeCode("SUBSTANCE_RATIO_OR_SUBSTANCE_FRACTION"), "Substance Ratio Or Substance Fraction "),
    SUBSTANCE(unitOfMeasureTypeCode("SUBSTANCE"), "Substance "),
    TEMPERATURE(unitOfMeasureTypeCode("TEMPERATURE"), "Temperature "),
    THERMAL_RESISTANCE(unitOfMeasureTypeCode("THERMAL_RESISTANCE"), "Thermal Resistance "),
    TIME(unitOfMeasureTypeCode("TIME"), "Time "),
    UNITY(unitOfMeasureTypeCode("UNITY"), "Unity"),
    VOLUME_CONTENT(unitOfMeasureTypeCode("VOLUME_CONTENT"), "Volume Content "),
    VOLUME_DURATION(unitOfMeasureTypeCode("VOLUME_DURATION"), "Volume Duration "),
    VOLUME_FRACTION(unitOfMeasureTypeCode("VOLUME_FRACTION"), "Volume Fraction "),
    PH(unitOfMeasureTypeCode("PH"), "pH ");

    public final UnitOfMeasureTypeCode code;

    public final String description;

    private UnitOfMeasureTypes(UnitOfMeasureTypeCode code, String description) {
        this.code = code;
        this.description = description;
    }
}
