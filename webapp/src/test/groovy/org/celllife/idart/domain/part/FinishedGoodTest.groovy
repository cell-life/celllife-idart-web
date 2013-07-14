package org.celllife.idart.domain.part

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 15h37
 */
class FinishedGoodTest {

    @Test
    public void shouldMarshalTestData() throws Exception {

        def inputStream = getClass().getResourceAsStream("/data/drug/finishedGoods-J05AF01.json")
        def typeReference = new TypeReference<List<FinishedGood>>() {}
        def finishedGoods = new ObjectMapper().reader(typeReference).readValue(inputStream)
        finishedGoods.each { finishedGood -> println finishedGood }

    }

}
