package org.celllife.idart.common

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 10h44
 */
enum PartyClassificationType {

    EE("Employment Equity Classification"),

    SIC("Standard Industrial Classification")

    String name

    PartyClassificationType(String name) {
        this.name = name
    }
}