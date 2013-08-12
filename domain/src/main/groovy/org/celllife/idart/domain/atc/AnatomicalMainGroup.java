package org.celllife.idart.domain.atc;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-13
 * Time: 21h22
 */
public enum AnatomicalMainGroup {

    A("Alimentary tract and metabolism"),
    B("Blood and blood forming organs"),
    C("Cardiovascular system"),
    D("Dermatologicals"),
    G("Genito-urinary system and sex hormones"),
    H("Systemic hormonal preparations, excluding sex hormones and insulins"),
    J("Antiinfectives for systemic use"),
    L("Antineoplastic and immunomodulating agents"),
    M("Musculo-skeletal system"),
    N("Nervous system"),
    P("Antiparasitic products, insecticides and repellents"),
    R("Respiratory system"),
    S("Sensory organs"),
    V("Various");

    private final String anatomicalMainGroup;

    private AnatomicalMainGroup(String anatomicalMainGroup) {
        this.anatomicalMainGroup = anatomicalMainGroup;
    }

    public String getAnatomicalMainGroup() {
        return anatomicalMainGroup;
    }
}
