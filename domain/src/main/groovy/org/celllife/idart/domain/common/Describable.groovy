package org.celllife.idart.domain.common
/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 19h37
 */
class Describable {

    def String getDescription() {
        descriptions
                .find({ description -> description.locale.equals("en") })
                .value
    }

    def setDescription(String description) {
        this.addDescription(description)
    }

    def addDescription(String description) {
        this.addDescription("en", description)
    }

    def addDescription(String locale, String description) {

        if (description == null) {
            return
        }

        this.descriptions.add(new LocalisedText(locale: locale, value: description))
    }
}
