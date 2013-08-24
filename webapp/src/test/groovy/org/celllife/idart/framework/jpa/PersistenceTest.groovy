package org.celllife.idart.framework.jpa

import org.celllife.idart.common.AdministrationMethodCode
import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.junit.Test

import javax.persistence.Persistence

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-11
 * Time: 14h02
 */
class PersistenceTest {

    @Test
    public void testName() throws Exception {

        def entityManagerFactory = Persistence.createEntityManagerFactory("org.celllife.idart.test.pu")
        def entityManager = entityManagerFactory.createEntityManager()
        def entityTransaction = entityManager.getTransaction()

        try {
            entityTransaction.begin()

            entityManager.persist(new AdministrationMethod(code: AdministrationMethodCode.valueOf("000001")))

            entityTransaction.commit()
        } catch (Exception e) {
            entityTransaction.rollback()
            e.printStackTrace()
        } finally {
            if (entityTransaction.active) {
                entityTransaction.commit()
            }
        }
    }
}
