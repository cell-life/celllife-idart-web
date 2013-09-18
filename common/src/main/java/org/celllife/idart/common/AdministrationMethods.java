package org.celllife.idart.common;

import static org.celllife.idart.common.AdministrationMethodCode.administrationMethodCode;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-18
 * Time: 13h24
 */
public enum AdministrationMethods {

    CH(administrationMethodCode("CH"),"Chew"),
    DI(administrationMethodCode("DI"),"Dissolve"),
    DU(administrationMethodCode("DU"),"Dust"),
    IF(administrationMethodCode("IF"),"Infiltrate"),
    IS(administrationMethodCode("IS"),"Insert"),
    IR(administrationMethodCode("IR"),"Irrigate"),
    IVPB(administrationMethodCode("IVPB"),"IV Piggyback"),
    IVP(administrationMethodCode("IVP"),"IV Push"),
    NB(administrationMethodCode("NB"),"Nebulized"),
    PT(administrationMethodCode("PT"),"Pain"),
    PF(administrationMethodCode("PF"),"Perfuse"),
    SH(administrationMethodCode("SH"),"Shampoo"),
    SO(administrationMethodCode("SO"),"Soak"),
    WA(administrationMethodCode("WA"),"Wash"),
    WI(administrationMethodCode("WI"),"Wipe");

    public final AdministrationMethodCode code;

    public final String description;

    private AdministrationMethods(AdministrationMethodCode code, String description) {
        this.code = code;
        this.description = description;
    }

}
