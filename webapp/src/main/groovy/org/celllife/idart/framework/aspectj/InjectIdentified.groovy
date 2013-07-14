package org.celllife.idart.framework.aspectj

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Join
import javax.persistence.criteria.Root

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-07
 * Time: 14h50
 */
enum InjectIdentified {

    INSTANCE

    @Autowired EntityManagerFactory entityManagerFactory

    static InjectIdentified getInstance() { INSTANCE }

    public static <T> T inject(T identifiable) {
        INSTANCE.doInject(identifiable)
        identifiable
    }

    void doInject(Object identifiable) {

        if (identifiable == null) {
            return
        }

        if (entityManagerFactory == null) {
            // Most likely in a unit test
            return
        }

        Class<? extends Identifiable> identifiedClass = identifiable.class as Class<? extends Identifiable>

        Set<String> identifierSystems = identifiable.getIdentifierSystems()

        for (identifierSystem in identifierSystems) {

            if (identifierSystem == null) {
                continue
            }

            String identifierValue = identifiable.getIdentifierValue(identifierSystem)
            if (identifierValue == null) {
                continue
            }

            EntityManager entityManager = entityManagerFactory.createEntityManager()
            try {
                CriteriaBuilder criteriaBuilder = entityManager.criteriaBuilder

                CriteriaQuery<? extends Identifiable> query = criteriaBuilder.createQuery(identifiedClass)
                Root<? extends Identifiable> root = query.from(identifiedClass)
                Join<? extends Identifiable, Identifier> identifiers = root.join("identifiers")

                query.where(
                        criteriaBuilder.equal(identifiers.get("system"), identifierSystem),
                        criteriaBuilder.equal(identifiers.get("value"), identifierValue)
                )

                List<? extends Identifiable> results = entityManager.createQuery(query).resultList
                if (!results.empty) {
                    ((Persistable) identifiable).pk = ((Persistable) results.get(0)).pk
                    return
                }
            } finally {
                entityManager.close()
            }
        }
    }
}
