package org.celllife.idart.domain.partclassification


import org.celllife.idart.domain.atc.AnatomicalMainGroup
import org.celllife.idart.domain.atc.AtcClassification
import org.junit.Assert
import org.junit.Test

class AtcClassificationTest {

    @Test
    public void shouldConstructAtcClassificationFromCode() throws Exception {
        def classification = AtcClassification.fromCode("A01AD05")
        Assert.assertEquals(AnatomicalMainGroup.A, classification.firstLevel)
        Assert.assertEquals("01", classification.secondLevel)
        Assert.assertEquals("A", classification.thirdLevel)
        Assert.assertEquals("D", classification.forthLevel)
        Assert.assertEquals("05", classification.fifthLevel)
    }

    @Test
    public void shouldGetAtcClassificationAsCode() throws Exception {
        def classification = AtcClassification.fromCode("A01AD05")
        Assert.assertEquals("A01AD05", classification.asCode())
    }
}
