package org.celllife.idart.codegen.relationship

import org.junit.Test

import static groovy.json.JsonOutput.prettyPrint
import static groovy.json.JsonOutput.toJson
import static org.celllife.idart.codegen.relationship.RelationshipModelEnricher.enrichRelationshipModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 19h16
 */
class RelationshipModelEnricherTest {

    def baseNamespace = "http://www.cell-life.org/idart"

    def models = [
            [name: "For", from: [name: "User"], to: [name: "System"]]
    ]

    @Test
    public void testEnrichModel() throws Exception {
        models.each { model ->
            println prettyPrint(toJson(enrichRelationshipModel(baseNamespace, model)))
        }
    }
}
