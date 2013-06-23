package org.celllife.idart.framework.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.celllife.idart.domain.common.Identifiable;
import org.celllife.idart.domain.common.Persistable;
import org.celllife.idart.domain.concept.Identifier;
import org.celllife.idart.domain.concept.Identifiers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 10h15
 */
@Aspect
public final class InjectIdentifiedAspect {

    private EntityManagerFactory entityManagerFactory;

    @Before(value = "@annotation(injectIdentified)", argNames = "joinPoint, injectIdentified")
    public void before(JoinPoint joinPoint, InjectIdentified injectIdentified) {

        if (joinPoint == null) {
            return;
        }

        Object target = joinPoint.getTarget();
        if (target == null) {
            return;
        }

        Signature signature = joinPoint.getSignature();
        if (signature == null) {
            return;
        }

        Object[] args = joinPoint.getArgs();
        if (args.length != 1) {
            return;
        }

        Object arg = args[0];
        if (arg == null) {
            return;
        }

        Class<?> argClass = arg.getClass();
        if (!Persistable.class.isAssignableFrom(argClass) || !Identifiable.class.isAssignableFrom(argClass)) {
            return;
        }

        Class<? extends Identifiable> identifierdConceptClass = (Class<? extends Identifiable>) arg.getClass();

        Identifiable identifiable = (Identifiable) arg;

        if (((Persistable) identifiable).getPk() != null) {
            return;
        }

        Set<String> identifierSystems = identifiable.getIdentifierSystems();

        for (String identifierSystem : identifierSystems) {

            if (identifierSystem == null) {
                return;
            }

            String identifierValue = identifiable.getIdentifierValue(identifierSystem);
            if (identifierValue == null) {
                return;
            }

            EntityManager entityManager = entityManagerFactory.createEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<? extends Identifiable> query = criteriaBuilder.createQuery(identifierdConceptClass);
            Root<? extends Identifiable> root = query.from(identifierdConceptClass);
            Join<? extends Identifiable, Identifiers> identifiers = root.join("identifiers");
            Join<? extends Identifiers, Identifier> identifiersIdentifiers = identifiers.join("identifiers");

            query.where(
                    criteriaBuilder.equal(identifiersIdentifiers.get("system"), identifierSystem),
                    criteriaBuilder.equal(identifiersIdentifiers.get("value"), identifierValue)
            );


            List<? extends Identifiable> results = entityManager.createQuery(query).getResultList();
            if (!results.isEmpty()) {
                ((Persistable) identifiable).setPk(((Persistable) results.get(0)).getPk());
                return;
            }
        }
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}