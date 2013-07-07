package org.celllife.idart.domain.common

import org.celllife.idart.domain.concept.LocalisedText

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 19h37
 */
class Nameable {

    def String getName() {
        names.find({ name -> name.locale.equals("en") }).value
    }

    def setName(String name) {
        this.addName(name)
    }

    def addName(String name) {
        this.addName("en", name)
    }

    def addName(String locale, String value) {

        if (value == null) {
            return
        }

        this.names.add(new LocalisedText(locale: locale, value: value))
    }
}
