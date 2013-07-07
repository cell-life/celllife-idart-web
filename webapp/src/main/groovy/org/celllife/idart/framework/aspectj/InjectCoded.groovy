package org.celllife.idart.framework.aspectj

import org.celllife.idart.domain.common.Codeable
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.concept.Code
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
 * Time: 14h48
 */
enum InjectCoded {

    INSTANCE

    static InjectCoded getInstance() { INSTANCE }

    @Autowired EntityManagerFactory entityManagerFactory

    public static <T> T inject(T codeable) {
        INSTANCE.doInject(codeable)
        codeable
    }

    public void doInject(Object codeable) {

        Class<? extends Codeable> codedClass = codeable.class as Class<? extends Codeable>

        Set<String> codeSystems = codeable.codeSystems
        for (codeSystem in codeSystems) {

            if (codeSystem == null) {
                continue
            }

            String codeValue = codeable.getCodeValue(codeSystem)
            if (codeValue == null) {
                continue
            }

            EntityManager entityManager = entityManagerFactory.createEntityManager()
            CriteriaBuilder criteriaBuilder = entityManager.criteriaBuilder

            CriteriaQuery<? extends Codeable> query = criteriaBuilder.createQuery(codedClass)
            Root<? extends Codeable> root = query.from(codedClass)
            Join<? extends Codeable, Code> code = root.join("codes")

            query.where(
                    criteriaBuilder.equal(code.get("system"), codeSystem),
                    criteriaBuilder.equal(code.get("value"), codeValue)
            )

            List<? extends Codeable> results = entityManager.createQuery(query).resultList
            if (!results.isEmpty()) {
                ((Persistable) codeable).pk = ((Persistable) results.get(0)).pk
                return
            }
        }
    }
}
