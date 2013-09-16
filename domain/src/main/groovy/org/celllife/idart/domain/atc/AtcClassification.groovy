package org.celllife.idart.domain.atc
/**
 * Anatomical Therapeutic Chemical Classification
 *
 * This pharmaceutical coding system divides drugs into different groups according to the organ or system on which they
 * act and/or their therapeutic and chemical characteristics. Each bottom-level ATC code stands for a pharmaceutically
 * used substance, or a combination of substances, in a single indication (or use). This means that one drug can have
 * more than one code: acetylsalicylic acid (aspirin), for example, has A01AD05 as a drug for local oral treatment,
 * B01AC06 as a platelet inhibitor, and N02BA01 as an analgesic and antipyretic. On the other hand, several different
 * brands share the same code if they have the same active substance and indications.
 *
 * Sources:
 * http://en.wikipedia.org/wiki/Anatomical_Therapeutic_Chemical_Classification_System
 * http://www.whocc.no/atc_ddd_index
 *
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 13h23
 */
class AtcClassification implements Serializable {

    /**
     * The first level of the code indicates the anatomical main group and consists of one letter.
     */
    AnatomicalMainGroup firstLevel

    /**
     * The second level of the code indicates the therapeutic main group and consists of two digits.
     */
    String secondLevel

    /**
     * The third level of the code indicates the therapeutic/pharmacological subgroup and consists of one letter.
     */
    String thirdLevel

    /**
     * The fourth level of the code indicates the chemical/therapeutic/pharmacological subgroup and consists of one letter.
     */
    String forthLevel

    /**
     * The fifth level of the code indicates the chemical substance and consists of two digits.
     */
    String fifthLevel

    /**
     * The ATC system also includes defined daily doses (DDDs) for many drugs. This is a measurement of drug
     * consumption based on the usual daily dose for a given drug. According to the definition, "the DDD is the assumed
     * average maintenance dose per day for a drug used for its main indication in adults."
     */
    Set<DefinedDailyDose> definedDailyDoses = []

    static fromCode(String code) {
        new AtcClassification(
                firstLevel: AnatomicalMainGroup.valueOf(code.charAt(0).toUpperCase().toString()),
                secondLevel: code.substring(1, 3),
                thirdLevel: code.substring(3, 4),
                forthLevel: code.substring(4, 5),
                fifthLevel: code.substring(5, 7)
        )
    }

    String asCode() {
        "$firstLevel$secondLevel$thirdLevel$forthLevel$fifthLevel"
    }
}
